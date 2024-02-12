package nepjr.gregspace.events;

import org.apache.commons.lang3.ArrayUtils;

import gregtech.api.block.machines.MachineItemBlock;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.util.GTUtility;
import nepjr.gregspace.Tags;
import nepjr.gregspace.cfg.ModConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class SpaceMachineEvents 
{
	@SubscribeEvent
	public static void disallowNonSpaceMachinesInSpace(EntityPlaceEvent event)
	{
		if (event.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if(ArrayUtils.contains(ModConfig.space.spaceDims, event.getWorld().provider.getDimension()))
			{
				Item itemHand = player.getHeldItemMainhand().getItem();
				if (itemHand instanceof MachineItemBlock)
				{	
					MetaTileEntity machine = GTUtility.getMetaTileEntity(player.getHeldItemMainhand());
					String machineName = machine.getMetaName();
					player.sendMessage(new TextComponentString(machineName));
					if(!(machineName.contains(".space_")))
					{
						if(!(ArrayUtils.contains(ModConfig.space.allowedMachines, machineName)))
						{
							player.sendMessage(new TextComponentTranslation("gregspace.space.notspace.error").setStyle(new Style().setColor(TextFormatting.RED)));
							event.setCanceled(true);
							player.getHeldItemMainhand().setCount(player.getHeldItemMainhand().getCount() - 1);
						}
					}
				}		
				Item itemOffHand = player.getHeldItemOffhand().getItem();
				if (itemOffHand instanceof MachineItemBlock)
				{	
					MetaTileEntity machine = GTUtility.getMetaTileEntity(player.getHeldItemOffhand());
					String machineName = machine.getMetaName();
					player.sendMessage(new TextComponentString(machineName));
					if(!(machineName.contains(".space_")))
					{
						if(!(ArrayUtils.contains(ModConfig.space.allowedMachines, machineName)))
						{
							player.sendMessage(new TextComponentTranslation("gregspace.space.notspace.error").setStyle(new Style().setColor(TextFormatting.RED)));
							event.setCanceled(true);
							player.getHeldItemOffhand().setCount(player.getHeldItemOffhand().getCount() - 1);
						}
					}
				}	
			}
		}
	}
}
