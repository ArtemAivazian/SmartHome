package cz.cvut.fel.omo.semesrtalWork.observer.devices;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.ADeviceState;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.DeviceOffState;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;

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
}
