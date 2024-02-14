package nepjr.gregspace.cfg;

import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import nepjr.gregspace.Tags;
import net.minecraftforge.common.config.Config;

@Config(modid = Tags.MODID)
public class ModConfig 
{
	@Config.Comment("Space related options in the mod")
	@Config.Name("Space Options")
	public static SpaceMachineOptions space = new SpaceMachineOptions();
	
	@Config.Comment("Options to configure the solar efficiency of planets")
	@Config.Name("Solar Efficiency Options")
	public static SolarEfficiency solarEfficiency = new SolarEfficiency();
	
	@Config.Comment("Set dimension IDs of dimensions")
	@Config.Name("Dim IDs")
	@Config.RequiresMcRestart
	public static DimIDs dim = new DimIDs();
	
	public static class SpaceMachineOptions
	{
		@Config.Comment("What dimensions are considered space? If you have GalactiCraft or Advanced Rocketry 2 installed for example, you should set it to the dimension IDs of space stations and planets/moons")
		@Config.Name("Space Dimensions")
		@Config.RequiresMcRestart
		public int spaceDims[] = new int[] {-1,1};
		
		@Config.Comment("What machines are allowed to be placed in space?")
		@Config.Name("Allowed Machines in space")
		public String allowedMachines[] = new String[] {	"gregtech.machine.gas_collector.lv"
														  , "gregtech.machine.gas_collector.mv"
														  , "gregtech.machine.gas_collector.hv"
														  , "gregtech.machine.gas_collector.ev"
														  , "gregtech.machine.gas_collector.iv"
														  , "gregtech.machine.gas_collector.luv"
														  , "gregtech.machine.gas_collector.zpm"
														  , "gregtech.machine.gas_collector.uv"
														  , "gregtech.machine.gas_collector.uhv"
														  , "gregtech.machine.gas_collector.uev"
														  , "gregtech.machine.gas_collector.uiv"
														  , "gregtech.machine.gas_collector.uxv"
														  , "gregtech.machine.gas_collector.opv"
														  , "gregtech.machine.gas_collector.max"};
		
	}
	
	public static class SolarEfficiency
	{
		@Config.Comment("Solar efficiency for the space station")
		@Config.Name("Space station efficiency")
		public int efficiencySpaceStation = 5;
	}
	
	public static class DimIDs
	{
		@Config.Comment("Dimension ID for the Space Station")
		@Config.Name("Space Station ID")
		public int spaceStationId = ConfigManagerCore.idDimensionOverworldOrbit;
	}
}
