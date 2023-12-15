package cz.cvut.fel.omo.semesrtalWork.observer.subjects.factory;

import cz.cvut.fel.omo.semesrtalWork.SLocation;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.Sensor;

public interface ISensorFactory {
    Sensor create(String type, SLocation location);
}
