/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package model;

import DAO.ExamDAO;
import beans.ExamBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Utils.Utility;

/**
 *
 * @author t
 */
@WebServlet(name = "ProcessExamServlet", urlPatterns = {"/ProcessExamServlet"})
public class ProcessExamServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {

                ExamDAO examDAO = new ExamDAO();
                ExamBean bean = new ExamBean();

                
                String studentId = request.getParameter("studentId");
               String courseId = request.getParameter("courseId");
                 int examScore = Integer.parseInt(request.getParameter("examScore"));
                

                String actionPerformed = request.getParameter("buttonName");

                if (actionPerformed.equals("Submit")) {
                    String examId = Utility.generateRandomAlphanumeric(5);

                    bean.setExamId(examId);
                    bean.setStudentId(studentId);
                    bean.setCourseId(courseId);
                    bean.setExamScore(examScore);
                    bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                    int status = examDAO.addExamData(bean);
                    if (status == 0) {

                        request.setAttribute("msg", "Exam Record has been added");
                        request.getRequestDispatcher("/exams/exam_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Exam Record has not been added");
                        request.getRequestDispatcher("/exams/exam_list.jsp").forward(request, response);
                    }
                } else if(actionPerformed.equals("Update")){
                    
                    String examId = request.getParameter("examId");
                    
                    bean.setExamId(examId);
                    bean.setStudentId(studentId);
                    bean.setCourseId(courseId);
                    bean.setExamScore(examScore);
                    bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                    int status = examDAO.updateExamData(bean);
                    if (status == 0) {

                        request.setAttribute("msg", "Exam Record has been updated");
                        request.getRequestDispatcher("/exams/exam_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Exam Record has not been updated");
                        request.getRequestDispatcher("/exams/exam_list.jsp").forward(request, response);
                    }
                }
                else if(actionPerformed.equals("Delete")){
                    
                    String examId = request.getParameter("examId");
                    
                    int status = examDAO.deleteExamData(examId);
                     if (status == 0) {
                        request.setAttribute("msg", "Exam Record has been deleted: "+examId);
                        request.getRequestDispatcher("/exams/exam_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Exam Record has not been deleted");
                        request.getRequestDispatcher("/exams/exam_list.jsp").forward(request, response);
                    }
                }
                else {
                    request.setAttribute("errorMsg", "Invalid action performed");
                    request.getRequestDispatcher("/exams/exam_list.jsp").forward(request, response);
                }

            } catch (IOException | NumberFormatException | ServletException ex) {
                ex.printStackTrace();
                System.out.println("Exception: " + ex.getLocalizedMessage());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
