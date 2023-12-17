package cz.cvut.fel.omo.semesrtalWork.observer.observers.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.ADevice;

public abstract class ADeviceState {
    protected ADevice device;

    public ADeviceState(ADevice device) {
        this.device = device;
    }

    public abstract void turnOn();
}
