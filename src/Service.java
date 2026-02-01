import java.util.ArrayList;

public class Service {
    public static void ManageAnimal() {

    }

    public static void ViewAllAnimals() {
        System.out.println("\n=== Animal List ===");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-15s | %-12s | %-5s | %-12s | %-15s |\n",
                "ID","Animal's Name", "Species", "Age", "Habitat's ID", "Food");
        System.out.println("--------------------------------------------------------------------------------");

        String lastHabitatId = null;
        for (Animal animal : ZooConfig.animals) {
            if (lastHabitatId != null && !animal.getHabitat().getId().equals(lastHabitatId)) {
                System.out.println("--------------------------------------------------------------------------------");
            }
            System.out.printf("| %-2s | %-15s | %-12s | %-5s | %-12s | %-15s |\n",
                    animal.getId(),
                    animal.getName(),
                    animal.getSpecies(),
                    animal.getAge(),
                    animal.getHabitat().getId(),
                    animal.getHabitat().getFoodId().getName()
            );
            lastHabitatId = animal.getHabitat().getId();
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void SetFeedingSchedule() {

    }

    public static void ViewFeedingSchedule() {
        System.out.println("\n=== Daily Animal Feeding Schedule ===");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-12s | %-12s | %-10s | %-8s | %-8s | %-8s | %-8s |\n",
                "Habitat's ID", "Name", "Species", "Food", "Morning", "Noon", "Evening", "Amount");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        for (Habitat habitat : ZooConfig.habitats) {
            boolean firstAnimal = true;
            boolean firstHabitat = true;

            for (Animal animal : ZooConfig.animals) {
                if (animal.getHabitat().equals(habitat)) {
                    String[] times = animal.getHabitat().getFeedingTime();
                    String morning = times[0];
                    String noon    = times[1];
                    String evening = times[2];

                    System.out.printf("| %-15s | %-12s | %-12s | %-10s | %-8s | %-8s | %-8s | %-8s |\n",
                            firstAnimal ? habitat.getId() : "",
                            animal.getName(),
                            animal.getSpecies(),
                            animal.getHabitat().getFoodId().getName(),
                            morning,
                            noon,
                            evening,
                            firstHabitat ? habitat.getAmountFood() + " kg" : ""
                    );
                    firstAnimal = false;
                    firstHabitat = false;
                }
            }
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }
    }
}
