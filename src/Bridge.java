public class Bridge {
    public static void main(String[] args) {
        Vehicle audiCar = new Car(new Audi());
        audiCar.drive();

        Vehicle toyotaCar = new Car(new Toyota());
        toyotaCar.drive();

        Vehicle toyotaTrack = new Track(new Toyota());
        toyotaTrack.drive();
    }
}
//adding a model or manufacturer leads to a significant increase in the number of classes

/*interface Car{}
interface Track{}
interface Bike{}

class ToyotaCar{}
class ToyotaTrack{}
class ToyotaBike{}

class MercedesCar{}
class MercedesTrack{}
class MercedesBike{}

class AudiCar{}
class AudiTrack{}
class AudiBike{}
*/

// for vehicle types, e.g. car, track, bike, etc
abstract class Vehicle{
    Model model;

    Vehicle(Model model) {
        this.model = model;
    }


    abstract void drive();
}

class Car extends Vehicle{
    Car(Model model) {
        super(model);
    }

    @Override
    void drive() {
        model.drive("drive car");
    }
}

class Track extends Vehicle{
    Track(Model model) {
        super(model);
    }

    @Override
    void drive() {
        model.drive("drive track");
    }
}

// for manufacturers, e.g. Toyota, Mercedes, Audi, etc
interface Model{
    void drive (String actionForVehicleType);
}

class Audi implements Model{

    @Override
    public void drive(String actionForVehicleType) {
        System.out.println(actionForVehicleType + " Audi");
    }
}

class Toyota implements Model{

    @Override
    public void drive(String actionForVehicleType) {
        System.out.println(actionForVehicleType + " Toyota");
    }
}
