package cz.cvut.fel.omo.semesrtalWork.observer.noSensorDevs;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;

public class Cattle extends ADevice {
    @Override
    public void updateState(double elapsedTime) {
        if (deviceState.getState() == State.USING) {
            electricityConsumption += 5;
            functionality -= 3.5;
            actionTime--;
        }
    }
}
