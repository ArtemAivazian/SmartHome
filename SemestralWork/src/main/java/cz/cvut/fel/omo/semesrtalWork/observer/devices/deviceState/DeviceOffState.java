package cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class DeviceOffState extends ADeviceState{
    public DeviceOffState(ADevice device, State state) {
        super(device, state);
    }

    @Override
    public void use() {
        device.changeState(new DeviceUsingState(device, State.USING));
    }

    @Override
    public void stopUsage() {
        System.out.println("???");
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
