package InterfaceExample;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver("GEAR");
        Bike bike = driver.rideBike.bikeObj;
        bike.turnOnBike();
        bike.turnOffBike();
    }
}
