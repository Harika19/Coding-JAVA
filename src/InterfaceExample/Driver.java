package InterfaceExample;

public class Driver {
//    GearBike gearBike = new GearBike();
//    GearLessBike gearLessBike = new GearLessBike();

    RideBike rideBike;

    public Driver(String bikeType) {
        //rideBike = new RideBike( gearBike, gearLessBike );

        // for interfaces to create an obj -> interfacename obj = new implemented classname()

        Bike bikeObj1= null;
        if( bikeType.equals("GEAR")){
            bikeObj1 = new GearBike();
        }else if(bikeType.equals("GEARLESS")){
            bikeObj1 = new GearLessBike();
        }


        rideBike = new RideBike(bikeObj1 );
    }
}
