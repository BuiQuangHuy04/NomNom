package BT.Object;

public class Duck {

    private String color;

    public void swim(){
        System.out.println("Swimming");
    }

    public void quack(){
        System.out.println("Quack quack quack!");
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void showInfo(){
        System.out.println("Color: "+ color);
    }

}
