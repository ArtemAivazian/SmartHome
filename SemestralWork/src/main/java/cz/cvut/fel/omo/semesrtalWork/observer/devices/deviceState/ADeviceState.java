package cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public abstract class ADeviceState {
    protected ADevice device;
    private State state;

    public ADeviceState(ADevice device, State state) {
        this.device = device;
        this.state = state;
    }

    public abstract void use();
    public abstract void stopUsage();
    public abstract void fix();
    public abstract void stopFix();
    public abstract void broke();

    public State getState() {
        return state;
    }
}
