/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author t
 */
public class CourseBean {

    private String courseId;
    private String instructorID;
    private String courseName;
    private int unit;
    private String date;

    public CourseBean() {
    }

    public CourseBean(String courseId, String instructorID, String courseName, int unit, String date) {
        this.courseId = courseId;
        this.instructorID = instructorID;
        this.courseName = courseName;
        this.unit = unit;
        this.date = date;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    




    @Override
    public String toString() {
        return "CourseBean{" + "courseId=" + courseId + ", instructorID=" + instructorID + ", courseName=" + courseName + ", unit=" + unit + ", date=" + date + '}';
    }

}
