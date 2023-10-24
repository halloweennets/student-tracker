/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


public class DeleteResponse {
    
    private String message;
    private String timeStamp;

    public DeleteResponse() {
    }
    
    
    public DeleteResponse(String message, String timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "DeleteResponse{" + "message=" + message + ", timeStamp=" + timeStamp + '}';
    }
    
    
    
    
    
}

   
    


