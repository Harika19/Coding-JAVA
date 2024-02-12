package ParkingLotLLD;

public abstract class AbstractPerson implements PersonInterface {
    String name;
    String phoneNumber;

    public AbstractPerson(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }
}

