import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ParkingSpot {
    public String id;
    public int num;
    public Type spotType;
    public boolean isFree;
    public Vehicle vehicle;

    public boolean isSpotFree(){
        return this.isFree;
    }
    public void removeVehicle(){
        this.isFree=true;
    }

    public Ticket assignVehicleToSpot(Vehicle vehicle){
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        Ticket ticket=new Ticket(Double.toString(Math.random()),vehicle,timestamp.getTime(), LocalDateTime.now());
        this.vehicle=vehicle;
        this.isFree=false;
        return ticket;
    }

}


