package cz.cvut.fel.omo.semesrtalWork.observer.devices;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.ADeviceState;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.DeviceOffState;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.simulation.DeviceDataCollector;

public abstract class ADevice implements DeviceDataCollector {
    protected ADeviceState deviceState;
    protected double electricityConsumption;
    protected double gasConsumption;
    protected double waterConsumption;
    protected double functionality; // Procentuální hodnota od 0 do 100


    public ADevice(double electricityConsumption, double gasConsumption, double waterConsumption, double functionality) {
         this.deviceState = new DeviceOffState(this, State.OFF);

        this.electricityConsumption = electricityConsumption;
        this.gasConsumption = gasConsumption;
        this.waterConsumption = waterConsumption;
        this.functionality = functionality;
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
}
