package ATM;

                           // Every method are non-static because different user perform different actions

public class Transaction {
    public String userName;       // A variable username is declared
    public  String type;
    public  long amount;

    public Transaction(String username,String type,long amount){   // Constructor is created to initialize

        this.userName=username;   // Assigns username
        this.type=type;         // Assigns type
        this.amount=amount;    // Assigns amount

    }

    public String getuserName(){  // Gets username

        return userName;  // Returns username

    }

    public String getType(){    // Gets type

        return type;  // Returns type

    }

    public long getAmount(){   // Gets amount

        return amount;  // Returns amount

    }

}
