package cz.cvut.fel.omo.semesrtalWork.simulation;

import java.io.IOException;

public interface ITimeTracker {
    void update(long time) throws IOException;
}
