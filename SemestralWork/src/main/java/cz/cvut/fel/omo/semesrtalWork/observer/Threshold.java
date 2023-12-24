package cz.cvut.fel.omo.semesrtalWork.observer;

public enum Threshold {
    LOW(100),
    MEDIUM(500),
    HIGH(1000);

    private final int value;

    Threshold(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
