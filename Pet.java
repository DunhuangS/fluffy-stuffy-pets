public abstract class Pet {

    private static int totalPets = 0;

    private String name;
    private int age;
    private String breed;
    private int weight;
    private int height;

    /*Constructor
    *@param name   the name of the pet
    *@param age     the age of the pet, in years
    *@param breed   the breed of the pet
    *@param weight  how heavy the pet is, in kg
    *@param height  how tall the pet is, in cm
    */
    public Pet(String name, int age, String breed, int weight, int height) {
        totalPets++;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
        this.height = height;
    }

    abstract String getSpecies();

    //returns the total number of pet objects created.
    //@return totalPets total number of pet objects created
    public static int getTotalPets() {
        return totalPets;
    }

    //getters and setters

    //returns the name of the pet
    //@return name
    public String getName() {
        return name;
    }

    //gives the pet a new name
    //@param newName
    public void setName(String newName) {
        name = newName;
    }

    //returns the age of the pet
    //@return age
    public int getAge() {
        return age;
    }

    //Sets the new age of the pet
    //The new given age must be greater than the current age.
    //@param newAge
    public void setAge(int newAge) {
        if (newAge >= age) {
            age = newAge;
        } else {
            System.out.println("Age cannot decrease!");
        }
    }

    //returns the breed of the pet
    //@return breed
    public String getBreed() {
        return breed;
    }

    // no setBreed, breed cannot be changed in any way

    //returns the weight, in kg
    //@return weight
    public int getWeight() {
        return weight;
    }
    
    //sets a new weight, in kg, for the pet
    //@param newWeight
    public void setWeight(int newWeight) {
        weight = newWeight;
    }

    //returns the height of the pet, in cm
    //@return height
    public int getHeight() {
        return height;
    }
    
    //sets the new height, in cm, of the pet
    //@param newHeight
    public void setHeight(int newHeight) {
        height = newHeight;
    }

}
