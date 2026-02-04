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

    @Override
    public String toString() {
        return "Food [id=" + id + ", name=" + name + ", type=" + type + ", inStock=" + inStock + ", stock=" + stock
                + ", expiryDate=" + expiryDate + "]";
    }
    

} 
