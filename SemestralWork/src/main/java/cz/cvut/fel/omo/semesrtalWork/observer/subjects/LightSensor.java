package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;

public class LightSensor extends ASensor {


    public LightSensor() {
        this.threshold = Threshold.LOW;
    }




    @Override
    public void updateState(double elapsedTime) {
        if (turnOn){
            value -= 15;
        }
        if (value >= threshold.getValue() && !turnOn) {
            value = 150;
            turnOn = true;
            notifyLightDevices();
        }
        else if ( value <= threshold.getValue() && turnOn) {
            turnOn = false;
        }
        functionality -= 0.0000001;
        electricityConsumption += 0.1;
    }
}
