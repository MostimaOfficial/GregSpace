package mostima.mod.machines.logic;

import gregtech.api.metatileentity.MetaTileEntity;

public class DarkAetherReactorLogic {

    private int maxProgress = 0;
    private int progressTime = 0;

    private final MetaTileEntity metaTileEntity;
    private final boolean hasMaintenance;

    private boolean isActive;
    private boolean isWorkingEnabled = true;
    private boolean wasActiveAndNeedsUpdate;

    private boolean hasNotEnoughEnergy;

    public DarkAetherReactorLogic(MetaTileEntity mte)
    {
        this.metaTileEntity = mte;
        this.hasMaintenance = false;
    }

    public void updateLogic()
    {
        if(!this.isWorkingEnabled)
        {
            return;
        }
    }
}
