package nepjr.gregspace.mte;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTLog;
import gregtech.api.util.GTUtility;
import gregtech.client.particle.VanillaParticleEffects;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.electric.*;
import gregtech.integration.jei.multiblock.MultiblockInfoCategory;
import nepjr.gregspace.api.metatileentity.SimpleSpaceMachineMetaTileEntity;
import nepjr.gregspace.api.metatileentity.SimpleSpaceMachineMetaTileEntityResizable;
import nepjr.gregspace.recipe.ModRecipeMaps;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import static gregtech.api.util.GTUtility.gregtechId;

public class SpaceMetaTileEntities {

    // HULLS
    public static final MetaTileEntityHull[] HULL = new MetaTileEntityHull[GTValues.V.length];

    // SIMPLE MACHINES SECTION
    public static final SimpleSpaceMachineMetaTileEntity[] ELECTRIC_FURNACE = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] MACERATOR = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] ALLOY_SMELTER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] ARC_FURNACE = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] ASSEMBLER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] AUTOCLAVE = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] BENDER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] BREWERY = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] CANNER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] CENTRIFUGE = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] CHEMICAL_BATH = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] CHEMICAL_REACTOR = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] COMPRESSOR = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] CUTTER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] DISTILLERY = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] ELECTROLYZER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] ELECTROMAGNETIC_SEPARATOR = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] EXTRACTOR = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] EXTRUDER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] FERMENTER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] FLUID_HEATER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] FLUID_SOLIDIFIER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] FORGE_HAMMER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] FORMING_PRESS = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] LATHE = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] MIXER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] ORE_WASHER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] PACKER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] UNPACKER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] POLARIZER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] LASER_ENGRAVER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] SIFTER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] THERMAL_CENTRIFUGE = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] WIREMILL = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final SimpleSpaceMachineMetaTileEntity[] CIRCUIT_ASSEMBLER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    // TODO Replication system
    // public static final SimpleSpaceMachineMetaTileEntity[] MASS_FABRICATOR = new
    // SimpleSpaceMachineMetaTileEntity[GTValues.V.length - 1];
    // public static final SimpleSpaceMachineMetaTileEntity[] REPLICATOR = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length
    // - 1];
    public static final SimpleSpaceMachineMetaTileEntity[] SCANNER = new SimpleSpaceMachineMetaTileEntity[GTValues.V.length];
    public static final MetaTileEntityGasCollector[] GAS_COLLECTOR = new MetaTileEntityGasCollector[GTValues.V.length];
    public static final MetaTileEntityRockBreaker[] ROCK_BREAKER = new MetaTileEntityRockBreaker[GTValues.V.length];

    // Used for addons if they wish to disable certain tiers of machines
    private static final Map<String, Boolean> MID_TIER = new HashMap<>();
    private static final Map<String, Boolean> HIGH_TIER = new HashMap<>();

    public static void init() {
        GTLog.logger.info("GregSpace: Registering SpaceMetaTileEntities");
        // Electric Furnace, IDs 50-64
        registerSimpleMetaTileEntity(ELECTRIC_FURNACE, 50, "space_electric_furnace", RecipeMaps.FURNACE_RECIPES,
                Textures.ELECTRIC_FURNACE_OVERLAY, true);

        // Macerator, IDs 65-79
        registerMetaTileEntities(MACERATOR, 65, "space_macerator",
                (tier, voltageName) -> new SimpleSpaceMachineMetaTileEntityResizable(
                        gregtechId(String.format("%s.%s", "space_macerator", voltageName)),
                        ModRecipeMaps.MACERATOR_RECIPES,
                        -1,
                        switch (tier) {
                            case 1, 2 -> 1;
                            case 3 -> 3;
                            default -> 4;
                        },
                        tier <= GTValues.MV ? Textures.MACERATOR_OVERLAY : Textures.PULVERIZER_OVERLAY,
                        tier,
                        true,
                        GTUtility.defaultTankSizeFunction,
                        VanillaParticleEffects.TOP_SMOKE_SMALL, null));

        // Alloy Smelter, IDs 80-94
        registerSimpleMetaTileEntity(ALLOY_SMELTER, 80, "space_alloy_smelter", ModRecipeMaps.ALLOY_SMELTER_RECIPES,
                Textures.ALLOY_SMELTER_OVERLAY, true);

        // Arc Furnace, IDs 95-109
        registerMetaTileEntities(ARC_FURNACE, 95, "space_arc_furnace",
                (tier, voltageName) -> new SimpleSpaceMachineMetaTileEntityResizable(
                        gregtechId(String.format("%s.%s", "space_arc_furnace", voltageName)),
                        RecipeMaps.ARC_FURNACE_RECIPES,
                        -1,
                        tier >= GTValues.EV ? 9 : 4,
                        Textures.ARC_FURNACE_OVERLAY,
                        tier,
                        false,
                        GTUtility.hvCappedTankSizeFunction));

        // Assembler, IDs 110-124
        registerSimpleMetaTileEntity(ASSEMBLER, 110, "space_assembler", RecipeMaps.ASSEMBLER_RECIPES,
                Textures.ASSEMBLER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Autoclave, IDs 125-139
        registerSimpleMetaTileEntity(AUTOCLAVE, 125, "space_autoclave", RecipeMaps.AUTOCLAVE_RECIPES,
                Textures.AUTOCLAVE_OVERLAY, false, GTUtility.hvCappedTankSizeFunction);

        // Bender, IDs 140-154
        registerSimpleMetaTileEntity(BENDER, 140, "space_bender", RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, true);

        // Brewery, IDs 155-169
        registerSimpleMetaTileEntity(BREWERY, 155, "space_brewery", RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY,
                true, GTUtility.hvCappedTankSizeFunction);

        // Canner, IDs 170-184
        registerSimpleMetaTileEntity(CANNER, 170, "space_canner", RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, true);

        // Centrifuge, IDs 185-199
        registerSimpleMetaTileEntity(CENTRIFUGE, 185, "space_centrifuge", RecipeMaps.CENTRIFUGE_RECIPES,
                Textures.CENTRIFUGE_OVERLAY, false, GTUtility.largeTankSizeFunction);

        // Chemical Bath, IDs 200-214
        registerSimpleMetaTileEntity(CHEMICAL_BATH, 200, "space_chemical_bath", RecipeMaps.CHEMICAL_BATH_RECIPES,
                Textures.CHEMICAL_BATH_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Chemical Reactor, IDs 215-229
        registerSimpleMetaTileEntity(CHEMICAL_REACTOR, 215, "space_chemical_reactor", RecipeMaps.CHEMICAL_RECIPES,
                Textures.CHEMICAL_REACTOR_OVERLAY, true, tier -> 16000);

        // Compressor, IDs 230-244
        registerSimpleMetaTileEntity(COMPRESSOR, 230, "space_compressor", RecipeMaps.COMPRESSOR_RECIPES,
                Textures.COMPRESSOR_OVERLAY, true);

        // Cutter, IDs 245-259
        registerSimpleMetaTileEntity(CUTTER, 245, "space_cutter", RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, true);

        // Distillery, IDs 260-274
        registerSimpleMetaTileEntity(DISTILLERY, 260, "space_distillery", RecipeMaps.DISTILLERY_RECIPES,
                Textures.DISTILLERY_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Electrolyzer, IDs 275-289
        registerSimpleMetaTileEntity(ELECTROLYZER, 275, "space_electrolyzer", RecipeMaps.ELECTROLYZER_RECIPES,
                Textures.ELECTROLYZER_OVERLAY, false, GTUtility.largeTankSizeFunction);

        // Electromagnetic Separator, IDs 290-304
        registerSimpleMetaTileEntity(ELECTROMAGNETIC_SEPARATOR, 290, "space_electromagnetic_separator",
                RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, true);

        // Extractor, IDs 305-319
        registerSimpleMetaTileEntity(EXTRACTOR, 305, "space_extractor", RecipeMaps.EXTRACTOR_RECIPES,
                Textures.EXTRACTOR_OVERLAY, true);

        // Extruder, IDs 320-334
        registerSimpleMetaTileEntity(EXTRUDER, 320, "space_extruder", RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY,
                true);

        // Fermenter, IDs 335-349
        registerSimpleMetaTileEntity(FERMENTER, 335, "space_fermenter", RecipeMaps.FERMENTING_RECIPES,
                Textures.FERMENTER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // TODO Replication system
        // Mass Fabricator, IDs 350-364
        // registerSimpleMetaTileEntity(MASS_FABRICATOR, 350, "space_mass_fabricator", RecipeMaps.MASS_FABRICATOR_RECIPES,
        // Textures.MASS_FABRICATOR_OVERLAY, true);

        // TODO Should anonymously override SimpleSpaceMachineMetaTileEntity#getCircuitSlotOverlay() to display the data
        // stick overlay
        // Replicator, IDs 365-379
        // registerSimpleMetaTileEntity(REPLICATOR, 365, "space_replicator", RecipeMaps.REPLICATOR_RECIPES,
        // Textures.REPLICATOR_OVERLAY, true);

        // Fluid Heater, IDs 380-394
        registerSimpleMetaTileEntity(FLUID_HEATER, 380, "space_fluid_heater", RecipeMaps.FLUID_HEATER_RECIPES,
                Textures.FLUID_HEATER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Fluid Solidifier, IDs 395-409
        registerSimpleMetaTileEntity(FLUID_SOLIDIFIER, 395, "space_fluid_solidifier", RecipeMaps.FLUID_SOLIDFICATION_RECIPES,
                Textures.FLUID_SOLIDIFIER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Forge Hammer, IDs 410-424
        registerSimpleMetaTileEntity(FORGE_HAMMER, 410, "space_forge_hammer", RecipeMaps.FORGE_HAMMER_RECIPES,
                Textures.FORGE_HAMMER_OVERLAY, true);

        // Forming Press, IDs 425-439
        registerSimpleMetaTileEntity(FORMING_PRESS, 425, "space_forming_press", RecipeMaps.FORMING_PRESS_RECIPES,
                Textures.FORMING_PRESS_OVERLAY, true);

        // Lathe, IDs 440-454
        registerSimpleMetaTileEntity(LATHE, 440, "space_lathe", RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, true);

        // Scanner, IDs 455-469
        registerSimpleMetaTileEntity(SCANNER, 455, "space_scanner", RecipeMaps.SCANNER_RECIPES, Textures.SCANNER_OVERLAY,
                true);

        // Mixer, IDs 470-484
        registerSimpleMetaTileEntity(MIXER, 470, "space_mixer", RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, false,
                GTUtility.hvCappedTankSizeFunction);

        // Ore Washer, IDs 485-499
        registerSimpleMetaTileEntity(ORE_WASHER, 485, "space_ore_washer", RecipeMaps.ORE_WASHER_RECIPES,
                Textures.ORE_WASHER_OVERLAY, true);

        // Packer, IDs 500-514
        registerSimpleMetaTileEntity(PACKER, 500, "space_packer", RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, true);

        // FREE, IDs 515-529

        // Gas Collectors, IDs 530-544
        registerMetaTileEntities(GAS_COLLECTOR, 530, "space_gas_collector",
                (tier, voltageName) -> new MetaTileEntityGasCollector(
                        gregtechId(String.format("%s.%s", "space_gas_collector", voltageName)),
                        RecipeMaps.GAS_COLLECTOR_RECIPES, Textures.GAS_COLLECTOR_OVERLAY, tier, false,
                        GTUtility.largeTankSizeFunction));
        // Polarizer, IDs 545-559
        registerSimpleMetaTileEntity(POLARIZER, 545, "space_polarizer", RecipeMaps.POLARIZER_RECIPES,
                Textures.POLARIZER_OVERLAY, true);

        // Laser Engraver, IDs 560-574
        registerSimpleMetaTileEntity(LASER_ENGRAVER, 560, "space_laser_engraver", RecipeMaps.LASER_ENGRAVER_RECIPES,
                Textures.LASER_ENGRAVER_OVERLAY, true);

        // Sifter, IDs 575-589
        registerSimpleMetaTileEntity(SIFTER, 575, "space_sifter", RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, true);

        // FREE, IDs 590-604

        // Thermal Centrifuge, IDs 605-619
        registerSimpleMetaTileEntity(THERMAL_CENTRIFUGE, 605, "space_thermal_centrifuge",
                RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, true);

        // Wire Mill, IDs 620-634
        registerSimpleMetaTileEntity(WIREMILL, 620, "space_wiremill", RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY,
                true);

        // Circuit Assembler, IDs 650-664
        registerSimpleMetaTileEntity(CIRCUIT_ASSEMBLER, 635, "space_circuit_assembler", RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES,
                Textures.ASSEMBLER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);

        // Rock Breaker, IDs 665-679
        registerMetaTileEntities(ROCK_BREAKER, 665, "space_rock_breaker",
                (tier, voltageName) -> new MetaTileEntityRockBreaker(
                        gregtechId(String.format("%s.%s", "space_rock_breaker", voltageName)),
                        RecipeMaps.ROCK_BREAKER_RECIPES, Textures.ROCK_BREAKER_OVERLAY, tier));

        // Some space here for more SimpleMachines

        // Space left for these just in case

        // Hulls, IDs 985-999
        int endPos = GregTechAPI.isHighTier() ? HULL.length : Math.min(HULL.length - 1, GTValues.UV + 2);
        for (int i = 0; i < endPos; i++) {
            HULL[i] = new MetaTileEntityHull(gregtechId("space_hull." + GTValues.VN[i].toLowerCase()), i);
            registerMetaTileEntity(985 + i, HULL[i]);
        }

        // MULTIBLOCK START: IDs 1000-1149. Space left for addons to register Multiblocks grouped with the rest in JEI

        /*
         * FOR ADDON DEVELOPERS:
         *
         * GTCEu will not take more than 2000 IDs. Anything past ID 1999
         * is considered FAIR GAME, take whatever you like.
         *
         * If you would like to reserve IDs, feel free to reach out to the
         * development team and claim a range of IDs! We will mark any
         * claimed ranges below this comment. Max value is 32767.
         *
         * - Gregicality / Shadows of Greg: 2000-3999
         * - Reserved for Integration Modules in GTCEu: 4000-4499
         * - GregTech Food Option: 8500-8999
         * - HtmlTech: 9000-9499
         * - PCM's Ore Addon: 9500-9999
         * - GCM: 10000-10099
         * - MechTech: 10100-10499
         * - MBT 10500 - 10999
         * - CT(MBT) 32000 - ~
         * - FREE RANGE 11000-32767
         */
    }

    private static void registerSimpleMetaTileEntity(SimpleSpaceMachineMetaTileEntity[] machines,
                                                     int startId,
                                                     String name,
                                                     RecipeMap<?> map,
                                                     ICubeRenderer texture,
                                                     boolean hasFrontFacing,
                                                     Function<Integer, Integer> tankScalingFunction) {
        registerSimpleMetaTileEntity(machines, startId, name, map, texture, hasFrontFacing, GTUtility::gregtechId,
                tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleSpaceMachineMetaTileEntity[] machines,
                                                     int startId,
                                                     String name,
                                                     RecipeMap<?> map,
                                                     ICubeRenderer texture,
                                                     boolean hasFrontFacing) {
        registerSimpleMetaTileEntity(machines, startId, name, map, texture, hasFrontFacing,
                GTUtility.defaultTankSizeFunction);
    }

    public static void registerSimpleMetaTileEntity(SimpleSpaceMachineMetaTileEntity[] machines,
                                                    int startId,
                                                    String name,
                                                    RecipeMap<?> map,
                                                    ICubeRenderer texture,
                                                    boolean hasFrontFacing,
                                                    Function<String, ResourceLocation> resourceId,
                                                    Function<Integer, Integer> tankScalingFunction) {
        registerMetaTileEntities(machines, startId, name,
                (tier, voltageName) -> new SimpleSpaceMachineMetaTileEntity(
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
        for (int i = 0; i < 14; i++) {
            //if (i > 4 && !getMidTier(name)) continue;
            //if (i > 7 && !getHighTier(name)) break;

            String voltageName = GTValues.VN[i + 1].toLowerCase();
            machines[i + 1] = registerMetaTileEntity(startId + i, mteCreator.apply(i + 1, voltageName));
        }
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
        GregTechAPI.MTE_REGISTRY.register(id + 24000, sampleMetaTileEntity.metaTileEntityId, sampleMetaTileEntity);
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

