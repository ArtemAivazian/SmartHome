package cz.cvut.fel.omo.semesrtalWork.events;


import java.util.ArrayList;
import java.util.List;

public class MakeFoodComposite implements ICommand{
    private List<ICommand> commands = new ArrayList<>();
    public void add(ICommand command){
        commands.add(command);
    }
    @Override
    public void execute() {
        for (var command : commands ){
            command.execute();
        }

    }
}
