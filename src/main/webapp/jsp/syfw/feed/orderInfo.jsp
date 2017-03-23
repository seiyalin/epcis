<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
BeyondAdmin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.2.0
Version: 1.0.0
Purchase: http://wrapbootstrap.com
-->

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Head -->
<head>
    <meta charset="utf-8" />
    <title>订单管理</title>

    <meta name="description" content="订单管理" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">

    <!--Basic Styles-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link id="bootstrap-rtl-link" href="" rel="stylesheet" />
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <link href="assets/css/weather-icons.min.css" rel="stylesheet" />

    <!--Fonts-->
    <!-- <link href="http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,600,700,300" rel="stylesheet" type="text/css"> -->

    <!--Beyond styles-->
    <link id="beyond-link" href="assets/css/beyond.min.css" rel="stylesheet" />
    <link href="assets/css/demo.min.css" rel="stylesheet" />
    <link href="assets/css/typicons.min.css" rel="stylesheet" />
    <link href="assets/css/animate.min.css" rel="stylesheet" />
    <link href="assets/css/customer.css" rel="stylesheet" />
    <link id="skin-link" href="" rel="stylesheet" type="text/css" />

    <!--Page Related styles-->
    <link href="assets/css/dataTables.bootstrap.css" rel="stylesheet" />

 	 <link rel="stylesheet" type="text/css" href="assets/css/fileinput.min.css" />
  
    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="assets/js/skins.min.js"></script>
    <style type="text/css">
