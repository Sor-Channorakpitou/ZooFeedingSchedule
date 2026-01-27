package util;

import java.util.ArrayList;
import java.util.List;
import model.Animal;
import model.Food;
import model.Habitat;

// ZooConfig holds all animals, foods, and habitats
public class ZooConfig {

    public static List<Food> allFoods = new ArrayList<>();
    public static List<Habitat> allHabitats = new ArrayList<>();
    public static List<Animal> allAnimals = new ArrayList<>();

    static {
        // Foods
        Food bamboo = new Food("Bamboo", "Plant");
        Food steak = new Food("Steak", "Meat");
        Food banana = new Food("Banana", "Fruit");
        Food fish = new Food("Fish", "Seafood");

        allFoods.addAll(List.of(bamboo, steak, banana, fish));

        // Habitats
        Habitat forest = new Habitat("FR001", "Forest", 30);
        Habitat savanna = new Habitat("SV001", "Savanna",50);
        Habitat jungle = new Habitat("JG001", "Jungle", 60);
        Habitat ocean = new Habitat("OC001", "Ocean",30);

        allHabitats.addAll(List.of(forest, savanna, jungle, ocean));

        // Feeding times as Strings
        List<String> forestTimes = List.of("08:00", "12:30", "17:00");
        List<String> savannaTimes = List.of("09:00", "13:00", "18:00");
        List<String> jungleTimes = List.of("08:30", "12:00", "16:30");
        List<String> oceanTimes = List.of("07:00", "11:30", "19:00");

        // Animals (ID, Name, Species, Food, Habitat, Feeding Times)
        allAnimals.add(new Animal(1, "Beno", "Panda", bamboo, forest, new ArrayList<>(forestTimes)));
        allAnimals.add(new Animal(5, "Koda", "Koala", bamboo, forest, new ArrayList<>(forestTimes)));
        allAnimals.add(new Animal(8, "Bugs", "Rabbit", bamboo, forest, new ArrayList<>(forestTimes)));
        allAnimals.add(new Animal(9, "Chip", "Squirrel", bamboo, forest, new ArrayList<>(forestTimes)));
        allAnimals.add(new Animal(11, "Toby", "Panda", bamboo, forest, new ArrayList<>(forestTimes)));
        allAnimals.add(new Animal(15, "Luna", "Koala", bamboo, forest, new ArrayList<>(forestTimes)));
        allAnimals.add(new Animal(18, "Thumper", "Rabbit", bamboo, forest, new ArrayList<>(forestTimes)));
        allAnimals.add(new Animal(19, "Rocky", "Squirrel", bamboo, forest, new ArrayList<>(forestTimes)));
        allAnimals.add(new Animal(2, "Leo", "Lion", steak, savanna, new ArrayList<>(savannaTimes)));
        allAnimals.add(new Animal(7, "Mel", "Zebra", steak, savanna, new ArrayList<>(savannaTimes)));
        allAnimals.add(new Animal(12, "Nala", "Lion", steak, savanna, new ArrayList<>(savannaTimes)));
        allAnimals.add(new Animal(17, "Zara", "Zebra", steak, savanna, new ArrayList<>(savannaTimes)));
        allAnimals.add(new Animal(3, "George", "Monkey", banana, jungle, new ArrayList<>(jungleTimes)));
        allAnimals.add(new Animal(6, "Pip", "Frog", banana, jungle, new ArrayList<>(jungleTimes)));
        allAnimals.add(new Animal(13, "Milo", "Monkey", banana, jungle, new ArrayList<>(jungleTimes)));
        allAnimals.add(new Animal(16, "Rico", "Frog", banana, jungle, new ArrayList<>(jungleTimes)));
        allAnimals.add(new Animal(4, "Fin", "Shark", fish, ocean, new ArrayList<>(oceanTimes)));
        allAnimals.add(new Animal(10, "Wally", "Whale", fish, ocean, new ArrayList<>(oceanTimes)));
        allAnimals.add(new Animal(14, "Shelly", "Shark", fish, ocean, new ArrayList<>(oceanTimes)));
        allAnimals.add(new Animal(20, "Blue", "Whale", fish, ocean, new ArrayList<>(oceanTimes)));
    }
}
