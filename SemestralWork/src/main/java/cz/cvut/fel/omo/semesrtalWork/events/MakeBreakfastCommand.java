package cz.cvut.fel.omo.semesrtalWork.events;


import java.util.ArrayList;
import java.util.List;

public class MakeBreakfastCommand extends ACommand {
    private List<ACommand> commands = new ArrayList<>();

    public MakeBreakfastCommand(CommandParameters parameters) {
        super(parameters);
    }
    public void add(ACommand command){
        commands.add(command);
    }
    @Override
    public void execute() {
        parameters.getPerson().setHungry(false);
        parameters.getPerson().setFullness(100);
        parameters.getPerson().setActionTime(3);
        parameters.getPerson().setFree(false);
        for (var command : commands) {
            command.execute();
        }
        parameters.getHandler().eatFood();

    }

}
