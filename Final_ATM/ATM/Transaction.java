package ATM;

public class Transaction {
    public String userName;
    public  String type;
    public  long amount;

    public Transaction(String username,String type,long amount){

        this.userName=username;
        this.type=type;
        this.amount=amount;

    }

    public  String getuserName(){

        return userName;

    }

    public String getType(){

        return type;

    }

    public long getAmount(){

        return amount;

    }

}
