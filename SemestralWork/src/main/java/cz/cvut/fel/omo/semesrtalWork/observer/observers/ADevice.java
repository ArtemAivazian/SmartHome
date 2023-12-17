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

    public void plugIn() {
        deviceState.plugIn();
    }

    public void plugOut() {
        deviceState.plugOut();
    }

    public void use() {
        deviceState.use();
    }
    public void stopUsage() {
        deviceState.stopUsage();
    }
    public void fix() {
        deviceState.fix();
    }
    public abstract void update();
}
