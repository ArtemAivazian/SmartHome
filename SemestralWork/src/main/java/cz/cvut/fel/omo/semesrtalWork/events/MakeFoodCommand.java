package cz.cvut.fel.omo.semesrtalWork.events;


import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Person;
import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

import java.util.ArrayList;
import java.util.List;

public class MakeFoodCommand implements ICommand {
    private CommandParameters parameters;

    public MakeFoodCommand(CommandParameters parameters) {
        this.parameters = parameters;
    }

    private List<ICommand> commands = new ArrayList<>();
    public void add(ICommand command){
        commands.add(command);
    }
    @Override
    public void execute() {
        parameters.getPerson().setHungry(false);
        parameters.getPerson().setFullness(100);
        parameters.getPerson().setActionTime(2);
        parameters.getPerson().setFree(false);
        for (var command : commands) {
            command.execute();
        }
        parameters.getHandler().eatFood();

    }

}
