package cz.cvut.fel.omo.semesrtalWork.item;

public class Skis extends AItem{
    public Skis() {
        actionTime = 10;
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
