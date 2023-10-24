/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;



/**
 *
 * @author t
 */
public class InstructorBean {

    private String instructorId;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String date;

    public InstructorBean() {
    }

    public InstructorBean(String instructorId, String fullName, String email, String mobileNumber, String date) {
        this.instructorId = instructorId;
        this.fullName = fullName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.date = date;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "InstructorBean{" + "instructorId=" + instructorId + ", fullName=" + fullName + ", email=" + email + ", mobileNumber=" + mobileNumber + ", date=" + date + '}';
    }
}
