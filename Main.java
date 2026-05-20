import java.io.*;

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

        //file Output
        Pet[] PetList = {myDog, dog2, myCatty, cat2};

        try {
            FileOutputStream temp = new FileOutputStream("data.dat");
            ObjectOutputStream output = new ObjectOutputStream(temp);
            for (Pet toSave : PetList) {
                output.writeObject(toSave);
            }
            output.close();
            temp.close();

        } catch (FileNotFoundException e) {
            System.err.println("The file seems to not be found (which is weird because I'm making it)");
            System.err.println(e);
        } catch (IOException e){
            System.err.println("Something went wrong with the ObjectOutput");
            System.err.println(e);
        }


        //File Input
        try {
            FileInputStream temp2 = new FileInputStream("data.dat");
            ObjectInputStream input = new ObjectInputStream(temp2);
            
            try {
                System.out.println("Reading Saved Pets:");
                while (true) {
                    Pet readPet = (Pet) input.readObject();
                    System.out.println("This pet is a " + readPet.getSpecies());
                    System.out.println("Its name is " + readPet.getName());
                    System.out.println("Its age is " + readPet.getAge());
                    System.out.println("Its breed is " + readPet.getBreed());
                    System.out.println("Its weight is " + readPet.getWeight());
                    System.out.println();

                }
            } catch (EOFException e) {
                //nothing happens, tells when the file ends.
            }

            temp2.close();
            input.close();

        } catch (FileNotFoundException e) {
            System.err.println("The file doesn't exist where it's supposed to exist");
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println("Bad class");
            System.err.println(e);
        } catch (IOException e) {
            System.err.println("Something went wrong with the ObjectInput");
            System.err.println(e);
        }

    }
}
