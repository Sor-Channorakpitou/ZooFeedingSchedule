package model;

import java.util.List;

public class Animal {
    private int id;
    private String name; 
    private String species; 
    private Food favoriteFood;
    private Habitat habitat;   
    private List<String> feedingTimes;

    public Animal(int id, String name, String species, Food favoriteFood,Habitat habitat, List<String> feedingTimes){
        this.id = id;
        this.name = name;
        this.species = species; 
        this.favoriteFood = favoriteFood;  
        this.feedingTimes = feedingTimes;
        this.habitat = habitat;
    } 
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSpecies(){
        return species; 
    }

    public Food getFood(){
        return favoriteFood;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public List<String> getFeedingTimes() {
        return feedingTimes;
    }
    
}
