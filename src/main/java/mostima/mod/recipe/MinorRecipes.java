package mostima.mod.recipe;

import firemerald.mc4.init.MC4Items;
import gregtech.api.unification.ore.OrePrefix;
import mostima.mod.material.MostimaMaterials;

public class MinorRecipes
{
    public static void init()
    {
        // Dark Aether Reactor Recipes
        ModRecipeMaps.DARK_AETHER_REACTOR.recipeBuilder()
                .input(OrePrefix.gem, MostimaMaterials.aetherCrystalDark, 1)
                .blastFurnaceTemp(1800)
                .EUt(-8192 * 1800)
                .circuitMeta(1)
                .duration(1)
                .buildAndRegister();

        ModRecipeMaps.DARK_AETHER_REACTOR.recipeBuilder()
                .input(OrePrefix.gem, MostimaMaterials.aetherCrystalDark, 1)
                .blastFurnaceTemp(2700)
                .EUt(-8192 * 2700)
                .circuitMeta(2)
                .duration(1)
                .buildAndRegister();

        ModRecipeMaps.DARK_AETHER_REACTOR.recipeBuilder()
                .input(OrePrefix.gem, MostimaMaterials.aetherCrystalDark, 1)
                .blastFurnaceTemp(3600)
                .EUt(-8192 * 3600)
                .circuitMeta(3)
                .duration(1)
                .buildAndRegister();

        ModRecipeMaps.DARK_AETHER_REACTOR.recipeBuilder()
                .input(OrePrefix.gem, MostimaMaterials.aetherCrystalDark, 1)
                .blastFurnaceTemp(4500)
                .EUt(-8192 * 4500)
                .circuitMeta(4)
                .duration(1)
                .buildAndRegister();

        ModRecipeMaps.DARK_AETHER_REACTOR.recipeBuilder()
                .input(OrePrefix.gem, MostimaMaterials.aetherCrystalDark, 1)
                .blastFurnaceTemp(5400)
                .EUt(-8192 * 5400)
                .circuitMeta(5)
                .duration(1)
                .buildAndRegister();

        ModRecipeMaps.DARK_AETHER_REACTOR.recipeBuilder()
                .input(OrePrefix.gem, MostimaMaterials.aetherCrystalDark, 1)
                .blastFurnaceTemp(7200)
                .EUt(-8192 * 7200)
                .circuitMeta(6)
                .duration(1)
                .buildAndRegister();

        ModRecipeMaps.DARK_AETHER_REACTOR.recipeBuilder()
                .input(OrePrefix.gem, MostimaMaterials.aetherCrystalDark, 1)
                .blastFurnaceTemp(9001)
                .EUt(-8192 * 9001)
                .circuitMeta(7)
                .duration(1)
                .buildAndRegister();

        ModRecipeMaps.DARK_AETHER_REACTOR.recipeBuilder()
                .input(OrePrefix.gem, MostimaMaterials.aetherCrystalDark, 1)
                .blastFurnaceTemp(10800)
                .EUt(-8192 * 10800)
                .circuitMeta(8)
                .duration(1)
                .buildAndRegister();
    }
}
