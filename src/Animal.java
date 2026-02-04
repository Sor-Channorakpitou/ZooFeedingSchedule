class Animal {
    int id;
    String name;
    int age;
    Habitat habitat;
    String species;

    Animal(int id, String name, int age, Habitat habitat, String species) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.habitat = habitat;
        this.species = species;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", name=" + name + ", age=" + age + ", habitat=" + habitat + ", species=" + species
                + "]";
    }
}
