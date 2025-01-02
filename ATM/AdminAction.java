package ATM;
import java.util.ArrayList;
import java.util.Scanner;
                                         // Every methods are static because there is only one admin
                                         // the same can be applied to multiple admins
public class AdminAction {

    public static Admin adminLogin(Scanner scan) throws CloneNotSupportedException {    // Method adminLogin is created and defined
        while(true) {
            System.out.println("Admin id: ");
            String adminname = scan.nextLine();
            for(Admin admin:ATM.getAdminList()){          // Gets the items in adminlist
                if (adminname.equals(Admin.admin_Id)) {     // Checks the adminname
                    int i = 0;
                    while (i < 3) {
                        System.out.println("Admin pass: ");
                        String adminPass = scan.nextLine();
                        if (adminPass.equals(Admin.admin_Pass)) {   // Checks adminPass
                            System.out.println("Login Successful");
                            return admin;
                        } else {
                            System.out.println("Invalid Password...Retry!!!");
                            i++;
                        }
                    }
                }
            }
            System.out.println("Invalid Admin id...");
            return null;
        }
    }
    public static void addUser(Scanner scan){    // Method addUser is created and defined

        System.out.println("New User id: ");
        String new_userId=scan.nextLine();
        for(User user:ATM.getUserList()) {     // Gets items in userlist
            if (user.getuserId().equals(new_userId)) {   // Checks userId
                System.out.println("User id already exists...");
                return;
            }
        }
                System.out.println("set Password: ");
                String new_userPass = scan.nextLine();
                ATM.getUserList().add(new User(new_userId, new_userPass,0.0));  // Adds the username and paasword in an object
                System.out.println("User added Successfully...");
    }

    public static void deleteUser(Scanner scan){  // Method deleteUser is created and defined
        System.out.println("User id to delete: ");
        String deleteUser=scan.nextLine();
        for(User user:ATM.getUserList()) {
            if (user.getuserId().equals(deleteUser)) {
                ATM.getUserList().remove(user);     // Removes the user object
                System.out.println("Deleted user Successfully");
                return;
            }
        }
        System.out.println("User id not Found...");
    }

    public static void adminDeposit(Scanner scan,Admin admin){   // Method adminDeposit is created and defined
        System.out.println("Enter Deposit Amount: ");
        double admindepamt=Double.parseDouble(scan.nextLine());   // Converts str into double
        System.out.println("No.of Two thousand notes: ");
        int twoThousand=Integer.parseInt(scan.nextLine());       // Converts str into int
        System.out.println("No.of Five hundred notes: ");
        int fiveHundred=Integer.parseInt(scan.nextLine());      // Converts str into int
        System.out.println("No.of Two hundred notes: ");
        int twoHundred=Integer.parseInt(scan.nextLine());     // Converts str into int
        System.out.println("No.of hundred notes: ");
        int hundred=Integer.parseInt(scan.nextLine());          // Converts str into int
        if (2000*twoThousand+500*fiveHundred+200*twoHundred+100*hundred==admindepamt){    // Checks the condition
            for(Notes notes:ATM.getNotesList()){     // Gets the items in notesList
                String old= notes.getNote();      // Notename is assigned to a variable
                switch (old){
                    case "2000":
                        notes.setNotecount(notes.getNotecount()+twoThousand);   // Sets the count for 2000 notes
                        break;
                    case "500":
                        notes.setNotecount(notes.getNotecount()+fiveHundred);     // Sets the count for 500 notes
                        break;
                    case "200":
                        notes.setNotecount(notes.getNotecount()+twoHundred);        // Sets the count for 200 notes
                        break;
                    case "100":
                        notes.setNotecount(notes.getNotecount()+hundred);       // Sets the count for 100 notes
                        break;
                    default:
                        System.out.println("Invalid note...");
                        break;
                }
            }
            ATM.setatmBalance(ATM.getatmBalance()+admindepamt);     // Sets the atmbalance
            System.out.println("Deposited Successfully...");
//            ATM.setNotesList(twoThousand,fiveHundred,twoHundred,hundred);
            admin.getAdminTransaction().add(new Transaction(Admin.admin_Id,"Deposited", (long) admindepamt));     // Adds the object into admintransactionlist
            System.out.println("The Admin has Deposited Rs."+admindepamt);
            System.out.println("AtmBalance: "+ATM.atm_Balance);
            for(Notes note:ATM.getNotesList()){              // Gets notes

                System.out.println("No.of "+note.getNote()+" are "+note.getNotecount());
            }
            return;
        }
        System.out.println("Invalid Note count...");
    }

    public static void viewalluser(Scanner scan){          // Method viewallser is created and defined
        for(User user:ATM.getUserList()){             // Gets the items in userList
            System.out.println(user.getuserId());
        }
    }

    public static void viewAlltransaction(Scanner scan,Admin admins){     // Method viewAlltransactin is created and defined
        System.out.println("1) Admin Transactions\n2) User Transactions\n3) view All Transactions\nEnter your choice: ");
        int options=Integer.parseInt(scan.nextLine());
        switch (options){
            case 1:                 // Prints the transactions of admin
                for(Transaction admin: admins.getAdminTransaction()){
                    System.out.println(admin.getuserName()+" has "+admin.getType()+" Rs."+admin.getAmount());
                }
                break;
            case 2:        // Prints the transaction of users
                for (User user:ATM.getUserList())
                {
                    for(Transaction trans: user.getUserTransaction())
                    {
                        System.out.println(trans.getuserName()+" has "+trans.getType()+" Rs. "+trans.getAmount());
                    }
                }
                break;
            case 3:           // Prints both admin and user transaction
                System.out.println("Admin Transactions\n");
                for(Transaction admin: admins.getAdminTransaction()){
                    System.out.println(admin.getuserName()+" has "+admin.getType()+" Rs."+admin.getAmount());
                }

                System.out.println("User Transactions\n");
                for (User user:ATM.getUserList())
                {
                    for(Transaction trans: user.getUserTransaction())
                    {
                        System.out.println(trans.getuserName()+" has "+trans.getType()+" Rs. "+trans.getAmount());
                    }
                }
                break;
        }

    }
}
