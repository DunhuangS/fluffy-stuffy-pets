public class Main {
    
    public static void main(String[] args) {
        Dog myDog = new Dog("Rufus", 9, "MyBreed", 32, 59);
        System.out.println(myDog.calculateAdoptionFee());
        System.out.println(Pet.getTotalPets());
        Cat myCatty = new Cat("Mittens", 9, "MyBreed", 20);
        System.out.println(myCatty.calculateAdoptionFee());
        Dog dog2 = new Dog("Ruffles", 2,"T H E   E X P E N S I V E", 21, 42);
        System.out.println(dog2.calculateAdoptionFee());
        Cat cat2 = new Cat("Amber", 3, "Other Breed", 34);
        System.out.println(cat2.calculateAdoptionFee());

        myCatty.trainCat();
        System.out.println("myCatty is a good mouser?: " + myCatty.getGoodMouser());
        cat2.trainCat();
        System.out.println("cat2 is a good mouser?: " + cat2.getGoodMouser());

        System.out.println("myDog's service dog type: " + myDog.getServiceDogType());
        myDog.setServiceDogType("Guide");
        System.out.println("myDog's new service dog type: " + myDog.getServiceDogType());
    }
}
