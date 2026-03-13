public class Main {
    
    public static void main(String[] args) {
        //dogs
        Dog myDog = new Dog("Rufus", 9, "MyBreed", 32, 59);
        System.out.println(myDog.calculateAdoptionFee());
        
        System.out.println("Total pets created: " + Pet.getTotalPets());

        Dog dog2 = new Dog("Ruffles", 1,"T H E   E X P E N S I V E", 2, 42);
        System.out.println(dog2.calculateAdoptionFee());

        //the dog becomes an adult, and is now subject to underweight pricing
        dog2.setAge(2);
        System.out.println(dog2.calculateAdoptionFee());

        //the dog's weight increases to a normal range
        dog2.setWeight(21);
        System.out.println(dog2.calculateAdoptionFee());

        //the age cannot decrease!
        dog2.setAge(1);


        //cats
        Cat myCatty = new Cat("Mittens", 9, "MyBreed", 20);
        System.out.println(myCatty.calculateAdoptionFee());

        Cat cat2 = new Cat("Amber", 3, "Other Breed", 34);
        System.out.println(cat2.calculateAdoptionFee());

        System.out.println("Total pets created: " + Pet.getTotalPets());

        //mousing and service dogs
        myCatty.trainCat();
        System.out.println("myCatty is a good mouser?: " + myCatty.getGoodMouser());
        //cat2 is not a good mouser after training because its body fat is too high
        cat2.trainCat();
        System.out.println("cat2 is a good mouser?: " + cat2.getGoodMouser());

        cat2.setWeight(22);

        //the cat can now be a good mouser.
        cat2.trainCat();
        System.out.println("cat2 is a good mouser?: " + cat2.getGoodMouser());

        //default service is None
        System.out.println("myDog's service dog type: " + myDog.getServiceDogType());
        //sets the service using string
        myDog.setServiceDogType("Guide");
        System.out.println("myDog's new service dog type: " + myDog.getServiceDogType());
        //sets the service using index
        myDog.setServiceDogType(8);
        System.out.println("myDog's newer service dog type: " + myDog.getServiceDogType());


        //pricing after mousing and service
        myDog.calculateAdoptionFee();
        cat2.calculateAdoptionFee();

        //special cases
        dog2.setAge(40); // <- oldest dog
        dog2.calculateAdoptionFee();
        cat2.setAge(50); // <- oldest cat
        cat2.calculateAdoptionFee();


    }
}
