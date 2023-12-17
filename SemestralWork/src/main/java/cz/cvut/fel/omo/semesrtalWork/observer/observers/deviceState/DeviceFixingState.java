package cz.cvut.fel.omo.semesrtalWork.observer.observers.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.ADevice;

public class DeviceFixingState extends ADeviceState{
    public DeviceFixingState(ADevice device, State state) {
        super(device, state);
    }


    @Override
    public void use() {

    }

    @Override
    public void stopUsage() {

    }

    @Override
    public void fix() {

    }

    @Override
    public void stopFix() {
        device.changeState(new DeviceOffState(device, State.OFF));
    }

    @Override
    public void broke() {
        device.changeState(new DeviceBrokenState(device, State.BROKEN));
    }
}
