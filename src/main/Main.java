package main;

import java.util.Scanner;
import service.Service;

public class Main {
    public static void main(String[] args) {
        // Banner
        System.out.println("\n=================================");
        System.out.println("|  ZOO FEEDING SCHEDULE SYSTEM  |");
        System.out.println("=================================\n");

        Service ZooServices = new Service();

        Scanner options = new Scanner(System.in); 
        int choice;
        boolean exit = false; 

        while(!exit) {

            System.out.println("1. Manage animal");
            System.out.println("2. View all animals");
            System.out.println("3. Set feeding schedule");
            System.out.println("4. View all feeding schedule");
            System.out.println("5. Exit");
            System.out.println("=================");
            System.out.print("Select option: ");
            

            choice = options.nextInt();
            options.nextLine();

            switch (choice) {
                case 1:
                    ZooServices.ManageAnimal();
                    break;
                case 2:
                    ZooServices.ViewAllAnimals();
                    break;
                case 3:
                    ZooServices.SetFeedingSchedule();
                    break;
                case 4:
                    ZooServices.ViewFeedingSchedule();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        };
        
        options.close();
    }
}
