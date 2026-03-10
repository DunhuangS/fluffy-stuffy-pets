public class Main {
    
    public static void main(String[] args) {
        Dog myDog = new Dog("Rufus", 9, "MyBreed", 32, 59);
        System.out.println(myDog.calculateAdoptionFee());
        
        System.out.println(Pet.getTotalPets());

        Dog dog2 = new Dog("Ruffles", 1,"T H E   E X P E N S I V E", 2, 42);
        System.out.println(dog2.calculateAdoptionFee());

        dog2.setAge(2);
        System.out.println(dog2.calculateAdoptionFee());

        dog2.setWeight(21);
        System.out.println(dog2.calculateAdoptionFee());

        dog2.setAge(1);



        Cat myCatty = new Cat("Mittens", 9, "MyBreed", 20);
        System.out.println(myCatty.calculateAdoptionFee());

        Cat cat2 = new Cat("Amber", 3, "Other Breed", 34);
        System.out.println(cat2.calculateAdoptionFee());

        System.out.println(Pet.getTotalPets());

        myCatty.trainCat();
        System.out.println("myCatty is a good mouser?: " + myCatty.getGoodMouser());
        cat2.trainCat();
        System.out.println("cat2 is a good mouser?: " + cat2.getGoodMouser());

        cat2.setWeight(22);

        cat2.trainCat();
        System.out.println("cat2 is a good mouser?: " + cat2.getGoodMouser());

        System.out.println("myDog's service dog type: " + myDog.getServiceDogType());
        myDog.setServiceDogType("Guide");
        System.out.println("myDog's new service dog type: " + myDog.getServiceDogType());


    }
}
