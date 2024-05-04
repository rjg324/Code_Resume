/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rosegenstein1
 */
public class Student {

    public int id;
    public String name;
    public String gender;
    public int[] courses = new int[7]; // Assuming course names are stored as strings

    //public Student(int id, String name, String gender, List<String> courses) {
    public Student(int id, String name, String gender, int[]courses) {
        this.id = id;
        this.name = name;
        this.gender = gender;
      this.courses = courses;
    }

    // Getters and setters for each attribute
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int[] getCourses() {
        return courses;
    }

    public void setCourses(int [] courses) {
        this.courses = courses;
    }


    // Additional method to display the list of courses the student is enrolled in
    public void displayCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (int course : courses) {
            System.out.println(course);
            
        }
    }
     

//    public void add(Student student) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
}


