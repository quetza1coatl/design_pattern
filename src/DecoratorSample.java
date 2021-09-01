public class DecoratorSample {
    public static void main(String[] args) {
        Pizza pizza = new HamPizza(new CheesePizza(new BasicPizza()));
        System.out.println(pizza.makePizza());
    }
}

interface Pizza{
    String makePizza();
}

class BasicPizza implements Pizza{
    @Override
    public String makePizza() {
        return "Pizza with";
    }
}

class CheesePizza implements Pizza{
    private Pizza pizza;

    CheesePizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String makePizza() {
        return pizza.makePizza() + " cheese";
    }
}

class HamPizza implements Pizza{
    private Pizza pizza;

    HamPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String makePizza() {
        return pizza.makePizza() + " ham";
    }
}
