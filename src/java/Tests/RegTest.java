/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import DAO.RegDAO;
import beans.RegBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import Utils.Utility;

/**
 *
 * @author t
 */
public class RegTest {

    RegDAO regDAO = new RegDAO();
    RegBean bean = new RegBean();

    public void testAddRegData() {

        String regId = Utility.generateRandomAlphanumeric(5);

        bean.setRegId(regId);
        bean.setStudentId("DVdL7");
        bean.setCourseId("sS87K");
        bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        int status = regDAO.addRegData(bean);
        if (status == 0) {
            System.out.println("Course Registration Record has been added");
        } else {
            System.out.println("Course Registration Record has not been added");
        }
    }

    public void testUpdateRegData(String regId) {

        bean.setRegId(regId);
        bean.setStudentId("");
        bean.setCourseId("");

        int status = regDAO.updateRegData(bean);
        if (status == 0) {
            System.out.println("Course Registration Record has been updated");
        } else {
            System.out.println("Course Registration Record has not been updated");
        }

    }

    public void testDeleteRegData(String regId) {

        int status = regDAO.deleteRegData(regId);
        if (status == 0) {
            System.out.println("Course Registration Record has been deleted");
        } else {
            System.out.println("Course Registration Record has not been deleted");
        }

    }

    public void testGetRegData(String regId) {

        RegBean rb = regDAO.getRegData(regId);

        if (rb != null) {
            System.out.println("Student ID: " + rb.getRegId());
            System.out.println("Full Name: " + rb.getStudentId());
            System.out.println("Age: " + rb.getCourseId());
            System.out.println("Entry Date: " + rb.getDate());
        } else {
            System.out.println("Course Registration Record does not exist");
        }
    }

    public void testGetRegList() {
        List<RegBean> regs = regDAO.getRegList();

        for (RegBean rb : regs) {
            if (rb != null) {
                System.out.println("********************************");
                System.out.println("Student ID: " + rb.getRegId());
                System.out.println("Full Name: " + rb.getStudentId());
                System.out.println("Age: " + rb.getCourseId());
                System.out.println("Entry Date: " + rb.getDate());
                System.out.println("******************************\n");
            } else {
                System.out.println("Course Registration Record does not exist");
            }
        }

    }

}
