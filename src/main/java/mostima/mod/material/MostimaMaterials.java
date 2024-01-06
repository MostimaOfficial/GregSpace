package mostima.mod.material;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.unification.material.info.MaterialIconSet;
import mostima.mod.Tags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static gregtech.api.util.GTUtility.gregtechId;
@Mod.EventBusSubscriber(modid = Tags.MODID)
public class MostimaMaterials
{
    public static Material aetherCrystalDark;
    public static Material chozodian;
    public static Material yellowChozodian;
    public static Material orangeChozodian;
    public static Material purpleChozodian;
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void register(MaterialEvent event)
    {
            MostimaMaterials.aetherCrystalDark = new Material.Builder(24000, gregtechId("aether_crystal_dark"))
                    .color(0x301934)
                    .iconSet(MaterialIconSet.DIAMOND)
                    .gem()
                    .fluid()
                    .build();
    }
}
