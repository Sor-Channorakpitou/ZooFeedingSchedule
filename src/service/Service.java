package service;

import java.util.Scanner;
import model.Animal;
import model.Food;
import util.ZooConfig;


public class Service {
    
    Scanner scanner = new Scanner(System.in); 

    public void ViewAllAnimals() {
        System.out.println("=== List of Animals ===");

        for(Animal animal : ZooConfig.allAnimals){
            System.out.println(
                "   Name: " + animal.getName() + 
                "   Species: " + animal.getSpecies() + 
                "   Food Type: " + animal.getFood().getName()
            );
        }

    }

    public void SetFeedingSchedule() {
        System.out.println("=== Feeding Schedule ==="); 

        for(Animal animal : ZooConfig.allAnimals){
            System.out.println(
                animal.getName() + " will feed with " + 
                animal.getFood().getName()
            );
        }
    }

    public void ViewFeedingSchedule() {
        SetFeedingSchedule();
    }
    
    
    public void ManageAnimal() {
        System.out.println("\n === Manage Animal === \n"); 
        int choice;  

        boolean back = false; 

        while(!back){
            System.out.println("=================");
            System.out.println("1. Add New Animal & Food");
            System.out.println("2. Remove Animal & Food");
            System.out.println("3. Back to the ZOO");
            System.out.println("=================");
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
