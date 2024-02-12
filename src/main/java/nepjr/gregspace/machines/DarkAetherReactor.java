package nepjr.gregspace.machines;

import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.GTValues;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.impl.*;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.*;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.Recipe;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextComponentUtil;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gregtech.core.sound.GTSoundEvents;
import nepjr.gregspace.blocks.ModMetaBlocks;
import nepjr.gregspace.blocks.GregSpaceCasing;
import nepjr.gregspace.machines.logic.DarkAetherReactorLogic;
import nepjr.gregspace.recipe.ModRecipeMaps;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DarkAetherReactor extends FuelMultiblockController implements IHeatingCoil {

    private int temperature;
    public DarkAetherReactor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, ModRecipeMaps.DARK_AETHER_REACTOR, 5);
        this.recipeMapWorkable = new DarkAetherReactorLogic(this);
    }
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new DarkAetherReactor(metaTileEntityId);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (!isStructureFormed()) {
            ITextComponent tooltip = new TextComponentTranslation("gregtech.multiblock.invalid_structure.tooltip");
            tooltip.setStyle(new Style().setColor(TextFormatting.GRAY));
            textList.add(new TextComponentTranslation("gregtech.multiblock.invalid_structure")
                    .setStyle(new Style().setColor(TextFormatting.RED)
                            .setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, tooltip))));
        }
        else {
            long produces = GTValues.V[5] * this.getCurrentTemperature();
            String voltageName = GTValues.VNF[GTUtility.getFloorTierByVoltage(produces)] + TextFormatting.RESET;
            textList.add(new TextComponentTranslation("gregtech.multiblock.max_energy_per_tick", TextFormattingUtil.formatNumbers(produces), voltageName));

            ITextComponent heatString = TextComponentUtil.stringWithColor(
                    TextFormatting.RED,
                    TextFormattingUtil.formatNumbers(temperature) + "K");

            textList.add(TextComponentUtil.translationWithColor(TextFormatting.GRAY, "gregtech.multiblock.blast_furnace.max_temperature", heatString));

            if (!recipeMapWorkable.isWorkingEnabled()) {
                textList.add(new TextComponentTranslation("gregtech.multiblock.work_paused"));
            } else if (recipeMapWorkable.isActive()) {
                textList.add(new TextComponentTranslation("gregtech.multiblock.running"));
                int currentProgress = (int) (recipeMapWorkable.getProgressPercent() * 100);
                textList.add(new TextComponentTranslation("gregtech.multiblock.progress", currentProgress));
            } else {
                textList.add(new TextComponentTranslation("gregtech.multiblock.idling"));
            }
        }
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "CRC", "CRC", "CRC", "XXX")
                .aisle("XXX", "R#R", "R#R", "R#R", "XXX")
                .aisle("XXX", "CRC", "CSC", "CRC", "XXX")
                .where('S', selfPredicate())
                .where('R', states(getCasingState())
                        .or(abilities(MultiblockAbility.OUTPUT_ENERGY).setExactLimit(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS).setExactLimit(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS).setExactLimit(1).setPreviewCount(1)))
                .where('C', heatingCoils())
                .where('#', air())
                .where('X', states(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ATOMIC_CASING)))
                .build();
    }

    protected IBlockState getCasingState() {
        //return MetaBlocks.COMPRESSED_BLOCKS.get(MostimaMaterials.aetherCrystalDark.getId()).getBlock(MostimaMaterials.aetherCrystalDark);
        return ModMetaBlocks.MOSTIMA_CASING.getState(GregSpaceCasing.CasingType.DARK_CRYSTAL_CASING);
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.temperature = 0;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GCYMTextures.ATOMIC_CASING;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        tooltip.add(I18n.format("mostima.multiblock.dark_aether_reactor"));
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.DATA_BANK_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return false;
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    @Override
    public int getCurrentTemperature() {
        return this.temperature;
    }

    @NotNull
    @Override
    public List<ITextComponent> getDataInfo() {
        List<ITextComponent> list = super.getDataInfo();
        list.add(new TextComponentTranslation("gregtech.multiblock.blast_furnace.max_temperature",
                new TextComponentTranslation(TextFormattingUtil.formatNumbers(temperature) + "K")
                        .setStyle(new Style().setColor(TextFormatting.RED))));
        return list;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        if (type instanceof IHeatingCoilBlockStats) {
            this.temperature = ((IHeatingCoilBlockStats) type).getCoilTemperature();
        } else {
            this.temperature = BlockWireCoil.CoilType.CUPRONICKEL.getCoilTemperature();
        }
    }
}
