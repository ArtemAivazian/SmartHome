package cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class DeviceFixingState extends ADeviceState{
    public DeviceFixingState(ADevice ADevice, State state) {
        super(ADevice, state);
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
        ADevice.changeState(new DeviceOffState(ADevice, State.OFF));
    }

    @Override
    public void toBreak() {
        ADevice.changeState(new DeviceBrokenState(ADevice, State.BROKEN));
    }
}
