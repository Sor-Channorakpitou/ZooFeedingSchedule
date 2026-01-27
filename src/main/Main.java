package main;

import java.util.Scanner;
import service.Service; 

public class Main {
    public static void main(String[] args) {

        Service zooService = new Service();
        Scanner options = new Scanner(System.in); 
        int choice;
        boolean exit = false; 

        while(!exit) {

            System.out.println("\n=================================");
            System.out.println("|  ZOO FEEDING SCHEDULE SYSTEM  |");
            System.out.println("=================================");
            System.out.printf("| %-29s |\n", "1. Manage animal");
            System.out.printf("| %-29s |\n", "2. View all animals");
            System.out.printf("| %-29s |\n", "3. Set feeding schedule");
            System.out.printf("| %-29s |\n", "4. View all feeding schedule");
            System.out.printf("| %-29s |\n", "5. Exit");
            System.out.println("=================================");
            System.out.print("Select option: ");
            

            choice = options.nextInt();
            options.nextLine();

            switch (choice) {
                case 1:
                    zooService.ManageAnimal();
                    break;
                case 2:
                    zooService.ViewAllAnimals();
                    break;
                case 3:
                    zooService.SetFeedingSchedule();
                    break;
                case 4:
                    zooService.ViewFeedingSchedule();
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
