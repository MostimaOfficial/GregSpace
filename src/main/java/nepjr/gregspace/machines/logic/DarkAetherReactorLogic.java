package nepjr.gregspace.machines.logic;

import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.impl.MultiblockFuelRecipeLogic;
import nepjr.gregspace.machines.DarkAetherReactor;

public class DarkAetherReactorLogic extends MultiblockFuelRecipeLogic {

    public DarkAetherReactorLogic(DarkAetherReactor controller) {
        super(controller);
        if (!(metaTileEntity instanceof IHeatingCoil)) {
            throw new IllegalArgumentException("MetaTileEntity must be instanceof IHeatingCoil");
        }
    }

    @Override
    public int getParallelLimit() {
        // No Parallel for Naq Reactors
        return 1;
    }

    @Override
    public boolean isAllowOverclocking() {
        return false;
    }

    @Override
    public long boostProduction(long boost)
    {
        return boost * ((IHeatingCoil) metaTileEntity).getCurrentTemperature();
    }

    @Override
    public long getMaxVoltage() {
        return Long.MAX_VALUE;
    }

}
