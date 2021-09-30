package BT.Relationship;

public class Circle extends Shape {
    private double radius;

    Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return radius*radius*3.14;
    }

    @Override
    double getPerimeter() {
        return 3.14*radius*2;
    }

    @Override
    public String toString() {
        return "\nCircle " + getColor() + " " + getRadius() + " " + isFilled();
    }
}