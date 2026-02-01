import java.util.ArrayList;

public class Habitat {
    private String id;
    private String species;
    private Food food;
    private double amountFood;
    private String[] feedingTime;
    private ArrayList<Animal> animals;

    Habitat(String id, String species, double amountFood, String[] feedingTime, ArrayList<Animal> animals, Food food) {
        this.id = id;
        this.species = species;
        this.amountFood = amountFood;
        this.feedingTime = feedingTime;
        this.animals = animals;
        this.food = food;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public double getAmountFood() {
        return amountFood;
    }

    public String[] getFeedingTime() {
        return feedingTime;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public Food getFoodId() {
        return food;
    }

    // Setter : these fields are modifiable
    public void setAmountFood(double amountFood) {
        this.amountFood = amountFood;
    }

    public void setFeedingTime(String[] feedingTime) {
        this.feedingTime = feedingTime;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
}

