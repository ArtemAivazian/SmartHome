package cz.cvut.fel.omo.semesrtalWork.observer.lightdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.LightAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;

public class WindowBlind extends LightAbstract {
    private LightASensor lightSensor;
    private final int threshold = 30;

    public WindowBlind(LightASensor lightSensor) {
        this.lightSensor = lightSensor;
    }

    @Override
    public void execute() {
        if (lightSensor.getValue() > threshold)
            System.out.println("Window Blind has been down");
        else
            System.out.println("Window Blind has been up");
    }

}
