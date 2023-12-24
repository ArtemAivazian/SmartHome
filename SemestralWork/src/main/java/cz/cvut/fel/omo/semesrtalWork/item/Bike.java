package cz.cvut.fel.omo.semesrtalWork.item;

public class Bike extends AItem{

    public Bike() {
        usageTime = 8;
    }

    @Override
    public void updateState(double elapsedTime) {
        if (isUsing){
            usageTime--;
            if (usageTime == 0){
                isUsing = false;
                usageTime = 8;
            }
        }
    }
}
