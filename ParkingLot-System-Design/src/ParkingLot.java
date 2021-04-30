import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
//Note:
//In this code only one parking lot is considered, so instead of keeping track of everything
//in database, everything is stored in static variable of parking lot class
//If we want multiple parking lots then everywhere instead of using parkinglot's static variable we can use
//a database.
public class ParkingLot {
    private String zipCode;
    public static HashMap<String,Gate> entryGates;
    public static HashMap<String,Gate> exitGates;
    public static HashMap<String,ParkingFloor> parkingFloors;
    public static HashMap<String,Ticket> tickets;
    public static HashMap<String,Attendent> attendents;
    public static int cost;

}
