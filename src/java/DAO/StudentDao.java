/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import beans.StudentBean;
import connection.SQLConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Utility;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import static java.time.LocalDate.now;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author aefilms
 */
public class StudentDao {
    
    SQLConnection connection = new SQLConnection();
    Connection connect = null;
    PreparedStatement ps = null;
    
public int addStudentData(StudentBean bean) {
        
        int status = -1;
        
        String query = "insert into students values(?,?,?,?,?,?,?)";
        
        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);
            
            ps.setString(1, bean.getStudent_id());
            ps.setString(2, bean.getFull_name());
            ps.setInt(3, bean.getAge());
            ps.setString(4, bean.getGender());
            ps.setString(5, bean.getEmail());
            ps.setString(6, bean.getPhone_number());
            
                    // Format the entry_date using SimpleDateFormat
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            String Entry_date = sdf.format(date);
            
            ps.setString(7, bean.getEntry_date());
            
            status = ps.executeUpdate();
            
            if(status>0){
                
               status = 0;   
            }
            else{
                status = 1;
            }
            
        } catch (SQLException ex) {   
            System.out.println("Exception"+ ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex){  
              System.out.println("Exception"+ ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }finally{
            
          if(ps!= null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception"+ ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
          }
          
          if(connect!=null){
                try {
                    connect.close();
                } catch (SQLException ex) {
                      System.out.println("Exception"+ ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
          }
          
        } 
        
        return status;
    }
    
    
    public static void main(String[] args) {
        
        StudentDao studentDAO = new StudentDao();
        
        String studentId = Utility.generateRandomAlphanumeric(5);
        
        StudentBean bean = new StudentBean();
        bean.setStudent_id(studentId);
        bean.setFull_name("Precious Tom");
        bean.setAge(10);
        bean.setGender("Male");
        bean.setEmail("tom@gmail.com");
        bean.setPhone_number("08102578666");
         // Format the entry_date using SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String Entry_date = sdf.format(date);
        bean.setEntry_date(Entry_date); // Set the formatted date

        
        int status = studentDAO.addStudentData(bean);
        if (status == 0) {
            System.out.println("Student Record has been added");
        }else{
             System.out.println("Student Record has not been added");
        }
        
    }
    
    
}

