<%-- 
    Document   : index.jsp
    Created on : Aug 22, 2023, 10:46:47 AM
    Author     : sleader
--%>
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
    <body id="kt_body" class="header-fixed">
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
                            <!--begin::Card-->
                            <div class="card">
                                <!--begin::Card body-->
                                <div class="card-body p-0">
                                    <!--begin::Wrapper-->
                                    <div class="card-px text-center py-20 my-10">
                                        <!--begin::Title-->
                                        <h2 class="fs-2x fw-bold mb-10">Welcome to Customers App</h2>
                                        <!--end::Title-->
                                        <!--begin::Description-->
                                        <p class="text-gray-400 fs-4 fw-semibold mb-10">There are no customers added yet.
                                            <br />Kickstart your CRM by adding a your first customer</p>
                                        <!--end::Description-->
                                        <!--begin::Action-->
                                        <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#kt_modal_add_customer">Add a Student</a>
                                        <!--end::Action-->
                                    </div>
                                    <!--end::Wrapper-->
                                    <!--begin::Illustration-->
                                    <div class="text-center px-4">
                                        <img class="mw-100 mh-300px" alt="" src="assets/media/illustrations/dozzy-1/2.png" />
                                    </div>
                                    <!--end::Illustration-->
                                </div>
                                <!--end::Card body-->
                            </div>
                            <!--end::Card-->
                            <!--begin::Modals-->
                            <!--begin::Modal - Customers - Add-->
                           
                            <jsp:include  page="modal_add_student.jsp" flush="true"  />
                            
                            <!--end::Modal - Customers - Add-->
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
        <script src=".https://cdn.amcharts.com/lib/5/index.js"></script>
        <script src=".https://cdn.amcharts.com/lib/5/xy.js"></script>
        <script src=".https://cdn.amcharts.com/lib/5/percent.js"></script>
        <script src=".https://cdn.amcharts.com/lib/5/radar.js"></script>
        <script src=".https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
        <script src=".https://cdn.amcharts.com/lib/5/map.js"></script>
        <script src=".https://cdn.amcharts.com/lib/5/geodata/worldLow.js"></script>
        <script src=".https://cdn.amcharts.com/lib/5/geodata/continentsLow.js"></script>
        <script src=".https://cdn.amcharts.com/lib/5/geodata/usaLow.js"></script>
        <script src=".https://cdn.amcharts.com/lib/5/geodata/worldTimeZonesLow.js"></script>
        <script src=".https://cdn.amcharts.com/lib/5/geodata/worldTimeZoneAreasLow.js"></script>
        <script src="assets/plugins/custom/datatables/datatables.bundle.js"></script>
        <!--end::Vendors Javascript-->
        <!--begin::Custom Javascript(used for this page only)-->
        <script src="assets/js/widgets.bundle.js"></script>
        <script src="assets/js/custom/widgets.js"></script>
        <script src="assets/js/custom/apps/chat/chat.js"></script>
        <script src="assets/js/custom/utilities/modals/users-search.js"></script>
        
        <script src="assets/js/custom/apps/customers/list/export.js"></script>
		<script src="assets/js/custom/apps/customers/list/list.js"></script>
		<script src="assets/js/custom/apps/customers/add.js"></script>
        <!--end::Custom Javascript-->
        <!--end::Javascript-->
    </body>

    <!--end::Body-->
</html>
