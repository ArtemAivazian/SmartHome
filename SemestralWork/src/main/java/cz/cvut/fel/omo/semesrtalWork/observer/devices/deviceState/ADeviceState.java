package cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public abstract class ADeviceState {
    protected ADevice ADevice;
    private State state;

    public ADeviceState(ADevice ADevice, State state) {
        this.ADevice = ADevice;
        this.state = state;
    }

    public abstract void use();
    public abstract void stopUsage();
    public abstract void fix();
    public abstract void stopFix();
    public abstract void toBreak();

    public State getState() {
        return state;
    }
}
