/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package model;

import DAO.InstructorDAO;
import beans.InstructorBean;
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
    @WebServlet(name = "ProcessInstructorServlet", urlPatterns = {"/ProcessInstructorServlet"})
public class ProcessInstructorServlet extends HttpServlet {

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

                InstructorDAO instructorDAO = new InstructorDAO();
                InstructorBean bean = new InstructorBean();

                String fullName = request.getParameter("fullName");

                String email = request.getParameter("email");
                String mobileNumber = request.getParameter("mobileNumber");

                String actionPerformed = request.getParameter("buttonName");

                if (actionPerformed.equals("Submit")) {
                    String instructorId = Utility.generateRandomAlphanumeric(5);

                    bean.setInstructorId(instructorId);
                    bean.setFullName(fullName);
                    bean.setEmail(email);
                    bean.setMobileNumber(mobileNumber);
                    bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                    int status = instructorDAO.addInstructorData(bean);
                    if (status == 0) {

                        request.setAttribute("msg", "Instructor Record has been added");
                        request.getRequestDispatcher("/instructors/instructors_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Instructor Record has not been added");
                        request.getRequestDispatcher("/instructors/instructors_list.jsp").forward(request, response);
                    }
                } else if (actionPerformed.equals("Update")) {

                    String instructorId = request.getParameter("instructorId");

                    bean.setInstructorId(instructorId);
                    bean.setFullName(fullName);

                    bean.setEmail(email);
                    bean.setMobileNumber(mobileNumber);
                    bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                    int status = instructorDAO.updateInstructorData(bean);
                    if (status == 0) {

                        request.setAttribute("msg", "Instructor Record has been updated");
                        request.getRequestDispatcher("/instructors/instructors_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Instructor Record has not been updated");
                        request.getRequestDispatcher("/instructors/instructors_list.jsp").forward(request, response);
                    }
                } else if (actionPerformed.equals("Delete")) {

                    String instructorId = request.getParameter("instructorId");

                    int status = instructorDAO.deleteInstructorData(instructorId);
                    if (status == 0) {
                        request.setAttribute("msg", "Instructor Record has been deleted: " + instructorId);
                        request.getRequestDispatcher("/instructors/instructors_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Instructor Record has not been deleted");
                        request.getRequestDispatcher("/instructors/instructors_list.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("errorMsg", "Invalid action performed");
                    request.getRequestDispatcher("/instructors/instructors_list.jsp").forward(request, response);
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
