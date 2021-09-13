public class VisitorSample {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.accept(new SoundVisitor());
        cat.accept(new EatVisitor());
    }
}

interface Animal{
    void accept(AnimalVisitor animalVisitor);
}

class Dog implements Animal{

    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

class Cat implements Animal{

    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

interface AnimalVisitor{
    void action (Dog dog);
    void action (Cat cat);
}

class SoundVisitor implements AnimalVisitor{

    @Override
    public void action(Dog dog) {
        System.out.println("Woof!");
    }

    @Override
    public void action(Cat cat) {
        System.out.println("Meow!");
    }
}

class EatVisitor implements AnimalVisitor{

    @Override
    public void action(Dog dog) {
        System.out.println("Eat meat");
    }

    @Override
    public void action(Cat cat) {
        System.out.println("Eat fish");
    }
}
