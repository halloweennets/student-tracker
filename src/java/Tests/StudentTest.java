/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import DAO.StudentDAO;
import beans.StudentBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import Utils.Utility;

/**
 *
 * @author t
 */
public class StudentTest {

    StudentDAO studentDAO = new StudentDAO();
    StudentBean bean = new StudentBean();

    public void testAddStudentData() {

        String studentId = Utility.generateRandomAlphanumeric(5);

        bean.setStudentId(studentId);
        bean.setFullName("Precious Tom");
        bean.setAge(10);
        bean.setGender("Male");
        bean.setEmail("tom@gmail.com");
        bean.setPhoneNumber("08102578666");
        bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        int status = studentDAO.addStudentData(bean);
        if (status == 0) {
            System.out.println("Student Record has been added");
        } else {
            System.out.println("Student Record has not been added");
        }
    }

    public void testUpdateStudentData(String studentId) {

        bean.setStudentId(studentId);
        bean.setFullName("Precious Ekwere");
        bean.setAge(30);
        bean.setGender("Male");
        bean.setEmail("precious@gmail.com");
        bean.setPhoneNumber("08102578555");

        int status = studentDAO.updateStudentData(bean);
        if (status == 0) {
            System.out.println("Student Record has been updated");
        } else {
            System.out.println("Student Record has not been updated");
        }

    }

    public void testDeleteStudentData(String studentId) {

        int status = studentDAO.deleteStudentData(studentId);
        if (status == 0) {
            System.out.println("Student Record has been deleted");
        } else {
            System.out.println("Student Record has not been deleted");
        }

    }

    public void testGetStudentData(String studentId) {

        StudentBean sb = studentDAO.getStudentData(studentId);

        if (sb != null) {
            System.out.println("Student ID: " + sb.getStudentId());
            System.out.println("Full Name: " + sb.getFullName());
            System.out.println("Age: " + sb.getAge());
            System.out.println("Gender: " + sb.getGender());
            System.out.println("Phone Number: " + sb.getPhoneNumber());
            System.out.println("Entry Date: " + sb.getDate());
        } else {
            System.out.println("Student Record does not exist");
        }
    }

    
    public void testGetStudentList() {
        List<StudentBean> students = studentDAO.getStudentList();

        for (StudentBean sb : students) {
            if (sb != null) {
                System.out.println("********************************");
                System.out.println("Student ID: " + sb.getStudentId());
                System.out.println("Full Name: " + sb.getFullName());
                System.out.println("Age: " + sb.getAge());
                System.out.println("Gender: " + sb.getGender());
                System.out.println("Phone Number: " + sb.getPhoneNumber());
                System.out.println("Entry Date: " + sb.getDate());
                 System.out.println("******************************\n");
            } else {
                System.out.println("Student Record does not exist");
            }
        }

    }

}
