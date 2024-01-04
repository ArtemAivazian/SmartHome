package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;

public class SmokeSensor extends ASensor{

    public SmokeSensor() {
        this.threshold = Threshold.MEDIUM;
    }




    @Override
    public void updateState(double elapsedTime) {
        functionality -= 0.0000001;
        electricityConsumption += 0.1;
    }
}
