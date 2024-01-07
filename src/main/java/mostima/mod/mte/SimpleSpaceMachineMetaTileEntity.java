package mostima.mod.mte;

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
import it.unimi.dsi.fastutil.ints.IntLists;
import mostima.mod.recipe.properties.SpaceDimensionProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
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

    private final boolean hasFrontFacing;

    protected final GTItemStackHandler chargerInventory;
    @Nullable
    protected GhostCircuitItemStackHandler circuitInventory;
    private EnumFacing outputFacingItems;
    private EnumFacing outputFacingFluids;

    private boolean autoOutputItems;
    private boolean autoOutputFluids;
    private boolean allowInputFromOutputSideItems = false;
    private boolean allowInputFromOutputSideFluids = false;

    protected IItemHandler outputItemInventory;
    protected IFluidHandler outputFluidInventory;

    private IItemHandlerModifiable actualImportItems;

    private static final int FONT_HEIGHT = 9; // Minecraft's FontRenderer FONT_HEIGHT value

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
        this.hasFrontFacing = hasFrontFacing;
        this.chargerInventory = new GTItemStackHandler(this, 1);
        this.tickingParticle = tickingParticle;
        this.randomParticle = randomParticle;
    }

    @Override
    protected RecipeLogicEnergy createWorkable(RecipeMap<?> recipeMap) {
        return new SimpleSpaceMachineMetaTileEntity.SpaceRecipeLogic(this, recipeMap, () -> energyContainer);
    }

    protected boolean checkRecipe(@NotNull Recipe recipe) {
        for (int dimension : recipe.getProperty(SpaceDimensionProperty.getInstance(), IntLists.EMPTY_LIST)) {
            if (dimension == this.getWorld().provider.getDimension()) {
                return true;
            }
        }
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