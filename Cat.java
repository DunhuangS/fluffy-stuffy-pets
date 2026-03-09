public class Cat extends Pet implements Adoptable {

    private final String SPECIES = "Cat";
    boolean goodMouser = false;

    /*Constructor
    *@param name   the name of the cat
    *@param age     the age of the cat, in years
    *@param breed   the breed of the cat
    *@param weight  how heavy the cat is, in kg
    *@param height  how tall the cat is, in cm
    */
    public Cat(String name, int age, String breed, int weight, int height) {
        super(name, age, breed, weight, height);
    }

    //returns the species (cat).
    //@return SPECIES
    @Override
    public String getSpecies() {
        return SPECIES;
    }

    //returns whether the cat is a good mouser.
    //@return goodMouser
    public boolean getGoodMouser() {
        return goodMouser;
    }

    //sets the status of goodMouser to true. This cannot be unlearned.
    public void trainCat() {
        goodMouser = true;
    }

    //calculates the price of adopting the cat using its age, height, weight, and breed.
    //@return finalPrice    the final calculated price to adopt a cat
    @Override
    public double calculateAdoptionFee() {
        //Cats usually cost slightly less than Dogs to adopt, so the price is cheaper (multiplier lower).

        //adjust price based on age. if age = 0 to 1, charge a set percent less.
        //Otherwise, charge less based on age (until age 21 = $0)
        //if age is > 38, it is a world record holding cat and its price is significantly increased.
        double priceMult;
        if (getAge() <= 1) {
            priceMult = 0.2;
            System.out.println("This is a young cat.");
        } else if (getAge() <= 38) {
            priceMult = 1.0 - (0.05 * ((double) getAge() - 1.0));
            System.out.println("This is an adult cat.");
        } else {
            priceMult = 50;
            System.out.println("This is the oldest cat in the world.");
        }

        if (priceMult < 0) {
                priceMult = 0;
        }
        System.out.println("Their price multiplier at this age is " + priceMult + ".");
        


        double weightMult;
        //adjust price based on weight. 
        //we assume weight is in kg, and height is in cm.
        //The basic formula is (Weight in kg / 0.45) / (Height in cm / 2.54) = BMI.
        //Cat BMI should generally be less than 1.5 for most species, and above 0.75 
        //    -> boundry increased to 1.75 for leniency
        //The cat is still growing from ages 0-2 so we only check for bmi > 1.75
        //As the cat ages BMI naturally decreases after age 10! This is from muscle loss and illnesses.
        //This means BMI restriction will decrease minorly after age 10.

        double BMI = (getWeight() / 0.45) / (getHeight() / 2.54);

        System.out.println("The cat has a BMI of " + BMI + ".");
        if (BMI < 0.75) {
            if (getAge() > 2) {
                //linearly decrease price to 0
                weightMult = 1 - (((double) 4 / 3) * (0.75 - BMI));
                System.out.println("This cat is underweight.");
            } else {
                //perfectly healthy
                weightMult = 1.5;
                System.out.println("This cat is perfectly healthy.");
            }
        } else if (BMI > 1.75 && getAge() <= 10) {
            //reduce price by 40% for each BMI above 1.75
            weightMult = 1 - ((BMI - 1.75) * 0.4);
            System.out.println("This cat is overweight.");
        } else if (BMI > (1.75 - ((double) (getAge() - 10) * 0.02))) {
            //reduce price by 35% for each BMI above dynamic threshold
            weightMult = 1 - ((BMI - (1.75 - ((double) (getAge() - 10) * 0.02))) * 0.35);
            System.out.println("This cat is overweight.");
        } else {
            //perfectly healthy
            weightMult = 1.5;
            System.out.println("This cat is perfectly healthy.");
        }

        if (weightMult < 0) {
                weightMult = 0;
        }

        System.out.println("Their price multiplier at this BMI is " + weightMult + ".");

        //adjust price by breed
        //Same as dogs, I could insert a long dictionary for each value of cat breed
        //but that would be boring and a waste of time
        //so instead I will change price by $5 for each character in the breed name
        //spaces mean the breed has multiple words and is probably cooler 
        //so $35 increase per space <- again, cats are cheaper than dogs in general
        double finalPrice = BASE_FEE;

        double priceAddition = (getBreed().length() * 5) + (countSpaces(getBreed()) * 30);

        System.out.println("The cat's breed increases its price by $" + priceAddition + ".");
        //final calculation
        finalPrice += priceAddition;
        finalPrice *= priceMult;
        finalPrice *= weightMult;
        //rounding
        finalPrice = ((double) ((int) (finalPrice * 100)) / 100);

        if(finalPrice < BASE_FEE) {
            finalPrice = BASE_FEE;
            System.out.println("This cat is priced at minimum.");
        }

        System.out.println("The cat's final price for adoption is $" + finalPrice + ".");
        return finalPrice;

    }

    private int countSpaces(String text) {
        int count = 0;
        for(int i = 0; i < text.length() - 1; i++) {
            if (text.substring(i,i+1).equals(" ")) {
                count++;
            }
        }
        return count;
    }
}
