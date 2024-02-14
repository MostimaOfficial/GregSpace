package nepjr.gregspace;

import net.minecraft.world.World;

public class GregSpaceUtil 
{
	public static float getEfficiency(World world)
	{
		int dim = world.provider.getDimension();
		int efficiency;
		
		if(dim == 1)
		{
			efficiency = 1;
		}
		else { efficiency = 0; }
		return efficiency;
	}
}
