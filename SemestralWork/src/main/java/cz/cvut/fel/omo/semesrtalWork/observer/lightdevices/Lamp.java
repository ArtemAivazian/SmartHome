package cz.cvut.fel.omo.semesrtalWork.observer.lightdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.LightAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;

public class Lamp extends LightAbstract {
    private LightASensor lightSensor;
    private final Threshold threshold = Threshold.LOW;

    public Lamp(LightASensor lightSensor) {
        this.lightSensor = lightSensor;
    }

    @Override
    public void execute() {
        if (lightSensor.getValue() == threshold.getValue())
            deviceState.use();
        else
            deviceState.stopUsage();
    }

    @Override
    public void updateState(double elapsedTime) {
        if (deviceState.getState() == State.USING) {
            functionality -= 0.1;
            electricityConsumption += 3;
        }
    }
}
