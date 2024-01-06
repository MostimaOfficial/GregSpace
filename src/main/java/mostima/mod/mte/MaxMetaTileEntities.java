package mostima.mod.mte;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.electric.*;
import gregtech.integration.jei.multiblock.MultiblockInfoCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import static gregtech.api.util.GTUtility.gregtechId;

public class MaxMetaTileEntities {
    // HULLS
    public static final MetaTileEntityHull[] HULL = new MetaTileEntityHull[GTValues.V.length];
    public static final MetaTileEntityTransformer[] TRANSFORMER = new MetaTileEntityTransformer[GTValues.V.length]; // no
    // MAX
    public static final MetaTileEntityTransformer[] HI_AMP_TRANSFORMER = new MetaTileEntityTransformer[GTValues.V.length]; /// no MAX
    public static final MetaTileEntityTransformer[] POWER_TRANSFORMER = new MetaTileEntityTransformer[GTValues.V.length]; // no MAX
    public static final MetaTileEntityDiode[] DIODES = new MetaTileEntityDiode[GTValues.V.length];
    public static final MetaTileEntityBatteryBuffer[][] BATTERY_BUFFER = new MetaTileEntityBatteryBuffer[3][GTValues.V.length];
    public static final MetaTileEntityCharger[] CHARGER = new MetaTileEntityCharger[GTValues.V.length];
    // SIMPLE MACHINES SECTION
    public static final SimpleMachineMetaTileEntity[] ELECTRIC_FURNACE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MACERATOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] ALLOY_SMELTER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] ARC_FURNACE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] ASSEMBLER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] AUTOCLAVE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] BENDER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] BREWERY = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] CANNER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] CENTRIFUGE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] CHEMICAL_BATH = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] CHEMICAL_REACTOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] COMPRESSOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] CUTTER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] DISTILLERY = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] ELECTROLYZER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] ELECTROMAGNETIC_SEPARATOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] EXTRACTOR = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] EXTRUDER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] FERMENTER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] FLUID_HEATER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] FLUID_SOLIDIFIER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] FORGE_HAMMER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] FORMING_PRESS = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] LATHE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] MIXER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] ORE_WASHER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] PACKER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] UNPACKER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] POLARIZER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] LASER_ENGRAVER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] SIFTER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] THERMAL_CENTRIFUGE = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] WIREMILL = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] CIRCUIT_ASSEMBLER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] SCANNER = new SimpleMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleMachineMetaTileEntity[] GAS_COLLECTOR = new MetaTileEntityGasCollector[GTValues.V.length];

    private static final Map<String, Boolean> MID_TIER = new HashMap<>();
    private static final Map<String, Boolean> HIGH_TIER = new HashMap<>();

    public static void init()
    {
        // Alloy Smelter, IDs 80-94
        registerSimpleMetaTileEntity(ALLOY_SMELTER, 80, "alloy_smelter", RecipeMaps.ALLOY_SMELTER_RECIPES,
                Textures.ALLOY_SMELTER_OVERLAY, true);

        // Arc Furnace, IDs 95-109
        registerMetaTileEntities(ARC_FURNACE, 95, "arc_furnace",
                (tier, voltageName) -> new SimpleMachineMetaTileEntityResizable(
                        gregtechId(String.format("%s.%s", "arc_furnace", voltageName)),
                        RecipeMaps.ARC_FURNACE_RECIPES,
                        -1,
                        tier >= GTValues.EV ? 9 : 4,
                        Textures.ARC_FURNACE_OVERLAY,
                        tier,
                        false,
                        GTUtility.hvCappedTankSizeFunction));

        // Assembler, IDs 110-124
        registerSimpleMetaTileEntity(ASSEMBLER, 110, "assembler", RecipeMaps.ASSEMBLER_RECIPES,
                Textures.ASSEMBLER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Autoclave, IDs 125-139
        registerSimpleMetaTileEntity(AUTOCLAVE, 125, "autoclave", RecipeMaps.AUTOCLAVE_RECIPES,
                Textures.AUTOCLAVE_OVERLAY, false, GTUtility.hvCappedTankSizeFunction);

        // Bender, IDs 140-154
        registerSimpleMetaTileEntity(BENDER, 140, "bender", RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, true);

        // Brewery, IDs 155-169
        registerSimpleMetaTileEntity(BREWERY, 155, "brewery", RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY,
                true, GTUtility.hvCappedTankSizeFunction);

        // Canner, IDs 170-184
        registerSimpleMetaTileEntity(CANNER, 170, "canner", RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, true);

        // Centrifuge, IDs 185-199
        registerSimpleMetaTileEntity(CENTRIFUGE, 185, "centrifuge", RecipeMaps.CENTRIFUGE_RECIPES,
                Textures.CENTRIFUGE_OVERLAY, false, GTUtility.largeTankSizeFunction);

        // Chemical Bath, IDs 200-214
        registerSimpleMetaTileEntity(CHEMICAL_BATH, 200, "chemical_bath", RecipeMaps.CHEMICAL_BATH_RECIPES,
                Textures.CHEMICAL_BATH_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Chemical Reactor, IDs 215-229
        registerSimpleMetaTileEntity(CHEMICAL_REACTOR, 215, "chemical_reactor", RecipeMaps.CHEMICAL_RECIPES,
                Textures.CHEMICAL_REACTOR_OVERLAY, true, tier -> 16000);

        // Compressor, IDs 230-244
        registerSimpleMetaTileEntity(COMPRESSOR, 230, "compressor", RecipeMaps.COMPRESSOR_RECIPES,
                Textures.COMPRESSOR_OVERLAY, true);

        // Cutter, IDs 245-259
        registerSimpleMetaTileEntity(CUTTER, 245, "cutter", RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, true);

        // Distillery, IDs 260-274
        registerSimpleMetaTileEntity(DISTILLERY, 260, "distillery", RecipeMaps.DISTILLERY_RECIPES,
                Textures.DISTILLERY_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Electrolyzer, IDs 275-289
        registerSimpleMetaTileEntity(ELECTROLYZER, 275, "electrolyzer", RecipeMaps.ELECTROLYZER_RECIPES,
                Textures.ELECTROLYZER_OVERLAY, false, GTUtility.largeTankSizeFunction);

        // Electromagnetic Separator, IDs 290-304
        registerSimpleMetaTileEntity(ELECTROMAGNETIC_SEPARATOR, 290, "electromagnetic_separator",
                RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, true);

        // Extractor, IDs 305-319
        registerSimpleMetaTileEntity(EXTRACTOR, 305, "extractor", RecipeMaps.EXTRACTOR_RECIPES,
                Textures.EXTRACTOR_OVERLAY, true);

        // Extruder, IDs 320-334
        registerSimpleMetaTileEntity(EXTRUDER, 320, "extruder", RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY,
                true);

        // Fermenter, IDs 335-349
        registerSimpleMetaTileEntity(FERMENTER, 335, "fermenter", RecipeMaps.FERMENTING_RECIPES,
                Textures.FERMENTER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // TODO Replication system
        // Mass Fabricator, IDs 350-364
        // registerSimpleMetaTileEntity(MASS_FABRICATOR, 350, "mass_fabricator", RecipeMaps.MASS_FABRICATOR_RECIPES,
        // Textures.MASS_FABRICATOR_OVERLAY, true);

        // TODO Should anonymously override SimpleMachineMetaTileEntity#getCircuitSlotOverlay() to display the data
        // stick overlay
        // Replicator, IDs 365-379
        // registerSimpleMetaTileEntity(REPLICATOR, 365, "replicator", RecipeMaps.REPLICATOR_RECIPES,
        // Textures.REPLICATOR_OVERLAY, true);

        // Fluid Heater, IDs 380-394
        registerSimpleMetaTileEntity(FLUID_HEATER, 380, "fluid_heater", RecipeMaps.FLUID_HEATER_RECIPES,
                Textures.FLUID_HEATER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Fluid Solidifier, IDs 395-409
        registerSimpleMetaTileEntity(FLUID_SOLIDIFIER, 395, "fluid_solidifier", RecipeMaps.FLUID_SOLIDFICATION_RECIPES,
                Textures.FLUID_SOLIDIFIER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Forge Hammer, IDs 410-424
        registerSimpleMetaTileEntity(FORGE_HAMMER, 410, "forge_hammer", RecipeMaps.FORGE_HAMMER_RECIPES,
                Textures.FORGE_HAMMER_OVERLAY, true);

        // Forming Press, IDs 425-439
        registerSimpleMetaTileEntity(FORMING_PRESS, 425, "forming_press", RecipeMaps.FORMING_PRESS_RECIPES,
                Textures.FORMING_PRESS_OVERLAY, true);

        // Lathe, IDs 440-454
        registerSimpleMetaTileEntity(LATHE, 440, "lathe", RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, true);

        // Scanner, IDs 455-469
        registerSimpleMetaTileEntity(SCANNER, 455, "scanner", RecipeMaps.SCANNER_RECIPES, Textures.SCANNER_OVERLAY,
                true);

        // Mixer, IDs 470-484
        registerSimpleMetaTileEntity(MIXER, 470, "mixer", RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, false,
                GTUtility.hvCappedTankSizeFunction);

        // Ore Washer, IDs 485-499
        registerSimpleMetaTileEntity(ORE_WASHER, 485, "ore_washer", RecipeMaps.ORE_WASHER_RECIPES,
                Textures.ORE_WASHER_OVERLAY, true);

        // Packer, IDs 500-514
        registerSimpleMetaTileEntity(PACKER, 500, "packer", RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, true);

        // FREE, IDs 515-529

        // Gas Collectors, IDs 530-544
        registerMetaTileEntities(GAS_COLLECTOR, 530, "gas_collector",
                (tier, voltageName) -> new MetaTileEntityGasCollector(
                        gregtechId(String.format("%s.%s", "gas_collector", voltageName)),
                        RecipeMaps.GAS_COLLECTOR_RECIPES, Textures.GAS_COLLECTOR_OVERLAY, tier, false,
                        GTUtility.largeTankSizeFunction));
        // Polarizer, IDs 545-559
        registerSimpleMetaTileEntity(POLARIZER, 545, "polarizer", RecipeMaps.POLARIZER_RECIPES,
                Textures.POLARIZER_OVERLAY, true);

        // Laser Engraver, IDs 560-574
        registerSimpleMetaTileEntity(LASER_ENGRAVER, 560, "laser_engraver", RecipeMaps.LASER_ENGRAVER_RECIPES,
                Textures.LASER_ENGRAVER_OVERLAY, true);

        // Sifter, IDs 575-589
        registerSimpleMetaTileEntity(SIFTER, 575, "sifter", RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, true);

        // FREE, IDs 590-604

        // Thermal Centrifuge, IDs 605-619
        registerSimpleMetaTileEntity(THERMAL_CENTRIFUGE, 605, "thermal_centrifuge",
                RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, true);

        // Wire Mill, IDs 620-634
        registerSimpleMetaTileEntity(WIREMILL, 620, "wiremill", RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY,
                true);

        // Circuit Assembler, IDs 650-664
        registerSimpleMetaTileEntity(CIRCUIT_ASSEMBLER, 635, "circuit_assembler", RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES,
                Textures.ASSEMBLER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines,
                                                     int startId,
                                                     String name,
                                                     RecipeMap<?> map,
                                                     ICubeRenderer texture,
                                                     boolean hasFrontFacing,
                                                     Function<Integer, Integer> tankScalingFunction) {
        registerSimpleMetaTileEntity(machines, startId, name, map, texture, hasFrontFacing, GTUtility::gregtechId,
                tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines,
                                                     int startId,
                                                     String name,
                                                     RecipeMap<?> map,
                                                     ICubeRenderer texture,
                                                     boolean hasFrontFacing) {
        registerSimpleMetaTileEntity(machines, startId, name, map, texture, hasFrontFacing,
                GTUtility.defaultTankSizeFunction);
    }

    public static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                    ICubeRenderer texture,
                                                    boolean hasFrontFacing,
                                                    Function<String, ResourceLocation> resourceId,
                                                    Function<Integer, Integer> tankScalingFunction) {
        registerMetaTileEntities(machines, startId, name,
                (tier, voltageName) -> new SimpleMachineMetaTileEntity(
                        resourceId.apply(String.format("%s.%s", name, voltageName)), map, texture, tier, hasFrontFacing,
                        tankScalingFunction));
    }

    /**
     * @param mteCreator Takes tier and voltage name for the machine, and outputs MTE to register
     */
    public static void registerMetaTileEntities(
            MetaTileEntity[] machines,
            int startId,
            String name,
            BiFunction<Integer, String, MetaTileEntity> mteCreator) {
            String voltageName = GTValues.VN[14].toLowerCase();
            machines[14] = registerMetaTileEntity(startId + 13, mteCreator.apply(14, voltageName));
    }

    public static <T extends MetaTileEntity> T registerMetaTileEntity(int id, T sampleMetaTileEntity) {
        if (sampleMetaTileEntity instanceof IMultiblockAbilityPart abilityPart) {
            MultiblockAbility.registerMultiblockAbility(abilityPart.getAbility(), sampleMetaTileEntity);
        }
        if (sampleMetaTileEntity instanceof MultiblockControllerBase && Loader.isModLoaded(GTValues.MODID_JEI)) {
            if (((MultiblockControllerBase) sampleMetaTileEntity).shouldShowInJei()) {
                MultiblockInfoCategory.registerMultiblock((MultiblockControllerBase) sampleMetaTileEntity);
            }
        }
        GregTechAPI.MTE_REGISTRY.register(id, sampleMetaTileEntity.metaTileEntityId, sampleMetaTileEntity);
        return sampleMetaTileEntity;
    }

    @SuppressWarnings("unused")
    public static void setMidTier(String key, boolean enabled) {
        MID_TIER.put(key, enabled);
    }

    @SuppressWarnings("unused")
    public static void setHighTier(String key, boolean enabled) {
        HIGH_TIER.put(key, enabled);
        if (!GregTechAPI.isHighTier()) {
            throw new IllegalArgumentException(
                    "Cannot set High-Tier machine without high tier being enabled in GregTechAPI.");
        }
    }

    public static boolean getMidTier(String key) {
        return MID_TIER.getOrDefault(key, true);
    }

    public static boolean getHighTier(String key) {
        return HIGH_TIER.getOrDefault(key, GregTechAPI.isHighTier());
    }
}
