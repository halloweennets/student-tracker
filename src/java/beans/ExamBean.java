/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author t
 */
public class ExamBean {

    private String examId;
    private String studentId;
    private String courseId;
    private int examScore;
    private String date;

    public ExamBean() {
    }

    public ExamBean(String examId, String studentId, String courseId, int examScore, String date) {
        this.examId = examId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.examScore = examScore;
        this.date = date;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
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

    public int getExamScore() {
        return examScore;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExamBean{" + "examId=" + examId + ", studentId=" + studentId + ", courseId=" + courseId + ", examScore=" + examScore + ", date=" + date + '}';
    }

    
    

    



   

}
