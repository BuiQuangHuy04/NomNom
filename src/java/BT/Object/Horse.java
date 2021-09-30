package BT.Object;

public class Horse{

    private String color;
    private boolean isWild;

    public void run(){}

    public boolean isMammal(){
        return true;
    }

    public void showInfo(){
        System.out.println("Color: "+ color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isWild() {
        return isWild;
    }

    public void setWild(boolean wild) {
        isWild = wild;
    }

}
