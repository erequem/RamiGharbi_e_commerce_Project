package products;

public class Electronics extends Item{

    private String model;
    public Electronics(String name, String description, double price, String model, String brand) {
        super(name, description, price,brand);

        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String toString(){
        return "Name: " + super.getName() + "\nDescription: " + super.getDescription() + "\nPrice: " + super.getPrice() + "\nBrand: " +  "\nModel: " + this.model;
    }
}

