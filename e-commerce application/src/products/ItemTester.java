package products;

public class ItemTester {
    public static void main(String[] args){
        ItemManager manager = new ItemManager();
        Item shirt = new Clothes("Shirt", "A shirt", 10, "M", "Blue", "Nike");
        Item pants = new Clothes("Pants", "A pair of pants", 20, "M", "Black", "Adidas");
        Item phone = new Electronics("Phone", "A phone", 1000, "iPhone 12", "Apple");
        Item laptop = new Electronics("Laptop", "A laptop", 2000, "Macbook Pro", "Apple");
        Item chips = new Food("Chips", "A bag of chips", 5, "BBQ", "Lays");
        Item chocolate = new Food("Chocolate", "A bar of chocolate", 2, "Dark", "Hershey's");
        manager.addItem(shirt);
        manager.addItem(pants);
        manager.addItem(phone);
        manager.addItem(laptop);
        manager.addItem(chips);
        manager.addItem(chocolate);
        System.out.println(manager);
        manager.removeItem(shirt);
        manager.removeItem(laptop);
        System.out.println(manager);
        System.out.println(manager.getItem(shirt.getName()));
        System.out.println(manager.getItem(laptop.getName()));
        System.out.println(manager.getItem(pants.getName()));
        System.out.println(manager.getItem(phone.getName()));
        System.out.println(manager.getItem(chips.getName()));
        System.out.println(manager.getItem(chocolate.getName()));
    }
}
