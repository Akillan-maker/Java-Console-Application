package ATM;

import java.util.ArrayList;
import java.util.Arrays;

public class User extends Accounts {
          // Declared a variable to store userPass
    private double balance=0.0;    // Declared a variable to store balance
    public ArrayList<Transaction> userTransaction=new ArrayList<>();    // Created a arraylist of userTransactions

    public ArrayList<Transaction>getUserTransaction(){        // Method to get the arraylist

        return userTransaction;   //returns the arraylist

    }

    public User(String userId,String userPass,Double balance){      // Created a constructor to initialize userId,userPass and balance

        super(userId,userPass);  // Assigns userPass
        this.balance =balance;    // Assigns balance

    }

//    public String getuserId(){       // Gets the userId
//
//        return userId;   // returns userId
//
//    }
//    public String getuserPass(){      // Gets ussrPass
//
//        return userPass;   // returns userPass
//
//    }
//    public void setUserPass(String userPass){   // Sets userPass
//
//        this.userPass=userPass;  // Assigns userPass
//    }
//
//    public void setUserId(String userId) {  // Sets userId
//
//        this.userId = userId;  // Returns userId
//    }

    public double getbalance(){   // Gets balance

        return balance;   // Returns balance

    }
    public void setbalance(double balance){  // Sets balance

        this.balance=balance;   // Assigns balance

    }

}