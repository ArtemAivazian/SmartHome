package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.AHeat;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ALight;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ASmoke;
import cz.cvut.fel.omo.semesrtalWork.simulation.DataCollector;

import java.util.ArrayList;
import java.util.List;

public abstract class ASensor implements DataCollector {
    protected Threshold threshold;
    protected int value = 0;

    protected boolean turnOn = false;

    private List<ALight> lightDevices = new ArrayList<>();
    private List<AHeat> heatDevices = new ArrayList<>();
    private List<ASmoke> smokeDevices = new ArrayList<>();
    protected double electricityConsumption = 0;
    protected double gasConsumption = 0;
    protected double waterConsumption = 0;
    protected double functionality = 100; // Procentuální hodnota od 0 do 100


    public void addLightDevice(ALight device){
        lightDevices.add(device);
    }
    public void addHeatDevice(AHeat device) {
        heatDevices.add(device);
    }
    public void addSmokeDevice(ASmoke device) {
        smokeDevices.add(device);
    }

    public void notifyHeatDevices() {
        for (var device : heatDevices)
            device.execute();
    }

    public void notifyLightDevices() {
        for (var device : lightDevices) {
            device.execute();
        }
    }

    public void notifySmokeDevices() {
        for (var device : smokeDevices) {
            device.execute();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValueHeat(int value) {
        this.value = value;
    }

    public void setValueLight(int value) {
        this.value = value;
    }


    public void setValueSmoke(int value) {
        this.value = value;
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
