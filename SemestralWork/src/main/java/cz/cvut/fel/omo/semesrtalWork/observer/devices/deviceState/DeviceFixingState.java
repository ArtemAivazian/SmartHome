package cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class DeviceFixingState extends ADeviceState{
    public DeviceFixingState(ADevice device, State state) {
        super(device, state);
    }


    @Override
    public void use() {
        System.out.println("???");
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
        device.changeState(new DeviceOffState(device, State.OFF));
    }

    @Override
    public void broke() {
        device.changeState(new DeviceBrokenState(device, State.BROKEN));
    }
}
