package nepjr.gregspace.recipe;

import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import nepjr.gregspace.material.MostimaMaterials;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.DistilledWater;

public class MinorRecipes
{
    public static void init()
    {
        // Dark Aether Reactor Recipes
        ModRecipeMaps.DARK_AETHER_REACTOR.recipeBuilder()
                .input(OrePrefix.gem, MostimaMaterials.aetherCrystalDark, 1)
                .output(OrePrefix.gem, MostimaMaterials.aetherCrystalLight, 1)
                .EUt(8192)
                .duration(1)
                .buildAndRegister();

        ModRecipeMaps.SINGULARITY_FUSION_REACTOR.recipeBuilder()
                .input(OrePrefix.block, Materials.Iron, 10000000)
                .output(MetaItems.SUS_RECORD)
                .EUt(2147483647)
                .duration(1728000)
                .buildAndRegister();
        
        RecipeMaps.STEAM_TURBINE_FUELS.recipeBuilder()
                .fluidInputs(MostimaMaterials.steam_5000c.getFluid(640))
                .fluidOutputs(DistilledWater.getFluid(40))
                .duration(10)
                .EUt((int) V[EV])
                .buildAndRegister();
    }
}
