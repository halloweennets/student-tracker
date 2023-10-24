/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Tests.CourseTest;
import beans.CourseBean;
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
public class CourseDAO {

    SQLConnection connection = new SQLConnection();
    Connection connect = null;
    PreparedStatement ps = null;
    Statement statement = null;

    /**
     * This method handles Course creation in the database
     *
     * @param bean
     * @return int
     */
    public int addCourseData(CourseBean bean) {

        int status = -1;

        String query = "insert into courses values(?,?,?,?,?)";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getCourseId());
            ps.setString(2, bean.getInstructorID());
            ps.setString(3, bean.getCourseName());
            ps.setInt(4, bean.getUnit());
            ps.setString(5, bean.getDate());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     * This method handles Course Update in the database
     *
     * @param bean
     * @return int
     */
    public int updateCourseData(CourseBean bean) {

        int status = -1;

        String query = "update courses set instructor_id = ?, course_name=?, unit=?, where course_id = ?";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getInstructorID());
            ps.setString(2, bean.getCourseName());
            ps.setInt(3, bean.getUnit());
            ps.setString(4, bean.getCourseId());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     * This method deletes Course record from database
     *
     * @param CourseId
     * @return
     */
    public int deleteCourseData(String courseId) {

        int status = -1;

        String query = "delete from courses where course_id=?";

        connect = connection.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, courseId);

            status = ps.executeUpdate();
            if (status > 0) {
                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     *
     * This method gets Course Data from database
     *
     * @param Cc
     */
    public CourseBean getCourseData(String courseId) {
        CourseBean bean = new CourseBean();

        ResultSet result = null;

        String query = "select * from courses where course_id=?";

        connect = connection.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, courseId);

            result = ps.executeQuery();
            if (result.next()) {
                bean.setCourseId(result.getString("course_id"));
                bean.setInstructorID(result.getString("Instructor_id"));
                bean.setCourseName(result.getString("course_name"));
                bean.setUnit(result.getInt("unit"));
                bean.setDate(result.getString("entry_date"));

            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return bean;

    }

    public List<CourseBean> getCourseList() {

        List<CourseBean> courses = new ArrayList<>();

        ResultSet result = null;

        String query = "select * from courses";

        connect = connection.getNewConnection();

        try {

            statement = connect.createStatement();

            result = statement.executeQuery(query);
            while (result.next()) {

                CourseBean bean = new CourseBean();

                bean.setCourseId(result.getString("course_id"));
                bean.setInstructorID(result.getString("Instructor_Id"));
                bean.setCourseName(result.getString("course_name"));
                bean.setUnit(result.getInt("unit"));
                bean.setDate(result.getString("entry_date"));

                courses.add(bean);
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

        return courses;
    }

    public LinkedHashMap<String, String> getCourseMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        ResultSet result = null;

        String query = "select * from courses";

        connect = connection.getNewConnection();

        try {
            statement = connect.createStatement();
            result = statement.executeQuery(query);

            while (result.next()) {

                String courseId = result.getString("course_id");
                String courseName = result.getString("course_name");

                map.put(courseId, courseName);
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

        return map;
    }

    public static void main(String[] args) {

        CourseTest testBean = new CourseTest();

        String courseId = "MjjtS";
        String instructorId = "dHLe3";

        testBean.testAddCourseData();
//
        testBean.testUpdateCourseData(courseId);

        testBean.testDeleteCourseData(courseId);

        testBean.testGetCourseData(courseId);

        testBean.testGetCourseList();
    }

}
