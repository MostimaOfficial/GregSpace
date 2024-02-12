package nepjr.gregspace.events;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nepjr.gregspace.Tags;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class GalacticraftEvents {

    @SubscribeEvent
    public static void disableGCGravity(LivingUpdateEvent event)
    {
        /* This shit is complicated man. I'm just gonna
    	   use Adv Rocketry 2 for space stations lol
    	   If someone wants to tackle this challenge
    	   you're more than welcome to but for now
    	   I ain't doin this it too complicated for
    	   my small brain :sadge:
    	*/
    }
}
