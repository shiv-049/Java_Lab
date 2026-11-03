
// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {

    InsufficientFundsException(String message) {
        super(message);
    }
}

// Bank Account class
class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Withdraw money
    void withdraw(double amount) throws InsufficientFundsException {

        if (amount > balance) {
            throw new InsufficientFundsException(
                "Withdrawal failed: Insufficient balance."
            );
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal successful. Amount withdrawn: Rs." + amount);
        }
    }

    // Display account details
    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: Rs." + balance);
    }
}

// Main class
public class BankingApplication {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("Ravi Kumar", 10000);

        try {
            System.out.println("Attempting to withdraw Rs.12000...");
            account.withdraw(12000);
        }
        catch (InsufficientFundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        finally {
            System.out.println("Transaction Completed.");
            account.displayBalance();
        }
    }
}
