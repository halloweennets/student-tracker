<%-- 
    Document   : modal_add_instructor
    Created on : Aug 29, 2023, 1:12:10 PM
    Author     : t
--%>

<%@page import="DAO.StudentDAO"%>
<%@page import="DAO.CourseDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="DAO.InstructorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin::Modal - Customers - Add-->
<div class="modal fade" id="kt_modal_add_customer" tabindex="-1" aria-hidden="true">
    <!--begin::Modal dialog-->
    <div class="modal-dialog modal-dialog-centered mw-650px">
        <!--begin::Modal content-->
        <div class="modal-content">
            <!--begin::Form-->
            <form class="form" action="jp.do?action=process-reg" method="POST" id="kt_modal_add_customer_form" data-kt-redirect="jp.do?action=reg-list">
                <!--begin::Modal header-->
                <div class="modal-header" id="kt_modal_add_customer_header">
                    <!--begin::Modal title-->
                    <h2 class="fw-bold">Add a Course</h2>
                    <!--end::Modal title-->
                    <!--begin::Close-->
                    <div id="kt_modal_add_customer_close" class="btn btn-icon btn-sm btn-active-icon-primary">
                        <i class="ki-duotone ki-cross fs-1">
                            <span class="path1"></span>
                            <span class="path2"></span>
                        </i>
                    </div>
                    <!--end::Close-->
                </div>
                <!--end::Modal header-->
                <!--begin::Modal body-->

                <div class="modal-body py-10 px-lg-17">
                    <!--begin::Scroll-->
                    <div class="scroll-y me-n7 pe-7" id="kt_modal_add_customer_scroll" data-kt-scroll="true" data-kt-scroll-activate="{default: false, lg: true}" data-kt-scroll-max-height="auto" data-kt-scroll-dependencies="#kt_modal_add_customer_header" data-kt-scroll-wrappers="#kt_modal_add_customer_scroll" data-kt-scroll-offset="300px">

                        <!--begin::Input group-->
                        <div class="d-flex flex-column mb-7 fv-row">
                            <!--begin::Label-->
                            <label class="fs-6 fw-semibold mb-2">
                                <span class="required">Student</span>
                            </label>
                            <!--end::Label-->
                            <!--begin::Input-->

                            <select name="studentId" aria-label="Select Student" data-control="select2" data-placeholder="Select Student..." data-dropdown-parent="#kt_modal_add_customer" class="form-select form-select-solid fw-bold">
                                <%
                                    StudentDAO studentDAO = new StudentDAO();

                                    LinkedHashMap studentMap = null;

                                    studentMap = studentDAO.getStudentMap();
                                    if (studentMap.isEmpty()) {
                                        out.print("<option value=''>No data found...</option>");
                                    } else {
                                        out.print("<option value=''>Select Student...</option>");
                                        Set keys = studentMap.keySet();
                                        Iterator itr = keys.iterator();
                                        for (int i = 0; i < keys.size(); i++) {
                                            String id = itr.next().toString();
                                            String name = studentMap.get(id).toString();

                                            out.print("<option value='" + id + "'");
                                            if (id.equals("")) {
                                                out.println("selected='true'");
                                            }

                                            out.println(">" + name + "</option>");
                                        }
                                    }
                                %> 

                            </select>
                        </div>

                        <!--begin::Input group-->
                        <div class="d-flex flex-column mb-7 fv-row">
                            <!--begin::Label-->
                            <label class="fs-6 fw-semibold mb-2">
                                <span class="required">Course</span>
                            </label>
                            <!--end::Label-->
                            <!--begin::Input-->

                            <select name="courseId" aria-label="Select Course" data-control="select2" data-placeholder="Select Course..." data-dropdown-parent="#kt_modal_add_customer" class="form-select form-select-solid fw-bold">
                                <%
                                    CourseDAO courseDAO = new CourseDAO();

                                    LinkedHashMap courseMap = null;

                                    courseMap = courseDAO.getCourseMap();
                                    if (courseMap.isEmpty()) {
                                        out.print("<option value=''>No data found...</option>");
                                    } else {
                                        out.print("<option value=''>Select Course...</option>");
                                        Set keys = courseMap.keySet();
                                        Iterator itr = keys.iterator();
                                        for (int i = 0; i < keys.size(); i++) {
                                            String id = itr.next().toString();
                                            String name = courseMap.get(id).toString();

                                            out.print("<option value='" + id + "'");
                                            if (id.equals("")) {
                                                out.println("selected='true'");
                                            }

                                            out.println(">" + name + "</option>");
                                        }
                                    }
                                %> 

                            </select>
                        </div>
                        </div>
                        <!--end::Input group-->


                        
                </div>

                <!--end::Modal body-->
                <!--begin::Modal footer-->
                <div class="modal-footer flex-center">
                    <!--begin::Button-->
                    <button type="reset" id="kt_modal_add_customer_cancel" class="btn btn-light me-3">Discard</button>
                    <!--end::Button-->
                    <!--begin::Button-->
                    <!--The id="kt_modal_add_customer_submit" triggers a JS code to show success or failed modal which i removed to accomodate my servlet-->
                    <!--<button type="submit" id="kt_modal_add_customer_submit" class="btn btn-primary">-->

                    <button type="submit" name="buttonName" value="Submit" class="btn btn-success">
                        Submit
                    </button>
                    <!--end::Button-->
                </div>
                <!--end::Modal footer-->
            </form>
            <!--end::Form-->
        </div>
    </div>
</div>