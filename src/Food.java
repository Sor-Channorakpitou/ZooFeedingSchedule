class Food {
    int id;
    String name;
    String type;
    boolean inStock = true;
    double stock;
    String expiryDate;

    Food(int id, String name, String type, double stock, String expiryDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.stock = stock;
        this.expiryDate = expiryDate;
    }
}
