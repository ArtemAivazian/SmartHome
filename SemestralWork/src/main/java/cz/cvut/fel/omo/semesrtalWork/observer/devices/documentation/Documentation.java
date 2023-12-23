package cz.cvut.fel.omo.semesrtalWork.observer.devices.documentation;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

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
