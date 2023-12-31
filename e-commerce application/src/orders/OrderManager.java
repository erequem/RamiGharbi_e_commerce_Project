package orders;

import java.util.ArrayList;

public class OrderManager{
    private ArrayList<Order> orders;
    public OrderManager(){
        orders = new ArrayList<Order>();
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public void removeOrder(Order order){
        if(orders.contains(order))
            orders.remove(order);
        else
            System.out.println("Order does not exist");
    }
    public Order getOrder(String orderId){
        for(Order order : orders){
            if(order.getOrderId().equals(orderId)){
                return order;
            }
        }
        System.out.println("Order does not exist");
        return null;
    }
    public ArrayList<Order> getOrders(){
        return this.orders;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Order order : orders){
            result.append(order.toString()).append("\n");
        }
        return result.toString();
    }
}
