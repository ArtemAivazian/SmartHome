package cz.cvut.fel.omo.semesrtalWork.observer.observers.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.ADevice;

public class DeviceBrokenState extends ADeviceState{
    public DeviceBrokenState(ADevice device) {
        super(device);
    }

    @Override
    public void turnOn() {

    }
}
