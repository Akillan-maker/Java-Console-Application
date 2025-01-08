package ATM;

import ATM.Note.Notes;

import java.util.ArrayList;
import java.util.Scanner;

                   // All the methods are static because every user's operation is same

public class UserAction {

    public static Accounts userLogin(Scanner scan) throws CloneNotSupportedException {   // Method userLogin is created and defined

        System.out.println("User ID: ");
        String username=scan.nextLine();
        for(Accounts user:ATM.getAccounts()){
            if(user instanceof User){
                if(user.getUserName().equals(username)){
                    System.out.println("Password: ");
                    String userpass=scan.nextLine();
                    if(user.getUserPass().equals(userpass)){
                        System.out.println("Login Successful...");
                        return user;
                    }
                }
            }
        }
        System.out.println("Login Failed...");
        return null;
    }


    public static void userDeposit(Scanner scan,User currentuser){   // Method userDeposit is created and defined
        System.out.println("Deposit Amount: ");
        double userDeposit=Double.parseDouble(scan.nextLine());  // Converts str into double
        System.out.println("No.of Two thousand notes: ");
        int twoThousand=Integer.parseInt(scan.nextLine());     // converts str into int
        System.out.println("No.of Five hundred notes: ");
        int fiveHundred=Integer.parseInt(scan.nextLine());
        System.out.println("No.of Two hundred notes: ");
        int twoHundred=Integer.parseInt(scan.nextLine());
        System.out.println("No.of hundred notes: ");
        int hundred=Integer.parseInt(scan.nextLine());
        if (2000*twoThousand+500*fiveHundred+200*twoHundred+100*hundred==userDeposit) {   // Checks the condition
            for(Notes notes:ATM.getNotesList()){
                String old= notes.getNote();
                switch (old){
                    case "2000":
                        notes.setNotecount(notes.getNotecount()+twoThousand);   // Sets the count for 2000 notes
                        break;
                    case "500":
                        notes.setNotecount(notes.getNotecount()+fiveHundred);     // Sets the count for 500 notes
                        break;
                    case "200":
                        notes.setNotecount(notes.getNotecount()+twoHundred);    // Sets the count for 200 notes
                        break;
                    case "100":
                        notes.setNotecount(notes.getNotecount()+hundred);       // Sets the count for 100 notes
                        break;
                    default:
                        System.out.println("Invalid note...");
                        break;
                }
            }
            currentuser.setbalance(currentuser.getbalance() + userDeposit);     // Sets currentuser balance
            ATM.setatmBalance(ATM.getatmBalance() + userDeposit);    // Sets atmbalance
            System.out.println("Deposited Successfully...");
            for(Notes note:ATM.getNotesList()) {
                System.out.println("No.of " + note.getNote() + " are " + note.getNotecount());
            }
            currentuser.getTransactions().add(new Transaction(currentuser.getUserName(), " Deposited", (long) userDeposit));   // Adds obj to usertransaction
            System.out.println(currentuser.getUserName() + " has deposited " + userDeposit);
            System.out.println("AtmBalance: "+ATM.atm_Balance);
            return;
        }
        System.out.println("Invalid No.of Notes...");
    }

    public static long withdrawOperation(long userWithdraw, Notes note, ArrayList<String> denominations){   // Method withdrawOperation is created and defined
        long count= userWithdraw/Integer.parseInt(note.getNote());    // Divides the withdraw amt with respective notes
        if(Long.parseLong(note.getNote()) <= userWithdraw && count <= note.getNotecount()){
            userWithdraw = userWithdraw - (count * Integer.parseInt(note.getNote()));
            note.setNotecount((note.getNotecount() - count));      // Minus the count
            denominations.add("You got "+note.getNote()+"  count: "+count);
            return userWithdraw;
        }
        return userWithdraw;
    }

    public static void userWithdraw(Scanner scan,User currentuser) throws CloneNotSupportedException {    // Method userwithdraw is created and defined
        ArrayList<Notes> duplicate=new ArrayList<>();    // Arraylist duplicate is created
        ArrayList<String> denominations=new ArrayList<>();      // Arraylist denominations is created

        System.out.println("Withdraw Amount: ");
        long userWithdraw=Long.parseLong(scan.nextLine());
        if(userWithdraw<= currentuser.getbalance()){
            long dupwithdrawam =userWithdraw;      // Assigns userWithdraw to dupwithdraw
            for(Notes note:ATM.getNotesList()){

                duplicate.add(note.clone());    // Clones the notelist to duplicate

            }
            while(userWithdraw!=0) {
                for (Notes dupnote : duplicate) {
                    String dupNotename = dupnote.getNote();    // Assigns notename
                    switch (dupNotename) {
                        case "2000", "500", "200", "100":
                            userWithdraw = UserAction.withdrawOperation(userWithdraw, dupnote, denominations);   // Calls the method withdrawOpertion
                            break;
                    }
                }

                if (userWithdraw == 0) {
                    ATM.setNotesList(duplicate);    // Sets duplicate to notelist
                    currentuser.setbalance(currentuser.getbalance() - dupwithdrawam);  // Sets balance os currentuser
                    ATM.setatmBalance(ATM.getatmBalance()- dupwithdrawam);   // Sets the balance of atm
                    System.out.println("Withdraw Successful...");
                    System.out.println("AtmBalance: " + ATM.atm_Balance);
                    for (String str : denominations) {
                        System.out.println(str);
                    }
                    for (Notes note : ATM.getNotesList()) {
                        System.out.println("No.of " + note.getNote() + " are " + note.getNotecount());
                    }
                    return;
                }
                System.out.println("Denominations not match...");
                return;
            }

        }
        System.out.println("Insufficient Amount...");
    }

    public static void changePin(Scanner scan,User currentuser){    // Method changePin is created and defined
        System.out.println("OldPass: ");
        String oldPass=scan.nextLine();
        if(oldPass.equals(currentuser.getUserPass())){
            System.out.println("New Password: ");
            String newPass=scan.nextLine();
            currentuser.setUserPass(newPass);    // Sets newPass
            System.out.println("Password Changed Successfully...");
            return;
        }
        System.out.println("Wrong Password...Retry");
    }

    public static void viewTransaction(Scanner scan,User currentuser){      // Method viewtransactionns is created and defined
        for(Transaction user:currentuser.getTransactions()){
            System.out.println(user.getuserName()+" has "+user.getType()+" Rs."+user.getAmount());
        }
    }
}