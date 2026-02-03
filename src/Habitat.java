import java.util.ArrayList;

class Habitat {
    String id;
    String species;
    Food food;
    double amountFood;
    String[] feedingTime;
    Animal[] animals;

    Habitat(String id, String species, double amountFood, String[] feedingTime, Animal[] animals, Food food) {
        this.id = id;
        this.species = species;
        this.amountFood = amountFood;
        this.feedingTime = feedingTime;
        this.animals = animals;
        this.food = food;
    }
}

