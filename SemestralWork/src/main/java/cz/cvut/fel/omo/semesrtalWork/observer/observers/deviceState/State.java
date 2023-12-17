package cz.cvut.fel.omo.semesrtalWork.observer.observers.deviceState;

public enum State {
    LOW(0),
    MEDIUM(5),
    HIGH(10);

    private final int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
