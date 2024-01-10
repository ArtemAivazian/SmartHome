package cz.cvut.fel.omo.semesrtalWork.observer.lightdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ALight;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightSensor;

public class WindowBlind extends ALight {
    private LightSensor lightSensor;

    public WindowBlind(LightSensor lightSensor) {
        this.lightSensor = lightSensor;
    }

    @Override
    public void execute() {
        if (deviceState.getState() == State.OFF) {
            System.out.println("Window Blin has been turned on");
            this.use();
        } else {
            System.out.println("Window Blind has been turned off");
            stopUsage();
        }
    }

    @Override
    public void updateState(double elapsedTime) {}
}
