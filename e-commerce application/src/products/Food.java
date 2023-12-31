package products;

public class Food extends Item{
    private String flavor;
    public Food(String name, String description, double price, String flavor, String brand) {
        super(name, description, price,brand);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    public String toString(){
        return "Name: " + super.getName() + "\nDescription: " + super.getDescription() + "\nPrice: " + super.getPrice() + "\nBrand: " +"\nFlavor: " + this.flavor;
    }
}
