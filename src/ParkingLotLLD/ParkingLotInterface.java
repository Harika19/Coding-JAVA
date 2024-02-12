package ParkingLotLLD;

public interface ParkingLotInterface {
    public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle);
    public boolean updateParkingAttendant(ParkingAttendant parkingAttendant, int gateId);
}


