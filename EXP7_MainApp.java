
// File: Account.java
// Location: com/finance/accounts/Account.java

// Declare the package name
package com.finance.accounts;

// Class representing a bank account
public class Account {

    // Private variables to store account information
    private String holderName;
    private double balance;

    // Constructor to initialize account details
    public Account(String holderName, double initialBalance) {
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
            System.out.println(holderName +
                    " deposited: Rs. " + amount);
        }
        else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        }
        else if (amount <= balance) {
            balance = balance - amount;
            System.out.println(holderName +
                    " withdrew: Rs. " + amount);
        }
        else {
            System.out.println("Insufficient balance!");
        }
    }

    // Method to display account details
    public void showBalance() {
        System.out.println("Account Holder: " + holderName);
        System.out.println("Current Balance: Rs. " + balance);
    }

    // Getter method to return current balance
    public double getBalance() {
        return balance;
    }
}


// File: TaxCalculator.java
// Location: com/finance/tax/TaxCalculator.java

// Declare the package name
package com.finance.tax;

// Class to calculate estimated tax
public class TaxCalculator {

    // Method to calculate tax based on income
    public double calculateTax(double income) {

        // Tax calculation using progressive slabs
        if (income <= 250000) {
            return 0;
        }

        else if (income <= 500000) {
            return (income - 250000) * 0.05;
        }

        else if (income <= 1000000) {
            return 12500 + (income - 500000) * 0.20;
        }

        else {
            return 112500 + (income - 1000000) * 0.30;
        }
    }
}


// File: MainApp.java
// Location: FinanceProject/MainApp.java

// Import Account class from accounts package
import com.finance.accounts.Account;

// Import TaxCalculator class from tax package
import com.finance.tax.TaxCalculator;

// Main class
public class MainApp {

    public static void main(String[] args) {

        // Create an account object
        Account acc = new Account("Ravi Kumar", 750000);

        // Deposit Rs. 25,000
        acc.deposit(25000);

        // Withdraw Rs. 1,00,000
        acc.withdraw(100000);

        // Display updated account balance
        System.out.println("\n--- ACCOUNT DETAILS ---");
        acc.showBalance();

        // Create TaxCalculator object
        TaxCalculator taxCalc = new TaxCalculator();

        // Get account balance
        double income = acc.getBalance();

        // Calculate estimated tax
        double tax = taxCalc.calculateTax(income);

        // Display calculated tax
        System.out.println("\nEstimated Tax Payable: Rs. " + tax);
    }
}

/*
========================================
HOW TO EXECUTE THIS PROGRAM IN VS CODE
========================================

STEP 1:
Create a folder named FinanceProject.

STEP 2:
Inside FinanceProject, create these folders:

com
  finance
    accounts
    tax

STEP 3:
Create Account.java inside:
com/finance/accounts/

STEP 4:
Create TaxCalculator.java inside:
com/finance/tax/

STEP 5:
Create MainApp.java directly inside:
FinanceProject/

STEP 6:
Paste the respective code into all three files
and save them.

STEP 7:
Open the FinanceProject folder in VS Code.

STEP 8:
Open the terminal in VS Code.

Make sure the terminal is inside FinanceProject.

STEP 9:
Compile all Java files using:

javac -d . MainApp.java com/finance/accounts/Account.java com/finance/tax/TaxCalculator.java

STEP 10:
Run the main class using:

java MainApp

NOTE:
The -d . option tells Java to place the
compiled class files in the correct package folders.

Do not run Account or TaxCalculator directly.
Execute only MainApp.
========================================
*/
