package cz.cvut.fel.omo.semesrtalWork.observer.devices;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.ADeviceState;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.DeviceOffState;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;

public abstract class ADevice {
    protected ADeviceState deviceState;
    protected String name;
    protected  double usageTime = 0;
    protected double totalWaterConsumption = 0;
    protected double totalElectricityConsumption = 0;
    protected double totalGasConsumption = 0;
    protected double waterConsuming = 0;
    protected double electricityConsumption = 0;
    protected double gasConsuming = 0;
    protected double fixingTime = 0;


    public ADevice() {
         this.deviceState = new DeviceOffState(this, State.OFF);
    }
    public void changeState (ADeviceState state){
        deviceState = state;
    }


    public void use() {
        deviceState.use();
    }
    public void stopUsage() {
        deviceState.stopUsage();
    }
    public void fix() {
        deviceState.fix();
    }
}
