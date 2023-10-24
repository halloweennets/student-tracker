/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Tests.InstructorTest;
import beans.InstructorBean;
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
import Utils.Utility;
import java.util.LinkedHashMap;

/**
 *
 * @author t
 */
public class InstructorDAO {

    SQLConnection connection = new SQLConnection();
    Connection connect = null;
    PreparedStatement ps = null;
    Statement statement = null;

    /**
     * This method handles instructor creation in the database
     *
     * @param bean
     * @return int
     */
    public int addInstructorData(InstructorBean bean) {

        int status = -1;

        String query = "insert into instructors values(?,?,?,?,?)";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getInstructorId());
            ps.setString(2, bean.getFullName());

            ps.setString(3, bean.getEmail());
            ps.setString(4, bean.getMobileNumber());
            ps.setString(5, bean.getDate());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     * This method handles instructor Update in the database
     *
     * @param bean
     * @return int
     */
    public int updateInstructorData(InstructorBean bean) {
        int status = -1;
        String query = "update instructors set full_name = ?, email=?, mobile_number=? where Instructor_id = ?";
        connect = connection.getNewConnection();

        try {
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getFullName());
            ps.setString(2, bean.getEmail());
            ps.setString(3, bean.getMobileNumber());
            ps.setString(4, bean.getInstructorId());

            // Print the SQL query
            System.out.println("SQL Query: " + ps.toString());

            status = ps.executeUpdate();

            if (status > 0) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            // Close resources
        }

        return status;
    }

    /**
     * This method deletes instructor record from database
     *
     * @param instructorId
     * @return
     */
    public int deleteInstructorData(String instructorId) {

        int status = -1;

        String query = "delete from instructors where Instructor_id=?";

        connect = connection.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, instructorId);

            status = ps.executeUpdate();
            if (status > 0) {
                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     *
     * This method gets instructor Data from database
     *
     * @param instructorId
     * @return
     */
    public InstructorBean getInstructorData(String instructorId) {
        InstructorBean bean = new InstructorBean();

        ResultSet result = null;

        String query = "select * from instructors where instructor_id=?";

        connect = connection.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, instructorId);

            result = ps.executeQuery();
            if (result.next()) {
                bean.setInstructorId(result.getString("instructor_id"));
                bean.setFullName(result.getString("full_name"));

                bean.setEmail(result.getString("email"));
                bean.setMobileNumber(result.getString("mobile_number"));
                bean.setDate(result.getString("entry_date"));

            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return bean;

    }

    public List<InstructorBean> getInstructorList() {

        List<InstructorBean> instructors = new ArrayList<>();

        ResultSet result = null;

        String query = "select * from instructors";

        connect = connection.getNewConnection();

        try {

            statement = connect.createStatement();

            result = statement.executeQuery(query);
            while (result.next()) {

                InstructorBean bean = new InstructorBean();

                bean.setInstructorId(result.getString("instructor_id"));
                bean.setFullName(result.getString("full_name"));

                bean.setEmail(result.getString("email"));
                bean.setMobileNumber(result.getString("mobile_number"));
                bean.setDate(result.getString("entry_date"));

                instructors.add(bean);
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

        return instructors;
    }

    public LinkedHashMap<String, String> getInstructorMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        ResultSet result = null;

        String query = "select * from instructors";

        connect = connection.getNewConnection();

        try {
            statement = connect.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {

                String instructorId = result.getString("Instructor_id");
                String fullName = result.getString("full_name");

                map.put(instructorId, fullName);
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(InstructorDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

        return map;
    }

    public static void main(String[] args) {

        InstructorTest testBean = new InstructorTest();

        String instructorId = "260iI";

        testBean.testAddInstructorData();

        testBean.testUpdateInstructorData(instructorId);

        testBean.testDeleteInstructorData(instructorId);

        testBean.testGetInstructorData(instructorId);

        testBean.testGetInstructorList();
    }

}
