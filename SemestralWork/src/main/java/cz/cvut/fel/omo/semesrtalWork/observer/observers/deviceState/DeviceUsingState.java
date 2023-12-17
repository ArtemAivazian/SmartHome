package cz.cvut.fel.omo.semesrtalWork.observer.observers.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.ADevice;

public class DeviceUsingState extends ADeviceState{
    public DeviceUsingState(ADevice device, State state) {
        super(device, state);
    }

    @Override
    public void use() {

    }

    @Override
    public void stopUsage() {
        device.changeState(new DeviceOffState(device, State.OFF));
    }

    @Override
    public void fix() {

    }

    @Override
    public void stopFix() {

    }

    @Override
    public void broke() {
        device.changeState(new DeviceBrokenState(device, State.BROKEN));
    }
}
