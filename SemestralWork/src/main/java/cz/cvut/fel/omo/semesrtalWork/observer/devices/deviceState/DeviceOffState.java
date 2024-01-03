package cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class DeviceOffState extends ADeviceState{
    public DeviceOffState(ADevice ADevice, State state) {
        super(ADevice, state);
    }
    @Override
    public void use() {
        ADevice.changeState(new DeviceUsingState(ADevice, State.USING));
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
    public void toBreak() {
        ADevice.changeState(new DeviceBrokenState(ADevice, State.BROKEN));
    }
}
