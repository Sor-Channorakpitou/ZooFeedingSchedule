import java.util.ArrayList;
import java.util.List;
public class ZooConfig {
    public static ArrayList<Animal> animals = new ArrayList<>();
    public static ArrayList<Food> foods = new ArrayList<>();
    public static ArrayList<Habitat> habitats = new ArrayList<>();

    static {
        // Food's Data

        // Plants
        Food bamboo = new Food(1, "Bamboo", "Plant", 100.0, "2026-12-31");
        Food lettuce = new Food(2, "Lettuce", "Plant", 50.0, "2026-07-15");
        Food carrot = new Food(3, "Carrot", "Plant", 60.0, "2026-06-20");
        Food spinach = new Food(4, "Spinach", "Plant", 40.0, "2026-05-30");

        // Fruits
        Food banana = new Food(5, "Banana", "Fruit", 80.0, "2026-05-15");
        Food apple = new Food(6, "Apple", "Fruit", 70.0, "2026-06-01");
        Food mango = new Food(7, "Mango", "Fruit", 50.0, "2026-04-30");
        Food orange = new Food(8, "Orange", "Fruit", 60.0, "2026-06-10");

        // Meats / Protein
        Food steak = new Food(9, "Steak", "Meat", 30.0, "2026-06-30");
        Food chicken = new Food(10, "Chicken", "Meat", 40.0, "2026-05-10");
        Food fish = new Food(11, "Fish", "Meat", 50.0, "2026-04-20");

        // Nuts / Snacks
        Food peanuts = new Food(12, "Peanuts", "Snack", 20.0, "2027-01-01");
        Food almonds = new Food(13, "Almonds", "Snack", 15.0, "2027-01-01");

        // Grains / Seeds
        Food corn = new Food(14, "Corn", "Grain", 60.0, "2026-09-30");
        Food wheat = new Food(15, "Wheat", "Grain", 50.0, "2026-08-15");
        Food oats = new Food(16, "Oats", "Grain", 40.0, "2026-08-20");

        // Vegetables
        Food cucumber = new Food(17, "Cucumber", "Vegetable", 50.0, "2026-06-10");
        Food pumpkin = new Food(18, "Pumpkin", "Vegetable", 30.0, "2026-10-15");

        // Tropical / Exotic
        Food papaya = new Food(19, "Papaya", "Fruit", 40.0, "2026-06-05");
        Food coconut = new Food(20, "Coconut", "Fruit", 30.0, "2027-01-01");

        // Add all to the food list
        foods.addAll(List.of( bamboo, lettuce, carrot, spinach, banana, apple, mango, orange, steak,
                chicken, fish, peanuts, almonds, corn, wheat, oats, cucumber, pumpkin, papaya, coconut ));

        // Feeding times as Strings
        ArrayList<String> forestTimes  = new ArrayList<>(List.of("08:00", "12:30", "17:00"));
        ArrayList<String> savannaTimes = new ArrayList<>(List.of("09:00", "13:00", "18:00"));
        ArrayList<String> jungleTimes  = new ArrayList<>(List.of("08:30", "12:00", "16:30"));
        ArrayList<String> oceanTimes   = new ArrayList<>(List.of("07:00", "11:30", "19:00"));

        // Habitats & Animals

        // --------- FOREST ----------
        ArrayList<Animal> fr001Animals = new ArrayList<Animal>();
        Habitat FR001 = new Habitat(
                "FR001", "Panda", bamboo.getStock(),
                forestTimes.toArray(new String[0]),
                fr001Animals,
                bamboo
        );
        fr001Animals.addAll(List.of(
                new Animal(12, "P1", 6, FR001, "Panda"),
                new Animal(31, "P2", 5, FR001, "Panda"),
                new Animal(4,  "P3", 4, FR001, "Panda")
        ));
        animals.addAll(fr001Animals);

        // FR002
        ArrayList<Animal> fr002Animals = new ArrayList<Animal>();
        Habitat FR002 = new Habitat(
                "FR002", "Deer", lettuce.getStock(),
                forestTimes.toArray(new String[0]),
                fr002Animals,
                lettuce
        );
        fr002Animals.addAll(List.of(
                new Animal(27, "D1", 4, FR002, "Deer"),
                new Animal(9,  "D2", 3, FR002, "Deer"),
                new Animal(35, "D3", 5, FR002, "Deer")
        ));
        animals.addAll(fr002Animals);

        // FR003
        ArrayList<Animal> fr003Animals = new ArrayList<>();
        Habitat FR003 = new Habitat(
                "FR003", "Rabbit", carrot.getStock(),
                forestTimes.toArray(new String[0]),
                fr003Animals,
                carrot
        );
        fr003Animals.addAll(List.of(
                new Animal(18, "R1", 2, FR003, "Rabbit"),
                new Animal(2,  "R2", 1, FR003, "Rabbit"),
                new Animal(29, "R3", 2, FR003, "Rabbit")
        ));
        animals.addAll(fr003Animals);

        // FR004
        ArrayList<Animal> fr004Animals = new ArrayList<>();
        Habitat FR004 = new Habitat(
                "FR004", "Gorilla", spinach.getStock(),
                forestTimes.toArray(new String[0]),
                fr004Animals,
                spinach
        );
        fr004Animals.addAll(List.of(
                new Animal(7,  "G1", 9, FR004, "Gorilla"),
                new Animal(33, "G2", 8, FR004, "Gorilla")
        ));
        animals.addAll(fr004Animals);

        // --------- JUNGLE ----------
        // JG001
        ArrayList<Animal> jg001Animals = new ArrayList<>();
        Habitat JG001 = new Habitat(
                "JG001", "Monkey", banana.getStock(),
                jungleTimes.toArray(new String[0]),
                jg001Animals,
                banana
        );
        jg001Animals.addAll(List.of(
                new Animal(14, "M1", 4, JG001, "Monkey"),
                new Animal(26, "M2", 3, JG001, "Monkey"),
                new Animal(5,  "M3", 5, JG001, "Monkey")
        ));
        animals.addAll(jg001Animals);

        // JG002
        ArrayList<Animal> jg002Animals = new ArrayList<>();
        Habitat JG002 = new Habitat(
                "JG002", "Parrot", apple.getStock(),
                jungleTimes.toArray(new String[0]),
                jg002Animals,
                apple
        );
        jg002Animals.addAll(List.of(
                new Animal(21, "P1", 2, JG002, "Parrot"),
                new Animal(10, "P2", 3, JG002, "Parrot")
        ));
        animals.addAll(jg002Animals);

        // JG003
        ArrayList<Animal> jg003Animals = new ArrayList<>();
        Habitat JG003 = new Habitat(
                "JG003", "Toucan", mango.getStock(),
                jungleTimes.toArray(new String[0]),
                jg003Animals,
                mango
        );
        jg003Animals.addAll(List.of(
                new Animal(34, "T1", 3, JG003, "Toucan"),
                new Animal(1,  "T2", 4, JG003, "Toucan")
        ));
        animals.addAll(jg003Animals);

        // JG004
        ArrayList<Animal> jg004Animals = new ArrayList<>();
        Habitat JG004 = new Habitat(
                "JG004", "Orangutan", orange.getStock(),
                jungleTimes.toArray(new String[0]),
                jg004Animals,
                orange
        );
        jg004Animals.addAll(List.of(
                new Animal(24, "O1", 10, JG004, "Orangutan"),
                new Animal(16, "O2", 9, JG004, "Orangutan")
        ));
        animals.addAll(jg004Animals);

        // --------- SAVANNA ----------
        // SV001
        ArrayList<Animal> sv001Animals = new ArrayList<>();
        Habitat SV001 = new Habitat(
                "SV001", "Lion", steak.getStock(),
                savannaTimes.toArray(new String[0]),
                sv001Animals,
                steak
        );
        sv001Animals.addAll(List.of(
                new Animal(30, "L1", 7, SV001, "Lion"),
                new Animal(6,  "L2", 6, SV001, "Lion"),
                new Animal(19, "L3", 8, SV001, "Lion")
        ));
        animals.addAll(sv001Animals);

        // SV002
        ArrayList<Animal> sv002Animals = new ArrayList<>();
        Habitat SV002 = new Habitat(
                "SV002", "Hyena", chicken.getStock(),
                savannaTimes.toArray(new String[0]),
                sv002Animals,
                chicken
        );
        sv002Animals.addAll(List.of(
                new Animal(11, "H1", 5, SV002, "Hyena"),
                new Animal(28, "H2", 4, SV002, "Hyena")
        ));
        animals.addAll(sv002Animals);

        // SV003
        ArrayList<Animal> sv003Animals = new ArrayList<>();
        Habitat SV003 = new Habitat(
                "SV003", "Elephant", peanuts.getStock(),
                savannaTimes.toArray(new String[0]),
                sv003Animals,
                peanuts
        );
        sv003Animals.addAll(List.of(
                new Animal(36, "E1", 15, SV003, "Elephant"),
                new Animal(8,  "E2", 14, SV003, "Elephant")
        ));
        animals.addAll(sv003Animals);

        // SV004
        ArrayList<Animal> sv004Animals = new ArrayList<>();
        Habitat SV004 = new Habitat(
                "SV004", "Meerkat", almonds.getStock(),
                savannaTimes.toArray(new String[0]),
                sv004Animals,
                almonds
        );
        sv004Animals.addAll(List.of(
                new Animal(22, "M1", 3, SV004, "Meerkat"),
                new Animal(3,  "M2", 2, SV004, "Meerkat")
        ));
        animals.addAll(sv004Animals);

        // --------- OCEAN ----------
        // OC001
        ArrayList<Animal> oc001Animals = new ArrayList<>();
        Habitat OC001 = new Habitat(
                "OC001", "Shark", fish.getStock(),
                oceanTimes.toArray(new String[0]),
                sv001Animals,
                fish
        );
        oc001Animals.addAll(List.of(
                new Animal(25, "S1", 9, OC001, "Shark"),
                new Animal(17, "S2", 10, OC001, "Shark")
        ));
        animals.addAll(oc001Animals);

        // OC002
        ArrayList<Animal> oc002Animals = new ArrayList<>();
        Habitat OC002 = new Habitat(
                "OC002", "Dolphin", chicken.getStock(),
                oceanTimes.toArray(new String[0]),
                oc002Animals,
                chicken
        );
        oc002Animals.addAll(List.of(
                new Animal(32, "D1", 6, OC002, "Dolphin"),
                new Animal(13, "D2", 5, OC002, "Dolphin")
        ));
        animals.addAll(oc002Animals);

        // OC003
        ArrayList<Animal> oc003Animals = new ArrayList<>();
        Habitat OC003 = new Habitat(
                "OC003", "Sea Turtle", oats.getStock(),
                oceanTimes.toArray(new String[0]),
                oc003Animals,
                oats
        );
        oc003Animals.addAll(List.of(
                new Animal(37, "S1", 20, OC003, "Sea Turtle"),
                new Animal(15, "S2", 18, OC003, "Sea Turtle")
        ));
        animals.addAll(oc003Animals);

        // OC004
        ArrayList<Animal> oc004Animals = new ArrayList<>();
        Habitat OC004 = new Habitat(
                "OC004", "Seal", corn.getStock(),
                oceanTimes.toArray(new String[0]),
                oc004Animals,
                corn
        );
        oc004Animals.addAll(List.of(
                new Animal(20, "S1", 6, OC004, "Seal"),
                new Animal(23, "S2", 5, OC004, "Seal")
        ));
        animals.addAll(oc004Animals);


        habitats.addAll(List.of( FR001, FR002, FR003, FR004, JG001, JG002,
                JG003, JG004, SV001, SV002, SV003, SV004, OC001, OC002, OC003, OC004 ));

    }

}
