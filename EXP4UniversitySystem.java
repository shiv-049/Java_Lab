
// Practical: Demonstrate Inheritance and Method Overriding
// Real-life example: University Management System

// Base class (Parent class)
class Person {

    String name;
    int id;

    // Constructor of Person class
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display person details
    void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}


// Child class 1: Student
// Student inherits properties and methods from Person
class Student extends Person {

    String course;

    // Student constructor
    Student(String name, int id, String course) {

        // Call parent class constructor
        super(name, id);

        this.course = course;
    }

    // Student-specific method
    void enrollCourse() {
        System.out.println(name + " enrolled in: " + course);
    }

    // Overriding parent class method
    @Override
    void showDetails() {

        System.out.println("Student Details:");

        // Call showDetails() of parent class
        super.showDetails();

        System.out.println("Course: " + course);
    }
}


// Child class 2: Faculty
class Faculty extends Person {

    String subject;

    // Faculty constructor
    Faculty(String name, int id, String subject) {

        super(name, id);

        this.subject = subject;
    }

    // Faculty-specific method
    void gradeStudent(String studentName, String grade) {
        System.out.println("Faculty " + name +
                " graded " + studentName +
                " with: " + grade);
    }

    // Overriding parent class method
    @Override
    void showDetails() {

        System.out.println("Faculty Details:");

        super.showDetails();

        System.out.println("Subject: " + subject);
    }
}


// Child class 3: AdminStaff
class AdminStaff extends Person {

    String department;

    // AdminStaff constructor
    AdminStaff(String name, int id, String department) {

        super(name, id);

        this.department = department;
    }

    // Admin-specific method
    void manageRecords() {
        System.out.println(name +
                " is managing records in: " + department);
    }

    // Overriding parent class method
    @Override
    void showDetails() {

        System.out.println("Admin Staff Details:");

        super.showDetails();

        System.out.println("Department: " + department);
    }
}


// Main class
public class UniversitySystem {

    public static void main(String[] args) {

        // Create an array of Person objects
        Person[] people = new Person[3];

        // Create Student, Faculty and AdminStaff objects
        people[0] = new Student("Aarav Mehta", 101, "Data Structures");

        people[1] = new Faculty("Dr. Neha Sharma", 201, "Algorithms");

        people[2] = new AdminStaff("Mr. Raj Gupta", 301, "Examination");


        // Display details using method overriding
        System.out.println("--- UNIVERSITY DETAILS ---");

        for (Person p : people) {

            // Calls the appropriate overridden method
            p.showDetails();

            System.out.println();
        }


        // Perform Student-specific operation
        System.out.println("--- SPECIFIC OPERATIONS ---");

        Student s = (Student) people[0];
        s.enrollCourse();


        // Perform Faculty-specific operation
        Faculty f = (Faculty) people[1];
        f.gradeStudent("Aarav Mehta", "A+");


        // Perform AdminStaff-specific operation
        AdminStaff a = (AdminStaff) people[2];
        a.manageRecords();
    }
}
