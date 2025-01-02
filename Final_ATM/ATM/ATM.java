package ATM;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static double atm_Balance;
    public static ArrayList<Admin> adminList=new ArrayList<>(Arrays.asList(new Admin(Admin.admin_Id,Admin.admin_Pass)));
    public static ArrayList<User> userList=new ArrayList<User>();
    public static ArrayList<Notes> notesList=new ArrayList<>(Arrays.asList(new TwoThousand("2000",0),new FiveHundred("500",0),new TwoHundred("200",0),new Hundred("100",0)));

    public static ArrayList<Notes> getNotesList(){

        return notesList;
    }
    public static void setNotesList(ArrayList<Notes> note){

        ATM.notesList=note;
    }

//    public static void setNotesList(int twoThousand,int fiveHundred, int twoHundred, int hundred)
//    {
//        notesList.set(0,new TwoThousand("2000",twoThousand));
//        notesList.set(1,new FiveHundred("500",fiveHundred));
//        notesList.set(2,new TwoHundred("200",twoHundred));
//        notesList.set(3,new Hundred("100",hundred));
//    }

    public static ArrayList<Admin> getAdminList(){

        return adminList;
    }
    public static ArrayList<User> getUserList(){

        return userList;

    }
    public static double getatmBalance(){

        return atm_Balance;

    }
    public static void setatmBalance(double atmBalance){

        atm_Balance =atmBalance;
    }


    public static void start(Scanner scan) throws CloneNotSupportedException {
        ATM.getUserList().add(new User("1","1",0.0));
        while(true){
        System.out.println("1) Admin\n2) User\n3) Exit\nYou are: ");
        int choice=Integer.parseInt(scan.nextLine());
        switch (choice){
            case 1:
                Admin admin = AdminAction.adminLogin(scan);
                if(admin==null)
                {
                    break;
                }
                ATM.adminOptions(scan,admin);
                break;
            case 2:
                User user = UserAction.userLogin(scan);
                if(user==null)
                {
                    break;
                }
                ATM.useroptions(scan,user);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid option...");
        }
        }
        }

    public static void adminOptions(Scanner scan,Admin admin) throws CloneNotSupportedException {
        while(true){
            System.out.println("1) Add User\n2) Delete User\n3) Admin Deposit\n4) View all User\n5) View all Transactions\n6) Exit\n Enter option: ");
            int adminchoice=Integer.parseInt(scan.nextLine());
            switch (adminchoice) {
                case 1:
                    AdminAction.addUser(scan);
                    break;
                case 2:
                    AdminAction.deleteUser(scan);
                    break;
                case 3:
                    AdminAction.adminDeposit(scan,admin);
                    break;
                case 4:
                    AdminAction.viewalluser(scan);
                    break;
                case 5:
                    AdminAction.viewAlltransaction(scan,admin);
                    break;
                case 6:
                    System.out.println("Loging out...");
                    ATM.start(scan);
                    break;
                default:
                    System.out.println("Invalid options ");
            }
        }
    }

    public static void useroptions(Scanner scan,User currentuser) throws CloneNotSupportedException {

        while(true) {
            System.out.println("1)Check Balance\n2)Deposit\n3)Withdraw\n4)Change Pin\n5)View Transaction\n6)Exit\nEnter your choice: ");
            int userchoice = Integer.parseInt(scan.nextLine());
            switch (userchoice){
                case 1:
                    System.out.println(currentuser.getbalance());
                    break;
                case 2:
                    UserAction.userDeposit(scan,currentuser);
                    break;
                case 3:
                    UserAction.userWithdraw(scan,currentuser);
                    break;
                case 4:
                    UserAction.changePin(scan,currentuser);
                    break;
                case 5:
                    UserAction.viewTransaction(scan,currentuser);
                    break;
                case 6:
                    System.out.println("Loging out...");
                    return;

            }
        }
    }
}
