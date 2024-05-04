/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final;

/****************************************************************************
* Assignment Final–  BIS 335, Business Application Development, Fall 2023
*
* Author: Rachel Sobocinski, Rose Genstein
* Date: Decemeber 12,2023
*
* this is our final projectAs the name suggests, this option is a student management system with functionalities
listed below. These are the minimum functionalities, please feel free to add more
methods/functions into your applications. The specific algorithm.
**************************************************************************/ 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class testingcode extends Application {

    // TextFields and data arrays
    private TextField courseIndexTextField;
    public static String[][] courseData;
    public Student[] myStudentDB;
    String outputFileName = "StudentsUpdated.txt";
    public static String[][] studentData;
    private TextField studentIndexTextField = new TextField(); // initialize the TextField

    // Entry point of the application
    public static void main(String[] args) {
        launch(args);
    }

    // Application start method
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Window");//title header for our main window
        Label loadStudent = new Label("Load Students: "); // this creates a label to be matched with a button
        Label loadCourses = new Label("Load Courses: ");
        Label select = new Label("Select: ");// select label
        Label instructions = new Label("Please press the read file buttons " + "\n"
                + "first to ensure that the data is successfully loaded");// instructions to apprear at the top of the program to give the user instructions

        // Button to read the file student
        Button readFileButtonstudent = new Button("Read File Student");// button for read file students
        readFileButtonstudent.setOnAction(e -> {
            studentData = readFileStudents();//set on action button that is connected to the reading the students fule
            //printData(studentData);
            System.out.println("File Sucessfully loaded "); // this is just a message that is printed to output so that we knew while creating that the file was loaded sucessfully
            myStudentDB = convert(studentData); // converting our 2d array to a 1d array by calling the method convert
            //System.out.println(myStudentDB[0].getName() + "," + myStudentDB[0].getGender());
            // myStudentDB[0].displayCourses();
        });

        // Button to read the file courses
        Button readFileButtoncourses = new Button("Read File Courses");
        readFileButtoncourses.setOnAction(e -> {
            courseData = readFileCourses();// set on action button so that the course data file is being sucessfully read and will display the data when asked
            System.out.println("File Sucessfully loaded");//this is just a message that is displayed to the output so that when creating the program we knew that the file was sucessfully read in and would work

        });

        // Buttons
        Button studentWindow = new Button("Student");// button was created for student
        Button adminWindow = new Button("Admin");// button created for admin
        courseIndexTextField = new TextField(""); // creating a new text field
        studentWindow.setOnAction(e -> showStudentWindow()); // action button that connects the button to open a new window that is the student window
        adminWindow.setOnAction(e -> showAdminWindow()); // action buttont to open the admin window

        // Layout where everythign is goign on the grid pane that was designed
        GridPane root = new GridPane(); // grid pane named root
        root.add(instructions, 0, 0);
        root.add(readFileButtonstudent, 1, 1);
        root.add(loadStudent, 0, 1);
        root.add(readFileButtoncourses, 1, 2);
        root.add(loadCourses, 0, 2);
        root.add(select, 0, 3);
        root.add(studentWindow, 0, 4);
        root.add(adminWindow, 1, 4);

        // Scene
        // setting the size of the scene
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    // Read student data from file
    public static String[][] readFileStudents() {
        // Read data from the "Students.txt" file using TextIO
        TextIO.readFile("Students.txt"); // set the input file

        // Declare variables to store each line, split values, and the final array
        String line;
        String[] split;
        String[][] returnArraystudents = new String[10][13]; // 2D array to store student data
        int sNo = 0; // Student number counter

        // Continue reading lines from the file until the end of file (eof) or 10 students are processed
        while (!TextIO.eof() && sNo < 10) {
            // Read a line from the file
            line = TextIO.getln();

            // Split the line into an array of values using a comma as the delimiter
            split = line.split(",");

            // Copy the first 6 values into the returnArraystudents for each student
            for (int i = 0; i < 6; i++) {
                returnArraystudents[sNo][i] = split[i];
            }

            // Move to the next student
            sNo++;
        }

        // Print an empty line for formatting
        System.out.println();

        // Return the 2D array containing student data
        return returnArraystudents;
    }

        // Read course data from file
    public static String[][] readFileCourses() {
        // Read data from the "Courses.txt" file using TextIO
        TextIO.readFile("Courses.txt"); // set the input file

           // Declare variables to store each line, split values, and the final array
        String line;
        String[] split;
        String[][] returnArraycourses = new String[100][5]; // 2D array to store course data
        int cNo = 0; // Course number counter

        // Continue reading lines from the file until the end of file (eof) or 100 courses are processed
        while (!TextIO.eof() && cNo < 100) {
            // Read a line from the file
            line = TextIO.getln();

            // Split the line into an array of values using a comma as the delimiter
            split = line.split(",");

            // Copy the first 5 values into the returnArraycourses for each course
            for (int i = 0; i < 5; i++) {
                returnArraycourses[cNo][i] = split[i];
            }

            // Move to the next course
            cNo++;
        }

        // Print an empty line for formatting
        System.out.println();

        // Return the 2D array containing course data
        return returnArraycourses;

    }

    // Print data to the console
    public static void printData(String[][] data) {
        for (String[] row : data) {
            for (String value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    // Convert 2D array to 1D array
    public static String[] convertTo1DArray(String[][] data) {
        int totalElements = 0;
        for (String[] row : data) {
            totalElements += row.length;
        }

        String[] resultArray = new String[totalElements];

        int index = 0;
        for (String[] row : data) {
            for (String value : row) {
                resultArray[index++] = value;
            }
        }

        return resultArray;
    }

    // Display the student window
    public void showStudentWindow() {
       // Create a new JavaFX stage for the student window
        Stage studentStage = new Stage();
        studentStage.setTitle("Student Window");

        // Create a label with instructions for the user
        Label instructions = new Label("Please enter your student ID so that you ensure " + "\n"
                + "you are making edits to your profile ");

        // Create a GridPane to organize the UI elements
        GridPane root = new GridPane();
        root.add(instructions, 0, 0);

        // Create labels, text fields, buttons, and add them to the GridPane
        Label searchstudent = new Label("Search Students ID (1 to 10): ");
        root.add(searchstudent, 0, 1);
        Button search = new Button("Search");
        root.add(search, 2, 1);
        root.add(studentIndexTextField, 1, 1);

        Label searchCourse = new Label("Search Course index (1 to 50): ");
        root.add(searchCourse, 0, 2);
        Button enter = new Button("Enter ");
        root.add(enter, 2, 2);
        root.add(courseIndexTextField, 1, 2);

        // Create labels to display information and add them to the GridPane
        Label courseInfo = new Label();
        root.add(courseInfo, 0, 3);
        Label studentInfo = new Label();
        root.add(studentInfo, 0, 5);

        // Set actions for the buttons
        enter.setOnAction(e -> showCourseInfo(courseInfo));
        search.setOnAction(e -> showStudentInfo(studentInfo));
        Button viewCourses = new Button("View Courses");
        viewCourses.setOnAction(e -> showCoursesWindow());
        root.add(viewCourses, 0, 6);

        Button viewStudent = new Button("View Student");
        viewStudent.setOnAction(e -> showStudentDataWindow());
        root.add(viewStudent, 1, 6);

        Button registerCourseButton = new Button("Register for Course");
        root.add(registerCourseButton, 1, 7);
        registerCourseButton.setOnAction(e -> registerForCourse());

        Button saveAndExitButton = new Button("Save and Exit");
        root.add(saveAndExitButton, 2, 7);
        saveAndExitButton.setOnAction(e -> saveAndExit());

        // Create a scene with the GridPane and set it to the student stage
        Scene resultScene = new Scene(root, 500, 500);
        studentStage.setScene(resultScene);

        // Show the student stage
        studentStage.show();

    }

    private void saveAndExit() {
        // Save updated student data to StudentsUpdated.txt
        saveToFile("StudentsUpdated.txt", studentData);

        // Save updated course data to CoursesUpdated.txt
        saveToFile("CoursesUpdated.txt", courseData);

        // Close the application
        System.exit(0);
    }

    // Show the window with course information
    public void showCoursesWindow() {
        Stage coursesStage = new Stage();
        coursesStage.setTitle("Courses Window");

        GridPane coursesRoot = new GridPane();

        Label coursesInfoLabel = new Label("Courses Information:");
        coursesRoot.add(coursesInfoLabel, 0, 0);

        TextArea coursesTextArea = new TextArea();
        coursesTextArea.setEditable(false);

        if (courseData != null) {
            for (String[] course : courseData) {
                String courseDetails = String.join("\t", course);
                coursesTextArea.appendText(courseDetails + "\n");
            }
        }

        coursesRoot.add(coursesTextArea, 0, 1);

        Scene coursesScene = new Scene(coursesRoot, 400, 300);
        coursesStage.setScene(coursesScene);

        coursesStage.show();
    }

    // Show the window with student information
    private void showStudentDataWindow() {
                // Create a new JavaFX stage for displaying student data
         Stage studentDataStage = new Stage();
         studentDataStage.setTitle("Student Data");

         // Create a GridPane to organize the UI elements
         GridPane studentDataRoot = new GridPane();

         // Create a label for the student information section
         Label studentInfoLabel = new Label("Student Information:");
         studentDataRoot.add(studentInfoLabel, 0, 0);

         // Create a TextArea for displaying student information and make it non-editable
         TextArea studentInfoTextArea = new TextArea();
         studentInfoTextArea.setEditable(false);

         // Check if studentData is not null before populating the TextArea
         if (studentData != null) {
             // Iterate through each student in the studentData array
             for (String[] student : studentData) {
                 // Join the student details with a tab delimiter and append to the TextArea
                 String studentDetails = String.join("\t", student);
                 studentInfoTextArea.appendText(studentDetails + "\n");
             }
         }

         // Add the TextArea to the GridPane
         studentDataRoot.add(studentInfoTextArea, 0, 1);

         // Create a scene with the GridPane and set it to the student data stage
         Scene studentDataScene = new Scene(studentDataRoot, 400, 300);
         studentDataStage.setScene(studentDataScene);

         // Show the student data stage
         studentDataStage.show();

    }

    // Show the admin window
    public void showAdminWindow() {
                    // Create a new JavaFX stage for the admin window
            Stage adminStage = new Stage();
            adminStage.setTitle("Admin Window");

            // Create a GridPane to organize the UI elements
            GridPane root = new GridPane();

            // Create labels, buttons, and text fields for searching students
            Label searchstudent = new Label("Search Students ID (1 to 10): ");
            Button enter = new Button("Enter ");
            root.add(enter, 2, 0);
            root.add(searchstudent, 0, 0);
            root.add(studentIndexTextField, 1, 0);

            // Create a label for displaying student information
            Label studentInfo = new Label();
            root.add(studentInfo, 0, 8);

            // Set an action for the "Enter" button to show student information
            enter.setOnAction(e -> showStudentInfo(studentInfo));

            // Create labels, buttons, and text fields for searching courses
            Label searchCourse = new Label("Search Course index (1 to 50): ");
            Button search = new Button("search ");
            root.add(search, 2, 2);
            root.add(searchCourse, 0, 2);
            root.add(courseIndexTextField, 1, 2);

            // Create a label for displaying course information
            Label courseInfo = new Label();
            root.add(courseInfo, 0, 9);

            // Set an action for the "Search" button to show course information
            search.setOnAction(e -> showCourseInfo(courseInfo));

            // Create buttons for viewing student and course information
            Button viewStudent = new Button("View Student");
            viewStudent.setOnAction(e -> showStudentDataWindow());
            root.add(viewStudent, 1, 6);

            Button viewCourses = new Button("View Courses");
            viewCourses.setOnAction(e -> showCoursesWindow());
            root.add(viewCourses, 0, 6);

            // Create a button for registering a course
            Button registerCourseButton = new Button("Register for Course");
            root.add(registerCourseButton, 1, 7);

            // Set an action for the "Register for Course" button
            registerCourseButton.setOnAction(e -> registerForCourse());

            // Create a scene with the GridPane and set it to the admin stage
            Scene resultScene = new Scene(root, 500, 500);
            adminStage.setScene(resultScene);

            // Show the admin stage
            adminStage.show();

    }

    private void registerForCourse() {
        try {
            int studentIndex = Integer.parseInt(studentIndexTextField.getText());
            int courseIndex = Integer.parseInt(courseIndexTextField.getText());

            if (studentData != null && courseData != null
                    && studentIndex >= 1 && studentIndex <= studentData.length
                    && courseIndex >= 1 && courseIndex <= courseData.length) {

                // Check if the course has available capacity
                int currentCapacity = Integer.parseInt(courseData[courseIndex - 1][4]);
                if (currentCapacity > 0) {
                    // Find the next null slot in the studentData array
                    int courseSlot = findNextNullSlot(studentData[studentIndex - 1]);

                    if (courseSlot != -1) {
                        // Register the student for the course
                        studentData[studentIndex - 1][courseSlot] = Integer.toString(courseIndex);

                        // Update the course capacity
                        courseData[courseIndex - 1][4] = Integer.toString(currentCapacity - 1);

                        // Display a success message
                        System.out.println("Registration successful!");

                        // Refresh the student information
                        Label studentInfo = new Label();
                        showStudentInfo(studentInfo);
                    } else {
                        System.out.println("Student has already registered for the maximum number of courses.");
                    }
                } else {
                    System.out.println("Course is full. Registration failed.");
                }
            } else {
                System.out.println("Invalid student or course index.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid student and course indices.");
        }
    }

// Method to find the next null slot in an array
    private int findNextNullSlot(String[] array) {
        for (int i = 6; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1; // If no null slot is found
    }

    // Show course information based on the index
    public void showCourseInfo(Label courseInfo) {
        try {
            int courseIndex = Integer.parseInt(courseIndexTextField.getText());
            if (courseData != null && courseIndex >= 1 && courseIndex <= courseData.length) {
                String courseDetails = Arrays.toString(courseData[courseIndex - 1]);
                courseInfo.setText("Course Info: " + courseDetails);
            } else {
                courseInfo.setText("Invalid course index.");
            }
        } catch (NumberFormatException e) {
            courseInfo.setText("Invalid input. Please enter a valid course index.");
        }
    }

    // Show student information based on the index
    public void showStudentInfo(Label studentInfo) {
        try {
            int studentIndex = Integer.parseInt(studentIndexTextField.getText());
            if (studentData != null && studentIndex >= 1 && studentIndex <= studentData.length) {
                String studentDetails = Arrays.toString(studentData[studentIndex - 1]);
                studentInfo.setText(" Info: " + studentDetails);
            } else {
                studentInfo.setText("Invalid student index.");
            }
        } catch (NumberFormatException e) {
            studentInfo.setText("Invalid input. Please enter a valid student index.");
        }
    }

    // Convert 2D array to an array of Student objects
    public Student[] convert(String twoD[][]) {
        Student returnarray[] = new Student[10];
        int id;
        String n, g;
        int[] c = new int[7];
        for (int i = 0; i < 10; i++) {
            id = Integer.parseInt(twoD[i][0]);
            n = twoD[i][1];
            g = twoD[i][2];
            c[0] = Integer.parseInt(twoD[i][3]);
            c[1] = Integer.parseInt(twoD[i][4]);
            c[2] = Integer.parseInt(twoD[i][5]);

            returnarray[i] = new Student(id, n, g, c);
        }
        return returnarray;
    }

    // Convert 2D array to an array of Courses objects
    public Courses[] convertC(String twoD[][]) {
        Courses returnarray[] = new Courses[100];
        int id, c, ca;
        String n, d;

        for (int i = 0; i < 10; i++) {
            id = Integer.parseInt(twoD[i][0]);
            n = twoD[i][1];
            d = twoD[i][2];
            c = Integer.parseInt(twoD[i][3]);
            ca = Integer.parseInt(twoD[i][4]);

            returnarray[i] = new Courses(id, n, d, c, ca);
        }
        return returnarray;
    }

    private void saveToFile(String fileName, String[][] data) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String[] row : data) {
                StringBuilder line = new StringBuilder();
                for (String value : row) {
                    line.append(value).append(",");
                }
                // Remove the trailing comma and write the line to the file
                writer.write(line.substring(0, line.length() - 1) + "\n");
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving data to " + fileName);
            e.printStackTrace();
        }
    }

}
