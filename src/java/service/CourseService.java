/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DAO.CourseDAO;
import DTO.CourseGetResponse;
import DTO.CourseRequest;
import DTO.CourseResponse;
import DTO.DeleteResponse;
import DTO.StudentGetResponse;
import Utils.Utility;
import beans.CourseBean;
import exception.CustomRuntimeException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aefilms
 */
public class CourseService {

    CourseDAO courseDAO = new CourseDAO();

    public CourseResponse saveOrUpdateCourse(CourseRequest req) {

        CourseResponse res = new CourseResponse();

        CourseBean bean = new CourseBean();
        bean.setInstructorID(req.getInstructorId());
        bean.setCourseName(req.getCourseName());
        bean.setUnit(req.getUnit());
        bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        if (req.getCourseId() == null) {
            //save student record

            String courseId = Utility.generateRandomAlphanumeric(5);
            bean.setCourseId(courseId);

            int status = courseDAO.addCourseData(bean);
            if (status == 0) {
                res.setSuccessful(true);
                res.setCourseId(courseId);
                res.setInstructorId(bean.getInstructorID());
                res.setCourseName(bean.getCourseName());
                res.setUnit(bean.getUnit());

                throw new RuntimeException("Course Record has not been saved ");
            }

        } else {
            //update Course record
            bean.setCourseId(req.getCourseId());

            int status = courseDAO.updateCourseData(bean);
            if (status == 0) {
                res.setSuccessful(true);
                res.setCourseId(bean.getCourseId());
                res.setInstructorId(bean.getInstructorID());
                res.setCourseName(bean.getCourseName());
                res.setUnit(bean.getUnit());
            } else {
                throw new RuntimeException("Course Record has not been updated");
            }
        }
        return res;
    }

    public CourseGetResponse getCourse(String courseId) {

        CourseBean course = courseDAO.getCourseData(courseId);

        if (course != null) {

            return new CourseGetResponse(course.getCourseId(),
                    course.getInstructorID(), course.getCourseName(),
                    course.getUnit());

        } else {
            throw new CustomRuntimeException("Did not find Course: " + courseId);
        }
    }

    public List<CourseGetResponse> getCourses() {

        List<CourseGetResponse> responses = new ArrayList<>();

        List<CourseBean> courses = courseDAO.getCourseList();

        if (!courses.isEmpty()) {
            for (CourseBean course : courses) {

                responses.add(new CourseGetResponse(course.getCourseId(),
                        course.getInstructorID(), course.getCourseName(),
                        course.getUnit()));

            }
        } else {
            throw new CustomRuntimeException("No Course Record Found. Please save Course to see list");
        }

        return responses;

    }

    public DeleteResponse deleteCourse(String courseId) {

        DeleteResponse res = new DeleteResponse();

        int status = courseDAO.deleteCourseData(courseId);
        if (status == 0) {
            res.setMessage(courseId + " has been deleted successfully");
            res.setTimeStamp(courseId);
        } else {
            throw new CustomRuntimeException("Course Record has not been deleted");
        }

        return res;

    }

}
