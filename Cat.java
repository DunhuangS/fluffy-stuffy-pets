public class Cat extends Pet implements Adoptable {

    private final String SPECIES = "Cat";
    boolean goodMouser = false;

    /*Constructor
    *@param name   the name of the cat
    *@param age     the age of the cat, in years
    *@param breed   the breed of the cat
    *@param fat  how much percent body fat the cat has. Weight has been repurposed in this class.
    */
    public Cat(String name, int age, String breed, int fat) {
        super(name, age, breed, fat);
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
    //The cat's fat must be in the perfectly healthy range
    public void trainCat() {
        if (getWeight() >= 16 && getWeight() <= 24)
            goodMouser = true;
        else 
            System.out.println("This cat does not have a healthy body fat, and cannot become a mouser!");
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
            priceMult = 1.0 - (0.025 * ((double) getAge() - 1.0));
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
        //adjust price based on body fat
        //ideal body fat range is 15-24%, however 10-30% is still acceptable.
        
        //if age is 1 or less, then body fat does not contribute and the cat is healthy.
        if (getAge() < 2) {
            System.out.println("this cat is perfectly healthy!");
            weightMult = 1.5;
        }
        else if (getWeight() >= 15 && getWeight() <= 24) {
            System.out.println("this cat is perfectly healthy!");
            weightMult = 1.5;
        }
        else if (getWeight() >= 10 && getWeight() <= 30) {
            System.out.println("this cat is healthy.");
            weightMult = 1;
        }
        //linearly decrease price when fat % is less than 10
        else if (getWeight() < 10) {
            System.out.println("this cat is underweight.");
            weightMult = (0.1 * getWeight());
        }
        //linearly decrease price by 10% per percent when fat % is greater than 30
        else {
            System.out.println("this cat is overweight.");
            weightMult = 1 - (0.1 * (getWeight() - 30));
        }

        if (weightMult < 0) {
            weightMult = 0;
        }
        

        System.out.println("Their price multiplier at this body fat is " + weightMult + ".");

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
