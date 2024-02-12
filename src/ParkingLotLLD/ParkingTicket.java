package ParkingLotLLD;

public class ParkingTicket {
    String ticketId;
    String userId;
    String entryTime;
    String exitTime;

    public ParkingTicket(String ticketId, String userId, String entryTime, String exitTime) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }
}
