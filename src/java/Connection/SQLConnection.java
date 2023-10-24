/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author t
 */
public class SQLConnection {
    
    public Connection getNewConnection() {
        
        Connection connect = null;
        
        try {
            
            Properties prop = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("prop/connection.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Property File not Found");
            }
            
            String connectionString = prop.getProperty("mysqlConnectionString");
            String driver = prop.getProperty("mysqlConnectionDriver");
            String password = prop.getProperty("mysqlPassword");
            String username = prop.getProperty("mysqlUsername");
            
            
            Class.forName(driver).newInstance();
            
        
            connect = DriverManager.getConnection(connectionString, username, password);
            
            
        } catch (ClassNotFoundException | SQLException | IOException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        return connect;
    }
    
    
    public void testConnection() {

        ResultSet rsObj = null;
        Connection connObj = null;
        PreparedStatement pstmtObj = null;
       

        try {

            System.out.println("\n=====Making A New Connection Object For Db Transaction=====\n");
            
            connObj = this.getNewConnection();

            pstmtObj = connObj.prepareStatement("SELECT * FROM students");
            
            rsObj = pstmtObj.executeQuery();
            
            while (rsObj.next()) {
                System.out.println("Username: " + rsObj.getString("student_id"));
            }
            
            System.out.println("\n=====Releasing Connection Object To Pool=====\n");

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                // Closing ResultSet Object
                if (rsObj != null) {
                    rsObj.close();
                }
                // Closing PreparedStatement Object
                if (pstmtObj != null) {
                    pstmtObj.close();
                }
                // Closing Connection Object
                if (connObj != null) {
                    connObj.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        
        
        try {

            System.out.println("\n=====Making A New Connection Object For Db Transaction=====\n");
            
            connObj = this.getNewConnection();

            pstmtObj = connObj.prepareStatement("SELECT * FROM instructors");
            
            rsObj = pstmtObj.executeQuery();
            
            while (rsObj.next()) {
                System.out.println("Username: " + rsObj.getString("instructor_id"));
            }
            
            System.out.println("\n=====Releasing Connection Object To Pool=====\n");

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                // Closing ResultSet Object
                if (rsObj != null) {
                    rsObj.close();
                }
                // Closing PreparedStatement Object
                if (pstmtObj != null) {
                    pstmtObj.close();
                }
                // Closing Connection Object
                if (connObj != null) {
                    connObj.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        
        try {

            System.out.println("\n=====Making A New Connection Object For Db Transaction=====\n");
            
            connObj = this.getNewConnection();

            pstmtObj = connObj.prepareStatement("SELECT * FROM courses");
            
            rsObj = pstmtObj.executeQuery();
            
            while (rsObj.next()) {
                System.out.println("Username: " + rsObj.getString("course_id"));
            }
            
            System.out.println("\n=====Releasing Connection Object To Pool=====\n");

        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                // Closing ResultSet Object
                if (rsObj != null) {
                    rsObj.close();
                }
                // Closing PreparedStatement Object
                if (pstmtObj != null) {
                    pstmtObj.close();
                }
                // Closing Connection Object
                if (connObj != null) {
                    connObj.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

    
    public static void main(String[] args) {
        
        SQLConnection conn = new SQLConnection();
        
        System.out.println("Connection Instance: " + conn.getNewConnection());
        
        conn.testConnection();
    }
    
}
