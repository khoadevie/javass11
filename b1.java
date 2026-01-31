interface Drawable {
    void draw();
}

abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    abstract double getArea();
    abstract double getPerimeter();

    public void displayInfo() {
        System.out.println("Shape: " + name);
    }
}

class Rectangle extends Shape implements Drawable {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Main {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[2];

        shapes[0] = new Rectangle("Rectangle", 3, 4);
        shapes[1] = new Circle("Circle", 2);

        for (Shape s : shapes) {
            s.displayInfo();
            System.out.println("Area: " + s.getArea());
            System.out.println("Perimeter: " + s.getPerimeter());
            ((Drawable) s).draw();
            System.out.println();
        }
    }
}
