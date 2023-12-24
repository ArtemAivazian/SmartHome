package cz.cvut.fel.omo.semesrtalWork.observer.noSensorDevs;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;

public class GasCooker extends ADevice {

    @Override
    public void updateState(double elapsedTime) {
        if (deviceState.getState() == State.USING) {
            functionality -= 0.0001;
            gasConsumption += 50;
            electricityConsumption += 2;
        }

    }
}
