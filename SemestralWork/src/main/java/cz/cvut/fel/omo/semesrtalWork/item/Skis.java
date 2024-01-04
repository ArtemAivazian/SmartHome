package cz.cvut.fel.omo.semesrtalWork.item;

public class Skis extends Item {
    public Skis() {
        actionTime = 10;
    }

    @Override
    public void updateState(double elapsedTime) {
        if (!isFree){
            actionTime--;
            if (actionTime == 0){
                System.out.println("Skis are Free");
                isFree = true;
                actionTime = 10;
            }
        }
    }
}
