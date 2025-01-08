package ATM;
import ATM.Note.Notes;

import java.util.Scanner;

                   // Every methods are static because there is only one admin
                   // the same can be applied to multiple admins

public class AdminAction {

    public static Accounts adminLogin(Scanner scan) throws CloneNotSupportedException {    // Method adminLogin is created and defined
        while (true){
            System.out.println("Admin ID: ");
            String adminname = scan.nextLine();
            for (Accounts adminn : ATM.getAccounts()) {
                if (adminn instanceof Admin) {
                    if (adminn.getUserName().equals(adminname)) {
                        int i=0;
                        while(i<3){
                            System.out.println("Password: ");
                            String adminpass = scan.nextLine();
                            if(adminn.getUserPass().equals(adminpass)){
                                System.out.println("Login Successful...");
                                return adminn;
                            }
                            else {
                                System.out.println("Invalid Password...Retry");
                                i++;
                            }
                        }
                    }
                }
            }
            System.out.println("Login Failed...");
            return null;
        }
    }

    public static void addUser(Scanner scan) {    // Method addUser is created and defined

        System.out.println("New User ID: ");
        String new_userId = scan.nextLine();
        for (Accounts user : ATM.getAccounts()) {
            if (user instanceof User) {
                if (user.getUserName().equals(new_userId)) {
                    System.out.println("User Already exists...");
                    return;
                }
            }
        }
        System.out.println("Password: ");
        String new_userPass = scan.nextLine();
        ATM.getAccounts().add(new User(new_userId, new_userPass, 0.0));
        System.out.println("User added Successfully...");
    }

    public static void deleteUser(Scanner scan) {  // Method deleteUser is created and defined

        System.out.println("User ID to Delete: ");
        String deleteuser = scan.nextLine();
        for (Accounts user : ATM.getAccounts()) {
            if (user instanceof User) {
                if (user.getUserName().equals(deleteuser)) {
                    ATM.getAccounts().remove(user);
                    System.out.println("User Deleted Successfully...");
                    return;
                }
            }
        }
        System.out.println("User ID not Found...");
    }

    public static void adminDeposit(Scanner scan, Accounts admin) {   // Method adminDeposit is created and defined
        System.out.println("Enter Deposit Amount: ");
        double admindepamt = Double.parseDouble(scan.nextLine());   // Converts str into double
        System.out.println("No.of Two thousand notes: ");
        int twoThousand = Integer.parseInt(scan.nextLine());       // Converts str into int
        System.out.println("No.of Five hundred notes: ");
        int fiveHundred = Integer.parseInt(scan.nextLine());      // Converts str into int
        System.out.println("No.of Two hundred notes: ");
        int twoHundred = Integer.parseInt(scan.nextLine());     // Converts str into int
        System.out.println("No.of hundred notes: ");
        int hundred = Integer.parseInt(scan.nextLine());          // Converts str into int
        if (2000 * twoThousand + 500 * fiveHundred + 200 * twoHundred + 100 * hundred == admindepamt) {    // Checks the condition
            for (Notes notes : ATM.getNotesList()) {     // Gets the items in notesList
                String old = notes.getNote();      // Notename is assigned to a variable
                switch (old) {
                    case "2000":
                        notes.setNotecount(notes.getNotecount() + twoThousand);   // Sets the count for 2000 notes
                        break;
                    case "500":
                        notes.setNotecount(notes.getNotecount() + fiveHundred);     // Sets the count for 500 notes
                        break;
                    case "200":
                        notes.setNotecount(notes.getNotecount() + twoHundred);        // Sets the count for 200 notes
                        break;
                    case "100":
                        notes.setNotecount(notes.getNotecount() + hundred);       // Sets the count for 100 notes
                        break;
                    default:
                        System.out.println("Invalid note...");
                        break;
                }
            }
            ATM.setatmBalance(ATM.getatmBalance() + admindepamt);     // Sets the atmbalance
            System.out.println("Deposited Successfully...");
            admin.getTransactions().add(new Transaction(admin.getUserName(),"Deposited", (long) admindepamt));     // Adds the object into admintransactionlist
            System.out.println("The Admin has Deposited Rs." + admindepamt);
            System.out.println("AtmBalance: " + ATM.atm_Balance);
            for (Notes note : ATM.getNotesList()) {              // Gets notes

                System.out.println("No.of " + note.getNote() + " are " + note.getNotecount());
            }
            return;
        }
        System.out.println("Invalid Note count...");
    }

    public static void viewalluser(Scanner scan) {       // Method viewallser is created and defined

            for (Accounts user : ATM.getAccounts()) {
                if (user instanceof User){
                    if(ATM.getAccounts().isEmpty()){
                        System.out.println("No User Found...");
                        return;
                    }
                    System.out.println(user.getUserName());
                }
            }
    }

    public static void viewAlltransaction(Scanner scan, Accounts admins) {     // Method viewAlltransactin is created and defined
        System.out.println("1) Admin Transactions\n2) User Transactions\n3) view All Transactions\nEnter your choice: ");
        int options=Integer.parseInt(scan.nextLine());
        switch (options){
            case 1:                 // Prints the transactions of admin
                for(Transaction admin: admins.getTransactions()){

                    System.out.println(admin.getuserName()+" has "+admin.getType()+" Rs."+admin.getAmount());
                }
                break;
            case 2:        // Prints the transaction of users
                for (Accounts user:ATM.getAccounts()) {
                    if (user instanceof User) {
                        for (Transaction users : user.getTransactions()) {
                            System.out.println(users.getuserName() + " has " + users.getType() + " Rs. " + users.getAmount());
                        }
                    }
                }
                break;

            case 3:           // Prints both admin and user transaction
                System.out.println("Admin Transactions\n");
                for(Transaction admin: admins.getTransactions()){

                    System.out.println(admin.getuserName()+" has "+admin.getType()+" Rs."+admin.getAmount());
                }

                System.out.println("User Transactions\n");
                for (Accounts user:ATM.getAccounts()) {
                    if (user instanceof User) {
                        for (Transaction trans : user.getTransactions()) {
                            System.out.println(trans.getuserName() + " has " + trans.getType() + " Rs. " + trans.getAmount());
                        }
                    }

                }
                break;
        }
    }
}