package orders;

import products.Item;
import shoppingCart.Cart;

import java.util.ArrayList;
import java.util.HashMap;

public class Order{
    private String orderId;
    private String userId;
    private Cart cart;
    private double total;
    private static int count = 0;
    public Order(String userId, Cart cart){
        this.userId = userId;
        this.cart = cart;
        this.total = 0;
        for(Item item : cart.getCart().keySet()){
            this.total += item.getPrice() * cart.getCart().get(item);
        }
        this.orderId = "O" + count;
        count++;
    }
    public String getOrderId(){
        return this.orderId;
    }
    public String getUserId(){
        return this.userId;
    }
    public Cart getCart(){
        return this.cart;
    }
    public double getTotal(){
        return this.total;
    }
    public void setOrderId(String orderId){
        this.orderId = orderId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public void setCart(Cart cart){
        this.cart = cart;
    }
    public void setTotal(double total){
        this.total = total;
    }
    public String toString(){
        return "Order ID: " + this.orderId + "\nUser ID: " + this.userId + "\n" + this.cart.toString() + "Total: " + this.total;
    }
}