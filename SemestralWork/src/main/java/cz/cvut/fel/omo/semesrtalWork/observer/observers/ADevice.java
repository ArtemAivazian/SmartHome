package cz.cvut.fel.omo.semesrtalWork.observer.observers;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.deviceState.ADeviceState;
import cz.cvut.fel.omo.semesrtalWork.observer.observers.deviceState.DeviceOffState;

public abstract class ADevice {
    private ADeviceState deviceState;

    public ADevice(ADevice deviceState) {
         this.deviceState = new DeviceOffState(this);
    }
    public void changeState (ADeviceState state){
        deviceState = state;
    }
    public void turnOn() {
        deviceState.turnOn();
    }
    public abstract void update();
}
