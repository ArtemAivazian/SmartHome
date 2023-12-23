package cz.cvut.fel.omo.semesrtalWork.observer.lightdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.LightAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;

public class Lamp extends LightAbstract {
    private LightASensor lightSensor;

    private final Threshold threshold = Threshold.LOW;

    public Lamp(LightASensor lightSensor, double electricityConsumption, double functionality) {
        super(electricityConsumption, 0, 0, functionality);
        this.lightSensor = lightSensor;
    }

    @Override
    public void execute() {
        if (lightSensor.getValue() == threshold.getValue())
            System.out.println("Lamp has been turned on");
        else
            System.out.println("Lamp has been turned off");
    }

    @Override
    public void updateState(double elapsedTime) {

    }
}
