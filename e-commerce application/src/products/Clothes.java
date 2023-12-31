package products;

public class Clothes extends Item{
    private String size;
    private String color;

    public Clothes(String name, String description, double price, String size, String color,String brand) {
        super(name, description, price,brand);
        this.size = size;
        this.color = color;
    }
    public String getSize() {
        return size;
    }
    public String getColor() {
        return color;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String toString(){
        return "Name: " + super.getName() + "\nDescription: " + super.getDescription() + "\nPrice: " + super.getPrice() + "\nSize: " + this.size + "\nColor: " + this.color;
    }
}