package ATM;

public class User extends Accounts {
    private double balance;    // Declared a variable to store balance

    public User(String userId,String userPass,Double balance){      // Created a constructor to initialize userId,userPass and balance

        super(userId,userPass);  // Assigns userPass
        this.balance =balance;    // Assigns balance

    }

    public double getbalance(){   // Gets balance

        return balance;   // Returns balance

    }
    public void setbalance(double balance){  // Sets balance

        this.balance=balance;   // Assigns balance

    }

}