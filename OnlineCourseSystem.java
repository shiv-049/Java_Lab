
// Practical: Demonstrate Default and Parameterized Constructors
// Real-life example: Online Course Enrollment System

// Creating a Course class
class Course {

    // Static variable shared by all Course objects
    // Used to generate unique course IDs
    private static int idCounter = 1000;

    // Instance variables (properties of each course)
    private int courseId;
    private String courseName;
    private String instructor;
    private int duration;

    // 1. Default Constructor
    // Called when an object is created without passing arguments
    public Course() {

        // Generate a unique course ID
        this.courseId = ++idCounter;

        // Assign default values
        this.courseName = "Introduction to Programming";
        this.instructor = "TBD";
        this.duration = 4;
    }

    // 2. Parameterized Constructor
    // Called when values are passed during object creation
    public Course(String courseName, String instructor, int duration) {

        // Generate a unique course ID
        this.courseId = ++idCounter;

        // Initialize variables using given values
        this.courseName = courseName;
        this.instructor = instructor;

        // Check whether duration is valid
        if (duration > 0) {
            this.duration = duration;
        } else {
            this.duration = 4;
            System.out.println("Invalid duration! Default 4 weeks assigned.");
        }
    }

    // Method to display course information
    public void displayCourseDetails() {

        System.out.println("Course ID  : " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor : " + instructor);
        System.out.println("Duration   : " + duration + " weeks");

        System.out.println("--------------------------------");
    }
}


// Main class: Program execution starts here
public class OnlineCourseSystem {

    public static void main(String[] args) {

        // Creating an object using Default Constructor
        System.out.println("COURSE CREATED USING DEFAULT CONSTRUCTOR");

        Course c1 = new Course();

        // Display default course details
        c1.displayCourseDetails();


        // Creating objects using Parameterized Constructor
        System.out.println("COURSES CREATED USING PARAMETERIZED CONSTRUCTOR");

        Course c2 = new Course("Data Structures", "Dr. A. Sharma", 6);

        Course c3 = new Course("Web Development", "Prof. S. Mehta", 8);

        Course c4 = new Course("Machine Learning", "Dr. R. Kumar", 10);


        // Display details of all courses
        c2.displayCourseDetails();
        c3.displayCourseDetails();
        c4.displayCourseDetails();

    }
}
