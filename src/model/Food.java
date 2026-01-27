package model;

public class Food {
    private String name; 
    private String foodSpecies; 

    
    public Food(String name, String foodSpecies){
        this.name = name; 
        this.foodSpecies = foodSpecies;
    }

    public String getName(){ 
        return name; 
    }

    public String getFoodSpecies(){
        return foodSpecies; 
    }

}
