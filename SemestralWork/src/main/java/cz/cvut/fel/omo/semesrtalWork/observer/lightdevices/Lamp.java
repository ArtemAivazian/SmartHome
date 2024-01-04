package cz.cvut.fel.omo.semesrtalWork.observer.lightdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ALight;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightSensor;

public class Lamp extends ALight {
    private LightSensor lightSensor;

    public Lamp(LightSensor lightSensor) {
        this.lightSensor = lightSensor;
    }

    @Override
    public void execute() {
        if (deviceState.getState() == State.OFF) {
            System.out.println("Lamp has been turned on");
            deviceState.use();
        } else {
            System.out.println("Lamp has been turned off");
            deviceState.stopUsage();
        }
    }

    @Override
    public void updateState(double elapsedTime) {
        if (deviceState.getState() == State.USING) {
            functionality -= 0.1;
            electricityConsumption += 3;
        }
    }
}
