package cz.cvut.fel.omo.semesrtalWork.item;

public class Bike extends Item {

    public Bike() {
        actionTime = 8;
    }

    @Override
    public void updateState(double elapsedTime) {
        if (!isFree){
            actionTime--;
            if (actionTime == 0){
                isFree = true;
                actionTime = 8;
            }
        }
    }
}
