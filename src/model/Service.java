package model;

import java.util.List;
import java.util.Scanner;

import util.ZooConfig;


public class Service {
    
    Scanner scanner = new Scanner(System.in); 

    public void ViewAllAnimals() {
        System.out.println("\n=== Animal List ===");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-15s | %-12s | %-12s | %-12s | %-10s |\n",
                "ID","Animal", "Species", "Habitat", "Habitat's ID", "Food");
        System.out.println("----------------------------------------------------------------------------------");

        for (Animal animal : ZooConfig.allAnimals) {
            System.out.printf("| %-2s | %-15s | %-12s | %-12s | %-12s | %-10s |\n",
                    animal.getId(),
                    animal.getName(),
                    animal.getSpecies(),
                    animal.getHabitat().getName(),
                    animal.getHabitat().getHabitatId(),
                    animal.getFood().getName() );
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    public void SetFeedingSchedule() {
        
    }

    public void ViewFeedingSchedule() {
        System.out.println("\n=== Animal Feeding Schedule ===");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-12s | %-12s | %-10s | %-8s | %-8s | %-8s | %-8s |\n",
                "Habitat's ID", "Name", "Species", "Food", "Morning", "Noon", "Evening", "Amount");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        for (Habitat habitat : ZooConfig.allHabitats) {
            boolean firstAnimal = true;
            boolean firstHabitat = true;

            for (Animal animal : ZooConfig.allAnimals) {
                if (animal.getHabitat().equals(habitat)) {

                    List<String> times = animal.getFeedingTimes();
                    String morning = times.size() > 0 ? times.get(0).toString() : "-";
                    String noon    = times.size() > 1 ? times.get(1).toString() : "-";
                    String evening = times.size() > 2 ? times.get(2).toString() : "-";

                    System.out.printf("| %-15s | %-12s | %-12s | %-10s | %-8s | %-8s | %-8s | %-8s |\n",
                            firstAnimal ? habitat.getHabitatId() : "", 
                            animal.getName(),
                            animal.getSpecies(),
                            animal.getFood().getName(),
                            morning,
                            noon,
                            evening,
                            firstHabitat ? habitat.getfoodAmount() + " kg" : ""
                    );
                    firstAnimal = false; 
                    firstHabitat = false; 
                }
            }
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }
    }
    
    
    public void ManageAnimal() {
        System.out.println("\n === Manage Animal === \n"); 
        int choice;  
        boolean back = false; 

        while(!back){
            System.out.println("=========================");
            System.out.println("1. Add New Animal & Food");
            System.out.println("2. Remove Animal & Food");
            System.out.println("3. Back to the ZOO");
            System.out.println("=========================");
            System.out.print("Select option: ");

            choice = scanner.nextInt(); 
            scanner.nextLine(); 
            switch(choice){
                case 1: 
                    addAnimal();
                    addFood();
                    break;
                case 2: 
                    removeAnimal(); 
                    removeFood(); 
                    break; 
                case 3: 
                    System.out.println("Leaving manage animal!!");
                    back = true; 
                    break; 
                default : 
                    System.out.println("Invalid Choice!");
            }

        }

    } 

    
    public void addAnimal(){}; 
    public void addFood(){}; 
    public void removeAnimal(){};
    public void removeFood(){}; 
    

    // scanner.close();  
}

