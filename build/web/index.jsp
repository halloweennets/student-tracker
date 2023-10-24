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
        <jsp:include page="main_title.jsp" flush="true"/>
        <meta charset="utf-8"/>
        <meta name="description" content="The most advanced Bootstrap 5 Admin Theme with 40 unique prebuilt layouts on Themeforest trusted by 100,000 beginners and professionals. Multi-demo, Dark Mode, RTL support and complete React, Angular, Vue, Asp.Net Core, Rails, Spring, Blazor, Django, Express.js, Node.js, Flask, Symfony & Laravel versions. Grab your copy now and get life-time updates for free." />
        <meta name="keywords" content="metronic, bootstrap, bootstrap 5, angular, VueJs, React, Asp.Net Core, Rails, Spring, Blazor, Django, Express.js, Node.js, Flask, Symfony & Laravel starter kits, admin themes, web design, figma, web development, free templates, free admin themes, bootstrap theme, bootstrap template, bootstrap dashboard, bootstrap dak mode, bootstrap button, bootstrap datepicker, bootstrap timepicker, fullcalendar, datatables, flaticon" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta property="og:locale" content="en_US" />
        <meta property="og:type" content="article" />
        <meta property="og:title" content="Metronic - Bootstrap Admin Template, HTML, VueJS, React, Angular. Laravel, Asp.Net Core, Ruby on Rails, Spring Boot, Blazor, Django, Express.js, Node.js, Flask Admin Dashboard Theme & Template" />
        <meta property="og:url" content="https://keenthemes.com/metronic" />
        <meta property="og:site_name" content="Keenthemes | Metronic" />
        <link rel="canonical" href="https://preview.keenthemes.com/metronic8" />
        <link rel="shortcut icon" href="./assets/media/logos/favicon.ico" />
        <!--begin::Fonts(mandatory for all pages)-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter:300,400,500,600,700" />
        <!--end::Fonts-->
        <!--begin::Vendor Stylesheets(used for this page only)-->
        <link href="./assets/plugins/custom/fullcalendar/fullcalendar.bundle.css" rel="stylesheet" type="text/css" />
        <link href="./assets/plugins/custom/datatables/datatables.bundle.css" rel="stylesheet" type="text/css" />
        <!--end::Vendor Stylesheets-->
        <!--begin::Global Stylesheets Bundle(mandatory for all pages)-->
        <link href="./assets/plugins/global/plugins.bundle.css" rel="stylesheet" type="text/css" />
        <link href="./assets/css/style.bundle.css" rel="stylesheet" type="text/css" />
        <!--end::Global Stylesheets Bundle-->
    </head>
    <!--end::Head-->
    <!--begin::Body-->
    <body id="kt_body" class="header-fixed sidebar-enabled">
        <!--begin::Theme mode setup on page load-->
        <script>var defaultThemeMode = "light"; var themeMode; if (document.documentElement) {
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
					
                     <jsp:include page="main_header.jsp" flush="true"/>
                                        
					<!--begin::Content-->
					<div class="content d-flex flex-column flex-column-fluid" id="kt_content">
						<!--begin::Container-->
						<div class="container-xxl" id="kt_content_container">
                                                    
                                                     <jsp:include page="main_cards.jsp" flush="true"/>
                                                     
                                                        
							<!--begin::Tables Widget 9-->
							<div class="card mb-5 mb-xl-10">
								<!--begin::Header-->
								<div class="card-header border-0 pt-5">
									<h3 class="card-title align-items-start flex-column">
										<span class="card-label fw-bold fs-3 mb-1">Members Statistics</span>
										<span class="text-muted mt-1 fw-semibold fs-7">Over 500 members</span>
									</h3>
									<div class="card-toolbar" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-trigger="hover" title="Click to add a user">
										<a href="#" class="btn btn-sm btn-light btn-active-primary" data-bs-toggle="modal" data-bs-target="#kt_modal_invite_friends">
										<i class="ki-duotone ki-plus fs-2"></i>New Member</a>
									</div>
								</div>
								<!--end::Header-->
								<!--begin::Body-->
								<div class="card-body py-3">
									<!--begin::Table container-->
									<div class="table-responsive">
										<!--begin::Table-->
										<table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
											<!--begin::Table head-->
											<thead>
												<tr class="fw-bold text-muted">
													<th class="w-25px">
														<div class="form-check form-check-sm form-check-custom form-check-solid">
															<input class="form-check-input" type="checkbox" value="1" data-kt-check="true" data-kt-check-target=".widget-9-check" />
														</div>
													</th>
													<th class="min-w-200px">Authors</th>
													<th class="min-w-150px">Company</th>
													<th class="min-w-150px">Progress</th>
													<th class="min-w-100px text-end">Actions</th>
												</tr>
											</thead>
											<!--end::Table head-->
											<!--begin::Table body-->
											<tbody>
												<tr>
													<td>
														<div class="form-check form-check-sm form-check-custom form-check-solid">
															<input class="form-check-input widget-9-check" type="checkbox" value="1" />
														</div>
													</td>
													<td>
														<div class="d-flex align-items-center">
															<div class="symbol symbol-45px me-5">
																<img src="./assets/media/avatars/300-14.jpg" alt="" />
															</div>
															<div class="d-flex justify-content-start flex-column">
																<a href="#" class="text-dark fw-bold text-hover-primary fs-6">Ana Simmons</a>
																<span class="text-muted fw-semibold text-muted d-block fs-7">HTML, JS, ReactJS</span>
															</div>
														</div>
													</td>
													<td>
														<a href="#" class="text-dark fw-bold text-hover-primary d-block fs-6">Intertico</a>
														<span class="text-muted fw-semibold text-muted d-block fs-7">Web, UI/UX Design</span>
													</td>
													<td class="text-end">
														<div class="d-flex flex-column w-100 me-2">
															<div class="d-flex flex-stack mb-2">
																<span class="text-muted me-2 fs-7 fw-bold">50%</span>
															</div>
															<div class="progress h-6px w-100">
																<div class="progress-bar bg-primary" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</div>
													</td>
													<td>
														<div class="d-flex justify-content-end flex-shrink-0">
															<a href="#" class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1">
																<i class="ki-duotone ki-switch fs-2">
																	<span class="path1"></span>
																	<span class="path2"></span>
																</i>
															</a>
															<a href="#" class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1">
																<i class="ki-duotone ki-pencil fs-2">
																	<span class="path1"></span>
																	<span class="path2"></span>
																</i>
															</a>
															<a href="#" class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm">
																<i class="ki-duotone ki-trash fs-2">
																	<span class="path1"></span>
																	<span class="path2"></span>
																	<span class="path3"></span>
																	<span class="path4"></span>
																	<span class="path5"></span>
																</i>
															</a>
														</div>
													</td>
												</tr>
                                                                                                
												<tr>
													<td>
														<div class="form-check form-check-sm form-check-custom form-check-solid">
															<input class="form-check-input widget-9-check" type="checkbox" value="1" />
														</div>
													</td>
													<td>
														<div class="d-flex align-items-center">
															<div class="symbol symbol-45px me-5">
																<img src="./assets/media/avatars/300-2.jpg" alt="" />
															</div>
															<div class="d-flex justify-content-start flex-column">
																<a href="#" class="text-dark fw-bold text-hover-primary fs-6">Jessie Clarcson</a>
																<span class="text-muted fw-semibold text-muted d-block fs-7">C#, ASP.NET, MS SQL</span>
															</div>
														</div>
													</td>
													<td>
														<a href="#" class="text-dark fw-bold text-hover-primary d-block fs-6">Agoda</a>
														<span class="text-muted fw-semibold text-muted d-block fs-7">Houses & Hotels</span>
													</td>
													<td class="text-end">
														<div class="d-flex flex-column w-100 me-2">
															<div class="d-flex flex-stack mb-2">
																<span class="text-muted me-2 fs-7 fw-bold">70%</span>
															</div>
															<div class="progress h-6px w-100">
																<div class="progress-bar bg-danger" role="progressbar" style="width: 70%" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
															</div>
														</div>
													</td>
													<td>
														<div class="d-flex justify-content-end flex-shrink-0">
															<a href="#" class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1">
																<i class="ki-duotone ki-switch fs-2">
																	<span class="path1"></span>
																	<span class="path2"></span>
																</i>
															</a>
															<a href="#" class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1">
																<i class="ki-duotone ki-pencil fs-2">
																	<span class="path1"></span>
																	<span class="path2"></span>
																</i>
															</a>
															<a href="#" class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm">
																<i class="ki-duotone ki-trash fs-2">
																	<span class="path1"></span>
																	<span class="path2"></span>
																	<span class="path3"></span>
																	<span class="path4"></span>
																	<span class="path5"></span>
																</i>
															</a>
														</div>
													</td>
												</tr>
											</tbody>
											<!--end::Table body-->
										</table>
										<!--end::Table-->
									</div>
									<!--end::Table container-->
								</div>
								<!--begin::Body-->
							</div>
							<!--end::Tables Widget 9-->
							<!--begin::Row-->
							<div class="row gy-5 g-xl-10">
								
                                                             <jsp:include page="main_activities.jsp" flush="true"/>
                                                             
                                                             
                                                             <jsp:include page="main_trends.jsp" flush="true"/>
                                                                
								
							</div>
							<!--end::Row-->
						</div>
						<!--end::Container-->
					</div>
					<!--end::Content-->
                                        
                                        <jsp:include page="main_footer.jsp" flush="true"/>
					
				</div>
                
                              <jsp:include page="main_side.jsp" flush="true"/>
                
                <jsp:include page="main_nav.jsp" flush="true"/>
               
                
            </div>

        </div>
        <!--end::Modal - Users Search-->
        <!--end::Modals-->
        <!--begin::Javascript-->
        <script>var hostUrl = "./assets/";</script>
        <!--begin::Global Javascript Bundle(mandatory for all pages)-->
        <script src="./assets/plugins/global/plugins.bundle.js"></script>
        <script src="./assets/js/scripts.bundle.js"></script>
        <!--end::Global Javascript Bundle-->
        <!--begin::Vendors Javascript(used for this page only)-->
        <script src="./assets/plugins/custom/fullcalendar/fullcalendar.bundle.js"></script>
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
        <script src="./assets/plugins/custom/datatables/datatables.bundle.js"></script>
        <!--end::Vendors Javascript-->
        <!--begin::Custom Javascript(used for this page only)-->
        <script src="./assets/js/widgets.bundle.js"></script>
        <script src="./assets/js/custom/widgets.js"></script>
        <script src="./assets/js/custom/apps/chat/chat.js"></script>
        <script src="./assets/js/custom/utilities/modals/users-search.js"></script>
        <!--end::Custom Javascript-->
        <!--end::Javascript-->
    </body>

    <!--end::Body-->
</html>
