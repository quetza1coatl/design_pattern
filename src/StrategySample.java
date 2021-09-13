public class StrategySample {
    public static void main(String[] args) {
        Transport t = new Car2(new NoFly());
        Transport t1 = new Jet(new Fly());
        t.fly();
        t1.fly();
    }
}

interface Flyable{
    void fly();
}

class Fly implements Flyable{

    @Override
    public void fly() {
        System.out.println("Fly");
    }
}

class NoFly implements Flyable{

    @Override
    public void fly() {
        System.out.println("Can't fly");
    }
}

abstract class Transport {
    private Flyable flyable;

    Transport(Flyable flyable) {
        this.flyable = flyable;
    }

    abstract void run();
    void fly(){
        flyable.fly();
    }
}

class Car2 extends Transport{

    Car2(Flyable flyable) {
        super(flyable);
    }

    @Override
    void run() {  }
}

class Jet extends Transport{

    Jet(Flyable flyable) {
        super(flyable);
    }

    @Override
    void run() {  }
}
