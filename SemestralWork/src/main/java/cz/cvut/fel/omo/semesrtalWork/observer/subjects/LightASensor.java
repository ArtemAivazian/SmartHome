package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

public class LightASensor extends ASensor {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyLightDevices();
    }

    @Override
    public void build() {
        System.out.println("Create Light Sensor");
    }
}
