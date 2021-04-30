import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

public class Attendent extends Account {
    public Ticket assignTicket(Vehicle vehicle){
        Ticket ticket =null;
        //This function contains whole logic that how we want to assign a parking spot
        //from all the available parking spots.
        outerloop:
        for(Map.Entry<String,ParkingFloor> floor : ParkingLot.parkingFloors.entrySet()){
            switch (vehicle.type){
                case SMALL: {
                    if(floor.getValue().freeSmall>0){
                        ticket=floor.getValue().assignVehicle(vehicle,Type.SMALL);
                        break outerloop;
                    }
                }
                case MEDIUM:{
                    if(floor.getValue().freeMedium>0){
                        ticket=floor.getValue().assignVehicle(vehicle,Type.MEDIUM);
                        break outerloop;
                    }
                }
                case LARGE:{
                    if(floor.getValue().freeLarge>0){
                        ticket=floor.getValue().assignVehicle(vehicle,Type.LARGE);
                        break outerloop;
                    }
                }
                case XLARGE:{
                    if(floor.getValue().freeXlarge>0){
                        ticket=floor.getValue().assignVehicle(vehicle,Type.XLARGE);
                        break outerloop;
                    }
                }
                ticket.floor=floor.getValue();
            }
        }
        ParkingLot.tickets.put(ticket.id,ticket);
        return ticket;
    }

    public Ticket giveExitTicket(Ticket ticket){
        ticket.floor.parkingSpots.get(ticket.spot).isFree=true;
        switch (ticket.vehicle.type){
            case SMALL:{
                ticket.floor.freeSmall=ticket.floor.freeSmall+1;
            }
            case MEDIUM:{
                ticket.floor.freeMedium=ticket.floor.freeMedium+1;
            }
            case LARGE:{
                ticket.floor.freeLarge=ticket.floor.freeLarge+1;
            }
            case XLARGE:{
                ticket.floor.freeXlarge=ticket.floor.freeXlarge+1;
            }
        }
        ticket.floor.parkingSpots.put(ticket.floor.parkingSpots.get(ticket.spot).id,ticket.floor.parkingSpots.get(ticket.spot));
        Ticket exitTicket=ticket;
        exitTicket.exittimestamp=new Timestamp(System.currentTimeMillis()).getTime();
        exitTicket.cost=(int)(ParkingLot.cost*(exitTicket.exittimestamp-exitTicket.entrytimestamp)/(1000*60));
        exitTicket.exitTime= LocalDateTime.now();
        ParkingLot.tickets.put(exitTicket.id,exitTicket);
        return exitTicket;
    }
}
