/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package model;

import DAO.StudentDAO;
import beans.StudentBean;
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
@WebServlet(name = "ProcessStudentServlet", urlPatterns = {"/ProcessStudentServlet"})
public class ProcessStudentServlet extends HttpServlet {

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

                StudentDAO studentDAO = new StudentDAO();
                StudentBean bean = new StudentBean();

                
                String fullName = request.getParameter("fullName");
                int age = Integer.parseInt(request.getParameter("age"));
                String email = request.getParameter("email");
                String phoneNumber = request.getParameter("phoneNumber");
                String gender = request.getParameter("gender");

                String actionPerformed = request.getParameter("buttonName");

                if (actionPerformed.equals("Submit")) {
                    String studentId = Utility.generateRandomAlphanumeric(5);

                    bean.setStudentId(studentId);
                    bean.setFullName(fullName);
                    bean.setAge(age);
                    bean.setGender(gender);
                    bean.setEmail(email);
                    bean.setPhoneNumber(phoneNumber);
                    bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                    int status = studentDAO.addStudentData(bean);
                    if (status == 0) {

                        request.setAttribute("msg", "Student Record has been added");
                        request.getRequestDispatcher("/students/students_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Student Record has not been added");
                        request.getRequestDispatcher("/students/students_list.jsp").forward(request, response);
                    }
                } else if(actionPerformed.equals("Update")){
                    
                    String studentId = request.getParameter("studentId");
                    
                    bean.setStudentId(studentId);
                    bean.setFullName(fullName);
                    bean.setAge(age);
                    bean.setGender(gender);
                    bean.setEmail(email);
                    bean.setPhoneNumber(phoneNumber);
                    bean.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                    int status = studentDAO.updateStudentData(bean);
                    if (status == 0) {

                        request.setAttribute("msg", "Student Record has been updated");
                        request.getRequestDispatcher("/students/students_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Student Record has not been updated");
                        request.getRequestDispatcher("/students/students_list.jsp").forward(request, response);
                    }
                }
                else if(actionPerformed.equals("Delete")){
                    
                    String studentId = request.getParameter("studentId");
                    
                    int status = studentDAO.deleteStudentData(studentId);
                     if (status == 0) {
                        request.setAttribute("msg", "Student Record has been deleted: "+studentId);
                        request.getRequestDispatcher("/students/students_list.jsp").forward(request, response);
                    } else {

                        request.setAttribute("errorMsg", "Student Record has not been deleted");
                        request.getRequestDispatcher("/students/students_list.jsp").forward(request, response);
                    }
                }
                else {
                    request.setAttribute("errorMsg", "Invalid action performed");
                    request.getRequestDispatcher("/students/students_list.jsp").forward(request, response);
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
