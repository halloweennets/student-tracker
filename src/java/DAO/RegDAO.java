/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Tests.RegTest;
import beans.RegBean;
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

/**
 *
 * @author t
 */
public class RegDAO {

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
    public int addRegData(RegBean bean) {

        int status = -1;

        String query = "insert into course_regs values(?,?,?,?)";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getRegId());
            ps.setString(2, bean.getStudentId());
            ps.setString(3, bean.getCourseId());
            ps.setString(4, bean.getDate());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     * This method handles Course Registration Update in the database
     *
     * @param bean
     * @return int
     */
    public int updateRegData(RegBean bean) {

        int status = -1;

        String query = "update course_regs set student_id = ?, course_id=? where course_reg_id = ?";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getStudentId());
            ps.setString(2, bean.getCourseId());
            ps.setString(3, bean.getRegId());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     * This method deletes Course Registration from database
     *
     * @param regId
     * @return
     */
    public int deleteRegData(String regId) {

        int status = -1;

        String query = "delete from course_regs where course_reg_id=?";

        connect = connection.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, regId);

            status = ps.executeUpdate();
            if (status > 0) {
                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     *
     * This method gets course Registration Data from database
     *
     * @param regId
     * @return
     */
    public RegBean getRegData(String regId) {
        RegBean bean = new RegBean();

        ResultSet result = null;

        String query = "select * from course_regs where course_reg_id=?";

        connect = connection.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, regId);

            result = ps.executeQuery();
            if (result.next()) {
                bean.setRegId(result.getString("course_reg_id"));
                bean.setStudentId(result.getString("student_id"));
                bean.setCourseId(result.getString("course_id"));
                bean.setDate(result.getString("entry_date"));

            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return bean;

    }

    public List<RegBean> getRegList() {

        List<RegBean> regs = new ArrayList<>();

        ResultSet result = null;

        String query = "select * from course_regs";

        connect = connection.getNewConnection();

        try {

            statement = connect.createStatement();

            result = statement.executeQuery(query);
            while (result.next()) {

                RegBean bean = new RegBean();

                bean.setRegId(result.getString("course_reg_id"));
                bean.setStudentId(result.getString("student_id"));
                bean.setCourseId(result.getString("course_id"));
                bean.setDate(result.getString("entry_date"));

                regs.add(bean);
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(RegDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

        return regs;
    }

    public static void main(String[] args) {

        RegTest testBean = new RegTest();

       

        testBean.testAddRegData();

//        testBean.testUpdateRegData(regId);
//
//        testBean.testDeleteRegData(regId);
//
//        testBean.testGetRegData(regId);
//
//        testBean.testGetRegList();
    }

}
