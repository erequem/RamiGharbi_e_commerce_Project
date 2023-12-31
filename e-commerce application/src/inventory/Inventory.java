package inventory;

import products.Item;

import java.util.HashMap;

public class Inventory{
    private HashMap<Integer, Integer> items;
    public Inventory(){
        items = new HashMap<Integer, Integer>();
    }
    public void addItem(int id, int quantity){
        if(items.containsKey(id)){
            items.put(id, items.get(id) + quantity);
        }
        else{
            items.put(id, quantity);
        }
    }
    public void removeItem(int id){
        if(items.containsKey(id))
            items.remove(id);
        else
            System.out.println("Item does not exist");
    }
    public void updateQuantity(int id, int quantity){
        if(items.containsKey(id))
            items.put(id, quantity);
        else
            System.out.println("Item does not exist");
    }
    public int getQuantity(int id){
        if(items.containsKey(id))
            return items.get(id);
        else
            System.out.println("Item does not exist");
        return -1;
    }
    public HashMap<Integer, Integer> getItems(){
        return this.items;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Integer id : items.keySet()){
            result.append("Item ID: ").append(id).append("\nQuantity: ").append(items.get(id)).append("\n");
        }
        return result.toString();
    }
}

