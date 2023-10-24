/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aefilms
 */
@WebServlet(name = "JController", urlPatterns = {"/jp.do"})
public class JController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            String action = request.getParameter("action");

            if (action.equalsIgnoreCase("dashboard")) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("student-form")) {
                request.getRequestDispatcher("/students/student_form.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("student-list")) {
                request.getRequestDispatcher("/students/students_list.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("student")) {
                request.getRequestDispatcher("/students/students.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("process-student")) {
                request.getRequestDispatcher("/ProcessStudentServlet").forward(request, response);
            } else if (action.equalsIgnoreCase("instructor-form")) {
                request.getRequestDispatcher("/instructors/instructor_form.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("instructor-list")) {
                request.getRequestDispatcher("/instructors/instructors_list.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("instructor")) {
                request.getRequestDispatcher("/instructors/instructors.jsp").forward(request, response);
            }else if (action.equalsIgnoreCase("process-instructor")) {
                request.getRequestDispatcher("/ProcessInstructorServlet").forward(request, response);
            }
            else if (action.equalsIgnoreCase("course-form")) {
                request.getRequestDispatcher("/courses/course_form.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("course-list")) {
                request.getRequestDispatcher("/courses/course_list.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("process-course")) {
                request.getRequestDispatcher("/ProcessCourseServlet").forward(request, response);
            }
            else if (action.equalsIgnoreCase("exam-form")) {
                request.getRequestDispatcher("/exams/exam_form.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("exam-list")) {
                request.getRequestDispatcher("/exams/exam_list.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("process-exam")) {
                request.getRequestDispatcher("/ProcessExamServlet").forward(request, response);
            }
            else if (action.equalsIgnoreCase("reg-form")) {
                request.getRequestDispatcher("/regs/reg_form.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("reg-list")) {
                request.getRequestDispatcher("/regs/reg_list.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("process-reg")) {
                request.getRequestDispatcher("/ProcessRegServlet").forward(request, response);
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
