package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.HeatAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.LightAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.SmokeAbstract;
import cz.cvut.fel.omo.semesrtalWork.simulation.DataCollector;

import java.util.ArrayList;
import java.util.List;

public abstract class ASensor implements DataCollector {
    private List<LightAbstract> lightDevices = new ArrayList<>();
    private List<HeatAbstract> heatDevices = new ArrayList<>();
    private List<SmokeAbstract> smokeDevices = new ArrayList<>();
    protected double electricityConsumption = 0;
    protected double gasConsumption = 0;
    protected double waterConsumption = 0;
    protected double functionality = 100; // Procentuální hodnota od 0 do 100


    public void addLightDevice(LightAbstract device){
        lightDevices.add(device);
    }
    public void addHeatDevice(HeatAbstract device) {
        heatDevices.add(device);
    }
    public void addSmokeDevice(SmokeAbstract device) {
        smokeDevices.add(device);
    }

    public void notifyHeatDevices() {
        for (var device : heatDevices)
            device.update();
    }

    public void notifyLightDevices() {
        for (var device : lightDevices) {
            device.update();
        }
    }

    public void notifySmokeDevices() {
        for (var device : smokeDevices) {
            device.update();
        }
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
