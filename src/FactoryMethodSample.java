public class FactoryMethodSample {
    public static void main(String[] args) {
        CarFactory factory= new MercedesFactory();
        CarFactory factory1 = new ToyotaFactory();
        factory.createCar();
        factory1.createCar();
    }
}

interface Car0{
    void drive();
}

class MercedesCar implements Car0{
    @Override
    public void drive() {
        System.out.println("Drive Mercedes");
    }
}

class ToyotaCar implements Car0{
    @Override
    public void drive() {
        System.out.println("Drive Toyota");
    }
}

abstract class CarFactory{
    void createCar(){
        Car0 car = getCar();
        car.drive();
        // more code
    }

    abstract Car0 getCar();
}

class MercedesFactory extends CarFactory{
    @Override
    Car0 getCar() {
        return new MercedesCar();
    }
}

class ToyotaFactory extends CarFactory{
    @Override
    Car0 getCar() {
        return new ToyotaCar();
    }
}
