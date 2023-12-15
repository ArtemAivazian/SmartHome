package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.HeatAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.observers.LightAbstract;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    protected long time = 0;
    private List<LightAbstract> lightDevices = new ArrayList<>();
    private List<HeatAbstract> heatDevices = new ArrayList<>();

    public void addLightDevice(LightAbstract device){
        lightDevices.add(device);
    }
    public void addHeatDevice(HeatAbstract device) {
        heatDevices.add(device);
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
}
