package cz.cvut.fel.omo.semesrtalWork.observer.noSensorDevs;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;

public class Microwave extends ADevice {

    @Override
    public void updateState(double elapsedTime) {
        if (deviceState.getState() == State.USING) {
            functionality -= 1.5;
            electricityConsumption += 10;
            actionTime--;
        }
    }
}
