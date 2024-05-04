/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Final;

/**
 *
 * @author rosegenstein1
 */
public class Courses {
    private int courseId;
    private String courseName;
    private String department;
    private int credit;
    private int capacity;
     private String[] students;

    // Constructors
    public Courses(int courseId, String courseName, String department, int credit, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
        this.credit = credit;
        this.capacity = capacity;
        this.students = new String[capacity];
    }

    // Getters and Setters
    
    
     public boolean registerStudent(String studentId) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = studentId;
                return true; // Registration successful
            }
        }
        return false; // Course is full
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", department='" + department + '\'' +
                ", credit=" + credit +
                ", capacity=" + capacity +
                '}';
    }

  
}
