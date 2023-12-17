package cz.cvut.fel.omo.semesrtalWork.observer;

public enum Threshold {
    LOW(0),
    MEDIUM(5),
    HIGH(10);

    private final int value;

    Threshold(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
