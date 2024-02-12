package nepjr.gregspace.blocks;

import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

public class ModMetaBlocks {
    private ModMetaBlocks() {
    }

    public static MostimaCasing MOSTIMA_CASING;

    public static void init()
    {
        MOSTIMA_CASING = new MostimaCasing();
        MOSTIMA_CASING.setRegistryName("mostima_casing");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(MOSTIMA_CASING);
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@NotNull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            // noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            MetaBlocks.statePropertiesToString(state.getProperties())));
        }
    }
}
