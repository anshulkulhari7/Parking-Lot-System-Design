import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Ticket {
    public String id;
    public LocalDateTime entryTime;
    public LocalDateTime exitTime;
    public long entrytimestamp;
    public long exittimestamp;
    public Vehicle vehicle;
    public ParkingFloor floor;
    public ParkingSpot spot;
    public int cost;

    public Ticket(String id,Vehicle vehicle,long entrytimestamp,LocalDateTime entryTime){
        this.id=id;
        this.vehicle=vehicle;
        this.entrytimestamp=entrytimestamp;
        this.entryTime=entryTime;
    }
}

