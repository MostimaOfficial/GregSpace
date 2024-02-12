package nepjr.gregspace.recipe.properties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.worldgen.config.WorldGenRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class SpaceDimensionProperty extends RecipeProperty<int[]> {

    public static final String KEY = "space_dimension";

    private static SpaceDimensionProperty INSTANCE;

    private SpaceDimensionProperty() {
        super(KEY, int[].class);
    }

    public static SpaceDimensionProperty getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SpaceDimensionProperty();
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gregtech.recipe.dimensions",
                getDimensionsForRecipe(castValue(value))), x, y, color);
    }

    private static String getDimensionsForRecipe(int[] value) {
    	Int2ObjectMap<String> dimNames = WorldGenRegistry.getNamedDimensions();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            builder.append(dimNames.getOrDefault(value[i], String.valueOf(value[i])));
            if (i != value.length - 1)
                builder.append(", ");
        }
        String str = builder.toString();

        if (str.length() >= 13) {
            str = str.substring(0, 10) + "..";
        }
        return str;
    }
}
