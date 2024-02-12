package nepjr.gregspace.proxy;

import nepjr.gregspace.blocks.ModMetaBlocks;
import nepjr.gregspace.client.GregSpaceTextures;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preLoad() {
    	GregSpaceTextures.preInit();
        super.preLoad();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModMetaBlocks.registerItemModels();
    }
}
