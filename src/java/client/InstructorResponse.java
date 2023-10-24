/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

/**
 *
 * @author aefilms
 */
public class InstructorResponse {
    
    private boolean successful;
    private String instructorId;
    private String fullName;
    private String email;
    private String mobileNumber;

    public InstructorResponse() {
    }

    public InstructorResponse(boolean successful, String instructorId, String fullName, String email, String mobileNumber) {
        this.successful = successful;
        this.instructorId = instructorId;
        this.fullName = fullName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "InstructorResponse{" + "successful=" + successful + ", instructorId=" + instructorId + ", fullName=" + fullName + ", email=" + email + ", mobileNumber=" + mobileNumber + '}';
    }
    
    
    
}
