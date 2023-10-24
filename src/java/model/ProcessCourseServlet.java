/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package model;

import DAO.CourseDAO;
import beans.CourseBean;
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
@WebServlet(name = "ProcessCourseServlet", urlPatterns = {"/ProcessCourseServlet"})
public class ProcessCourseServlet extends HttpServlet {

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

            try {

                CourseDAO courseDAO = new CourseDAO();
                CourseBean bean = new CourseBean();

                String instructorId = request.getParameter("instructorId");
                String courseName = request.getParameter("courseName");
                int unit = Integer.parseInt(request.getParameter("unit"));

                String actionPerformed = request.getParameter("buttonName");

                if (actionPerformed.equals("Submit")) {
                    String courseId = Utility.generateRandomAlphanumeric(5);

                    bean.setCourseId(courseId);
                    bean.setInstructorID(instructorId);
                    bean.setCourseName(courseName);
                    bean.setUnit(unit);
                    bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                    int status = courseDAO.addCourseData(bean);
                    if (status == 0) {

                        request.setAttribute("msg", "Course Record has been added");
                        request.getRequestDispatcher("/courses/course_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Course Record has not been added");
                        request.getRequestDispatcher("/courses/course_list.jsp").forward(request, response);
                    }
                    
                } else if (actionPerformed.equals("Update")) {

                    String courseId = request.getParameter("courseId");

                    bean.setCourseId(courseId);
                    bean.setInstructorID(instructorId);
                    bean.setCourseName(courseName);
                    bean.setUnit(unit);

                    int status = courseDAO.updateCourseData(bean);
                    if (status == 0) {

                        request.setAttribute("msg", "Course Record has been updated");
                        request.getRequestDispatcher("/courses/course_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Course Record has not been updated");
                        request.getRequestDispatcher("/courses/course_list.jsp").forward(request, response);
                    }
                } else if (actionPerformed.equals("Delete")) {

                    String courseId = request.getParameter("courseId");

                    int status = courseDAO.deleteCourseData(courseId);
                    if (status == 0) {
                        request.setAttribute("msg", "Course Record has been deleted: " + courseId);
                        request.getRequestDispatcher("/courses/course_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Course Record has not been deleted");
                        request.getRequestDispatcher("/courses/course_list.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("errorMsg", "Invalid action performed");
                    request.getRequestDispatcher("/courses/course_list.jsp").forward(request, response);
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
