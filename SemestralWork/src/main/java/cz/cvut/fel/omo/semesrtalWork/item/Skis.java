package cz.cvut.fel.omo.semesrtalWork.item;

public class Skis extends AItem{
    public Skis() {
        usageTime = 10;
    }

    @Override
    public void updateState(double elapsedTime) {
        if (isUsing){
            usageTime--;
            if (usageTime == 0){
                isUsing = false;
                usageTime = 10;
            }
        }
    }
}
