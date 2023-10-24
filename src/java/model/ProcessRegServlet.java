/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package model;

import DAO.RegDAO;
import beans.RegBean;
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
@WebServlet(name = "ProcessRegServlet", urlPatterns = {"/ProcessRegServlet"})
public class ProcessRegServlet extends HttpServlet {

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

                RegDAO regDAO = new RegDAO();
                RegBean bean = new RegBean();

                String studentId = request.getParameter("studentId");
                String CourseId = request.getParameter("courseId");

                String actionPerformed = request.getParameter("buttonName");

                if (actionPerformed.equals("Submit")) {
                    String regId = Utility.generateRandomAlphanumeric(5);

                    bean.setRegId(regId);
                    bean.setStudentId(studentId);
                    bean.setCourseId(CourseId);
                    bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                    int status = regDAO.addRegData(bean);
                    if (status == 0) {

                        request.setAttribute("msg", "Course Registration Record has been added");
                        request.getRequestDispatcher("/regs/reg_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Course Registration Record has not been added");
                        request.getRequestDispatcher("/regs/reg_list.jsp").forward(request, response);
                    }
                } else if (actionPerformed.equals("Update")) {

                    String regId = request.getParameter("regId");

                    bean.setRegId(regId);
                    bean.setStudentId(studentId);
                    bean.setCourseId(CourseId);
                    bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                    int status = regDAO.updateRegData(bean);
                    if (status == 0) {

                        request.setAttribute("msg", "Course Registration Record has been updated");
                        request.getRequestDispatcher("/regs/reg_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Course Registration Record has not been updated");
                        request.getRequestDispatcher("/regs/reg_list.jsp").forward(request, response);
                    }
                } else if (actionPerformed.equals("Delete")) {

                    String regId = request.getParameter("regId");

                    int status = regDAO.deleteRegData(regId);
                    if (status == 0) {
                        request.setAttribute("msg", "Course Registration Record has been deleted: " + studentId);
                        request.getRequestDispatcher("/regs/reg_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Course Registration Record has not been deleted");
                        request.getRequestDispatcher("/regs/reg_list.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("errorMsg", "Invalid action performed");
                    request.getRequestDispatcher("/regs/reg_list.jsp").forward(request, response);
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
