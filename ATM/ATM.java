package ATM;

import ATM.ListofNotes.*;
import ATM.Note.Notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static double atm_Balance;     // Declared a variable atmbalance as static(it is only need in ATM)
    public static ArrayList<Admin> adminList=new ArrayList<>();   // Created a arraylist adminlist with a assigned list
    public static ArrayList<User> userList=new ArrayList<>();     // Craeted a arraylist userlist
    public static ArrayList<Notes> notesList=new ArrayList<>(Arrays.asList(new TwoThousand("2000",0),new FiveHundred("500",0),new TwoHundred("200",0),new Hundred("100",0)));   // Craeted a noteslist with a assigned list

    public static ArrayList<Accounts> accounts=new ArrayList<>();

    public static ArrayList<Accounts> getAccounts(){

        return accounts;

    }

    public static ArrayList<Notes> getNotesList(){   // Gets notelist

        return notesList;   // Returns notelist

    }
    public static void setNotesList(ArrayList<Notes> note){   // Sets notelist

        ATM.notesList=note;   // Assigns notelist

    }

    public static ArrayList<Admin> getAdminList(){     // Gets adminlist

        return adminList;   // Returns adminlist

    }
    public static ArrayList<User> getUserList(){   // Gets userlist

        return userList;  // Returns userlist

    }
    public static double getatmBalance(){   // Gets atmbalance

        return atm_Balance;   // returns atmbalance

    }
    public static void setatmBalance(double atmBalance){   // Sets atmbalance

        atm_Balance =atmBalance;  // Assigns atmbalance
    }


    public static void start(Scanner scan) throws CloneNotSupportedException {      // Method start is created and defined
        ATM.getAccounts().add(new Admin("Ad01","123"));
        ATM.getAccounts().add(new User("1","1",0.0));
        while(true){
            System.out.println("1) Admin\n2) User\n3) Exit\nYou are: ");     // Prints the menu
            int choice=Integer.parseInt(scan.nextLine());           // Gets the user choice as int
            switch (choice){                 // Gets the choice to perform assigned action
                case 1:
                    Admin admin = (Admin) AdminAction.adminLogin(scan);   // An object admin is created and adminLogin is called
                    if(admin==null)       // If null then it breaks
                    {
                        System.out.println("No admins found");
                        break;
                    }
                    ATM.adminOptions(scan,admin);           // Calls method adminOptions
                    break;
                case 2:
                    User user = (User) UserAction.userLogin(scan);   // An object is created and userLogin is called
                    if(user==null)         // If null it breaks
                    {
                        break;
                    }
                    ATM.useroptions(scan,user);     // Method userOptions is called
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid option...");     // Prints
            }
        }
    }

    public static void adminOptions(Scanner scan, Accounts admin) throws CloneNotSupportedException {     // Method adminOptions is created and defined
        while(true){
            System.out.println("1) Add User\n2) Delete User\n3) Admin Deposit\n4) View all User\n5) View all Transactions\n6) Exit\n Enter option: ");  // Prints
            int adminchoice=Integer.parseInt(scan.nextLine());        // Gets user choice
            switch (adminchoice) {
                case 1:
                    AdminAction.addUser(scan);     // Calls method addUser
                    break;
                case 2:
                    AdminAction.deleteUser(scan);   // Calls method deleteUser
                    break;
                case 3:
                    AdminAction.adminDeposit(scan,admin);   // Calls method adminDeposit
                    break;
                case 4:
                    AdminAction.viewalluser(scan);     // Calls method viewalluser
                    break;
                case 5:
                    AdminAction.viewAlltransaction(scan,admin);    // Calls method viewAlltransactions
                    break;
                case 6:
                    System.out.println("Loging out...");  // Prints
                    ATM.start(scan);          // Calls method start
                    break;
                default:
                    System.out.println("Invalid options ");    // Prints
            }
        }
    }

    public static void useroptions(Scanner scan,User currentuser) throws CloneNotSupportedException {   // userOptions method is created and defined

        while(true) {
            System.out.println("1)Check Balance\n2)Deposit\n3)Withdraw\n4)Change Pin\n5)View Transaction\n6)Exit\nEnter your choice: ");  // Prints
            int userchoice = Integer.parseInt(scan.nextLine());             // Gets user choice
            switch (userchoice){
                case 1:
                    System.out.println(currentuser.getbalance());   //Print the balance os current user
                    break;
                case 2:
                    UserAction.userDeposit(scan,currentuser);      //  Calls method  userDeposit
                    break;
                case 3:
                    UserAction.userWithdraw(scan,currentuser);    // Calls method userWithdraw
                    break;
                case 4:
                    UserAction.changePin(scan,currentuser);    // Calls method chandePin
                    break;
                case 5:
                    UserAction.viewTransaction(scan,currentuser);    // Calls method viewTransactions
                    break;
                case 6:
                    System.out.println("Loging out...");   // Prints
                    return;

            }
        }
    }
}