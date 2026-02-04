public class Main {
    public static void main(String[] agrs) {



        // Copy a primitive, modify the copy, original remains unchanged
        int Id = ZooResource.animals[1].id;
        int copyId = Id;
        copyId = 23;
        System.out.println("The copy value after modify: " + copyId);
        System.out.println("The original id after modify: " + Id);

        // Two variables reference the same object; change is visible everywhere
        Animal testAnimal = ZooResource.animals[2];
        Animal clonedAnimal = testAnimal;
        System.out.println("The initial ID of original animal: " + testAnimal.id);
        System.out.println("The initial ID of clone animal: " + clonedAnimal.id);
        clonedAnimal.id = 3;
        System.out.println("The update ID of original animal: " + testAnimal.id);
        System.out.println("The update ID of clone animal: " + clonedAnimal.id);

//        // Objects inside arrays reflect later modifications
        Animal[] animals = new Animal[1];
        animals[0] = ZooResource.animals[1];
        System.out.println("The initial ID of original animals: " + animals[0].id);
        ZooResource.animals[1].id = 33;  // Object change
        System.out.println("The update ID of original animals: " + animals[0].id);

        // Stored snapshot values do not change after the original object changes
        Animal animal = ZooResource.animals[1];
        int snapShotId = animal.id;
        System.out.println("The original ID of animal: " + animal.id);

        animal.id = 333;
        System.out.println("The snapshotID of the animal after modification the original object: " + snapShotId);
        System.out.println("The originalID of the animal: " + animal.id);


    }
}
