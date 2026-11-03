
// Practical: Demonstrate Method Overloading
// Real-life example: Scientific Calculator

class ScientificCalculator {

    // Method 1: Addition and subtraction of two integers
    public void calculate(int a, int b, String operation) {

        if (operation.equalsIgnoreCase("add")) {
            System.out.println("Addition: " + (a + b));
        }
        else if (operation.equalsIgnoreCase("subtract")) {
            System.out.println("Subtraction: " + (a - b));
        }
        else {
            System.out.println("Invalid operation!");
        }
    }

    // Method 2: Scientific operations using double values
    public void calculate(double value, String operation) {

        switch (operation.toLowerCase()) {

            case "sin":
                System.out.println("Sin(" + value + ") = " + Math.sin(value));
                break;

            case "cos":
                System.out.println("Cos(" + value + ") = " + Math.cos(value));
                break;

            case "log":
                if (value > 0) {
                    System.out.println("Log(" + value + ") = " + Math.log(value));
                }
                else {
                    System.out.println("Logarithm is undefined!");
                }
                break;

            default:
                System.out.println("Invalid scientific operation!");
        }
    }

    // Method 3: Addition of two matrices
    public void calculate(int[][] mat1, int[][] mat2) {

        // Find number of rows and columns
        int rows = mat1.length;
        int cols = mat1[0].length;

        // Check whether both matrices have the same dimensions
        if (rows != mat2.length || cols != mat2[0].length) {
            System.out.println("Matrix dimensions do not match!");
            return;
        }

        // Create a new matrix to store the result
        int[][] result = new int[rows][cols];

        System.out.println("Matrix Addition Result:");

        // Add corresponding elements of both matrices
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                result[i][j] = mat1[i][j] + mat2[i][j];

                // Display the result
                System.out.print(result[i][j] + "\t");
            }

            System.out.println();
        }
    }
}


// Main class
public class CalculatorTest {

    public static void main(String[] args) {

        // Create an object of ScientificCalculator
        ScientificCalculator calc = new ScientificCalculator();

        // Integer addition and subtraction
        System.out.println("--- Integer Operations ---");

        calc.calculate(10, 5, "add");
        calc.calculate(15, 7, "subtract");


        // Scientific calculations
        System.out.println("\n--- Scientific Operations ---");

        calc.calculate(0.5, "sin");
        calc.calculate(1.0, "cos");
        calc.calculate(10.0, "log");


        // Create first matrix
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // Create second matrix
        int[][] mat2 = {
            {6, 5, 4},
            {3, 2, 1}
        };

        // Matrix addition
        System.out.println("\n--- Matrix Operation ---");

        calc.calculate(mat1, mat2);
    }
}
