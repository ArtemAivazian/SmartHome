package cz.cvut.fel.omo.semesrtalWork.observer.lightdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ALight;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;

public class WindowBlind extends ALight {
    private LightASensor lightSensor;

    public WindowBlind(LightASensor lightSensor) {
        this.lightSensor = lightSensor;
        threshold = Threshold.MEDIUM;
    }

    @Override
    public void execute() {
        if (lightSensor.getValue() > threshold.getValue()) {
            deviceState.use();
            functionality -= 7;
            electricityConsumption += 10;
        } else {
            deviceState.stopUsage();
            functionality -= 7;
            electricityConsumption += 10;
        }
    }

    @Override
    public void updateState(double elapsedTime) {}
}
