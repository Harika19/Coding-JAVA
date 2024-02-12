package ParkingLotLLD;

public class User extends AbstractPerson {
    public User(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    protected String getDetails(){
        return this.getName();
    }

    public static void main(String[] args) {
        User obj = new User("name", "900");
        System.out.println(obj.getDetails());

    }
}
