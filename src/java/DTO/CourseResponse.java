/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author aefilms
 */
public class CourseResponse {

    private boolean successful;
    private String courseId;
    private String instructorId;
    private String courseName;
    private int unit;

    public CourseResponse() {
    }

    public CourseResponse(boolean successful, String courseId, String instructorId, String courseName, int unit) {
        this.successful = successful;
        this.courseId = courseId;
        this.instructorId = instructorId;
        this.courseName = courseName;
        this.unit = unit;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
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

    @Override
    public String toString() {
        return "CourseResponse{" + "successful=" + successful + ", courseId=" + courseId + ", instructorId=" + instructorId + ", courseName=" + courseName + ", unit=" + unit + '}';
    }

}