.modal-dialog {
	margin: 30px auto;
	width: 947px;
}
</style>
</head>
<!-- /Head -->
<!-- Body -->
<body>
    <!-- Loading Container -->
    <div class="loading-container">
        <div class="loading-progress">
            <div class="rotator">
                <div class="rotator">
                    <div class="rotator colored">
                        <div class="rotator">
                            <div class="rotator colored">
                                <div class="rotator colored"></div>
                                <div class="rotator"></div>
                            </div>
                            <div class="rotator colored"></div>
                        </div>
                        <div class="rotator"></div>
                    </div>
                    <div class="rotator"></div>
                </div>
                <div class="rotator"></div>
            </div>
            <div class="rotator"></div>
        </div>
    </div>
    <!--  /Loading Container -->
    <!--     -->
    <jsp:include page="top.jsp" />
    <!-- Main Container -->
    <div class="main-container container-fluid">
        <!-- Page Container -->
        <div class="page-container">
            <jsp:include page="menu.jsp" />
            <!-- Page Content -->
            <div class="page-content">
                <!-- Page Breadcrumb -->
                <div class="page-breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="fa fa-home"></i>
                            <a href="#">首页</a>
                        </li>
                        <li class="active">订单管理</li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                <!-- Page Header -->
                <div class="page-header position-relative">
                    <div class="header-title">
                        <h1>
                          	 订单管理
                            <small>
                                <i class="fa fa-angle-right"></i>
                                                                                                                订单管理记录
                            </small>
                        </h1>
                    </div>
                    <!--Header Buttons-->
                    <div class="header-buttons">
                        <a class="sidebar-toggler" href="#">
                            <i class="fa fa-arrows-h"></i>
                        </a>
                        <a class="refresh" id="refresh-toggler" href="">
                            <i class="glyphicon glyphicon-refresh"></i>
                        </a>
                        <a class="fullscreen" id="fullscreen-toggler" href="#">
                            <i class="glyphicon glyphicon-fullscreen"></i>
                        </a>
                    </div>
                    <!--Header Buttons End-->
                </div>
                <!-- /Page Header -->
                <!-- Page Body -->
                <div class="page-body">
                    <div class="row">
                        <div class="col-xs-12 col-md-12">
                            <div class="widget widget-table-container">
                                <div class="widget-header ">
                                    <span class="widget-caption">订单管理</span>
                                    <div class="widget-buttons">
                                        <a href="#" data-toggle="maximize">
                                            <i class="fa fa-expand"></i>
                                        </a>
                                        <a href="#" data-toggle="collapse">
                                            <i class="fa fa-minus"></i>
                                        </a>
                                        <a href="#" data-toggle="dispose">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="widget-body">
                                	<div class="table-toolbar">
                                        <div class="buttons-preview" style="border-bottom: 1px solid #e5e5e5;">
                                        	<a id="orderDetailButton" href="javascript:void(0);" class="btn btn-info" style="margin-right: 10px;">
												<i class="fa fa-warning right"></i>详情
											</a>
                                        </div>
                                    </div>
                                    <table class="table table-striped table-bordered table-hover" id="orderInfo_datatable" width="100%">
                                        <thead>
											<tr>
												<th width="5%">
													<label class="checkbox_label">
														<input class="colored-blue group-checkable" type="checkbox"><span class="text"></span>
													</label>
												</th>
												<th width="15%">购买用户</th>
												<th width="15%">订单编号</th>
												<th width="15%">下单时间</th>
												<th width="15%">完成时间</th>
											</tr>
										</thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                      <!-- detail page  -->
                    <div class="row">
						<div class="col-xs-12 col-md-12 detail-container">
							<div class="widget" style="display:none;">
								<div class="widget-header">
									<span class="widget-caption">套餐管理</span>
									<div class="widget-buttons">
										<a href="#" data-toggle="maximize"> <i class="fa fa-expand"></i>
										</a> <a href="#" data-toggle="collapse"> <i class="fa fa-minus"></i>
										</a> <a href="#" data-toggle="self-dispose"> <i class="fa fa-times"></i>
										</a>
									</div>
								</div>
								<div class="widget-body">
								
								</div>
							</div>
						</div>
					</div>
					
                </div>
                <!-- /Page Body -->
            </div>
            <!-- /Page Content -->
        </div>
        <!-- /Page Container -->
        <!-- Main Container -->

    </div>
	
	 <!-- 分类选择框  -->
	<div id="catalogyDialog" style="display:none;">
		<div id="horizontal-form">
            <div class="form-group">
                
                <div class="widget flat radius-bordered">
                     <div class="widget-body">
                         <div id="catalogyTree" class="tree">
                             <div class="tree-folder" style="display: none;">
                                 <div class="tree-folder-header">
                                     <i class="fa fa-folder"></i>
                                     <div class="tree-folder-name"></div>
                                 </div>
                                 <div class="tree-folder-content">
                                 </div>
                                 <div class="tree-loader" style="display: none;"></div>
                             </div>
                             <div class="tree-item" style="display: none;">
                                 <i class="tree-dot"></i>
                                 <div class="tree-item-name"></div>
                             </div>
                         </div>
                     </div>
                     
                     
                 </div>
                
            </div>
       </div>
    </div>    
  
	<!------end------->

	<!--Basic Scripts-->
	<script src="assets/js/jquery-2.0.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>

	<!--Beyond Scripts-->
	<script src="assets/js/beyond.min.js"></script>

	<!--Page Related Scripts-->
	<script src="assets/js/datatable/jquery.dataTables.min.js"></script>
	<script src="assets/js/datatable/ZeroClipboard.js"></script>
	<script src="assets/js/datatable/dataTables.tableTools.min.js"></script>
	<script src="assets/js/datatable/dataTables.bootstrap.min.js"></script>
	<!--  <script src="assets/js/datatable/datatables-init.js"></script> -->
	<script src="assets/js/bootbox/bootbox.js"></script>
	<script src="assets/js/toastr/toastr.js"></script>
	
	
	 <script src="assets/js/fuelux/treeview/tree-custom.min.js"></script>
	   <!--Jquery Select2-->
    <script src="assets/js/select2/select2.js"></script>
    <!--Bootstrap Tags Input-->
    <script src="assets/js/tagsinput/bootstrap-tagsinput.js"></script>
	 
	 
	<script src="assets/js/customer.js"></script>
	

	<script src="assets/js/upload/jquery.form.min.js"
		type="text/javascript"></script>

	<script src="assets/js/page/orderInfo.js"></script>
	
	
	<script src="assets/js/upload/jquery.form.min.js"  type="text/javascript"></script>
 	<script src="assets/js/upload/fileinput.min.js"  type="text/javascript"></script>
    <script src="assets/js/upload/fileinput_locale_zh.js" type="text/javascript"></script>
    
	<script type="text/javascript">
		
	</script>
</body>
<!--  /Body -->
</html>
