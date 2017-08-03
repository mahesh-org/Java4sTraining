package oops.inheritance;

public class AnimalInheritanceTest {

    public static void main(String[] args) {
        Cat cat = new Cat(false, "milk", 4, "black");

        System.out.println("Cat is Vegetarian?" + cat.isVegetarian());
        System.out.println("Cat eats " + cat.getEats());
        System.out.println("Cat has " + cat.getNoOfLegs() + " legs.");
        System.out.println("Cat color is " + cat.getColor());



    }

}