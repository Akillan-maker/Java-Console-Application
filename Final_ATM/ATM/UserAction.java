package ATM;
import java.util.ArrayList;
import java.util.Scanner;
import static ATM.ATM.notesList;

public class UserAction {

    public static User userLogin(Scanner scan) throws CloneNotSupportedException {
        System.out.println("User id: ");
        String username=scan.nextLine();
        for(User user:ATM.getUserList()){
            if(user.getuserId().equals(username)){
                System.out.println("Password: ");
                String userpassword=scan.nextLine();
                if(user.getuserPass().equals(userpassword)){
                    System.out.println("Login Successful");
                    return user;
                }
                System.out.println("Incorrect Password...Retry!!!");
            }
        }
        System.out.println("Invalid User Id...Retry!!!");
        return null;
    }

    public static void userDeposit(Scanner scan,User currentuser){
        System.out.println("Deposit Amount: ");
        double userDeposit=Double.parseDouble(scan.nextLine());
        System.out.println("No.of Two thousand notes: ");
        int twoThousand=Integer.parseInt(scan.nextLine());
        System.out.println("No.of Five hundred notes: ");
        int fiveHundred=Integer.parseInt(scan.nextLine());
        System.out.println("No.of Two hundred notes: ");
        int twoHundred=Integer.parseInt(scan.nextLine());
        System.out.println("No.of hundred notes: ");
        int hundred=Integer.parseInt(scan.nextLine());
        if (2000*twoThousand+500*fiveHundred+200*twoHundred+100*hundred==userDeposit) {
            for(Notes notes:ATM.getNotesList()){
                String old= notes.getNote();
                switch (old){
                    case "2000":
                        notes.setNotecount(notes.getNotecount()+twoThousand);
                        break;
                    case "500":
                        notes.setNotecount(notes.getNotecount()+fiveHundred);
                        break;
                    case "200":
                        notes.setNotecount(notes.getNotecount()+twoHundred);
                        break;
                    case "100":
                        notes.setNotecount(notes.getNotecount()+hundred);
                        break;
                    default:
                        System.out.println("Invalid note...");
                        break;
                }
            }
            double balance1 = currentuser.getbalance();
            currentuser.setbalance(balance1 + userDeposit);
            double balance2 = ATM.getatmBalance();
            ATM.setatmBalance(balance2 + userDeposit);
            System.out.println("Deposited Successfully...");
//            ATM.setNotesList(twoThousand,fiveHundred,twoHundred,hundred);
            for(Notes note:ATM.getNotesList()) {
                System.out.println("No.of " + note.getNote() + " are " + note.getNotecount());
            }
            currentuser.getUserTransaction().add(new Transaction(currentuser.getuserId(), " Deposited", (long) userDeposit));
            System.out.println(currentuser.getuserId() + " has deposited " + userDeposit);
            System.out.println("AtmBalance: "+ATM.atm_Balance);
            return;
        }
        System.out.println("Invalid No.of Notes...");
        return;
    }

    public static long withdrawOperation(long userWithdraw,Notes note,ArrayList<String> dinominations){
        long count= userWithdraw/Integer.parseInt(note.getNote());
        if(Long.parseLong(note.getNote()) <= userWithdraw && count <= note.getNotecount()){
            userWithdraw = userWithdraw - (count * Integer.parseInt(note.getNote()));
            note.setNotecount((note.getNotecount() - count));
            dinominations.add("You got "+note.getNote()+"  count: "+count);
            return userWithdraw;
        }
        return userWithdraw;
    }

    public static void userWithdraw(Scanner scan,User currentuser) throws CloneNotSupportedException {
        ArrayList<Notes> duplicate=new ArrayList<>();
        ArrayList<String> dinominations=new ArrayList<>();

        System.out.println("Withdraw Amount: ");
        long userWithdraw=Long.parseLong(scan.nextLine());
        if(userWithdraw<= currentuser.getbalance()){
            long dupwithdrawam=userWithdraw;
            for(Notes note:ATM.getNotesList()){

                duplicate.add(note.clone());

            }
            while(userWithdraw!=0) {
                for (Notes dupnote : duplicate) {
                    String dupNotename = dupnote.getNote();
                    switch (dupNotename) {
                        case "2000", "500", "200", "100":
                            userWithdraw = UserAction.withdrawOperation(userWithdraw, dupnote, dinominations);
                            break;
                    }
                }

                if (userWithdraw == 0) {
                    ATM.setNotesList(duplicate);
                    double curBalance = currentuser.getbalance();
                    currentuser.setbalance(curBalance - dupwithdrawam);
                    double balance2 = ATM.getatmBalance();
                    ATM.setatmBalance(balance2 - dupwithdrawam);
                    System.out.println("Withdraw Successful...");
                    currentuser.getUserTransaction().add(new Transaction(currentuser.getuserId(), "Withdrawn", dupwithdrawam));
//                System.out.println(currentuser.getuserId()+" has withdrawn "+dupwithdrawam);
                    System.out.println("AtmBalance: " + ATM.atm_Balance);
                    for (String str : dinominations) {
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

    public static void changePin(Scanner scan,User currentuser){
        System.out.println("OldPass: ");
        String oldPass=scan.nextLine();
        if(oldPass.equals(currentuser.getuserPass())){
            System.out.println("New Password: ");
            String newPass=scan.nextLine();
            currentuser.setUserPass(newPass);
            System.out.println("Password Changed Successfully...");
            return;
        }
        System.out.println("Wrong Password...Retry");
    }

    public static void viewTransaction(Scanner scan,User currentuser){
        for(Transaction user:currentuser.getUserTransaction()){
            System.out.println(user.getuserName()+" has "+user.getType()+" Rs."+user.getAmount());
        }
    }
}
