package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;

import java.util.Random;

public class HeatSensor extends ASensor {

    public HeatSensor() {
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
            notifyHeatDevices();
        }
        else if ( value <= threshold.getValue() && turnOn) {
            turnOn = false;
        }
        functionality -= 0.0000001;
        electricityConsumption += 0.1;
    }
}
