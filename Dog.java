public class Dog extends Pet implements Adoptable {

    private final String SPECIES = "Dog";
    ServiceDogType service = ServiceDogType.None;

    public Dog(String name, int age, String breed, int weight, int height) {
        super(name, age, breed, weight, height);
    }

    @Override
    public String getSpecies() {
        return SPECIES;
    }

    @Override
    public double calculateAdoptionFee() {
        //adjust price based on age. if age = 0 to 1, charge a set percent less.
        //Otherwise, charge less based on age (until age 21 = $0)
        //if age is > 31, it is a world record holding dog and its price is significantly increased.
        double priceMult;
        if (getAge() <= 1) {
            priceMult = 0.2;
            System.out.println("This is a young dog.");
        } else if (getAge() <= 31) {
            priceMult = 1.0 - (0.05 * ((double) getAge() - 1.0));
            if (priceMult < 0) {
                priceMult = 0;
            }
            System.out.println("This is an adult dog.");
        } else {
            priceMult = 50;
            System.out.println("This is the oldest dog in the world.");
        }

        priceMult *= 2;

        System.out.println("Their price multiplier at this age is " + priceMult + ".");

        double weightMult;
        //adjust price based on weight. 
        //we assume weight is in kg, and height is in cm.
        //The basic formula is (Weight in kg / 0.45) / (Height in cm / 2.54) = BMI.
        //Dog BMI should generally be less than 3 for most species, and above 0.5 
        //    -> boundry increased to 3.5 for leniency
        //The dog is still growing from ages 0-2 so we only check for bmi > 3.5
        //As the dog ages BMI naturally increases
        //for each year past age 10 upper bound lenience increases by 0.05

        double BMI = (getWeight() / 0.45) / (getHeight() / 2.54);

        System.out.println("The dog has a BMI of " + BMI + ".");
        if (BMI < 0.5) {
            if (getAge() > 2) {
                //linearly decrease price to 0
                weightMult = 1 - (2 * (0.5 - BMI));
                System.out.println("This dog is underweight.");
            } else {
                //perfectly healthy
                weightMult = 1.5;
                System.out.println("This dog is perfectly healthy.");
            }
        } else if (BMI > 3.5 && getAge() <= 10) {
            //reduce price by 30% for each BMI above 3.5
            weightMult = 1 - ((BMI - 3.5) * 0.3);
            System.out.println("This dog is overweight.");
        } else if (BMI > (3.5 + ((double) (getAge() - 10) * 0.05))) {
            //reduce price by 30% for each BMI above dynamic threshold
            weightMult = 1 - ((BMI - (3.5 + ((double) (getAge() - 10) * 0.05))) * 0.3);
            System.out.println("This dog is overweight.");
        } else {
            //perfectly healthy
            weightMult = 1.5;
            System.out.println("This dog is perfectly healthy.");
        }

        System.out.println("Their price multiplier at this BMI is " + weightMult + ".");

        //adjust price by breed
        //I could insert a long dictionary for each value of dog breed
        //but that would be boring and a waste of time
        //so instead I will change price by $10 for each character in the breed name
        //spaces mean the breed has multiple words and is probably cooler 
        //so $100 increase per space
        double finalPrice = BASE_FEE;

        double priceAddition = (getBreed().length() * 10) + (countSpaces(getBreed()) * 90);

        System.out.println("The dog's breed increases its price by $" + priceAddition + ".");
        //final calculation
        finalPrice += priceAddition;
        finalPrice *= priceMult;
        finalPrice *= weightMult;
        //rounding
        finalPrice = ((double) ((int) (finalPrice * 100)) / 100);

        if(finalPrice < BASE_FEE) {
            finalPrice = BASE_FEE;
            System.out.println("This dog is priced at minimum.");
        }

        System.out.println("The dog's final price for adoption is $" + finalPrice + ".");
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

    public ServiceDogType getServiceDogType() {
        return service;
    }    

    public void setServiceDogType(String type) {
        service = ServiceDogType.valueOf(type);
    }

    public void setServiceDogType(int type) {
        service = ServiceDogType.values()[type];
    }


}
