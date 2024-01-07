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
                .output(OrePrefix.gem, MostimaMaterials.aetherCrystalLight, 1)
                .EUt(8192)
                .duration(1)
                .buildAndRegister();
    }
}
