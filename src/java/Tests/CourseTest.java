/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import DAO.CourseDAO;
import beans.CourseBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import Utils.Utility;

/**
 *
 * @author t
 */
public class CourseTest {

    CourseDAO courseDAO = new CourseDAO();
    CourseBean bean = new CourseBean();

    public void testAddCourseData() {

        String courseId = Utility.generateRandomAlphanumeric(5);

        bean.setCourseId(courseId);
        bean.setInstructorID("");
        bean.setCourseName("");
        bean.setUnit(10);
        bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        int status = courseDAO.addCourseData(bean);
        if (status == 0) {
            System.out.println("Course Record has been added");
        } else {
            System.out.println("Course Record has not been added");
        }
    }

    public void testUpdateCourseData(String courseId) {

        bean.setCourseId(courseId);
        bean.setInstructorID("");
        bean.setCourseName("");
        bean.setUnit(10);

        int status = courseDAO.updateCourseData(bean);
        if (status == 0) {
            System.out.println("Course Record has been updated");
        } else {
            System.out.println("Course Record has not been updated");
        }

    }

    public void testDeleteCourseData(String courseId) {

        int status = courseDAO.deleteCourseData(courseId);

        if (status == 0) {
            System.out.println("Course Record has been deleted");
        } else {
            System.out.println("Course Record has not been deleted");
        }

    }

    public void testGetCourseData(String courseId) {

        CourseBean sb = courseDAO.getCourseData(courseId);

        if (sb != null) {
            System.out.println("Course ID: " + sb.getCourseId());
            System.out.println("Instructor ID: " + sb.getInstructorID());
            System.out.println("Course Name: " + sb.getCourseName());
            System.out.println("Unit: " + sb.getUnit());
            System.out.println("Entry Date: " + sb.getDate());
        } else {
            System.out.println("Course Record does not exist");
        }
    }

    public void testGetCourseList() {
        List<CourseBean> courses = courseDAO.getCourseList();

        for (CourseBean sb : courses) {

            System.out.println("********************************");
            System.out.println("Course ID: " + sb.getCourseId());
            System.out.println("Instructor ID: " + sb.getInstructorID());
            System.out.println("Course Name: " + sb.getCourseName());
            System.out.println("Unit: " + sb.getUnit());
            System.out.println("Entry Date: " + sb.getDate());
            System.out.println("******************************\n");

        }

    }

}
