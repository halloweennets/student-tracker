/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Tests.ExamTest;
import beans.ExamBean;
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
public class ExamDAO {

    SQLConnection connection = new SQLConnection();
    Connection connect = null;
    PreparedStatement ps = null;
    Statement statement = null;

    /**
     * This method handles exam creation in the database
     *
     * @param bean
     * @return int
     */
    public int addExamData(ExamBean bean) {

        int status = -1;

        String query = "insert into exams values(?,?,?,?,?)";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getExamId());
            ps.setString(2, bean.getStudentId());
            ps.setString(3, bean.getCourseId());
            ps.setInt(4, bean.getExamScore());
            ps.setString(5, bean.getDate());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
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
    public int updateExamData(ExamBean bean) {

        int status = -1;

        String query = "update exams set student_id = ?, course_id=?, exam_score=? where exam_id = ?";

        connect = connection.getNewConnection();
        try {
            ps = connect.prepareStatement(query);

            ps.setString(1, bean.getStudentId());
            ps.setString(2, bean.getCourseId());
            ps.setInt(3, bean.getExamScore());
            ps.setString(4, bean.getExamId());

            status = ps.executeUpdate();

            if (status > 0) {

                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     * This method deletes exam record from database
     *
     * @param examId
     * @return
     */
    public int deleteExamData(String examId) {

        int status = -1;

        String query = "delete from exams where exam_id=?";

        connect = connection.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, examId);

            status = ps.executeUpdate();
            if (status > 0) {
                status = 0;
            } else {
                status = 1;
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return status;
    }

    /**
     *
     * This method gets Student Data from database
     *
     * @param examId
     * @return
     */
    public ExamBean getExamData(String examId) {
        ExamBean bean = new ExamBean();

        ResultSet result = null;

        String query = "select * from exams where exam_id=?";

        connect = connection.getNewConnection();

        try {

            ps = connect.prepareStatement(query);
            ps.setString(1, examId);

            result = ps.executeQuery();
            if (result.next()) {
               bean.setExamId(result.getString("exam_id"));
                bean.setStudentId(result.getString("student_id"));
                bean.setCourseId(result.getString("course_id"));
                bean.setExamScore(result.getInt("exam_score"));
                bean.setDate(result.getString("entry_date"));

            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

        }

        return bean;

    }

    public List<ExamBean> getExamList() {

        List<ExamBean> exams = new ArrayList<>();

        ResultSet result = null;

        String query = "select * from exams";

        connect = connection.getNewConnection();

        try {

            statement = connect.createStatement();

            result = statement.executeQuery(query);
            while (result.next()) {

                ExamBean bean = new ExamBean();

                bean.setExamId(result.getString("exam_id"));
                bean.setStudentId(result.getString("student_id"));
                bean.setCourseId(result.getString("course_id"));
                bean.setExamScore(result.getInt("exam_score"));
                bean.setDate(result.getString("entry_date"));

                exams.add(bean);
            }

        } catch (SQLException ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }

            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("Exception" + ex);
                    Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

        return exams;
    }

    public static void main(String[] args) {

        ExamTest testBean = new ExamTest();

        String examId = "";

        testBean.testAddExamData();

        testBean.testUpdateExamData(examId);

        testBean.testDeleteExamData(examId);

        testBean.testGetExamData(examId);

        testBean.testGetExamList();
    }

}
