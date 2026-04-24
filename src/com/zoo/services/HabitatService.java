package com.zoo.services;

import com.zoo.dao.HabitatDAO;
import com.zoo.exceptions.*;
import com.zoo.models.Food;
import com.zoo.models.habitat_types.*;
import java.util.List;

public class HabitatService {

    private final List<Habitat> habitats;
    private final HabitatDAO habitatDAO;

    public HabitatService(List<Habitat> habitats, HabitatDAO habitatDAO) {
        this.habitats = habitats;
        this.habitatDAO = habitatDAO;
    }

    // CRUD                                                               
    public Habitat createHabitat(String name, String type, int capacity, Food food) throws ZooException {
        Habitat h = buildHabitat(type, food);
        h.setName(name);
        h.setCapacity(capacity);
        habitatDAO.createHabitat(h);
        habitats.add(h);
        return h;
    }

    public void removeHabitat(String name) throws ZooException {
        Habitat target = habitats.stream()
                .filter(h -> h.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new ZooException("Habitat not found: " + name));

        if (!target.getAnimals().isEmpty()) {
            throw new ZooException("Cannot remove \"" + name + "\": "
                    + target.getAnimals().size() + " animal(s) still inside.");
        }

        habitatDAO.deleteHabitat(target.getId());
        habitats.remove(target);
    }

    // PRIVATE HELPERS                                                     
    private Habitat buildHabitat(String type, Food food) throws ZooException {
        return switch (type.toLowerCase()) {
            case "forest"   -> new Forest(null, food);
            case "ocean"    -> new Ocean(null, food);
            case "savannah" -> new Savannah(null, food);
            default -> throw new InvalidHabitatException(
                    "Unknown habitat type: " + type + ". Use: forest, ocean, savannah.");
        };
    }
}