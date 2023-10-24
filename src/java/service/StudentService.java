/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author aefilms
 */
import DAO.StudentDAO;
import DTO.DeleteResponse;
import DTO.StudentGetResponse;
import DTO.StudentRequest;
import DTO.StudentResponse;
import beans.StudentBean;
import exception.CustomRuntimeException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Utils.Utility;

/**
 *
 * @author t
 */
public class StudentService {

    StudentDAO studentDAO = new StudentDAO();

    public StudentResponse saveOrUpdateStudent(StudentRequest req) {

        StudentResponse res = new StudentResponse();

        StudentBean bean = new StudentBean();
        bean.setFullName(req.getFullName());
        bean.setAge(req.getAge());
        bean.setGender(req.getGender());
        bean.setEmail(req.getEmail());
        bean.setPhoneNumber(req.getPhoneNumber());
        bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        if (req.getStudentId() == null) {
            //save student record

            String studentId = Utility.generateRandomAlphanumeric(5);
            bean.setStudentId(studentId);

            int status = studentDAO.addStudentData(bean);
            if (status == 0) {
                res.setSuccessful(true);
                res.setStudentId(studentId);
                res.setFullName(bean.getFullName());
                res.setAge(bean.getAge());
                res.setGender(bean.getGender());
                res.setEmail(bean.getEmail());
                res.setPhoneNumber(bean.getPhoneNumber());
            } else {
                throw new RuntimeException("Student Record has not been saved ");
            }

        } else {
            //update student record
            bean.setStudentId(req.getStudentId());

            int status = studentDAO.updateStudentData(bean);
            if (status == 0) {
                res.setSuccessful(true);
                res.setStudentId(bean.getStudentId());
                res.setFullName(bean.getFullName());
                res.setAge(bean.getAge());
                res.setGender(bean.getGender());
                res.setEmail(bean.getEmail());
                res.setPhoneNumber(bean.getPhoneNumber());
            } else {
                throw new RuntimeException("Student Record has not been updated");
            }
        }
        return res;
    }

    public StudentGetResponse getStudent(String studentId) {

        StudentBean student = studentDAO.getStudentData(studentId);

        if (student != null) {

            return new StudentGetResponse(student.getStudentId(),
                    student.getFullName(), student.getAge(),
                    student.getGender(), student.getEmail(),
                    student.getPhoneNumber());

        } else {
            throw new CustomRuntimeException("Did not find Student: " + studentId);
        }
    }

    public List<StudentGetResponse> getStudents() {

        List<StudentGetResponse> responses = new ArrayList<>();

        List<StudentBean> students = studentDAO.getStudentList();

        if (!students.isEmpty()) {
            for (StudentBean student : students) {

                responses.add(new StudentGetResponse(student.getStudentId(),
                        student.getFullName(), student.getAge(),
                        student.getGender(), student.getEmail(),
                        student.getPhoneNumber()));

            }
        } else {
            throw new CustomRuntimeException("No Student Record Found. Please save student to see list");
        }

        return responses;

    }

    public DeleteResponse deleteStudent(String studentId) {

        DeleteResponse res = new DeleteResponse();

        int status = studentDAO.deleteStudentData(studentId);
        if (status == 0) {
            res.setMessage(studentId + " has been deleted successfully");
            res.setTimeStamp(studentId);
        } else {
            throw new CustomRuntimeException("Student Record has not been deleted");
        }

        return res;

    }

}

