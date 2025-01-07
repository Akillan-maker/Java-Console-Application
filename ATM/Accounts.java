package ATM;

import java.util.ArrayList;

public class Accounts{
    public String userName;
    public String userPass;

    public Accounts(String userName,String userPass){

        this.userName=userName;
        this.userPass=userPass;
    }
    public String getUserName(){

        return userName;

    }
    public String getUserPass(){

        return userPass;

    }

    public void setUserName(String userName) {

        this.userName = userName;

    }

    public void setUserPass(String userPass) {

        this.userPass = userPass;

    }
}