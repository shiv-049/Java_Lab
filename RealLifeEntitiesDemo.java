
// Practical: Demonstrate Real-Life Entities using Classes and Objects

// Class 1: Student
// This class represents a real-life student.

class Student {

    // Data members (properties of Student)
    String name;
    int rollNo;
    String course;

    // Constructor to initialize student details
    Student(String name, int rollNo, String course) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
    }

    // Method to display student details
    void displayStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Course: " + course);
    }
}


// Class 2: Book
// This class represents a real-life book.

class Book {

    // Data members (properties of Book)
    String title;
    String author;
    double price;

    // Constructor to initialize book details
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void displayBook() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs. " + price);
    }
}


// Class 3: Account
// This class represents a bank account.

class Account {

    // Data members (properties of Account)
    String accHolderName;
    long accNumber;
    double balance;

    // Constructor to initialize account details
    Account(String accHolderName, long accNumber, double balance) {
        this.accHolderName = accHolderName;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    // Method to deposit money
    void deposit(double amount) {

        // Check whether the amount is valid
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Rs. " + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    void withdraw(double amount) {

        // Check whether the amount is valid
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        }

        // Check whether sufficient balance is available
        else if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Rs. " + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Method to display account details
    void displayAccount() {
        System.out.println("Account Holder: " + accHolderName);
        System.out.println("Account Number: " + accNumber);
        System.out.println("Available Balance: Rs. " + balance);
    }
}


// Main class: Program execution starts here

public class RealLifeEntitiesDemo {

    public static void main(String[] args) {

        // Creating Student object
        Student s1 = new Student("Riya Sharma", 101, "Computer Science");

        System.out.println("\n--- STUDENT DETAILS ---");
        s1.displayStudent();


        // Creating Book object
        Book b1 = new Book("Java Programming", "James Gosling", 499.50);

        System.out.println("\n--- BOOK DETAILS ---");
        b1.displayBook();


        // Creating Account object
        Account a1 = new Account("Amit Kumar", 123456789, 10000.00);

        System.out.println("\n--- ACCOUNT DETAILS BEFORE TRANSACTIONS ---");
        a1.displayAccount();


        // Performing deposit operation
        System.out.println("\n--- DEPOSIT OPERATION ---");
        a1.deposit(2000);


        // Performing withdrawal operation
        System.out.println("\n--- WITHDRAWAL OPERATION ---");
        a1.withdraw(1500);


        // Displaying updated account details
        System.out.println("\n--- ACCOUNT DETAILS AFTER TRANSACTIONS ---");
        a1.displayAccount();
    }
}
