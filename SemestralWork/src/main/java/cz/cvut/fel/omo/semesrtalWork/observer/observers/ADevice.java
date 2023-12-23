package cz.cvut.fel.omo.semesrtalWork.observer.observers;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.deviceState.ADeviceState;
import cz.cvut.fel.omo.semesrtalWork.observer.observers.deviceState.DeviceOffState;
import cz.cvut.fel.omo.semesrtalWork.observer.observers.deviceState.State;

public abstract class ADevice {
    private ADeviceState deviceState;

    public ADevice() {
         this.deviceState = new DeviceOffState(this, State.OFF);
    }
    public void changeState (ADeviceState state){
        deviceState = state;
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
