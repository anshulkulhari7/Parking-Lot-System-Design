public interface IAdmin {
    void addFloor(ParkingFloor floor);
    void removeFloor(ParkingFloor floor);
    void addEntryGate(Gate gate);
    void addExitGate(Gate gate);
    void removeEntryGate(Gate gate);
    void removeExitGate(Gate gate);
    void addParkingSpot(ParkingFloor parkingFloor,ParkingSpot parkingSpot);
    void removeParkingSpot(ParkingFloor parkingFloor,ParkingSpot parkingSpot);
    void addAttendent(Attendent attendent);
    void removeAttendent(Attendent attendent);
}
