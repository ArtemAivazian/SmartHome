package cz.cvut.fel.omo.semesrtalWork.observer.lightdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.LightAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;

public class SolarPanel extends LightAbstract {
    private LightASensor lightSensor;

    private final int treashold = 5;

    public SolarPanel(LightASensor lightSensor) {
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
