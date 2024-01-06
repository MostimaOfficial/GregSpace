package mostima.mod.recipe;

import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.RecyclingHandler;
import gregtech.api.recipes.builders.*;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.api.recipes.machines.*;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.util.AssemblyLineManager;
import gregtech.core.sound.GTSoundEvents;

import mostima.mod.recipe.builders.ReactorRecipeBuilder;
import mostima.mod.recipe.builders.SimpleSpaceRecipeBuilder;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

import static gregtech.api.GTValues.*;

@ZenClass("mostima.addon.gregtech.recipe.ModRecipeMaps")
@ZenRegister
public class ModRecipeMaps {
    @ZenProperty
    public static final RecipeMap<SimpleSpaceRecipeBuilder> MACERATOR_RECIPES = new RecipeMap<>("space_macerator", 1, 4, 0, 0,
            new SimpleSpaceRecipeBuilder().duration(150).EUt(2), false)
            .setSlotOverlay(false, false, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.DUST_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.MACERATOR);

    @ZenProperty
    public static final RecipeMap<SimpleSpaceRecipeBuilder> ALLOY_SMELTER_RECIPES = new RecipeMap<>("space_alloy_smelter", 2, 1, 0,
            0, new SimpleSpaceRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    @ZenProperty
    public static final RecipeMap<ReactorRecipeBuilder> DARK_AETHER_REACTOR = new RecipeMap<>("dark_aether_reactor", 1, 0, 0,
            0, new ReactorRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.RESEARCH_STATION_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.SCIENCE);

}
