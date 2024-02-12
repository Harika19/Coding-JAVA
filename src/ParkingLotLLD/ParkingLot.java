package ParkingLotLLD;

public class ParkingLot implements  ParkingLotInterface{
    String parkingLotName;

    public ParkingLot(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    @Override
    public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean updateParkingAttendant(ParkingAttendant parkingAttendant, int gateId) {
        return false;
    }
}
