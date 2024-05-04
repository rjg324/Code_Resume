/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final;
import Assignment6.TextIO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author rosegenstein1
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main extends Application {
//private static String[][] myData;
    private TextField courseIndexTextField;
      public static  String[][] courseData;
      


    public static void main(String[] args) {
        launch(args);
  

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Window");
Label loadStudent = new Label("Load Students: ");
Label loadCourses = new Label("Load Courses: ");
Label select = new Label("Select: ");


        // Button to read the file student
        Button readFileButtonstudent = new Button("Read File Student");
        readFileButtonstudent.setOnAction(e -> {
            String[][] data = readFileStudents();
            printData(data);
        });

        
         // Button to read the file courses
        Button readFileButtoncourses = new Button("Read File Courses");
        readFileButtoncourses.setOnAction(e -> {
         courseData = readFileCourses();
            printData(courseData);
        });
        
        //Buttons
        Button studentwindow = new Button ("Student");
        Button adminwindow = new Button ("Admin");
        courseIndexTextField = new TextField("");
    //Label searchCourse = new Label("Search Course index (1 to 50): ");
        
        studentwindow.setOnAction(e ->showStudentWindow(findCourse(courseData,Integer.parseInt(input));
          
        // Layout
        GridPane root = new GridPane();
        root.add(readFileButtonstudent,1,1);
        root.add(loadStudent,0,1);
        root.add(readFileButtoncourses,1,2);
        root.add(loadCourses,0,2);
        root.add(select,0,3);
        root.add(studentwindow, 0, 4);

        

        // Scene
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static String[][] readFileStudents() {
        TextIO.readFile("Students.txt"); // set the input file
        String line;
        String[] split;
        String[][] returnArraystudents = new String[10][7];
        int sNo = 0;

        while (!TextIO.eof() && sNo < 10) {
            line = TextIO.getln();
            split = line.split(",");

            for (int i = 0; i < 6; i++)
                returnArraystudents[sNo][i] = split[i];

            sNo++;
        }

        return returnArraystudents;
    }
    
    
   public static String[][] readFileCourses() {
                 TextIO.readFile("Courses.txt"); // set the input file
      String line;
     String[] split;
        String[][] returnArraycourses = new String[100][5];
        int cNo = 0;
         while (!TextIO.eof() && cNo < 100) {
            line = TextIO.getln();
            split = line.split(",");

            for (int i = 0; i < 5; i++)
                returnArraycourses[cNo][i] = split[i];

            cNo++;
        }

        return returnArraycourses;
    }
       
    /*
   private static void readFileAndLoadDatacourses() {
        myData = readFileCourses();
        System.out.println("File read successfully and data loaded.");
    }
*/
    public static void printData(String[][] data) {
        // Print the data to the console
        for (String[] row : data) {
            for (String value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
    
    public static int findCourse(String [][]courseData, int ind){
        int place = Integer.parseInt(courseData [ind][0]);
        return place;
    }
      public static void showCourseInfo( String input) {
        try {
            int courseIndex = Integer.parseInt(input);
           System.out.println("hello");
           System.out.println(courseData);

            
        }catch (NumberFormatException e) {
        }



}
      
      
public static void showStudentWindow(int place, TextField courseIndexTextField) {
    Stage studentStage = new Stage();
    //studentStage.setTitle(title);

    //Label resultLabel = new Label(result);
    GridPane root = new GridPane();
    //root.getChildren().add(resultLabel);
    Label courseInfo = new Label("Course Info "+ place);
    
    /*
    int courseIndex = Integer.parseInt(input);
            if (courseIndex < 1 || courseIndex > courseData.length) {
                System.out.println("Invalid patient index. Please enter a value between 1 and " + courseData.length + ".");
                return;
            }
*/


    Scene resultScene = new Scene(root, 500, 500);
    studentStage.setScene(resultScene);

    // Set the position of the new window relative to the primary stage
    //studentStage.setX(primaryStage.getX() + 50);
    //studentStage.setY(primaryStage.getY() + 50);

    
   //TextField courseIndexTextField = new TextField();
    Label searchCourse = new Label("Search Course index (1 to 50): ");
    Button enter = new Button("Enter ");
    root.add(enter, 2, 0);
    root.add(searchCourse,0,0);
    root.add(courseIndexTextField,1,0);
        root.add(courseInfo, 0,3);
            enter.setOnAction(e ->showCourseInfo(courseIndexTextField.getText()));
                   
Button viewcourses = new Button ("View Courses");
viewcourses.setOnAction(e ->{
         courseData = readFileCourses();
            printData(courseData);
        });
root.add(viewcourses,1,2);

   studentStage.show();
}
}



