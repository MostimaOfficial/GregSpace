package nepjr.gregspace.material;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.Elements;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.ToolProperty;
import gregtech.api.unification.stack.MaterialStack;
import nepjr.gregspace.Tags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.util.GTUtility.gregtechId;
@Mod.EventBusSubscriber(modid = Tags.MODID)
public class MostimaMaterials
{
    public static Material aetherCrystalDark;
    public static Material aetherCrystalLight;
    public static Material chozite;
    public static Material yellowChozite;
    public static Material orangeChozite;
    public static Material purpleChozite;
    public static Material infinity;
    public static Material steam_5000c;

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void register(MaterialEvent event)
    {
        MostimaMaterials.aetherCrystalDark = new Material.Builder(4000, gregtechId("aether_crystal_dark"))
                .color(0x301934)
                .iconSet(MaterialIconSet.DIAMOND)
                .gem()
                .fluid()
                .build();

        MostimaMaterials.aetherCrystalLight = new Material.Builder(4001, gregtechId("aether_crystal_light"))
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.DIAMOND)
                .gem()
                .fluid()
                .build();

        MostimaMaterials.infinity = new Material.Builder(4002, gregtechId("infinity"))
                .color(0xFF00FF)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(EXT_METAL, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_LONG_ROD,
                        GENERATE_DOUBLE_PLATE)
                .rotorStats(2048, 1024, 1000000)
                .build();

        MostimaMaterials.steam_5000c = new Material.Builder(4003, gregtechId("steam_5000_c"))
                .gas(new FluidBuilder()
                        .temperature(5000)
                        .customStill())
                .color(0xC4C4C4)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 1)
                .build();
    }
}
