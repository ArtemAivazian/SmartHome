package cz.cvut.fel.omo.semesrtalWork.simulation;

public interface DeviceDataCollector {
    double getElectricityConsumption();
    double getGasConsumption();
    double getWaterConsumption();
    double getFunctionality();
    void updateState(double elapsedTime);
}
