package util;

import model.Animal;
import model.Food;
import java.util.ArrayList;
import java.util.List;

public class ZooConfig {
    // These lists hold all your data
    public static List<Animal> allAnimals = new ArrayList<>();
    public static List<Food> allFoods = new ArrayList<>();

    // // STATIC BLOCK: This runs automatically when the program starts
    // static {
    //     // 1. Create 10 Food types
    //     allFoods.add(new Food("Bamboo", "Plant"));
    //     allFoods.add(new Food("Steak", "Meat"));
    //     allFoods.add(new Food("Banana", "Fruit"));
    //     allFoods.add(new Food("Fish", "Seafood"));
    //     allFoods.add(new Food("Eucalyptus", "Plant"));
    //     allFoods.add(new Food("Insects", "Protein"));
    //     allFoods.add(new Food("Grass", "Fiber"));
    //     allFoods.add(new Food("Carrots", "Veggie"));
    //     allFoods.add(new Food("Nuts", "Seeds"));
    //     allFoods.add(new Food("Krill", "Seafood"));

    //     // 2. Create 10 Animals and link them to those foods
    //     allAnimals.add(new Animal("Beno", "Panda", allFoods.get(0)));    // Bamboo
    //     allAnimals.add(new Animal("Leo", "Lion", allFoods.get(1)));      // Steak
    //     allAnimals.add(new Animal("George", "Monkey", allFoods.get(2))); // Banana
    //     allAnimals.add(new Animal("Fin", "Shark", allFoods.get(3)));     // Fish
    //     allAnimals.add(new Animal("Koda", "Koala", allFoods.get(4)));    // Eucalyptus
    //     allAnimals.add(new Animal("Pip", "Frog", allFoods.get(5)));      // Insects
    //     allAnimals.add(new Animal("Mel", "Zebra", allFoods.get(6)));     // Grass
    //     allAnimals.add(new Animal("Bugs", "Rabbit", allFoods.get(7)));   // Carrots
    //     allAnimals.add(new Animal("Chip", "Squirrel", allFoods.get(8))); // Nuts
    //     allAnimals.add(new Animal("Wally", "Whale", allFoods.get(9)));   // Krill
    }
}
