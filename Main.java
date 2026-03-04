public class Main {
    
    public static void main(String[] args) {
        Dog myDog = new Dog("Rufus", 2, "MyBreed", 3, 5);
        System.out.println(myDog.calculateAdoptionFee());
        System.out.println(Pet.getTotalPets());
    }
}
