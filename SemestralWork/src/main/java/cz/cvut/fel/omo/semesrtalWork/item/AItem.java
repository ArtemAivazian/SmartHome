package cz.cvut.fel.omo.semesrtalWork.item;

import cz.cvut.fel.omo.semesrtalWork.simulation.AAction;
import cz.cvut.fel.omo.semesrtalWork.simulation.DataCollector;

public abstract class AItem extends AAction {



    public void  use(){
        isFree = false;
    }
    public abstract void updateState(double elapsedTime);
}
