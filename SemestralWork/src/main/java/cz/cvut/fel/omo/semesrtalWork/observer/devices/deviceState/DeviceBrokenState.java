package cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class DeviceBrokenState extends ADeviceState{

    public DeviceBrokenState(ADevice ADevice, State state) {
        super(ADevice, state);
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
        ADevice.changeState(new DeviceFixingState(ADevice, State.FIXING));
    }

    @Override
    public void stopFix() {
        System.out.println("???");
    }

    @Override
    public void toBreak() {
        ADevice.changeState(new DeviceBrokenState(ADevice, State.BROKEN));
    }
}
