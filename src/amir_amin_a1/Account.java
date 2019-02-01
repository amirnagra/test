package amir_amin_a1;

import java.text.DecimalFormat;

/**
 *
 * @author Amir Amin Description: This account will get and set the information
 * from the user. This class has four attributes, constructor and mutator,
 * deposit, withdraw, monthly intrust rate and toString method.
 */
public class Account {

    //attributes
    private String customerName;
    private final int customerIdNumber;
    private double accountBalance;
    private double annualInterestRate;

    //constructor of account class with two paramenters.
    public Account(int id, String customerName) {
        this.customerIdNumber = id;
        this.customerName = customerName;
    }

    //
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAnnualInterestRate(double intRate) {
        this.annualInterestRate = intRate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerIdNumber() {
        return customerIdNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    //This methord deposit amount into customer account. and throw exception if the user enter -ve amount.
    public void deposit(double depositAmount) throws IllegalArgumentException {
        if (depositAmount < 0.0) {
            throw new IllegalArgumentException("plese enter positive number");
        }
        this.accountBalance = accountBalance + depositAmount;
    }

    //This methord withdraw amount from customer account. and throw exception if the user enter -ve amount.
    public void withdraw(double amountWithdraw) throws IllegalArgumentException {
        if (amountWithdraw < 0.0) {
            throw new IllegalArgumentException("please enter positive number");
        }
        else if (amountWithdraw>accountBalance){
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.accountBalance = accountBalance - amountWithdraw;
    }

    //This methord calculate the monthly intrust on available balance in account .
    public double monthlyInterest() {
        return accountBalance * (annualInterestRate / 100 / 12);
    }

    @Override
    //This methord print the account information of customer. Moreover the DecimalFormat class 
    //formate and roundoff the value after decimal point for Account Balance & intrust earned.
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "Customer: " + getCustomerName() + "\n"
                + "Account Balance " + df.format(getAccountBalance()) + "\n"
                + "Monthly inturest earned " + df.format(monthlyInterest());
    }
}
