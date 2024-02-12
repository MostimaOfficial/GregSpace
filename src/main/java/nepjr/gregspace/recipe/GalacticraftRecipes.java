package nepjr.gregspace.recipe;

import com.mjr.extraplanets.recipes.MarsRoverRecipes;
import com.mjr.extraplanets.recipes.Tier10ElectricRocketRecipes;
import com.mjr.extraplanets.recipes.Tier10RocketRecipes;
import com.mjr.extraplanets.recipes.Tier4RocketRecipes;
import com.mjr.extraplanets.recipes.Tier5RocketRecipes;
import com.mjr.extraplanets.recipes.Tier6RocketRecipes;
import com.mjr.extraplanets.recipes.Tier7RocketRecipes;
import com.mjr.extraplanets.recipes.Tier8RocketRecipes;
import com.mjr.extraplanets.recipes.Tier9RocketRecipes;
import com.mjr.extraplanets.recipes.VenusRoverRecipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GCItems;
import nepjr.gregspace.material.GCMaterials;
import net.minecraft.util.ResourceLocation;

public class GalacticraftRecipes
{
    public static void init()
    {
        heavyDutyAlloyRecipes();
        rocketRecipes();
        removeRecipes();
    }
    public static void rocketRecipes()
    {    	
    	RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
            .input(OrePrefix.plate, GCMaterials.heavyDutyPlateAlpha, 8)
            .input(GCItems.partNoseCone)
            .input(GCItems.rocketEngine)
            .input(GCItems.partFins, 4)
            .input(OrePrefix.circuit, MarkerMaterials.Tier.HV, 4)
            .output(GCItems.rocketTier1)
            .EUt(512)
            .duration(1200)
            .buildAndRegister();}

    public static void heavyDutyAlloyRecipes()
    {
        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, Materials.Steel, 3)
                .input(OrePrefix.dust, Materials.Aluminium, 3)
                .input(OrePrefix.dust, Materials.Bronze, 3)
                .output(OrePrefix.dust, GCMaterials.heavyDutyPlateAlpha, 9)
                .EUt(512)
                .duration(600)
                .buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, GCMaterials.heavyDutyPlateAlpha)
                .output(OrePrefix.ingot, GCMaterials.heavyDutyPlateAlpha)
                .blastFurnaceTemp(3600)
                .EUt(1024)
                .duration(600)
                .buildAndRegister();

        RecipeMaps.MIXER_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, GCMaterials.heavyDutyPlateAlpha, 5)
                .input(OrePrefix.dust, GCMaterials.meteoricIron, 5)
                .output(OrePrefix.dust, GCMaterials.heavyDutyPlateBeta, 10)
                .EUt(2048)
                .duration(600)
                .buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, GCMaterials.heavyDutyPlateBeta)
                .output(OrePrefix.ingot, GCMaterials.heavyDutyPlateBeta)
                .blastFurnaceTemp(4500)
                .EUt(4096)
                .duration(600)
                .buildAndRegister();
    }
    
    public static void removeRecipes()
    {
    	GalacticraftRegistry.removeAllAstroMinerRecipes();
    	GalacticraftRegistry.removeAllCargoRocketRecipes();
    	GalacticraftRegistry.removeAllMoonBuggyRecipes();
    	GalacticraftRegistry.removeAllT1RocketRecipes();
    	GalacticraftRegistry.removeAllT2RocketRecipes();
    	GalacticraftRegistry.removeAllT3RocketRecipes();
    	
    	Tier4RocketRecipes.removeAllTier4RocketRecipes();
    	Tier5RocketRecipes.removeAllTier5RocketRecipes();
    	Tier6RocketRecipes.removeAllTier6RocketRecipes();
    	Tier7RocketRecipes.removeAllTier7RocketRecipes();
    	Tier8RocketRecipes.removeAllTier8RocketRecipes();
    	Tier9RocketRecipes.removeAllTier9RocketRecipes();
    	Tier10RocketRecipes.removeAllTier10RocketRecipes();
    	Tier10ElectricRocketRecipes.removeAllTier10ElectricRocketRecipes();
    	
    	VenusRoverRecipes.removeAllVenusRoverRecipes();
    	MarsRoverRecipes.removeAllMarsRoverRecipes(); 	
    	
    	// NASA Workbench
    	ModHandler.removeRecipeByName(new ResourceLocation("galacticraftcore:rocket_workbench"));
    	ModHandler.removeRecipeByName(new ResourceLocation("galacticraftcore:rocket_workbench_convert"));	
    	ModHandler.removeRecipeByName(new ResourceLocation("galacticraftcore:compact_workbench"));
    }
}
