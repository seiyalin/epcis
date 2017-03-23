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
    <title>商品分类管理</title>

    <meta name="description" content="商品分类管理" />
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

    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="assets/js/skins.min.js"></script>
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
                        <li class="active">商品分类</li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                <!-- Page Header -->
                <div class="page-header position-relative">
                    <div class="header-title">
                        <h1>
                          	 商品分类
                            <small>
                                <i class="fa fa-angle-right"></i>
                                                                                                                维护商品分类
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
                                    <span class="widget-caption">商品分类</span>
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
                                            <a id="addButton" href="javascript:void(0);" class="btn btn-default purple" style="margin-right: 10px;"><i class="fa fa-plus"></i>新增</a>
											<a id="updateButton" href="javascript:void(0);" class="btn btn-primary" style="margin-right: 10px;" disabled="disabled"><i class="fa fa-edit "></i>编辑</a>
											<a id="deleteButton" href="javascript:void(0);" class="btn btn-danger" style="margin-right: 10px;" disabled="disabled"><i class="fa fa-times"></i>删除</a>
											<a id="refreshButton" href="javascript:void(0);" class="btn btn-success" style="margin-right: 10px;"><i class="fa fa-refresh"></i>刷新</a>
                                        </div>
                                    </div>
                                    <table class="table table-striped table-bordered table-hover" id="productCategory_datatable" width="100%">
                                        <thead>
											<tr>
												<th width="5%">
													<!-- <div class="checker">
														<span class=""><input type="checkbox" class="group-checkable"/> </span>
													</div> -->
													<label class="checkbox_label">
														<input class="colored-blue group-checkable" type="checkbox"><span class="text"></span>
													</label>
												</th>
												<th width="30%">商品分类名</th>
												<th width="30%">排序号</th>
												<th width="10%">默认商品分类</th>
												<th hidden="true">id</th>
											</tr>
										</thead>
                                        <tbody>
                                        </tbody>
                                    </table>
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
	<!--========添加弹出框=========---->
	<div id="addDialog" style="display:none;">
		<div id="horizontal-form">
           <form class="form-horizontal" role="form">
               <div class="form-group">
                   <label for="name" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">名称</span></label>
                   <div class="col-sm-10">
                       <input type="text" class="form-control" id="name" name="name" placeholder="名称" maxlength="50">
                   </div>
               </div>
               <div class="form-group">
                   <label for="orderNo" class="col-sm-2 control-label no-padding-right"><span class="label label-default graded">排序号</span></label>
                   <div class="col-sm-10">
                       <input type="text" class="form-control" id="orderNo" name="orderNo" placeholder="排序号" maxlength="50">
                   </div>
               </div>
           </form>
       </div>
    </div>
	<!------end------->

	<!--修改页面--->
	<div id="updateDialog" style="display:none;">
		<div id="horizontal-form">
           <form class="form-horizontal" role="form">
           	 <input type="hidden" id="id" name="id"></input>
             <div class="form-group">
                   <label for="name" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">名称</span></label>
                   <div class="col-sm-10">
                       <input type="text" class="form-control" id="name" name="name" placeholder="名称" maxlength="50">
                   </div>
               </div>
               <div class="form-group">
                   <label for="orderNo" class="col-sm-2 control-label no-padding-right"><span class="label label-default graded">排序号</span></label>
                   <div class="col-sm-10">
                       <input type="text" class="form-control" id="orderNo" name="orderNo" placeholder="排序号" maxlength="50">
                   </div>
               </div>
           </form>
       </div>
	</div>
	
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
    <script src="assets/js/customer.js"></script>
    <script src="assets/js/page/productCategory.js"></script>
 </body>
<!--  /Body -->
</html>
