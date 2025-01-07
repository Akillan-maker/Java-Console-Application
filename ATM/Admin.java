package ATM;

import java.util.ArrayList;
import java.util.Arrays;

public class Admin extends Accounts{
//    public static String admin_Id="Ad01";                 // Assigned default admin id as static(it will not be changed)
//    public static String admin_Pass="123";                // Assigned default admin password as static(it will not be changed)
    public ArrayList<Transaction> adminTransaction=new ArrayList<>();   // Created an arraylist to store admin transaction

    public ArrayList<Transaction>getAdminTransaction(){         // This method gets the items in arraylist

        return adminTransaction;          //returns the arraylist

    }

    public Admin(String adminId,String adminPass){           // Constructor is created to initialize the adminId and adminPass

        super(adminId,adminPass);

    }

}
