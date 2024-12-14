import java.sql.SQLOutput;
import java.util.Scanner;

public class Calculator {
    private static boolean True;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Do you want to try again??");
//        int i= scanner.nextInt();
        //Two r three character
        //Menu
        System.out.println("***Menu of Operations***");
        System.out.println("1)Addition");
        System.out.println("2)Subraction");
        System.out.println("3)Multiplication");
        System.out.println("4)Division");
        System.out.println("5)Modulus");
        System.out.println("6)Exit");
        while (true) {
            System.out.println("1)Two char");
            System.out.println("2)Three char");
            System.out.println("-1 Exit");
            System.out.print("Enter wheather two or three char:");
            int no_op = scanner.nextInt();

//            System.out.println("Enter the type of operation:");
//            int operation = scanner.nextInt();

            if (no_op == 1) {
                System.out.println("Enter the type of operation:");
                int operation = scanner.nextInt();
//                System.out.print("Enter the first value:");
//                double num1 = scanner.nextDouble();
//                System.out.print("Enter the second value:");
//                double num2 = scanner.nextDouble();

                if (operation == 1) {
                    System.out.print("Enter the first value:");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second value:");
                    double num2 = scanner.nextDouble();
                    CalculatorCon.add(num1, num2);
                } else if (operation == 2) {
                    System.out.print("Enter the first value:");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second value:");
                    double num2 = scanner.nextDouble();
                    CalculatorCon.sub(num1, num2);
                } else if (operation == 3) {
                    System.out.print("Enter the first value:");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second value:");
                    double num2 = scanner.nextDouble();
                    CalculatorCon.mul(num1, num2);
                } else if (operation == 4) {
                    System.out.print("Enter the first value:");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second value:");
                    double num2 = scanner.nextDouble();
                    CalculatorCon.div(num1, num2);
                } else if (operation == 5) {
                    System.out.print("Enter the first value:");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second value:");
                    double num2 = scanner.nextDouble();
                    CalculatorCon.mod(num1, num2);
                } else if (operation == 6) {
                    System.out.println("Exit");
                    break;
                } else {
                    System.out.println("Invalid number");
                }
            } else if (no_op == 2) {
                System.out.println("Enter the type of operation:");
                int operation = scanner.nextInt();

                double num3 = scanner.nextDouble();
                if (operation == 1) {
                    System.out.print("Enter the first value:");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second value:");
                    double num2 = scanner.nextDouble();
                    System.out.print("Enter the third value:");
                    CalculatorCon.add(num1, num2, num3);
                } else if (operation == 2) {
                    System.out.print("Enter the first value:");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second value:");
                    double num2 = scanner.nextDouble();
                    System.out.print("Enter the third value:");
                    CalculatorCon.sub(num1, num2, num3);
                } else if (operation == 3) {
                    System.out.print("Enter the first value:");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second value:");
                    double num2 = scanner.nextDouble();
                    System.out.print("Enter the third value:");
                    CalculatorCon.mul(num1, num2, num3);
                } else if (operation == 4) {
                    System.out.print("Enter the first value:");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second value:");
                    double num2 = scanner.nextDouble();
                    System.out.print("Enter the third value:");
                    CalculatorCon.div(num1, num2, num3);
                } else if (operation == 5) {
                    System.out.print("Enter the first value:");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second value:");
                    double num2 = scanner.nextDouble();
                    System.out.print("Enter the third value:");
                    CalculatorCon.mod(num1, num2);
                } else if (operation == 6) {
                    System.out.println("Exit");
                    break;
                } else {
                    System.out.println("Invalid Number");
                }
            } else if(no_op==-1){
                System.out.println("Exit");
                break;
            }
            System.out.println("Do you want to try again??");
        }
    }

}



