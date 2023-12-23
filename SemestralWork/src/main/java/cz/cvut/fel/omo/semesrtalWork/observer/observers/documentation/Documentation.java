package cz.cvut.fel.omo.semesrtalWork.observer.observers.documentation;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.ADevice;
import java.util.logging.Logger;

public class Documentation {
    private final ADevice device;
    private final double timeToFix;


    public Documentation(ADevice device, double timeToFix) {
        this.device = device;
        this.timeToFix = timeToFix;
    }
    public void fixDevice(ADevice device) {
        System.out.println("Reading manual");
    }
}