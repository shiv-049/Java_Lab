Filename: ResumeFormatter.java


// Resume Formatter using File Handling and Regular Expressions

import java.io.*;
import java.util.regex.*;

public class ResumeFormatter {

    public static void main(String[] args) throws IOException {

        // Input and output folders
        File inputFolder = new File("./input_resumes/");
        File outputFolder = new File("./cleaned_resumes/");

        // Check if input folder exists
        if (!inputFolder.exists()) {
            System.out.println("Input folder not found!");
            return;
        }

        File[] files = inputFolder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found in input_resumes directory.");
            return;
        }

        // Create output folder if it does not exist
        if (!outputFolder.exists()) {
            outputFolder.mkdir();
        }

        // Process all text files
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                processResume(file, outputFolder);
            }
        }

        System.out.println("Resume formatting completed!");
    }

    // Method to process each resume
    public static void processResume(File inputFile, File outputFolder)
            throws IOException {

        String name = "Not Found";
        String email = "Not Found";
        StringBuilder skills = new StringBuilder();

        // Regular expression to find email
        Pattern emailPattern = Pattern.compile(
            "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
        );

        // Read resume file
        BufferedReader reader = new BufferedReader(
            new FileReader(inputFile)
        );

        String line;

        while ((line = reader.readLine()) != null) {

            line = line.trim();

            // Extract name
            if (line.toLowerCase().contains("name:")) {
                name = line.split(":", 2)[1].trim();
            }

            // Extract email
            Matcher matcher = emailPattern.matcher(line);

            if (matcher.find()) {
                email = matcher.group();
            }

            // Extract skills
            if (line.toLowerCase().contains("skills:")) {
                skills.append(line.split(":", 2)[1].trim());
            }
        }

        reader.close();

        // Create output file
        File outputFile = new File(
            outputFolder, "Formatted_" + inputFile.getName()
        );

        // Write formatted resume
        FileWriter writer = new FileWriter(outputFile);

        writer.write("Formatted Resume\n");
        writer.write("====================\n");
        writer.write("Name  : " + name + "\n");
        writer.write("Email : " + email + "\n");
        writer.write("Skills: " +
            (skills.length() > 0 ? skills.toString() : "Not Mentioned") + "\n");

        writer.close();

        System.out.println("Processed: " + inputFile.getName());
    }
}

/*
FOLDER STRUCTURE:

ResumeProject/
    ResumeFormatter.java
    input_resumes/
        resume1.txt
    cleaned_resumes/

SAMPLE INPUT (input_resumes/resume1.txt):

Name: Ravi Sharma
Email: ravi.sharma@example.com
Experience in Java, Python
Skills: Java, Spring Boot, SQL, Git, REST API

EXECUTION:

1. Open terminal inside ResumeProject.
2. Compile:
   javac ResumeFormatter.java

3. Run:
   java ResumeFormatter

4. Find formatted resumes inside cleaned_resumes/.
*/
