package nepjr.gregspace.mte;

import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.GhostCircuitItemStackHandler;
import gregtech.api.capability.impl.RecipeLogicEnergy;
import gregtech.api.items.itemhandlers.GTItemStackHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.GasCollectorDimensionProperty;
import gregtech.api.util.GTUtility;
import gregtech.client.particle.IMachineParticleEffect;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.electric.MetaTileEntityGasCollector;
import io.netty.handler.logging.LogLevel;
import it.unimi.dsi.fastutil.ints.IntArrays;
import it.unimi.dsi.fastutil.ints.IntLists;
import nepjr.gregspace.GregSpace;
import nepjr.gregspace.cfg.ModConfig;
import nepjr.gregspace.recipe.properties.SpaceDimensionProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.function.Supplier;

public class SimpleSpaceMachineMetaTileEntity extends SimpleMachineMetaTileEntity
{
    /*
    public SimpleSpaceMachineMetaTileEntity(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, ICubeRenderer renderer,
                                      int tier, boolean hasFrontFacing,
                                      Function<Integer, Integer> tankScalingFunction) {
        super(metaTileEntityId, recipeMap, renderer, tier, hasFrontFacing, tankScalingFunction);
    }
    */

    protected final GTItemStackHandler chargerInventory;
    @Nullable
    protected GhostCircuitItemStackHandler circuitInventory;
    protected IItemHandler outputItemInventory;
    protected IFluidHandler outputFluidInventory;

    @Nullable // particle run every tick when the machine is active
    protected final IMachineParticleEffect tickingParticle;
    @Nullable // particle run in randomDisplayTick() when the machine is active
    protected final IMachineParticleEffect randomParticle;

    public SimpleSpaceMachineMetaTileEntity(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap,
                                       ICubeRenderer renderer, int tier, boolean hasFrontFacing) {
        this(metaTileEntityId, recipeMap, renderer, tier, hasFrontFacing, GTUtility.defaultTankSizeFunction);
    }

    public SimpleSpaceMachineMetaTileEntity(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap,
                                       ICubeRenderer renderer, int tier, boolean hasFrontFacing,
                                       Function<Integer, Integer> tankScalingFunction) {
        this(metaTileEntityId, recipeMap, renderer, tier, hasFrontFacing, tankScalingFunction, null, null);
    }

    public SimpleSpaceMachineMetaTileEntity(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap,
                                       ICubeRenderer renderer, int tier, boolean hasFrontFacing,
                                       Function<Integer, Integer> tankScalingFunction,
                                       @Nullable IMachineParticleEffect tickingParticle,
                                       @Nullable IMachineParticleEffect randomParticle) {
        super(metaTileEntityId, recipeMap, renderer, tier, hasFrontFacing, tankScalingFunction);
        this.chargerInventory = new GTItemStackHandler(this, 1);
        this.tickingParticle = tickingParticle;
        this.randomParticle = randomParticle;
    }
    
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new SimpleSpaceMachineMetaTileEntity(this.metaTileEntityId, this.recipeMap,
                this.renderer, this.getTier(), this.hasFrontFacing(), this.getTankScalingFunction());
    }

    @Override
    protected RecipeLogicEnergy createWorkable(RecipeMap<?> recipeMap) {
        return new SpaceRecipeLogic(this, recipeMap, () -> energyContainer);
    }

    protected boolean checkRecipe(@NotNull Recipe recipe) {
    	System.out.println("Checking Recipe");
    	int[] x = recipe.getProperty(SpaceDimensionProperty.getInstance(), ModConfig.space.spaceDims);
    	System.out.println(x);
        for (int i = 0; i < x.length; i++) {
        	System.out.println("Checking Dimension ID " + x[i]);
            if(x[i] == this.getWorld().provider.getDimension())
            {
            	System.out.println("Dimension ID " + x[i] + " is valid!");
            	return true;
            }
        }
        System.out.println("Dimension ID was invalid!");
        return false;
    }

    private static class SpaceRecipeLogic extends RecipeLogicEnergy {

        public SpaceRecipeLogic(MetaTileEntity metaTileEntity, RecipeMap<?> recipeMap,
                                       Supplier<IEnergyContainer> energyContainer) {
            super(metaTileEntity, recipeMap, energyContainer);
        }

        @Override
        public boolean checkRecipe(@NotNull Recipe recipe) {
            return ((SimpleSpaceMachineMetaTileEntity) metaTileEntity).checkRecipe(recipe) && super.checkRecipe(recipe);
        }
    }
}