<%-- 
    Document   : index.jsp
    Created on : Aug 22, 2023, 10:46:47 AM
    Author     : sleader
--%>
<%@page import="beans.StudentBean"%>
<%@page import="DAO.StudentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!--begin::Head-->
    <head><base href=""/>
        <jsp:include page="../main_title.jsp" flush="true"/>
        <meta charset="utf-8" />
        <meta name="description" content="The most advanced Bootstrap 5 Admin Theme with 40 unique prebuilt layouts on Themeforest trusted by 100,000 beginners and professionals. Multi-demo, Dark Mode, RTL support and complete React, Angular, Vue, Asp.Net Core, Rails, Spring, Blazor, Django, Express.js, Node.js, Flask, Symfony & Laravel versions. Grab your copy now and get life-time updates for free." />
        <meta name="keywords" content="metronic, bootstrap, bootstrap 5, angular, VueJs, React, Asp.Net Core, Rails, Spring, Blazor, Django, Express.js, Node.js, Flask, Symfony & Laravel starter kits, admin themes, web design, figma, web development, free templates, free admin themes, bootstrap theme, bootstrap template, bootstrap dashboard, bootstrap dak mode, bootstrap button, bootstrap datepicker, bootstrap timepicker, fullcalendar, datatables, flaticon" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta property="og:locale" content="en_US" />
        <meta property="og:type" content="article" />
        <meta property="og:title" content="Metronic - Bootstrap Admin Template, HTML, VueJS, React, Angular. Laravel, Asp.Net Core, Ruby on Rails, Spring Boot, Blazor, Django, Express.js, Node.js, Flask Admin Dashboard Theme & Template" />
        <meta property="og:url" content="https://keenthemes.com/metronic" />
        <meta property="og:site_name" content="Keenthemes | Metronic" />
        <link rel="canonical" href="https://preview.keenthemes.com/metronic8" />
        <link rel="shortcut icon" href="assets/media/logos/favicon.ico" />
        <!--begin::Fonts(mandatory for all pages)-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter:300,400,500,600,700" />
        <!--end::Fonts-->
        <!--begin::Vendor Stylesheets(used for this page only)-->
        <link href="assets/plugins/custom/fullcalendar/fullcalendar.bundle.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/custom/datatables/datatables.bundle.css" rel="stylesheet" type="text/css" />
        <!--end::Vendor Stylesheets-->
        <!--begin::Global Stylesheets Bundle(mandatory for all pages)-->
        <link href="assets/plugins/global/plugins.bundle.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style.bundle.css" rel="stylesheet" type="text/css" />
        <!--end::Global Stylesheets Bundle-->
    </head>
    <!--end::Head-->
    <!--begin::Body-->
    <body id="kt_body" class="header-fixed ">
        <!--begin::Theme mode setup on page load-->
        <script>var defaultThemeMode = "light";
            var themeMode;
            if (document.documentElement) {
                if (document.documentElement.hasAttribute("data-bs-theme-mode")) {
                    themeMode = document.documentElement.getAttribute("data-bs-theme-mode");
                } else {
                    if (localStorage.getItem("data-bs-theme") !== null) {
                        themeMode = localStorage.getItem("data-bs-theme");
                    } else {
                        themeMode = defaultThemeMode;
                    }
                }
                if (themeMode === "system") {
                    themeMode = window.matchMedia("(prefers-color-scheme: dark)").matches ? "dark" : "light";
                }
                document.documentElement.setAttribute("data-bs-theme", themeMode);
            }</script>
        <!--end::Theme mode setup on page load-->

        <div class="d-flex flex-column flex-root">
            <!--begin::Page-->
            <div class="page d-flex flex-row flex-column-fluid">
                <div class="wrapper d-flex flex-column flex-row-fluid" id="kt_wrapper">

                    <jsp:include page="../main_header.jsp" flush="true"/>



                    <!--begin::Content-->
                    <div class="content d-flex flex-column flex-column-fluid" id="kt_content">


                        <!--begin::Container-->
                        <div class="container-xxl" id="kt_content_container">

                            <%

                                StudentDAO studentDAO = new StudentDAO();
                                StudentBean bean = new StudentBean();

                                String studentId = "";
                                String fullName = "";
                                int age = 0;
                                String gender = "";
                                String email = "";
                                String phoneNumber = "";
                                String date = "";

                                String buttonName = "Submit";
                                String buttonColour = "btn btn-success";

                                if (request.getParameter("studentId") != null) {

                                    if (request.getParameter("op").equals("update")) {
                                        studentId = String.valueOf(request.getParameter("studentId"));

                                        StudentBean sb = studentDAO.getStudentData(studentId);

                                        studentId = sb.getStudentId();
                                        fullName = sb.getFullName();
                                        age = sb.getAge();
                                        gender = sb.getGender();
                                        email = sb.getEmail();
                                        phoneNumber = sb.getPhoneNumber();
                                        date = sb.getDate();

                                        buttonName = "Update";
                                        buttonColour = "btn btn-primary";
                                    } else if (request.getParameter("op").equals("delete")) {

                                        studentId = String.valueOf(request.getParameter("studentId"));

                                        StudentBean sb = studentDAO.getStudentData(studentId);

                                        studentId = sb.getStudentId();
                                        fullName = sb.getFullName();
                                        age = sb.getAge();
                                        gender = sb.getGender();
                                        email = sb.getEmail();
                                        phoneNumber = sb.getPhoneNumber();
                                        date = sb.getDate();

                                        buttonName = "Delete";
                                        buttonColour = "btn btn-danger";
                                    }
                                }

                            %>

                            <%                                if (request.getAttribute("errorMsg") != null) {
                                    String errorMsg = String.valueOf(request.getAttribute("errorMsg"));
                                    out.print("<div class='alert alert-danger' role='alert'> " + errorMsg + " </div>");
                                } else {
                                    out.print("");
                                }
                            %>



                            <%
                                //if(request.getAttribute("errorMsg")!=null){
                                //String errorMsg = String.valueOf(request.getAttribute("errorMsg"));
                            %>
                            <!--When displaying errorMsg using the method, inject the code with a jsp inject expression tag-->
                            <!--<div class="alert alert-danger" role='alert'> errorMsg  </div>-->
                            <%                                //}else{
                                //out.print("");
                                //}

                            %>


                            <!--begin::Card-->
                            <div class="card">


                                <!--begin::Card body-->
                                <div class="card-body p-5">

                                    <form class="form" action="jp.do?action=process-student" method="POST" id="kt_modal_add_customer_form" data-kt-redirect="jp.do?action=student-list">
                                        <!--begin::Modal header-->
                                        <div class="modal-header" id="kt_modal_add_customer_header">
                                            <!--begin::Modal title-->
                                            <h2 class="fw-bold">Add a Student</h2>
                                            <!--end::Modal title-->
                                        </div>
                                        <!--end::Modal header-->
                                        <!--begin::Modal body-->
                                        <div class="modal-body py-10 px-lg-17">
                                            <!--begin::Scroll-->
                                            <div class="scroll-y me-n7 pe-7" id="kt_modal_add_customer_scroll" data-kt-scroll="true" data-kt-scroll-activate="{default: false, lg: true}" data-kt-scroll-max-height="auto" data-kt-scroll-dependencies="#kt_modal_add_customer_header" data-kt-scroll-wrappers="#kt_modal_add_customer_scroll" data-kt-scroll-offset="300px">
                                               <input type="hidden" class="form-control form-control-solid" placeholder="Student ID" name="studentId" value="<%=studentId%>"/>
                                                <!--begin::Input group-->
                                                <div class="fv-row mb-7">
                                                    <!--begin::Label-->
                                                    <label class="required fs-6 fw-semibold mb-2">Full Name</label>
                                                    <!--end::Label-->
                                                    <!--begin::Input-->
                                                    <input type="text" class="form-control form-control-solid" placeholder="Full Name" name="fullName" value="<%=fullName%>"/>
                                                    <!--end::Input-->
                                                </div>
                                                <!--end::Input group-->
                                                <!--begin::Input group-->
                                                <div class="fv-row mb-7">
                                                    <!--begin::Label-->
                                                    <label class="fs-6 fw-semibold mb-2">
                                                        <span class="required">Email</span>
                                                        <span class="ms-1" data-bs-toggle="tooltip" title="Email address must be active">
                                                            <i class="ki-duotone ki-information fs-7">
                                                                <span class="path1"></span>
                                                                <span class="path2"></span>
                                                                <span class="path3"></span>
                                                            </i>
                                                        </span>
                                                    </label>
                                                    <!--end::Label-->
                                                    <!--begin::Input-->
                                                    <input type="email" class="form-control form-control-solid" placeholder="example@gmail.com" name="email" value="<%=email%>"/>
                                                    <!--end::Input-->
                                                </div>
                                                <!--end::Input group-->

                                                <!--begin::Input group-->
                                                <div class="d-flex flex-column mb-7 fv-row">
                                                    <!--begin::Label-->
                                                    <label class="fs-6 fw-semibold mb-2">
                                                        <span class="required">Age</span>

                                                    </label>
                                                    <!--end::Label-->
                                                    <!--begin::Input-->
                                                    <%
                                                        String selected = "";
                                                    %>
                                                    <select name="age" aria-label="Select Age" data-control="select2" data-placeholder="Select Age..." data-dropdown-parent="#kt_modal_add_customer" class="form-select form-select-solid fw-bold">
                                                        <option value="" selected="<%if(age<=0){selected="false";}%>">Select Age...</option>
                                                        <option value="4" selected="<%if(age==4){selected="true";}%>">4</option>
                                                        <option value="10" selected="<%if(age==10){selected="true";}%>">10</option>
                                                        <option value="15" selected="<%if(age==15){selected="true";}%>">15</option>
                                                        <option value="16" selected="<%if(age==16){selected="true";}%>">16</option>
                                                        <option value="17" selected="<%if(age==17){selected="true";}%>">17</option>
                                                        <option value="18" selected="<%if(age==18){selected="true";}%>">18</option>
                                                        <option value="19" selected="<%if(age==19){selected="true";}%>">19</option>
                                                        <option value="20" selected="<%if(age==20){selected="true";}%>">20</option>
                                                    </select>
                                                    <!--end::Input-->
                                                </div>

                                                <!--begin::Input group-->
                                                <div class="fv-row mb-7">
                                                    <!--begin::Label-->
                                                    <label class="required fs-6 fw-semibold mb-2">Phone Number</label>
                                                    <!--end::Label-->
                                                    <!--begin::Input-->
                                                    <input type="number" class="form-control form-control-solid" placeholder="Phone Number" name="phoneNumber" value="<%=phoneNumber%>" />
                                                    <!--end::Input-->
                                                </div>
                                                <!--end::Input group-->

                                                <!--begin::Input group-->
                                                <div class="d-flex flex-column mb-7 fv-row">
                                                    <!--begin::Label-->
                                                    <label class="fs-6 fw-semibold mb-2">
                                                        <span class="required">Gender</span>
                                                    </label>
                                                    <!--end::Label-->
                                                    <!--begin::Input-->
                                                    <%
                                                        String selectedGender = "";
                                                    %>
                                                    <select name="gender" aria-label="Select Gender" data-control="select2" data-placeholder="Select Gender..." data-dropdown-parent="#kt_modal_add_customer" class="form-select form-select-solid fw-bold">
                                                        <option value="">Select Gender...</option>
                                                        <option value="male" selected="<%if(gender.equals("male")){selectedGender="true";}%>">Male</option>
                                                        <option value="female" selected="<%if(gender.equals("female")){selectedGender="true";}%>">Female</option>
                                                    </select>
                                                    <!--end::Input-->
                                                </div>
                                            </div>
                                            <!--end::Scroll-->
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

                                            <button type="submit" name="buttonName" value="<%=buttonName%>" class="<%=buttonColour%>">
                                                <%=buttonName%>
                                            </button>
                                            <!--end::Button-->
                                        </div>
                                        <!--end::Modal footer-->
                                    </form>


                                </div>
                                <!--end::Card body-->
                            </div>
                            <!--end::Card-->
                            <!--begin::Modals-->

                            <jsp:include page="modal_add_student.jsp" flush="true"/>

                            <!--end::Modals-->
                        </div>
                        <!--end::Container-->
                    </div>


                    <!--end::Content-->

                    <jsp:include page="../main_footer.jsp" flush="true"/>

                </div>


                <jsp:include page="../main_nav.jsp" flush="true"/>


            </div>

        </div>
        <!--end::Modal - Users Search-->
        <!--end::Modals-->
        <!--begin::Javascript-->
        <script>var hostUrl = "assets/";</script>
        <!--begin::Global Javascript Bundle(mandatory for all pages)-->
        <script src="assets/plugins/global/plugins.bundle.js"></script>
        <script src="assets/js/scripts.bundle.js"></script>
        <!--end::Global Javascript Bundle-->
        <!--begin::Vendors Javascript(used for this page only)-->
        <script src="assets/plugins/custom/fullcalendar/fullcalendar.bundle.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/index.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/percent.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/radar.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/map.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/geodata/worldLow.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/geodata/continentsLow.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/geodata/usaLow.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/geodata/worldTimeZonesLow.js"></script>
        <script src="https://cdn.amcharts.com/lib/5/geodata/worldTimeZoneAreasLow.js"></script>
        <script src="assets/plugins/custom/datatables/datatables.bundle.js"></script>
        <!--end::Vendors Javascript-->
        <!--begin::Custom Javascript(used for this page only)-->
        <script src="assets/js/widgets.bundle.js"></script>
        <script src="assets/js/custom/widgets.js"></script>
        <script src="assets/js/custom/apps/chat/chat.js"></script>
        <script src="assets/js/custom/utilities/modals/users-search.js"></script>
        <!--end::Custom Javascript-->
        <!--begin::Custom Javascript(used for this page only)-->
        <script src="assets/js/custom/apps/customers/list/export.js"></script>
        <script src="assets/js/custom/apps/customers/list/list.js"></script>
        <script src="assets/js/custom/apps/customers/add.js"></script>

        <!--end::Javascript-->
    </body>

    <!--end::Body-->
</html>
