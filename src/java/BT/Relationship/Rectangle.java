package BT.Relationship;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    @Override
    double getArea() {
        return width*length;
    }

    @Override
    double getPerimeter() {
        return 2*(length+width);
    }

    @Override
    public String toString() {
        return "\nRectangle " + getColor() + " " + getLength() + " " + getWidth() + " " + isFilled();
    }


}