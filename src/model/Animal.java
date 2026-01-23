package model;
import model.Food;
public class Animal {
     private String name; 
     private String species; 
     private Food favoriteFood;

    public Animal(String name, String species, Food favoriteFood){
        this.name = name;
        this.species = species; 
        this.favoriteFood = favoriteFood;   
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
    
}
