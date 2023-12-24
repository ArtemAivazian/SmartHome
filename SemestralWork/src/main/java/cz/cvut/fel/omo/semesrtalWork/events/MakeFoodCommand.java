package cz.cvut.fel.omo.semesrtalWork.events;


import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Person;
import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

import java.util.ArrayList;
import java.util.List;

public class MakeFoodCommand implements ICommand {
    private EventHandler handler;
    private Person person;

    public MakeFoodCommand(EventHandler handler, Person person) {
        this.handler = handler;
        this.person = person;
    }

    @Override
    public void execute() {
        person.setHungry(false);
        person.setFullness(100);
        person.setActionTime(2);
        person.setFree(false);
        handler.eatFood();
    }

    @Override
    public void execute(ADevice device) {
        System.out.println("!!?");
    }

    @Override
    public void execute(AItem item) {

    }
    @Override
    public void execute(Pet pet) {

    }
}
