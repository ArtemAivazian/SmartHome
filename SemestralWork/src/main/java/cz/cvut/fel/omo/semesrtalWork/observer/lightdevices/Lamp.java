package cz.cvut.fel.omo.semesrtalWork.observer.lightdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.LightAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightSensor;

public class Lamp extends LightAbstract {
    private LightSensor lightSensor;

    private final int treashold = 0;

    public Lamp(LightSensor lightSensor) {
        this.lightSensor = lightSensor;
    }

    @Override
    public void execute() {
        if (lightSensor.getValue() == treashold)
            System.out.println("Lamp has been turned on");
        else
            System.out.println("Lamp has been turned off");
    }

}
