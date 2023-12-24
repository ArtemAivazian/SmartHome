package cz.cvut.fel.omo.semesrtalWork.observer.lightdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.LightAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;

public class WindowBlind extends LightAbstract {
    private LightASensor lightSensor;
    private final Threshold threshold = Threshold.MEDIUM;

    public WindowBlind(LightASensor lightSensor) {
        this.lightSensor = lightSensor;
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
