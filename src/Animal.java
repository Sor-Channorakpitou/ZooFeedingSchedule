public class Animal {
    private int id;
    private String name;
    private int age;
    private Habitat habitat;
    private String species;

    public Animal(int id, String name, int age, Habitat habitat, String species) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.habitat = habitat;
        this.species = species;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    // Setter: Animal might change habitat and older each year
    public void setAge(int age) {
        this.age = age;
    }

    public void setHabitatId(Habitat habitat) {
        this.habitat = habitat;
    }
}
