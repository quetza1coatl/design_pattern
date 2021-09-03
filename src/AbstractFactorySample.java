public class AbstractFactorySample {
    public static void main(String[] args) {
        AbstractFactory factory = new MercedesFactory1();
        Bike1 bike = factory.getBike();
        Car1 car = factory.getCar();
        bike.drive();
        car.drive();
    }
}

interface Car1{
    void drive();
}
interface Bike1{
    void drive();
}

class MercedesCar1 implements Car1{
    @Override
    public void drive() {
        System.out.println("Drive Mercedes car");
    }
}
class MercedesBike1 implements Bike1{
    @Override
    public void drive() {
        System.out.println("Drive Mercedes bike");
    }
}

class ToyotaCar1 implements Car1{
    @Override
    public void drive() {
        System.out.println("Drive Toyota");
    }
}

class ToyotaBike1 implements Bike1{
    @Override
    public void drive() {
        System.out.println("Drive Toyota bike");
    }
}

interface AbstractFactory{
    Car1 getCar();
    Bike1 getBike();
}

class MercedesFactory1 implements AbstractFactory{

    @Override
    public Car1 getCar() {
        return new MercedesCar1();
    }

    @Override
    public Bike1 getBike() {
        return new MercedesBike1();
    }
}

class ToyotaFactory2 implements AbstractFactory{

    @Override
    public Car1 getCar() {
        return new ToyotaCar1();
    }

    @Override
    public Bike1 getBike() {
        return new ToyotaBike1();
    }
}
