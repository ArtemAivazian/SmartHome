package cz.cvut.fel.omo.semesrtalWork.observer.devices;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.ADeviceState;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.DeviceOffState;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.simulation.Action;
import cz.cvut.fel.omo.semesrtalWork.simulation.DataCollector;

public abstract class ADevice extends Action implements DataCollector {
    protected ADeviceState deviceState;
    protected double electricityConsumption = 0;
    protected double gasConsumption = 0;
    protected double waterConsumption = 0;
    protected double functionality = 100; // Procentuální hodnota od 0 do 100
    private String type;


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

    @Override
    public double getElectricityConsumption() {
        return electricityConsumption;
    }

    @Override
    public double getGasConsumption() {
        return gasConsumption;
    }

    @Override
    public double getWaterConsumption() {
        return waterConsumption;
    }

    @Override
    public double getFunctionality() {
        return functionality;
    }

    public abstract void updateState(double elapsedTime);

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
