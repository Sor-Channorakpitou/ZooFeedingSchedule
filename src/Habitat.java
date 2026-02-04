import java.util.Arrays;

class Habitat {
    String id;
    String species;
    Food food;
    double amountFood;
    String[] feedingTime;
    Animal[] animals;

    Habitat(String id, String species, double amountFood, String[] feedingTime, Animal[] animals, Food food) {
        this.id = id;
        this.species = species;
        this.amountFood = amountFood;
        this.feedingTime = feedingTime;
        this.animals = animals;
        this.food = food;
    }

    @Override
    public String toString() {
        return "Habitat [id=" + id + ", species=" + species + ", food=" + food + ", amountFood=" + amountFood
                + ", feedingTime=" + Arrays.toString(feedingTime) + ", animals=" + Arrays.toString(animals) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        
        Habitat other = (Habitat) obj;
        if (id == null) {
            if (other.id != null)  
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (species == null) {
            if (other.species != null)
                return false;
        } else if (!species.equals(other.species))
            return false;
        if (food == null) {
            if (other.food != null)
                return false;
        } else if (!food.equals(other.food))
            return false;
        if (Double.doubleToLongBits(amountFood) != Double.doubleToLongBits(other.amountFood))
            return false;
        if (!Arrays.equals(feedingTime, other.feedingTime))
            return false;
        if (!Arrays.equals(animals, other.animals))
            return false;
        return true;
    }
    
    
    
}

