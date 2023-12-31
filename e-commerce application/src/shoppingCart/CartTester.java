package shoppingCart;

import accountManagement.Account;
import accountManagement.Admin;
import accountManagement.Client;
import products.Clothes;
import products.Electronics;
import products.Item;

public class CartTester {
    public static void main(String[] args){
        Item shirt = new Clothes("Shirt", "A shirt", 10, "M", "Blue", "Nike");
        Item pants = new Clothes("Pants", "A pair of pants", 20, "M", "Black", "Adidas");
        Item phone = new Electronics("Phone", "A phone", 1000, "iPhone 12", "Apple");
        Item laptop = new Electronics("Laptop", "A laptop", 2000, "Macbook Pro", "Apple");
        Account client1 = new Client("client1", "password");
        Account client2 = new Client("client2", "password");
        Account admin1 = new Admin("admin1", "password");
        Account admin2 = new Admin("admin2", "password");
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();
        Cart cart4 = new Cart();
        cart1.addItem(shirt, 1);
        cart1.addItem(pants, 2);
        cart2.addItem(phone, 4);
        cart2.addItem(laptop, 5);
        cart3.addItem(shirt, 2);
        cart3.addItem(phone, 1);
        cart4.addItem(pants, 3);
        cart4.addItem(laptop, 1);
        UserCarts userCarts = new UserCarts();
        userCarts.addCart(client1.getUserId(), cart1);
        userCarts.addCart(client2.getUserId(), cart2);
        userCarts.addCart(admin1.getUserId(), cart3);
        userCarts.addCart(admin2.getUserId(), cart4);
        System.out.println(userCarts);
        userCarts.removeCart(client1.getUserId());
        userCarts.removeCart(admin2.getUserId());
        System.out.println(userCarts);
        System.out.println(userCarts.getCart(client1.getUserId()));
        System.out.println(userCarts.getCart(admin2.getUserId()));
        System.out.println(userCarts.getCart(client2.getUserId()));
        System.out.println(userCarts.getCart(admin1.getUserId()));
    }
}
