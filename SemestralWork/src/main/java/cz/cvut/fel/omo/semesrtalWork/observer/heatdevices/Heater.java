package cz.cvut.fel.omo.semesrtalWork.observer.heatdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.HeatAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatASensor;

public class Heater extends HeatAbstract {

    private HeatASensor heatSensor;

    private final Threshold threshold = Threshold.LOW;
    public Heater(HeatASensor heatSensor, double electricityConsumption, double functionality) {
        super(electricityConsumption, 0, 0, functionality);
        this.heatSensor = heatSensor;
    }

    @Override
    public void execute() {
        if (heatSensor.getValue() < threshold.getValue())
            System.out.println("Heater has been turned on");
        else
            System.out.println("Heater has been turned off");
    }

    @Override
    public void updateState(double elapsedTime) {

    }
}
