package shoppingCart;

import java.util.HashMap;

public class UserCarts{
    private HashMap<String, Cart> carts;
    public UserCarts(){
        carts = new HashMap<String, Cart>();
    }
    public void addCart(String userId, Cart cart){
        carts.put(userId, cart);
    }
    public void removeCart(String userId){
        if(carts.containsKey(userId))
            carts.remove(userId);
        else
            System.out.println("Cart does not exist");
    }
    public Cart getCart(String userId){
        if(carts.containsKey(userId))
            return carts.get(userId);
        else
            System.out.println("Cart does not exist");
        return null;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(String userId : carts.keySet()){
            result.append("User ID: ").append(userId).append("\n").append(carts.get(userId).toString()).append("\n");
        }
        return result.toString();
    }
}