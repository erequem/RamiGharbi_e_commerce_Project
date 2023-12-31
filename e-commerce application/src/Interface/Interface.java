package Interface;

import Payment.PaymentManager;
import Payment.PaymentMethod;
import accountManagement.Account;
import accountManagement.AccountManager;
import accountManagement.Admin;
import accountManagement.Client;
import inventory.Inventory;
import orders.Order;
import orders.OrderManager;
import products.*;
import shoppingCart.Cart;
import shoppingCart.UserCarts;

import java.util.Scanner;

public class Interface {
    public static ItemManager initializeItemManager(){
        ItemManager itemManager = new ItemManager();
        itemManager.addItem(new Clothes("Shirt", "A shirt", 10, "M", "Blue", "Nike"));
        itemManager.addItem(new Clothes("Pants", "A pair of pants", 20, "M", "Black", "Adidas"));
        itemManager.addItem(new Electronics("Phone", "A phone", 1000, "iPhone 12", "Apple"));
        itemManager.addItem(new Electronics("Laptop", "A laptop", 2000, "Macbook Pro", "Apple"));
        itemManager.addItem(new Food("Chips", "A bag of chips", 5, "BBQ", "Lays"));
        itemManager.addItem(new Food("Chocolate", "A bar of chocolate", 2, "Dark", "Hershey's"));
        return itemManager;
    }
    public static AccountManager initializeAccountManager(){
        AccountManager accountManager = new AccountManager();
        accountManager.addAccount(new Client("client1", "password"));
        accountManager.addAccount(new Client("client2", "password"));
        accountManager.addAccount(new Admin("admin1", "password"));
        accountManager.addAccount(new Admin("admin2", "password"));
        return accountManager;
    }
    public static UserCarts initializeUserCarts(AccountManager accountManager){
        UserCarts userCarts = new UserCarts();
        userCarts.addCart(accountManager.getAccount("client1").getUserId(), new Cart());
        userCarts.addCart(accountManager.getAccount("client2").getUserId(), new Cart());
        return userCarts;
    }
    public static Inventory initializeInventory(ItemManager itemManager){
        Inventory inventory = new Inventory();
        inventory.addItem(itemManager.getItem("Shirt").getId(), 10);
        inventory.addItem(itemManager.getItem("Pants").getId(), 10);
        inventory.addItem(itemManager.getItem("Phone").getId(), 10);
        inventory.addItem(itemManager.getItem("Laptop").getId(), 10);
        inventory.addItem(itemManager.getItem("Chips").getId(), 10);
        inventory.addItem(itemManager.getItem("Chocolate").getId(), 10);
        return inventory;
    }
    public static void optionMenu(){
        System.out.println("Please enter the number of the option you would like to choose");
        System.out.println("1. Search for products");
        System.out.println("2. Manage cart");
        System.out.println("3. View orders");
        System.out.println("4. Logout");
    }
    public static void adminOptionMenu(){
        System.out.println("Please enter the number of the option you would like to choose");
        System.out.println("1. Add item");
        System.out.println("2. Remove item");
        System.out.println("3. Update item quantity");
        System.out.println("4. View inventory");
        System.out.println("5. View orders");
        System.out.println("6. add discount");
        System.out.println("7. Logout");
    }
    public static void main(String[] args){
        AccountManager accountManager = initializeAccountManager();
        ItemManager itemManager = initializeItemManager();
        UserCarts userCarts = initializeUserCarts(accountManager);
        Inventory inventory = initializeInventory(itemManager);
        PaymentManager paymentManager = new PaymentManager();
        OrderManager orderManager = new OrderManager();
        while(true){//main loop: user login and account creation
            System.out.println("Please enter the number of the option you would like to choose");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            Scanner scanner = new Scanner(System.in);
            int optionLog = scanner.nextInt();
            scanner.nextLine();
            if(optionLog == 1){
                System.out.println("Welcome to the online store!");
                System.out.println("Please enter your username and password to login");
                String username = scanner.nextLine();
                String password = scanner.nextLine();
                Account account = accountManager.getAccount(username);
                if(account == null){
                    System.out.println("Username does not exist");
                    System.out.println("Would you like to create an account? (Y/N)");
                    String option = scanner.nextLine();
                    if(option.equals("Y")){
                        System.out.println("Please enter your username and password");
                        username = scanner.nextLine();
                        password = scanner.nextLine();
                        accountManager.addAccount(new Client(username, password));
                        userCarts.addCart(accountManager.getAccount(username).getUserId(), new Cart());
                        System.out.println("Account created");
                        account = accountManager.getAccount(username);
                    }
                }
                while(!account.getPassword().equals(password)){ // in case the password is incorrect
                    System.out.println("Incorrect password");
                    System.out.println("Please enter your password");
                    password = scanner.nextLine();
                }
                if(account instanceof Client){ //the client side of the application
                    System.out.println("Welcome " + account.getUsername());
                    optionMenu();
                    int option = scanner.nextInt();
                    while(true){//the loop for prompting the client commands

                        if(option == 1){
                            ProductSearch productSearch = new ProductSearch(itemManager);
                            while(true){
                                System.out.println("Please enter the number of the option you would like to choose");
                                System.out.println("1. Search by price");
                                System.out.println("2. Search by brand");
                                System.out.println("3. Search by size");
                                System.out.println("4. Search by color");
                                System.out.println("5. Search by flavor");
                                System.out.println("6. Search by model");
                                System.out.println("7. Search by category");
                                System.out.println("8. Search by name");
                                System.out.println("9. Reset search");
                                System.out.println("10. Purchase product");
                                System.out.println("11. Exit");
                                int searchOption = scanner.nextInt();
                                scanner.nextLine();

                                if(searchOption == 1){
                                    System.out.println("Please enter the minimum price");
                                    double min = scanner.nextDouble();
                                    System.out.println("Please enter the maximum price");
                                    double max = scanner.nextDouble();
                                    productSearch.searchByPrice(min, max);
                                    System.out.println(productSearch);
                                }
                                else if(searchOption == 2){
                                    System.out.println("Please enter the brand");
                                    String brand = scanner.nextLine();
                                    productSearch.searchByBrand(brand);
                                    System.out.println(productSearch);
                                }
                                else if(searchOption == 3){
                                    System.out.println("Please enter the size");
                                    String size = scanner.nextLine();
                                    productSearch.searchBySize(size);
                                    System.out.println(productSearch);
                                }
                                else if(searchOption == 4){
                                    System.out.println("Please enter the color");
                                    String color = scanner.nextLine();
                                    productSearch.searchByColor(color);
                                    System.out.println(productSearch);
                                }
                                else if(searchOption == 5){
                                    System.out.println("Please enter the flavor");
                                    String flavor = scanner.nextLine();
                                    productSearch.searchByFlavor(flavor);
                                    System.out.println(productSearch);
                                }
                                else if(searchOption == 6){
                                    System.out.println("Please enter the model");
                                    String model = scanner.nextLine();
                                    productSearch.searchByModel(model);
                                    System.out.println(productSearch);
                                }
                                else if(searchOption == 7){
                                    System.out.println("Please enter the category");
                                    String category = scanner.nextLine();
                                    productSearch.searchByCategory(category);
                                    System.out.println(productSearch);
                                }
                                else if(searchOption == 8){
                                    System.out.println("Please enter the name");
                                    String name = scanner.nextLine();
                                    productSearch.searchByName(name);
                                    System.out.println(productSearch);
                                }
                                else if(searchOption == 9){
                                    productSearch.reset();
                                    System.out.println(productSearch);
                                }
                                else if(searchOption == 10){
                                    System.out.println("Please enter the name of the item you would like to purchase");
                                    String name = scanner.nextLine();
                                    Item item = itemManager.getItem(name);
                                    if(item != null){
                                        System.out.println("Please enter the quantity of the item you would like to purchase");
                                        int quantity = scanner.nextInt();
                                        if(inventory.getQuantity(item.getId()) >= quantity){
                                            inventory.updateQuantity(item.getId(), inventory.getQuantity(item.getId()) - quantity);
                                            userCarts.getCart(account.getUserId()).addItem(item, quantity);
                                            System.out.println("Item added to cart");
                                        }
                                        else{
                                            System.out.println("uwu");
                                            System.out.println("Not enough items in stock");
                                        }
                                    }
                                }
                                else if(searchOption == 11){
                                    break;
                                }
                                else{
                                    System.out.println("Invalid option");
                                }
                            }
                        }
                        else if(option == 2){
                            Cart cart = userCarts.getCart(account.getUserId());
                            while(true){ // the loop for the cart manipulation prompts
                                System.out.println("Please enter the number of the option you would like to choose");
                                System.out.println("1. Add item to cart");
                                System.out.println("2. Remove item from cart");
                                System.out.println("3. Update quantity of item in cart");
                                System.out.println("4. View cart");
                                System.out.println("5. Checkout");
                                System.out.println("6. Exit");
                                int cartOption = scanner.nextInt();
                                scanner.nextLine();
                                if(cartOption ==1){
                                    System.out.println("Please enter the name of the item you would like to add to your cart");
                                    String name = scanner.nextLine();
                                    Item item = itemManager.getItem(name);
                                    if(item != null){
                                        System.out.println("Please enter the quantity of the item you would like to add to your cart");
                                        int quantity = scanner.nextInt();
                                        if(inventory.getQuantity(item.getId()) >= quantity){
                                            inventory.updateQuantity(item.getId(), inventory.getQuantity(item.getId()) - quantity);
                                            cart.addItem(item, quantity);
                                            System.out.println("Item added to cart");
                                        }
                                        else{
                                            System.out.println("Not enough items in stock");
                                        }
                                    }
                                }
                                else if(cartOption == 2){
                                    System.out.println("Please enter the name of the item you would like to remove from your cart");
                                    String name = scanner.nextLine();
                                    Item item = itemManager.getItem(name);
                                    if(item != null){
                                        inventory.updateQuantity(item.getId(), inventory.getQuantity(item.getId()) + cart.getQuantity(item));
                                        cart.removeItem(item);
                                        System.out.println("Item removed from cart");
                                    }
                                }
                                else if(cartOption == 3){
                                    System.out.println("Please enter the name of the item you would like to update the quantity of");
                                    String name = scanner.nextLine();
                                    Item item = itemManager.getItem(name);
                                    if(item != null){
                                        System.out.println("Please enter the new quantity of the item");
                                        int quantity = scanner.nextInt();
                                        if(inventory.getQuantity(item.getId()) >= quantity-cart.getQuantity(item)){
                                            inventory.updateQuantity(item.getId(), inventory.getQuantity(item.getId()) + cart.getQuantity(item) - quantity);
                                            cart.updateQuantity(item, quantity);
                                            System.out.println("Item quantity updated");
                                        }
                                        else{
                                            System.out.println("Not enough items in stock");
                                        }
                                    }
                                }
                                else if(cartOption == 4){
                                    System.out.println(cart);
                                }
                                else if(cartOption == 5){
                                    while (true) { // the loop for the payment system
                                        System.out.println("Please enter the number of the option you would like to choose");
                                        System.out.println("1. Pay with existing payment method");
                                        System.out.println("2. Add new payment method");
                                        System.out.println("3. Remove payment method");
                                        System.out.println("4. Exit");
                                        int paymentOption = scanner.nextInt();
                                        scanner.nextLine();
                                        if (paymentOption == 1) {
                                            System.out.println("Please enter the card number of the payment method you would like to use");
                                            String cardNumber = scanner.nextLine();
                                            PaymentMethod paymentMethod = paymentManager.getPaymentMethod(cardNumber);
                                            if (paymentMethod != null) {
                                                System.out.println("Please enter the CVV of the payment method you would like to use");
                                                String cvv = scanner.nextLine();
                                                if (paymentMethod.getCvv().equals(cvv)) {
                                                    Order order = new Order(account.getUserId(), cart);
                                                    orderManager.addOrder(order);
                                                    System.out.println("Order placed");
                                                    System.out.println("Order ID: " + order.getOrderId());
                                                    System.out.println("Total: " + order.getTotal());
                                                    userCarts.removeCart(account.getUserId());
                                                    userCarts.addCart(account.getUserId(), new Cart());
                                                    cart = userCarts.getCart(account.getUserId());
                                                    break;
                                                } else {
                                                    System.out.println("Incorrect CVV");
                                                }
                                            }
                                        } else if (paymentOption == 2) {
                                            System.out.println("Please enter the card number of the payment method you would like to add");
                                            String cardNumber = scanner.nextLine();
                                            System.out.println("Please enter the card holder of the payment method you would like to add");
                                            String cardHolder = scanner.nextLine();
                                            System.out.println("Please enter the expiration date of the payment method you would like to add");
                                            String expirationDate = scanner.nextLine();
                                            System.out.println("Please enter the CVV of the payment method you would like to add");
                                            String cvv = scanner.nextLine();
                                            paymentManager.addPaymentMethod(account.getUserId(), new PaymentMethod(cardNumber, cardHolder, expirationDate, cvv));
                                            System.out.println("Payment method added");
                                        } else if (paymentOption == 3) {
                                            System.out.println("Please enter the card number of the payment method you would like to remove");
                                            String cardNumber = scanner.nextLine();
                                            paymentManager.removePaymentMethod(cardNumber);
                                            System.out.println("Payment method removed");
                                        } else if (paymentOption == 4) {
                                            break;
                                        } else {
                                            System.out.println("Invalid option");
                                        }
                                    }
                                }
                                else if(cartOption==6){
                                    break;
                                }
                                else{
                                    System.out.println("Invalid option");
                                }
                            }
                        }
                        else if(option == 3){
                            for(Order order : orderManager.getOrders()){
                                if(order.getUserId().equals(account.getUserId())){
                                    System.out.println(order.toString());
                                }
                            }
                        }
                        else if(option == 4){
                            break;
                        }
                        else{
                            System.out.println("Invalid option");
                        }
                        optionMenu();
                        option = scanner.nextInt();

                    }
                }
                else if(account instanceof Admin){ // the admin side of the project
                    System.out.println("Welcome " + account.getUsername());
                    int option;
                    while(true){ // admin prompts loop
                        adminOptionMenu();
                        option = scanner.nextInt();
                        scanner.nextLine();
                        if(option == 1){
                            System.out.println("Please enter the name of the item you would like to add");
                            String name = scanner.nextLine();
                            System.out.println("Please enter the description of the item you would like to add");
                            String description = scanner.nextLine();
                            System.out.println("Please enter the price of the item you would like to add");
                            double price = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Please enter the brand of the item you would like to add");
                            String brand = scanner.nextLine();
                            System.out.println("Please enter the category of the item you would like to add");
                            String category = scanner.nextLine();
                            while(!category.equals("Clothes") && !category.equals("Electronics") && !category.equals("Food")){
                                System.out.println("Invalid category");
                                System.out.println("Please enter the category of the item you would like to add");
                                category = scanner.nextLine();
                            }
                            if(category.equals("Clothes")){
                                System.out.println("Please enter the size of the item you would like to add");
                                String size = scanner.nextLine();
                                System.out.println("Please enter the color of the item you would like to add");
                                String color = scanner.nextLine();
                                itemManager.addItem(new Clothes(name, description, price, size, color, brand));
                            }
                            else if(category.equals("Electronics")){
                                System.out.println("Please enter the model of the item you would like to add");
                                String model = scanner.nextLine();
                                itemManager.addItem(new Electronics(name, description, price, model, brand));
                            }
                            else {
                                System.out.println("Please enter the flavor of the item you would like to add");
                                String flavor = scanner.nextLine();
                                itemManager.addItem(new Food(name, description, price, flavor, brand));
                            }
                            System.out.println("please enter the quantity");
                            int q = scanner.nextInt();
                            inventory.addItem(itemManager.getItem(name).getId(),q);
                            System.out.println("Item added");
                        }
                        else if(option == 2){
                            System.out.println("Please enter the name of the item you would like to remove");
                            String name = scanner.nextLine();
                            Item item = itemManager.getItem(name);
                            if(item != null){
                                itemManager.removeItem(item);
                                inventory.removeItem(itemManager.getItem(name).getId());
                                System.out.println("Item removed");
                            }
                        }
                        else if(option == 3){
                            System.out.println("Please enter the name of the item you would like to update the quantity of");
                            String name = scanner.nextLine();
                            Item item = itemManager.getItem(name);
                            if(item != null){
                                System.out.println("Please enter the new quantity of the item");
                                int quantity = scanner.nextInt();
                                inventory.updateQuantity(item.getId(), quantity);
                                System.out.println("Item quantity updated");
                            }
                        }
                        else if(option == 4){
                            System.out.println(inventory);
                        }
                        else if(option == 5){
                            for(Order order : orderManager.getOrders()){
                                System.out.println(order.toString());
                            }
                        }
                        else if(option == 6){
                            System.out.println("Please enter the name of the item you would like to add a discount to");
                            String name = scanner.nextLine();
                            Item item = itemManager.getItem(name);
                            if(item != null){
                                System.out.println("Please enter the discount you would like to add");
                                double discount = scanner.nextDouble();
                                item.setPrice(item.getPrice() * (1 - discount));
                                System.out.println("Discount added");
                            }
                        }
                        else if(option == 7){
                            break;
                        }
                        else{
                            System.out.println("Invalid option");
                        }
                    }
                }
            }
            else if(optionLog == 2){
                break;
            }
            else{
                System.out.println("Invalid option");
            }

        }
    }
}