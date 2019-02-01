package amir_amin_a1;

import java.util.Scanner;

/**
 *
 * @author Amir Amin
 * Description: This class have a main method and Menu method. The main method 
 * get the user input and print the result by calling menu method. 
 */
public class Atm {
//Main methord
    public static void main(String[] args) {
        Account firstAccount = new Account(101, "Amir");    //instentiate the object of account class.
        Account secondAccount = new Account(102, "Picasso");//instentiate the second object of account class.
        firstAccount.setAccountBalance(50);                 //set account balance for first account
        secondAccount.setAccountBalance(1000);              //set account balance for second account
        firstAccount.setAnnualInterestRate(5);              //set intrustrate for first account
        secondAccount.setAnnualInterestRate(5);             //set intrustrate for second account

        //imported scanner class to get user input
        Scanner in = new Scanner(System.in);

        int idNumber;

        //Iteration will get Id from user- if the user give wrong ID number they will prompt the user to put right ID
        do {
            System.out.println("Enter Account Id");
            idNumber = in.nextInt();
            if (idNumber == 101) {
                menu(firstAccount);
            } else if (idNumber == 102) {
                menu(secondAccount);
            } else {
                System.out.println("please enter correct ID");
            }
        } while (true);
    }

    /*This methord print the menu screen and give the information to the user as per 
    *their requesting from the menu items by calling methors in account class.
    */
    public static void menu(Account account) {

        int option;
        Scanner in = new Scanner(System.in);
        do {

            System.out.println("Main Menu");
            System.out.println("1: Account info");
            System.out.println("2: Withdraw");
            System.out.println("3: Deposit");
            System.out.println("4: Exit");
            System.out.println("Please choose what you'd like to do:");

            option = in.nextInt();
            switch (option) {

                case 1:
                    System.out.println(account.toString());
                    break;

                case 2:
                    System.out.println("Enter the Amount to Withdraw");
                    try {
                        account.withdraw(in.nextDouble());
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Enter the amount to deposit");
                    try {
                        account.deposit(in.nextDouble());
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        } while (option != 4);
    }
}
