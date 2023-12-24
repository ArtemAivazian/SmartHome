package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class TakeBikeCommand implements ICommand {
    private EventHandler handler;
    public TakeBikeCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {

    }
    @Override
    public void execute(ADevice device) {

    }

    @Override
    public void execute(AItem item) {
        if (item.isFree()){
            item.use();
            handler.takeSkies();
        } else {
            System.out.println("BahuY");
        }
    }

    @Override
    public void execute(Pet pet) {

    }
}
