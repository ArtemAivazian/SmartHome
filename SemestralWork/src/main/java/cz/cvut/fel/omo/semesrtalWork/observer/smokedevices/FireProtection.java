package cz.cvut.fel.omo.semesrtalWork.observer.smokedevices;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.SmokeAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.SmokeSensor;

public class FireProtection extends SmokeAbstract {
    private SmokeSensor smokeSensor;
    private final Threshold threshold = Threshold.LOW;

    public FireProtection(SmokeSensor smokeSensor) {
        this.smokeSensor = smokeSensor;
    }

    @Override
    public void execute() {
        if (smokeSensor.getValue() > threshold.getValue())
            deviceState.use();
        else
            deviceState.stopUsage();
    }

    @Override
    public void updateState(double elapsedTime) {
        if (deviceState.getState() == State.USING) {
            waterConsumption += 25;
            electricityConsumption += 0.001;
            functionality -= 8;
        }
    }
}
