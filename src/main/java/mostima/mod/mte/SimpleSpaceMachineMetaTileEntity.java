package mostima.mod.mte;

import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.RecipeLogicEnergy;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.GasCollectorDimensionProperty;
import gregtech.client.particle.IMachineParticleEffect;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.electric.MetaTileEntityGasCollector;
import it.unimi.dsi.fastutil.ints.IntLists;
import mostima.mod.recipe.properties.SpaceDimensionProperty;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.function.Supplier;

public class SimpleSpaceMachineMetaTileEntity extends SimpleMachineMetaTileEntity
{

    public SimpleSpaceMachineMetaTileEntity(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, ICubeRenderer renderer,
                                      int tier, boolean hasFrontFacing,
                                      Function<Integer, Integer> tankScalingFunction) {
        super(metaTileEntityId, recipeMap, renderer, tier, hasFrontFacing, tankScalingFunction);
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