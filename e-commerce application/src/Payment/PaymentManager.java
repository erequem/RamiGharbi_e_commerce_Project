package Payment;

import java.util.ArrayList;
import java.util.HashMap;

public class PaymentManager{
    private HashMap<String, ArrayList<PaymentMethod>> paymentMethods;
    public PaymentManager(){
        paymentMethods = new HashMap<String, ArrayList<PaymentMethod>>();
    }
    public void addPaymentMethod(String userId, PaymentMethod paymentMethod){
        if(paymentMethods.containsKey(userId)){
            paymentMethods.get(userId).add(paymentMethod);
        }
        else{
            ArrayList<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
            paymentMethods.add(paymentMethod);
            this.paymentMethods.put(userId, paymentMethods);
        }
    }
    public void removePaymentMethod(String cardNumber){
        for(String userId : paymentMethods.keySet()){
            for(PaymentMethod paymentMethod : paymentMethods.get(userId)){
                if(paymentMethod.getCardNumber().equals(cardNumber)){
                    paymentMethods.get(userId).remove(paymentMethod);
                    return;
                }
            }
        }
        System.out.println("Payment method does not exist");
    }
    public PaymentMethod getPaymentMethod(String cardNumber){
        for(String userId : paymentMethods.keySet()){
            for(PaymentMethod paymentMethod : paymentMethods.get(userId)){
                if(paymentMethod.getCardNumber().equals(cardNumber)){
                    return paymentMethod;
                }
            }
        }
        System.out.println("Payment method does not exist");
        return null;
    }
    public String toString(){
        String result = "";
        for(String userId : paymentMethods.keySet()){
            result += "User ID: " + userId + "\n";
            for(PaymentMethod paymentMethod : paymentMethods.get(userId)){
                result += paymentMethod.toString() + "\n";
            }
        }
        return result;
    }
}
