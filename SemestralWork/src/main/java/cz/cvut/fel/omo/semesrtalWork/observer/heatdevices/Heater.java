package cz.cvut.fel.omo.semesrtalWork.observer.heatdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.HeatAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatASensor;

public class Heater extends HeatAbstract {

    private HeatASensor heatSensor;

    private final Threshold threshold = Threshold.LOW;
    public Heater(HeatASensor heatSensor) {
        this.heatSensor = heatSensor;
    }

    @Override
    public void execute() {
        if (heatSensor.getValue() < threshold.getValue())
            System.out.println("Heater has been turned on");
        else
            System.out.println("Heater has been turned off");
    }

}
