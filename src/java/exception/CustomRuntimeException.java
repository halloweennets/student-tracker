/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author aefilms
 */
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author t
 */
public class CustomRuntimeException extends WebApplicationException {
    
    public CustomRuntimeException() {
        super();
    }
    public CustomRuntimeException(String message) {
        super(message);
    }

    
}
