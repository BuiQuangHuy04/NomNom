package BT.Object;

public class Main {

    public static void main(String[] args){

        Duck duck = new Duck();
        Fish fish = new Fish();
        Horse horse = new Horse();

        System.out.println("\nBT.Object.Duck: ");
        duck.setColor("Đen");
        duck.showInfo();

        System.out.println("\nBT.Object.Fish: ");
        fish.showInfo();

        System.out.println("\nBT.Object.Horse: ");
        horse.showInfo();

    }
}