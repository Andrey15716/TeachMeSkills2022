public class Main {
    public static void main(String[] args) {
        PassengerTransport audi = new PassengerTransport();
        audi.setModel("a4");
        audi.setBodyType("седан");
        audi.setHorsePower(150);
        audi.setKwPower(audi.getHorsePower());
        audi.setMaxSpeed(250);
        audi.setWeight(2100);
        audi.setPassengerQuantity(4);
        audi.setConsumption(12);
        audi.setWheelQuantity(4);
        System.out.println(audi.infoOfGroundTransport() + audi.infoOfPassengerTransport());
        audi.infoTravelTime(3);
        System.out.println();

        FreightTransport scania = new FreightTransport();
        scania.setModel("Scania");
        scania.setConsumption(18);
        scania.setHorsePower(200);
        scania.setKwPower(scania.getHorsePower());
        scania.setMaxSpeed(120);
        scania.setLoadCapacity(15);
        scania.setWeight(3500);
        scania.setWheelQuantity(6);
        System.out.println(scania.infoOfGroundTransport() + scania.infoOfFreightTransport());
        scania.infoLoadCapacity(25, scania.getLoadCapacity());
        System.out.println();

        PassengerAirTransport boing = new PassengerAirTransport();
        boing.setModel("Boing");
        boing.setAvailabilityOfBusinessClass(false);
        boing.setHorsePower(2343);
        boing.setMaxSpeed(342);
        boing.setHorsePower(boing.getHorsePower());
        boing.setWeight(30000);
        boing.setWingSpan(9);
        boing.setMinRunwayLength(1200);
        boing.setPassengerQuantity(15);
        System.out.println(boing.infoOfAirTransport() + boing.infoPassengerAirTransport());
        boing.infoPassengerCapacity(190, 5, true);
        System.out.println();

        MilitaryTransport ty160 = new MilitaryTransport();
        ty160.setModel("K");
        ty160.setAvailabilityCatapult(true);
        ty160.setHorsePower(12000);
        ty160.setMaxSpeed(10000);
        ty160.setKwPower(ty160.getHorsePower());
        ty160.setWeight(2121);
        ty160.setWingSpan(5);
        ty160.setRocketQuantity(2);
        ty160.setMinRunwayLength(100);
        System.out.println(ty160.infoOfAirTransport() + ty160.infoOfMilitaryTransport());
        ty160.infoRocket(10, ty160.getRocketQuantity());
        ty160.setAvailabilityCatapult(true);
        System.out.println();
    }
}
