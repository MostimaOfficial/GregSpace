package nepjr.gregspace.material;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;
import nepjr.gregspace.Tags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static gregtech.api.util.GTUtility.gregtechId;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class GCMaterials {

    public static Material meteoricIron;
    public static Material heavyDutyPlateAlpha;
    public static Material heavyDutyPlateBeta;
    public static Material heavyDutyPlateGamma;
    public static Material heavyDutyPlateDelta;
    public static Material heavyDutyPlateEpsilon;
    public static Material heavyDutyPlateZeta;
    public static Material heavyDutyPlateEta;
    public static Material heavyDutyPlateTheta;
    public static Material heavyDutyPlateIota;
    public static Material heavyDutyPlateKappa;
    public static Material heavyDutyPlateLambda;

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void register(MaterialEvent event)
    {
        GCMaterials.heavyDutyPlateAlpha = new Material.Builder(24002, gregtechId("heavy_duty_plate_alpha"))
                .color(0x656164)
                .ingot()
                .components(Materials.Steel, 3, Materials.Aluminium, 3, Materials.Bronze, 3)
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.heavyDutyPlateBeta = new Material.Builder(24003, gregtechId("heavy_duty_plate_beta"))
                .color(0x9E9E9E)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.heavyDutyPlateGamma = new Material.Builder(24004, gregtechId("heavy_duty_plate_gamma"))
                .color(0x444444)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.heavyDutyPlateDelta = new Material.Builder(24005, gregtechId("heavy_duty_plate_delta"))
                .color(0x844200)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.heavyDutyPlateEpsilon = new Material.Builder(24006, gregtechId("heavy_duty_plate_epsilon"))
                .color(0xABA5FF)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.heavyDutyPlateZeta = new Material.Builder(24007, gregtechId("heavy_duty_plate_zeta"))
                .color(0x008712)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.heavyDutyPlateEta = new Material.Builder(24008, gregtechId("heavy_duty_plate_eta"))
                .color(0xE17DFF)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.heavyDutyPlateTheta = new Material.Builder(24009, gregtechId("heavy_duty_plate_theta"))
                .color(0xFFBA7D)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.heavyDutyPlateIota = new Material.Builder(24010, gregtechId("heavy_duty_plate_iota"))
                .color(0x7DCCFF)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.heavyDutyPlateKappa = new Material.Builder(24011, gregtechId("heavy_duty_plate_kappa"))
                .color(0xD500FF)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.heavyDutyPlateLambda = new Material.Builder(24012, gregtechId("heavy_duty_plate_lambda"))
                .color(0x008080)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();

        GCMaterials.meteoricIron = new Material.Builder(24013, gregtechId("meteoric_iron"))
                .color(0x958958).iconSet(MaterialIconSet.DULL)
                .ingot()
                .fluid()
                .flags(MaterialFlags.GENERATE_PLATE)
                .build();
    }
}
