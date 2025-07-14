// Factory Pattern Example - Creating Shapes without exposing object creation logic

interface Shape {
    void draw();
}

// Concrete implementation 1
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("This is a Circle.");
    }
}

// Concrete implementation 2
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("This is a Square.");
    }
}

// Factory class that decides which Shape to return
class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;

        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        }

        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        // Let's ask the factory for a Circle
        Shape shape1 = factory.getShape("circle");
        shape1.draw();  // Output: This is a Circle.

        // Now ask for a Square
        Shape shape2 = factory.getShape("square");
        shape2.draw();  // Output: This is a Square.
    }
}

