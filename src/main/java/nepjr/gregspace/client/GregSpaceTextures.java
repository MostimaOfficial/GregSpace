package nepjr.gregspace.client;

import gregtech.api.GTValues;
import gregtech.client.renderer.texture.cube.SimpleSidedCubeRenderer;
import nepjr.gregspace.Tags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Tags.MODID, value = Side.CLIENT)
public class GregSpaceTextures 
{
	public static final SimpleSidedCubeRenderer[] SPACE_VOLTAGE_CASINGS = new SimpleSidedCubeRenderer[GTValues.V.length];
	
	public static void preInit()
	{
		for (int i = 0; i < SPACE_VOLTAGE_CASINGS.length; i++)
		{
			String volName = GTValues.VN[i].toLowerCase();
			
			SPACE_VOLTAGE_CASINGS[i] = new SimpleSidedCubeRenderer("casings/voltage/space/" + volName);
		}
	}
}
