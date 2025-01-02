package ATM;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String userId;
    private String userPass;
    private double balance=0.0;
    public ArrayList<Transaction> userTransaction=new ArrayList<>();

    public ArrayList<Transaction>getUserTransaction(){

        return userTransaction;

    }

     public User(String userId,String userPass,Double balance){
         this.userId=userId;
         this.userPass=userPass;
         this.balance =balance;

    }

    public String getuserId(){

        return userId;

    }
    public String getuserPass(){

         return userPass;

    }
    public void setUserPass(String userPass){

         this.userPass=userPass;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public double getbalance(){

         return balance;

    }
    public void setbalance(double balance){

        this.balance=balance;

    }

}
