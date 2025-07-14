nterface TravelStrategy {
    void travel();
}

// Concrete strategy 1
class BikeTravel implements TravelStrategy {
    public void travel() {
        System.out.println("Traveling by Bike 🚴‍♀️");
    }
}

// Concrete strategy 2
class BusTravel implements TravelStrategy {
    public void travel() {
        System.out.println("Traveling by Bus 🚌");
    }
}

// Context class
class Person {
    private TravelStrategy strategy;

    // Person decides how they want to travel
    public void setTravelStrategy(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void travelToWork() {
        if (strategy == null) {
            System.out.println("No travel strategy chosen!");
        } else {
            strategy.travel();
        }
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Person alice = new Person();

        // Today Alice takes a bike
        alice.setTravelStrategy(new BikeTravel());
        alice.travelToWork();  // Output: Traveling by Bike 🚴‍♀️

        // Tomorrow she decides to take the bus
        alice.setTravelStrategy(new BusTravel());
        alice.travelToWork();  // Output: Traveling by Bus 🚌
    }
}

