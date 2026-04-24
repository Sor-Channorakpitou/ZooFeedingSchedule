package com.zoo.services;

import com.zoo.dao.AnimalDAO;
import com.zoo.exceptions.*;
import com.zoo.models.Animal;
import com.zoo.models.habitat_types.Habitat;
import com.zoo.models.staff_roles.Staff;
import java.util.List;

public class AnimalService {

    private final List<Animal> animals;
    private final AnimalDAO animalDAO;

    public AnimalService(List<Animal> animals, AnimalDAO animalDAO) {
        this.animals = animals;
        this.animalDAO = animalDAO;
    }

    // CRUD                                                                
    public void addAnimalToHabitat(Animal animal, Habitat habitat, Staff loggedInStaff) throws ZooException {
        if (!habitat.canHouse(animal)) {
            throw new InvalidHabitatException("Incompatible habitat.");
        }

        animalDAO.addAnimal(animal, habitat.getName());
        habitat.getAnimals().add(animal);
        animals.add(animal);
    }

    public void removeAnimalFromHabitat(Animal animal, Habitat habitat, Staff loggedInStaff) throws ZooException {
        if (!loggedInStaff.canAccessHabitat(habitat)) {
            throw new ZooException("You are not assigned to this habitat.");
        }

        animalDAO.deleteAnimal(animal.getId());
        habitat.removeAnimal(animal);
        animals.remove(animal);
    }
}