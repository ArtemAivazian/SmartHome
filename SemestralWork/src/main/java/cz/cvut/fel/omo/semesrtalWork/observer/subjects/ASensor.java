package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.HeatAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.LightAbstract;

import java.util.ArrayList;
import java.util.List;

public abstract class ASensor {
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
    public abstract void build();
}
