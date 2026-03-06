public class Main {
    
    public static void main(String[] args) {
        Dog myDog = new Dog("Rufus", 2, "MyBreed", 32, 59);
        System.out.println(myDog.calculateAdoptionFee());
        System.out.println(Pet.getTotalPets());
        Dog myCatty = new Dog("ruffles", 9, "impostor", 4,25);
        myCatty.calculateAdoptionFee();
    }
}
