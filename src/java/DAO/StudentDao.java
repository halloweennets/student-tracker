/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Tests.StudentTest;
import beans.StudentBean;
import Connection.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.LinkedHashMap;

/**
 *
 * @author t
 */
public class StudentDAO {

    SQLConnection connection = new SQLConnection();
    Connection connect = null;
    PreparedStatement ps = null;
    Statement statement = null;

    /**
     * This method handles student creation in the database
     *
     * @param bean
     * @return int
     */
    public int addStudentData(StudentBean bean) {

        int status = -1;

        String query = "insert into students values(?,?,?,?,?,?,?)";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getStudentId());
            ps.setString(2, bean.getFullName());
            ps.setInt(3, bean.getAge());
            ps.setString(4, bean.getGender());
            ps.setString(5, bean.getEmail());
            ps.setString(6, bean.getPhoneNumber());
            ps.setString(7, bean.getDate());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     * This method handles Student Update in the database
     *
     * @param bean
     * @return int
     */
    public int updateStudentData(StudentBean bean) {

        int status = -1;

        String query = "update students set full_name = ?, age=?, gender=?, email=?, phone_number=? where student_id = ?";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getFullName());
            ps.setInt(2, bean.getAge());
            ps.setString(3, bean.getGender());
            ps.setString(4, bean.getEmail());
            ps.setString(5, bean.getPhoneNumber());
            ps.setString(6, bean.getStudentId());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     * This method deletes student record from database
     *
     * @param studentId
     * @return
     */
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
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
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
                bean.setStudentId(result.getString("student_id"));
                bean.setFullName(result.getString("full_name"));
                bean.setAge(result.getInt("age"));
                bean.setGender(result.getString("gender"));
                bean.setEmail(result.getString("email"));
                bean.setPhoneNumber(result.getString("phone_number"));
                bean.setDate(result.getString("entry_date"));

            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
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

                bean.setStudentId(result.getString("student_id"));
                bean.setFullName(result.getString("full_name"));
                bean.setAge(result.getInt("age"));
                bean.setGender(result.getString("gender"));
                bean.setEmail(result.getString("email"));
                bean.setPhoneNumber(result.getString("phone_number"));
                bean.setDate(result.getString("entry_date"));

                students.add(bean);
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

        return students;
    }

    public LinkedHashMap<String, String> getStudentMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        ResultSet result = null;

        String query = "select * from students";

        connect = connection.getNewConnection();

        try {
            statement = connect.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {

                String studentId = result.getString("student_id");
                String fullName = result.getString("full_name");

                map.put(studentId, fullName);
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

        return map;
    }

    public static void main(String[] args) {

        StudentTest testBean = new StudentTest();

        String studentId = "MjjtS";

        testBean.testAddStudentData();

        testBean.testUpdateStudentData(studentId);

        testBean.testDeleteStudentData(studentId);

        testBean.testGetStudentData(studentId);

        testBean.testGetStudentList();
    }

}
