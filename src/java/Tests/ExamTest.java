/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import DAO.ExamDAO;
import beans.ExamBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import Utils.Utility;

/**
 *
 * @author t
 */
public class ExamTest {

    ExamDAO examDAO = new ExamDAO();
    ExamBean bean = new ExamBean();

    public void testAddExamData() {

        String examId = Utility.generateRandomAlphanumeric(5);

        bean.setExamId(examId);
        bean.setStudentId("studentId");
        bean.setCourseId(examId);
        bean.setExamScore(0);
        bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        int status = examDAO.addExamData(bean);
        if (status == 0) {
            System.out.println("Exam Record has been added");
        } else {
            System.out.println("Exam Record has not been added");
        }
    }

    public void testUpdateExamData(String examId) {

        bean.setExamId(examId);
        bean.setStudentId("");
        bean.setCourseId("");
        bean.setExamScore(0);
        

        int status = examDAO.updateExamData(bean);
        if (status == 0) {
            System.out.println("Exam Record has been updated");
        } else {
            System.out.println("Exam Record has not been updated");
        }

    }

    public void testDeleteExamData(String examId) {

        int status = examDAO.deleteExamData(examId);
        if (status == 0) {
            System.out.println("Exam Record has been deleted");
        } else {
            System.out.println("Exam Record has not been deleted");
        }

    }

    public void testGetExamData(String examId) {

        ExamBean eb = examDAO.getExamData(examId);

        if (eb != null) {
            System.out.println("Exam ID: " + eb.getExamId());
            System.out.println("Student ID: " + eb.getStudentId());
            System.out.println("Course ID: " + eb.getCourseId());
            System.out.println("Exam Score: " + eb.getExamScore());
            System.out.println("Entry Date: " + eb.getDate());
        } else {
            System.out.println("Exam Record does not exist");
        }
    }

    
    public void testGetExamList() {
        List<ExamBean> exams = examDAO.getExamList();

        for (ExamBean eb : exams) {
            if (eb != null) {
                System.out.println("********************************");
                System.out.println("Exam ID: " + eb.getExamId());
                System.out.println("Student ID: " + eb.getStudentId());
                System.out.println("Course ID: " + eb.getCourseId());
                System.out.println("Exam Score " + eb.getExamScore());
                System.out.println("Entry Date: " + eb.getDate());
                 System.out.println("******************************\n");
            } else {
                System.out.println("Exam Record does not exist");
            }
        }

    }

}
