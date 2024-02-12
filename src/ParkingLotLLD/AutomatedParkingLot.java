package ParkingLotLLD;

public class AutomatedParkingLot implements ParkingLotInterface{
    @Override
    public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean updateParkingAttendant(ParkingAttendant parkingAttendant, int gateId) {
        return false;
    }

}
