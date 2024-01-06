package mostima.mod;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = Tags.MODID)
public class CommonProxy {
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
    }
}
