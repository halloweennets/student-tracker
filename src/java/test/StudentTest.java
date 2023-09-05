/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package test;
//
//import DAO.StudentDao;
//import beans.StudentBean;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import utils.Utility;
//
///**
// *
// * @author aefilms
// */
//public class StudentTest {
//
//    
//    StudentBean bean = new StudentBean();
//    StudentDao sd = new StudentDao();
//    
//    
//    
//public void testAddStudentData(){
//        
//        String studentId = Utility.generateRandomAlphanumeric(5);
//
//        bean.setStudent_id(studentId);
//        bean.setFull_name("Precious Tom");
//        bean.setAge(10);
//        bean.setGender("Male");
//        bean.setEmail("tom@gmail.com");
//        bean.setPhone_number("08102578666");
//        bean.setEntry_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//
//        int status = studentId.addStudentData(bean);
//        if (status == 0) {
//            System.out.println("Student Record has been added");
//        } else {
//            System.out.println("Student Record has not been added");
//        }
//        
//    }
//
//    
//    public void deleteStudentData(String Student_id){
//        
//       
//
//        int status = sd.deleteStudentData(Student_id);
//        if (status == 0) {
//            System.out.println("Student Record has been deleted");
//        } else {
//            System.out.println("Student Record has not been deleted");
//        }
//        
//    }
//
//
//    
//     public void getStudentData(String Student_id){
//        
//        StudentBean bean = StudentDao.getStudentData(Student_id);
//
//        
//        if  (bean !=null){
//        
//            System.out.println("Student ID :" + bean.getStudent_id());
//            System.out.println("Full Name :" + bean.getFull_name());
//            System.out.println("Age :" + bean.getAge());
//            System.out.println("Gender :" + bean.getGender());
//            System.out.println("Phone Number :" + bean.getPhone_number());
//            System.out.println("Entry Date :" + bean.getEntry_date());
//        } else {
//            System.out.println("Student Record has not been added");
//        }
//        
//    }
    

//    public static void main(String[] args) {
//
//        
//        String student_id, full_name, email, gender, phone_number, entry_date;
//
//        StudentBean bean = new StudentBean(student_id = "DVdL7", full_name = "Wale Adenuga", 19, gender = "MALE", email = "koo@ko.vcom", phone_number = "8939020234", entry_date = "");
//StudentDao sd = new StudentDao();
//        sd.updateStudentData(bean);
//    }

//}



package test;

import DAO.StudentDao;
import beans.StudentBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import utils.Utility;

public class StudentTest {

    StudentBean bean = new StudentBean();
    StudentDao sd = new StudentDao();

    public void testAddStudentData() {
        String studentId = Utility.generateRandomAlphanumeric(5);

        bean.setStudent_id(studentId);
        bean.setFull_name("Precious Tom");
        bean.setAge(10);
        bean.setGender("Male");
        bean.setEmail("tom@gmail.com");
        bean.setPhone_number("08102578666");
        bean.setEntry_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        int status = sd.addStudentData(bean); // Use correct method name
        if (status == 0) {
            System.out.println("Student Record has been added");
        } else {
            System.out.println("Student Record has not been added");
        }
    }

    public void deleteStudentData(String studentId) {
        int status = sd.deleteStudentData(studentId); // Use correct method name
        if (status == 0) {
            System.out.println("Student Record has been deleted");
        } else {
            System.out.println("Student Record has not been deleted");
        }
    }

    public void getStudentData(String studentId) {
        StudentBean retrievedBean = sd.getStudentData(studentId); // Use correct method name

        if (retrievedBean != null) {
            System.out.println("Student ID :" + retrievedBean.getStudent_id());
            System.out.println("Full Name :" + retrievedBean.getFull_name());
            System.out.println("Age :" + retrievedBean.getAge());
            System.out.println("Gender :" + retrievedBean.getGender());
            System.out.println("Phone Number :" + retrievedBean.getPhone_number());
            System.out.println("Entry Date :" + retrievedBean.getEntry_date());
        } else {
            System.out.println("Student Record not found");
        }
    }
}

