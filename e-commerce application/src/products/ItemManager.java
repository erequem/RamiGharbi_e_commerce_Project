package products;

import java.util.ArrayList;

public class ItemManager{
    private ArrayList<Item> items;
    public ItemManager(){
        items = new ArrayList<Item>();
    }
    public void addItem(Item item){
        for(Item i : items){
            if(i.getName().equals(item.getName())){
                System.out.println("Item already exists");
                return;
            }
        }
        items.add(item);
    }
    public void removeItem(Item item){
        if(items.contains(item))
            items.remove(item);
        else
            System.out.println("Item does not exist");
    }
    public Item getItem(String name){
        for(Item item : items){
            if(item.getName().equals(name)){
                return item;
            }
        }
        System.out.println("Item does not exist");
        return null;
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Item item : items){
            result.append(item.toString()).append("\n");
        }
        return result.toString();
    }
}