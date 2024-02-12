package nepjr.gregspace.events;

import nepjr.gregspace.Tags;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class GalacticraftEvents {

    @SubscribeEvent
    public static void entityLivingEvent(LivingEvent.LivingUpdateEvent event)
    {
        // do something to set gravity to normal idk
    }
}
