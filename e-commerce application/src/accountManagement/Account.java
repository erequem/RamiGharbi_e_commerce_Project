package accountManagement;

public class Account{
    private String username;
    private String password;
    private String userId;//unique id for each user
    private static int count = 0;
    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.userId = "U" + count;
        count++;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUserId(){
        return this.userId;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String toString(){
        return "Username: " + this.username + "\nPassword: " + this.password + "\nUser ID: " + this.userId;
    }
}
