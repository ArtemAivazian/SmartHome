package cz.cvut.fel.omo.semesrtalWork.Events;

public abstract class AInhabitant {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void invokeEvent() {
        command.execute();
    }
}
