package shoppingCart;

import products.Item;


import java.util.HashMap;

public class Cart{
    private HashMap<Item, Integer> items;
    public Cart(){
        items = new HashMap<Item, Integer>();
    }
    public void addItem(Item item, int quantity){
        if(items.containsKey(item)){
            items.put(item, items.get(item) + quantity);
        }
        else{
            items.put(item, quantity);
        }
    }
    public void removeItem(Item item){
        if(items.containsKey(item))
            items.remove(item);
        else
            System.out.println("Item does not exist");
    }
    public void updateQuantity(Item item, int quantity){
        if(items.containsKey(item))
            items.put(item, quantity);
        else
            System.out.println("Item does not exist");
    }
    public int getQuantity(Item item){
        if(items.containsKey(item))
            return items.get(item);
        else
            System.out.println("Item does not exist");
        return -1;
    }
    public HashMap<Item, Integer> getCart(){
        return this.items;
    }
    public String toString(){
        String result = "";
        for(Item item : items.keySet()){
            result += item.toString() + "\nQuantity: " + items.get(item) + "\n";
        }
        return result;
    }
}
