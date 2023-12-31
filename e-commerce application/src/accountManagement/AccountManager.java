package accountManagement;

import java.io.Console;
import java.util.ArrayList;

public class AccountManager{
    private ArrayList<Account> accounts;
    public AccountManager(){
        accounts = new ArrayList<Account>();
    }
    public void addAccount(Account account){
        for(Account a : accounts){
            if(a.getUsername().equals(account.getUsername())){
                System.out.println("Account already exists");
                return;
            }
        }
        accounts.add(account);
    }
    public void removeAccount(Account account){
        if(accounts.contains(account))
            accounts.remove(account);
        else
            System.out.println("Account does not exist");
    }
    public Account getAccount(String username){
        for(Account account : accounts){
            if(account.getUsername().equals(username)){
                return account;
            }
        }
        System.out.println("Account does not exist");
        return null;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Account account : accounts){
            result.append(account.toString()).append("\n");
        }
        return result.toString();
    }
}