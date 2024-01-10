package cz.cvut.fel.omo.semesrtalWork.observer.heatdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.AHeat;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatSensor;

public class Heater extends AHeat {

    private HeatSensor heatSensor;
    public Heater(HeatSensor heatSensor) {
        this.heatSensor = heatSensor;
    }
    @Override
    public void execute() {
        if (deviceState.getState() == State.OFF) {
            System.out.println("Heater has been turned on");
            this.use();
        } else {
            System.out.println("Heater has been turned off");
            stopUsage();
        }
    }

    @Override
    public void updateState(double elapsedTime) {
        if (deviceState.getState() == State.USING) {
            functionality -= 2;
            electricityConsumption += 10;
        }
    }
}
