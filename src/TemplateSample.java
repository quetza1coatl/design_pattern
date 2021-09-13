public class TemplateSample {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();
        tea.makeBeverage();
        coffee.makeBeverage();
    }
}

abstract class Beverage{
    private void boilWater(){
        System.out.println("Boiled water");
    }
    private void addSugar(){
        System.out.println("Added sugar");
    }
    abstract void addBeverage();
    abstract void addCondiment();

    void hook(){ }

    void makeBeverage(){
        boilWater();
        addBeverage();
        addSugar();
        addCondiment();
        hook();
    }
}

class Tea extends Beverage{
    @Override
    void addBeverage() {
        System.out.println("Added tea");
    }

    @Override
    void addCondiment() {
        System.out.println("Added lemon");
    }

    @Override
    void hook() {
        System.out.println("Tea is ready");
    }
}

class Coffee extends Beverage{

    @Override
    void addBeverage() {
        System.out.println("Added coffee");
    }

    @Override
    void addCondiment() {
        System.out.println("Added milk");
    }
}
