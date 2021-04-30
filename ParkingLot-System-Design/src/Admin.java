public class Admin extends Account implements IAdmin {
    public void addFloor(ParkingFloor floor){
        ParkingLot.parkingFloors.put(floor.id,floor);
    }
    public void addEntryGate(Gate gate){
        ParkingLot.entryGates.put(gate.id,gate);
    }
    public void addExitGate(Gate gate){
        ParkingLot.exitGates.put(gate.id,gate);
    }
    public void removeFloor(ParkingFloor floor){
        ParkingLot.parkingFloors.remove(floor.id);
    }
    public void removeEntryGate(Gate gate){
        ParkingLot.entryGates.remove(gate.id);
    }
    public void removeExitGate(Gate gate){
        ParkingLot.exitGates.remove(gate.id);
    }
    public void addAttendent(Attendent attendent){
        ParkingLot.attendents.put(attendent.id,attendent);
    }
    public void removeAttendent(Attendent attendent){
        ParkingLot.attendents.remove(attendent.id);
    }
    public void addParkingSpot(ParkingFloor parkingFloor,ParkingSpot parkingSpot){
        parkingFloor.parkingSpots.put(parkingSpot.id,parkingSpot);
        switch(parkingSpot.spotType){
            case SMALL:{
                parkingFloor.totalSmall=parkingFloor.totalSmall+1;
            }
            case MEDIUM:{
                parkingFloor.totalMedium=parkingFloor.totalMedium+1;
            }
            case LARGE:{
                parkingFloor.totalLarge=parkingFloor.totalLarge+1;
            }
            case XLARGE:{
                parkingFloor.totalXlarge=parkingFloor.totalXlarge+1;
            }
        }
    }
    public void removeParkingSpot(ParkingFloor parkingFloor,ParkingSpot parkingSpot){
        parkingFloor.parkingSpots.remove(parkingSpot.id);
        switch(parkingSpot.spotType){
            case SMALL:{
                parkingFloor.totalSmall=parkingFloor.totalSmall-1;
            }
            case MEDIUM:{
                parkingFloor.totalMedium=parkingFloor.totalMedium-1;
            }
            case LARGE:{
                parkingFloor.totalLarge=parkingFloor.totalLarge-1;
            }
            case XLARGE:{
                parkingFloor.totalXlarge=parkingFloor.totalXlarge-1;
            }
        }
    }

    public void changeCost(int cost){
        ParkingLot.cost=cost;
    }
}
