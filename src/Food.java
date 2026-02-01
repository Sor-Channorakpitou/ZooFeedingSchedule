public class Food {
    private int id;
    private String name;
    private String type;
    private boolean inStock = true;
    private double stock;
    private String expiryDate;

    Food(int id, String name, String type, double stock,String expiryDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.stock = stock;
        this.expiryDate = expiryDate;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isInStock() {
        return inStock;
    }

    public double getStock() {
        return stock;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    // Setter
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
