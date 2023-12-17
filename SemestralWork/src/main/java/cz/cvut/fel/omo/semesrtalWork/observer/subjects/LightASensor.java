package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

public class LightSensor extends Sensor {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyLightDevices();
    }
}
