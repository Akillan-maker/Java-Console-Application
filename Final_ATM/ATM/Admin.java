package ATM;

import java.util.ArrayList;
import java.util.Arrays;

public class Admin {
    public static String admin_Id="Ad01";
    public static String admin_Pass="123";
    public ArrayList<Transaction> adminTransaction=new ArrayList<>();

    public  ArrayList<Transaction>getAdminTransaction(){

        return adminTransaction;

    }

    public Admin(String adminId,String adminPass){

        this.admin_Id=adminId;
        this.admin_Pass=adminPass;

    }

//    public String getAdminId(){
//
//        return admin_Id;
//
//    }
//    public String getAdminPass(){
//
//        return admin_Pass;
//    }

}
