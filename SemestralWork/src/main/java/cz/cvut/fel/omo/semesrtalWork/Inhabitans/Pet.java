package cz.cvut.fel.omo.semesrtalWork.Inhabitans;

import cz.cvut.fel.omo.semesrtalWork.events.ICommand;

public class Pet extends AInhabitant{

    @Override
    public void updateState(double elapsedTime) {
        fullness -= 5;
    }
}
