package model;

public class Habitat {
    private String habitatId;
    private String name;
    private double foodAmount;

    public Habitat(String habitatId, String name, double foodAmount) {
        this.habitatId = habitatId;
        this.name = name;
        this.foodAmount = foodAmount;
    }

    public String getHabitatId() {
        return habitatId;
    }

    public String getName() {
        return name;
    }

    public double getfoodAmount(){
        return foodAmount; 
    }
}

