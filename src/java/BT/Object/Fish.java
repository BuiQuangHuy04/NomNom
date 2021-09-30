package BT.Object;

public class Fish {

    private int size;
    private boolean canEat;

    public void swim(){
        System.out.println("Swimming");
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) { this.size = size; }

    public boolean isCanEat() {
        return canEat;
    }

    public void setCanEat(boolean canEat) {
        this.canEat = canEat;
    }

    public void showInfo(){
        System.out.println("Size: "+ size + "\ncanEat: " + canEat);
    }
}
