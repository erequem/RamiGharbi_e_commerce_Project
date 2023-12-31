package products;

public abstract class Item{
    private int id;
    private String description;
    private String brand;
    private String name;
    private double price;
    private static int count = 0;

    public Item(String name, String description, double price, String brand) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.brand = brand;
        this.id += count;
        count++;
    }

    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public abstract String toString();
}
