// Decorator Pattern Example - Adding toppings to a pizza

// Base component
interface Pizza {
    String getDescription();
    double getCost();
}

// Concrete component
class BasicPizza implements Pizza {
    public String getDescription() {
        return "Plain Pizza";
    }

    public double getCost() {
        return 100.0;
    }
}

// Decorator (abstract wrapper)
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

// Concrete decorators
class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    public double getCost() {
        return pizza.getCost() + 30.0;
    }
}

class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    public double getCost() {
        return pizza.getCost() + 20.0;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        // Nandani wants a pizza
        Pizza nandaniPizza = new BasicPizza();

        // She adds cheese
        nandaniPizza = new Cheese(nandaniPizza);

        // Then she adds olives
        nandaniPizza = new Olives(nandaniPizza);

        System.out.println("Order: " + nandaniPizza.getDescription());
        System.out.println("Total cost: ₹" + nandaniPizza.getCost());
    }
}

