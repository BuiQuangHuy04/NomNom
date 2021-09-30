package BT.Relationship;

public class Square extends Rectangle {
    private  double side;

    public double getSide() {
        return side;
    }

    public void setSite(double site) {
        this.side = site;
    }

    Square(double side) {
        this.side=side;
    }

    @Override
    public String toString() {
        return "\nSquare " + getColor() + " " + getSide() + " " + isFilled();
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }

}
