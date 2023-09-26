package cz.cvut.k36.omo.hw.hw01;

public class Homework1 {
    private int countH = 0;
    private static int countI = 0;
    public boolean f() {
        return true;
    }

    public static boolean g() {
        return false;
    }

    public int h() {
        countH++;
        return countH;
    }

    public int i() {
        countI++;
        return countI;
    }
}
