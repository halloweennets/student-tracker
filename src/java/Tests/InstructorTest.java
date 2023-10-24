/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import DAO.InstructorDAO;
import beans.InstructorBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import Utils.Utility;

/**
 *
 * @author t
 */
public class InstructorTest {

    InstructorDAO instructorDAO = new InstructorDAO();
    InstructorBean bean = new InstructorBean();

    public void testAddInstructorData() {

        String instructorId = Utility.generateRandomAlphanumeric(5);

        bean.setInstructorId(instructorId);
        bean.setFullName("Ann Tom");

        bean.setEmail("Anntom@gmail.com");
        bean.setMobileNumber("08102578490");
        bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        int status = instructorDAO.addInstructorData(bean);
        if (status == 0) {
            System.out.println("Instructor Record has been added");
        } else {
            System.out.println("Instructor Record has not been added");
        }
    }

    public void testUpdateInstructorData(String instructorId) {

        bean.setInstructorId(instructorId);
        bean.setFullName("Precious Ekwere");

        bean.setEmail("precious@gmail.com");
        bean.setMobileNumber("08102578555");

        int status = instructorDAO.updateInstructorData(bean);
        if (status == 0) {
            System.out.println("Instructor Record has been updated");
        } else {
            System.out.println("Instructor Record has not been updated");
        }

    }

    public void testDeleteInstructorData(String instructorId) {

        int status = instructorDAO.deleteInstructorData(instructorId);
        if (status == 0) {
            System.out.println("Instructor Record has been deleted");
        } else {
            System.out.println("Instructor Record has not been deleted");
        }

    }

    public void testGetInstructorData(String instructorId) {

        InstructorBean sb = instructorDAO.getInstructorData(instructorId);

        if (sb != null) {
            System.out.println("Instructor ID: " + sb.getInstructorId());
            System.out.println("Full Name: " + sb.getFullName());

            System.out.println("Phone Number: " + sb.getMobileNumber());
            System.out.println("Entry Date: " + sb.getDate());
        } else {
            System.out.println("Instructor Record does not exist");
        }
    }

    public void testGetInstructorList() {
        List<InstructorBean> instructors = instructorDAO.getInstructorList();

        for (InstructorBean sb : instructors) {
            if (sb != null) {
                System.out.println("********************************");
                System.out.println("Instructor ID: " + sb.getInstructorId());
                System.out.println("Full Name: " + sb.getFullName());
                System.out.println("Email: " + sb.getEmail());
                System.out.println("Phone Number: " + sb.getMobileNumber());
                System.out.println("Entry Date: " + sb.getDate());
                System.out.println("******************************\n");
            } else {
                System.out.println("Instructor Record does not exist");
            }
        }

    }

}
