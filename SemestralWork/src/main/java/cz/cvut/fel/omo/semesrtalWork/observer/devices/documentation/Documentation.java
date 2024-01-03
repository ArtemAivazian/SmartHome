package cz.cvut.fel.omo.semesrtalWork.observer.devices.documentation;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class Documentation {
    private final ADevice ADevice;
    private final double timeToFix;


    public Documentation(ADevice ADevice, double timeToFix) {
        this.ADevice = ADevice;
        this.timeToFix = timeToFix;
    }
    public void fixDevice(ADevice ADevice) {
        System.out.println("Reading manual");
    }
}
