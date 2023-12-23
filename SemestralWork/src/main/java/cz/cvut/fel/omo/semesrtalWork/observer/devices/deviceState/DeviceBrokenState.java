package cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class DeviceBrokenState extends ADeviceState{

    public DeviceBrokenState(ADevice device, State state) {
        super(device, state);
    }

    @Override
    public void use() {
        System.out.println("Device is already broken");
    }

    @Override
    public void stopUsage() {
        System.out.println("???");
    }

    @Override
    public void fix() {
        device.changeState(new DeviceFixingState(device, State.FIXING));
    }

    @Override
    public void stopFix() {
        System.out.println("???");
    }

    @Override
    public void broke() {
        device.changeState(new DeviceBrokenState(device, State.BROKEN));
    }
}
