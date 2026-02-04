public class Main {
    public static void main(String[] agrs) {



        // Copy a primitive, modify the copy, original remains unchanged
        System.out.println("\nF1 - Primitive copy proof");
        int Id = ZooConfig.animals[1].id;
        int copyId = Id;
        copyId = 23;
        System.out.println("The copied id: " + copyId);
        System.out.println("The original id: " + Id);

        // Two variables reference the same object; change is visible everywhere
        System.out.println("\nF2 - Reference copy proof");
        Animal testAnimal = ZooConfig.animals[2];
        Animal clonedAnimal = testAnimal;
        System.out.println("The animal's id before change: " + testAnimal.id);
        clonedAnimal.id = 3;

        System.out.println("After change:");
        System.out.println("The original animal's id: " + testAnimal.id);
        System.out.println("The clone animal's id: " + clonedAnimal.id);

        // Objects inside arrays reflect later modifications
        System.out.println("\nF3 - Array stores references proof");
        Animal animals = ZooConfig.animals[1];
        if (animals != null) {
            System.out.println("Animal's id before change: " + animals.id);
            animals.id = 33;  // Object change
            System.out.println("Animal's id after change: " + animals.id);
        }

        // Stored snapshot values do not change after the original object changes
        System.out.println("\nF4 - Snapshot proof");
        Animal animal = ZooConfig.animals[1];
        int snapShotId = animal.id;
        System.out.println("The original animal's id: " + animal.id);
        animal.id = 333;  // Animal object change
        System.out.println("After animal's id change ( snapshot ): " + snapShotId);
        System.out.println("Original animal's id: " + animal.id);


    }
}
