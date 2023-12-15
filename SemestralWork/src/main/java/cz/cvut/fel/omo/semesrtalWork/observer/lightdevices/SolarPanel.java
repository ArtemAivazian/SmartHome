package cz.cvut.fel.omo.semesrtalWork.observer.lightdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatSensor;
import cz.cvut.fel.omo.semesrtalWork.observer.observers.LightAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightSensor;

public class SolarPanel extends LightAbstract {
    private LightSensor lightSensor;

    private final int treashold = 5;

    public SolarPanel(LightSensor lightSensor) {
        this.lightSensor = lightSensor;
    }

    @Override
    public void execute() {
        if (lightSensor.getValue() > treashold)
            System.out.println("Solar panel has been turned on");
        else
            System.out.println("Solar panel has been turned off");
    }
}
