package products;

import java.util.ArrayList;

public class ProductSearch{
    private ItemManager items;
    private ArrayList<Item> result;
    public ProductSearch(ItemManager items){
        this.items = items;
        result = new ArrayList<Item>();
        result.addAll(items.getItems());
    }
    public ArrayList<Item> searchByName(String name){
        for(Item item : items.getItems()){
            if(!item.getName().equals(name)){
                result.remove(item);
            }
        }
        if (result.size() == 0){
            System.out.println("No items found");
        }
        return result;
    }
    public ArrayList<Item> searchByPrice(double min, double max){
        for(Item item : items.getItems()){
            if(item.getPrice() < min || item.getPrice() > max){
                result.remove(item);
            }
        }
        if (result.isEmpty()){
            System.out.println("No items found");
        }
        return result;
    }
    public ArrayList<Item> searchByBrand(String brand){
        for(Item item : items.getItems()){
            if(item instanceof Electronics){
                if(!item.getBrand().equals(brand)){
                    result.remove(item);
                }
            }
            else if(item instanceof Food){
                if(!item.getBrand().equals(brand)){
                    result.remove(item);
                }
            }
            else if(item instanceof Clothes){
                if(!item.getBrand().equals(brand)){
                    result.remove(item);
                }
            }
        }
        if (result.isEmpty()){
            System.out.println("No items found");
        }
        return result;
    }
    public ArrayList<Item> searchBySize(String size){
        for(Item item : items.getItems()){
            if(item instanceof Clothes){
                if(!((Clothes) item).getSize().equals(size)){
                    result.remove(item);
                }
            }
            else{
                result.remove(item);
            }
        }
        if (result.isEmpty()){
            System.out.println("No items found");
        }
        return result;
    }
    public ArrayList<Item> searchByColor(String color){
        for(Item item : items.getItems()){
            if(item instanceof Clothes){
                if(!((Clothes) item).getColor().equals(color)){
                    result.remove(item);
                }
            }
            else{
                result.remove(item);
            }
        }
        if (result.isEmpty()){
            System.out.println("No items found");
        }
        return result;
    }
    public ArrayList<Item> searchByFlavor(String flavor){
        for(Item item : items.getItems()){
            if(item instanceof Food){
                if(!((Food) item).getFlavor().equals(flavor)){
                    result.remove(item);
                }
            }
            else{
                result.remove(item);
            }
        }
        if (result.isEmpty()){
            System.out.println("No items found");
        }
        return result;
    }
    public ArrayList<Item> searchByCategory(String category){
        if(category.equals("Clothes")){
            for(Item item : items.getItems()){
                if(!(item instanceof Clothes)){
                    result.remove(item);
                }
            }
        }
        else if(category.equals("Electronics")){
            for(Item item : items.getItems()){
                if(!(item instanceof Electronics)){
                    result.remove(item);
                }
            }
        }
        else if(category.equals("Food")){
            for(Item item : items.getItems()){
                if(!(item instanceof Food)){
                    result.remove(item);
                }
            }
        }
        else{
            System.out.println("Invalid category");
        }
        if (result.isEmpty()){
            System.out.println("No items found");
        }
        return result;
    }
    public ArrayList<Item> searchByModel(String model){
        for(Item item : items.getItems()){
            if(item instanceof Electronics){
                if(!((Electronics) item).getModel().equals(model)){
                    result.remove(item);
                }
            }
            else{
                result.remove(item);
            }
        }
        if (result.isEmpty()){
            System.out.println("No items found");
        }
        return result;
    }
    public void reset(){
        result.clear();
        result.addAll(items.getItems());
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Item item : this.result){
            result.append(item.toString()).append("\n");
        }
        return result.toString();
    }
}
