package cz.cvut.fel.omo.semesrtalWork.observer.heatdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.AHeat;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatASensor;

public class Heater extends AHeat {

    private HeatASensor heatSensor;
    public Heater(HeatASensor heatSensor) {
        this.heatSensor = heatSensor;
        threshold = Threshold.LOW;
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
        if (deviceState.getState() == State.USING) {
            functionality -= 2;
            electricityConsumption += 10;
        }
    }
}
