package cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class DeviceUsingState extends ADeviceState{
    public DeviceUsingState(ADevice device, State state) {
        super(device, state);
    }

    @Override
    public void use() {
        System.out.println("???");
    }

    @Override
    public void stopUsage() {
        device.changeState(new DeviceOffState(device, State.OFF));
    }

    @Override
    public void fix() {
        System.out.println("???");
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
