/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author t
 */
public class RegBean {

    private String regId;
    private String studentId;
    private String courseId;
    private String date;

    public RegBean() {
    }

    public RegBean(String regId, String studentId, String courseId, String date) {
        this.regId = regId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RegBean{" + "regId=" + regId + ", studentId=" + studentId + ", courseId=" + courseId + ", date=" + date + '}';
    }

}
