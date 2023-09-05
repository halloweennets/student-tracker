/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import beans.StudentBean;
import connection.SQLConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Utility;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import static java.time.LocalDate.now;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aefilms
 */
public class StudentDao {

    SQLConnection connection = new SQLConnection();
    Connection connect = null;
    PreparedStatement ps = null;
    Statement statement = null;

    public int addStudentData(StudentBean bean) {

        int status = -1;

        String query = "insert into students values(?,?,?,?,?,?,?)";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getStudent_id());
            ps.setString(2, bean.getFull_name());
            ps.setInt(3, bean.getAge());
            ps.setString(4, bean.getGender());
            ps.setString(5, bean.getEmail());
            ps.setString(6, bean.getPhone_number());

            // Format the entry_date using SimpleDateFormat
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            String Entry_date = sdf.format(date);

            ps.setString(7, bean.getEntry_date());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    //This method is to update student record
    public int updateStudentData(StudentBean bean) {

        int status = -1;

        String query = "UPDATE students SET full_name=?, age=?, gender=?, email=?, phone_number=? WHERE student_id=?";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getFull_name());
            ps.setInt(2, bean.getAge());
            ps.setString(3, bean.getGender());
            ps.setString(4, bean.getEmail());
            ps.setString(5, bean.getPhone_number());
            ps.setString(6, bean.getStudent_id());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    public int deleteStudentData(String studentId) {

        int status = -1;

        String query = "delete from students where student_id=?";

        connect = connection.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, studentId);

            status = ps.executeUpdate();
            if (status > 0) {
                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     *
     * This method gets Student Data from database
     *
     * @param studentId
     * @return
     */
    public StudentBean getStudentData(String studentId) {
        StudentBean bean = new StudentBean();

        ResultSet result = null;

        String query = "select * from students where student_id=?";

        connect = connection.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, studentId);

            result = ps.executeQuery();
            if (result.next()) {
                bean.setStudent_id(result.getString("student_id"));
                bean.setFull_name(result.getString("full_name"));
                bean.setAge(result.getInt("age"));
                bean.setGender(result.getString("gender"));
                bean.setEmail(result.getString("email"));
                bean.setPhone_number(result.getString("pnone_number"));
                bean.setEntry_date(result.getString("entry_date"));

            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return bean;

    }

    public List<StudentBean> getStudentList() {

        List<StudentBean> students = new ArrayList<>();

        ResultSet result = null;

        String query = "select * from students";

        connect = connection.getNewConnection();

        try {

            statement = connect.createStatement();

            result = statement.executeQuery(query);
            while (result.next()) {

                StudentBean bean = new StudentBean();

                bean.setStudent_id(result.getString("student_id"));
                bean.setFull_name(result.getString("full_name"));
                bean.setAge(result.getInt("age"));
                bean.setGender(result.getString("gender"));
                bean.setEmail(result.getString("email"));
                bean.setPhone_number(result.getString("pnone_number"));
                bean.setEntry_date(result.getString("entry_date"));

                students.add(bean);
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

        return students;
    }

    public static void main(String[] args) {

        StudentDao studentDAO = new StudentDao();

       String student_id = "";
       studentDAO.testAddStudentData();
//       studentDAO.deleteStudentData();
//       studentDAO.getStudentData();
       

    }

    private void testAddStudentData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
