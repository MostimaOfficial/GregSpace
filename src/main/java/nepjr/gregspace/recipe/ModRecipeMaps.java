package nepjr.gregspace.recipe;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.*;
import gregtech.core.sound.GTSoundEvents;

import nepjr.gregspace.recipe.builders.SimpleSpaceRecipeBuilder;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mostima.addon.gregtech.recipe.ModRecipeMaps")
@ZenRegister
public class ModRecipeMaps {
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DARK_AETHER_REACTOR = new RecipeMap<>("dark_aether_reactor", 1, 1, 0,
            0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.RESEARCH_STATION_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ELECTROLYZER);

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> SINGULARITY_FUSION_REACTOR = new RecipeMap<>("singularity_fusion_reactor", 1, 1, 0,
            0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.ATOMIC_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    // Space Machine Recipe Maps
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
    public static final RecipeMap<SimpleRecipeBuilder> SOLAR_ARRAY = new RecipeMap<>("none", 0, 0, 0, 0, 
    		new SimpleRecipeBuilder(), false)
    		.setSlotOverlay(false, false, GuiTextures.ATOMIC_OVERLAY_1)
    		.setProgressBar(GuiTextures.BUTTON_VOID_NONE, ProgressWidget.MoveType.CIRCULAR)
    		.setSound(GTSoundEvents.REPLICATOR);


}
