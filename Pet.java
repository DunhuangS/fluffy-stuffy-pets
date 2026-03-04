public abstract class Pet {

    private static int totalPets = 0;

    private String name;
    private int age;
    private String breed;
    private int weight;
    private int height;

    public Pet(String name, int age, String breed, int weight, int height) {
        totalPets++;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
        this.height = height;
    }

    abstract String getSpecies();

    public static int getTotalPets() {
        return totalPets;
    }

    //getset

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge >= age) {
            age = newAge;
        } else {
            System.out.println("Age cannot decrease!");
        }
    }

    public String getBreed() {
        return breed;
    }

    // no setBreed

    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int newWeight) {
        weight = newWeight;
    }

    public int getHeight() {
        return height;
    }
    
    public void setHeight(int newHeight) {
        height = newHeight;
    }

}
