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
    <title>投诉管理</title>

    <meta name="description" content="追溯管理" />
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
   <!--  表格 -->
     <link href="assets/css//bootstrap-table.css" rel="stylesheet" />
     <style>
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
                        <li class="active">投诉管理</li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                <!-- Page Header -->
                <div class="page-header position-relative">
                    <div class="header-title">
                        <h1>
                          	 投诉管理
                            <small>
                                <i class="fa fa-angle-right"></i>
                                                                                                               投诉受理管理记录
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
                                    <span class="widget-caption">投诉管理</span>
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
                          <!--       <div class="widget-body">
                                	<div class="table-toolbar">
                                        <div class="buttons-preview" style="border-bottom: 1px solid #e5e5e5;">
                                        	<a id="orderDetailButton" href="javascript:void(0);" class="btn btn-info" style="margin-right: 10px;">
												<i class="fa fa-warning right"></i>详情
											</a>
                                        </div>
                                    </div> -->
                                    
                                    <!--  新增投诉要求 -->
                                    
                                    	<div class="table-toolbar">
			                                        <div class="buttons-preview" style="border-bottom: 1px solid #e5e5e5;">
			                                            <a id="addButton" href="javascript:void(0);" class="btn btn-default purple" style="margin-right: 10px;"><i class="fa fa-plus"></i>我要投诉</a>
														<a id="updateButton" href="javascript:void(0);" class="btn btn-primary" style="margin-right: 10px;"><i class="fa fa-edit "></i>编辑</a>
														<a id="deleteButton" href="javascript:void(0);" class="btn btn-danger" style="margin-right: 10px;" disabled="disabled"><i class="fa fa-times"></i>删除</a>
														<a id="detailButton" href="javascript:void(0);" class="btn btn-info" style="margin-right: 10px;" disabled="disabled"><i class="fa fa-info right"></i>详细</a>
														
			                                        </div>
			                                    </div>
                                   <div class="panel-body" style="padding-bottom:0px;">
        <div class="panel panel-default">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
                <form id="formSearch" class="form-horizontal">
                    <div class="form-group" style="margin-top:15px">
                        <label class="control-label col-sm-1" for="txt_search_departmentname">部门名称</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_departmentname">
                        </div>
                        <label class="control-label col-sm-1" for="txt_search_statu">状态</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_statu">
                        </div>
                        <div class="col-sm-4" style="text-align:left;">
                            <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>       

        <div id="toolbar" class="btn-group">
            <button id="btn_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
        <table id="tb_departments"></table>
    </div>
                                    
                                    
                                    
                                    
                                   <!--  <table class="table table-striped table-bordered table-hover" id="orderInfo_datatable" width="100%">
                                        <thead >
											<tr>
												<th width="5%">
													<label class="checkbox_label">
														<input class="colored-blue group-checkable" type="checkbox"><span class="text"></span>
													</label>
												</th>
												<th width="15%">投诉对象</th>
												<th width="15%">投诉标题</th>
												<th width="15%">投诉人</th>
												<th width="15%">投诉时间</th>
												<th width="15%">联系电话</th>
												<th width="15%">受理状态</th>
											</tr>
										</thead>
										<tbody>
										<tr>
												<td width="5%">
													<label class="checkbox_label">
														<input class="colored-blue group-checkable" type="checkbox"><span class="text"></span>
													</label>
												</td>
												<td>投诉对象</td>
												<td >投诉对象</td>
												<td >投诉对象</td>
												<td>投诉对象</td>
												<td >投诉对象</td>
												<td >投诉对象</td>
											</tr>
                                        
                                        </tbody>
                                    </table> -->
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                      <!-- detail page  -->
                    <div class="row">
						<div class="col-xs-12 col-md-12 detail-container">
							<div class="widget" style="display:none;">
								<div class="widget-header">
									<span class="widget-caption">追溯结果管理</span>
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
	
	 分类选择框 
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
	
		<!--========投诉弹出框=========---->
	<div id="addDialog" style="display:none;">
		<div id="horizontal-form">
           <form class="form-horizontal" role="form" enctype="multipart/form-data">
           <!-- <div class="form-group">投诉人信息</div> -->
               <div class="form-group">
                   <label for="cover" class="col-sm-1 control-label no-padding-right"><span class="label label-darkpink graded">投诉标题</span></label>
                     <div class="col-sm-11">
							   <input type="text" class="form-control" id="brief" name="po.brief" placeholder="水产品质量问题" maxlength="10">
						   </div>
               </div>
               
     		 <!--  <div class="row">
				    <div class="col-sm-12">
				        <div class="form-group">
						   <label for="size" class="col-sm-1 control-label no-padding-right"><span class="label label-darkpink graded">投诉内容</span></label>
						   <div class="col-sm-11">
							   <input type="text" class="form-control" id="brief" name="po.brief" placeholder="我购买的水产品有质量问题" maxlength="10">
						   </div>
					   </div>
				    </div>
				</div> -->
				
				<div class="row">
				    <div class="col-sm-6">
				        <div class="form-group">
						   <label for="code" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">投诉人身份</span></label>
						   <div class="col-sm-10">
							   <input type="text" class="form-control" id="no" name="po.no" placeholder="消费者" maxlength="50">
						   </div>
					   </div>
				    </div>
				    
				    <div class="col-sm-6">
				        <div class="form-group">
						   <label for="specification" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">联系电话</span></label>
						   <div class="col-sm-10">
							   <input type="text" class="form-control" id="specification" name="po.specification"  maxlength="50">
						   </div>
					   </div>
				    </div>
				</div>
				
				<div class="row">
					<!-- 
				    <div class="col-sm-6">
				        <div class="form-group">
						   <label for="brand" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">品牌</span></label>
		                   <div class="col-lg-10">
			                   <select class="form-control brand" name="brand" id="brand" data-bv-field="brand">
			                            <option value="">请选择 </option>
			                   </select><i class="form-control-feedback" data-bv-field="brand" style="display: none;"></i>
		                   </div>
					   </div>
				    </div>
				     -->
				     <div class="col-sm-6">
				        <div class="form-group">
						   <label for="brand" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">投诉单位</span></label>
		                   <div class="col-lg-10">
			                   <select class="form-control brand" name="po.brand" id="brand" data-bv-field="brand">
			                            <option value="0">请选择 </option>
			                   </select><i class="form-control-feedback" data-bv-field="brand" style="display: none;"></i>
		                   </div>
					   </div>
				    </div>
				    <div class="col-sm-6">
				        <div class="form-group">
						   <label for="sourceArea" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">原产地单位</span></label>
						   <div class="col-sm-10">
							   <input type="text" class="form-control" id="sourceArea" name="po.sourceArea" placeholder="原产地" maxlength="50">
						   </div>
					   </div>
				    </div>
				</div>
				
				<div class="row">
				    <div class="col-sm-6">
				        <div class="form-group">
						   <label for="price" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">消费价格</span></label>
						   <div class="col-sm-10">
							   <input type="text" class="form-control" id="price" name="po.price" placeholder="价格" maxlength="50">
						   </div>
					   </div>
				    </div>
				    
				     <div class="col-sm-6">
				        <div class="form-group">
						   <label for="pirceUnit" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">单位</span></label>
		                   <div class="col-lg-10">
			                   <select class="form-control pirceUnit" name="po.pirceUnit" id="pirceUnit" data-bv-field="pirceUnit">
			                            <option value="1">人民币 </option>
			                   </select><i class="form-control-feedback" data-bv-field="pirceUnit" style="display: none;"></i>
		                   </div>
					   </div>
				    </div>
				</div>
				
				<!-- 
				<div class="row">
				    <div class="col-sm-6">
				        <div class="form-group">
						   <label for="expiration" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">保质期</span></label>
						   <div class="col-sm-10">
							   <input type="text" class="form-control" id="expiration" name="po.expiration" placeholder="保质期" maxlength="50">
						   </div>
					   </div>
				    </div> -->
				    
				     <!-- <div class="col-sm-6">
				        <div class="form-group">
						   <label for="expiration" class="col-sm-2 control-label no-padding-right"><span class="label label-darkpink graded">单位</span></label>
		                   <div class="col-lg-10">
			                   <select class="form-control expirationUnit" name="po.expirationUnit" id="expirationUnit" data-bv-field="expirationUnit">
			                            <option value="">请选择 </option>
			                            <option value="1">年 </option>
			                            <option value="2">月 </option>
			                            <option value="3">日 </option>
			                            <option value="4">小时</option>
			                   </select><i class="form-control-feedback" data-bv-field="expirationUnit" style="display: none;"></i>
		                   </div>
					   </div>
				    </div> -->
				</div>
				
              <!--  <div class="row">
				    <div class="col-sm-12">
				        <div class="form-group">
						   <label for="size" class="col-sm-1 control-label no-padding-right"><span class="label label-darkpink graded">简介</span></label>
						   <div class="col-sm-11">
							   <input type="text" class="form-control" id="brief" name="po.brief" placeholder="简介" maxlength="10">
						   </div>
					   </div>
				    </div>
				</div> -->
				<!-- <div class="form-group">
                   <label for="code" class="col-sm-1 control-label no-padding-right"><span class="label label-darkpink graded">分类</span></label>
                   <div class="col-sm-11" id="selectCatalogyBt">
                       <div class="bootstrap-tagsinput" id="catalogiesStr"></div>
	                   <input type="hidden" id="catalogies" name="po.catalogies"></input>
                   </div>
               </div> -->
               <div class="form-group">
                   <label for="description" class="col-sm-1 control-label no-padding-right"><span class="label label-default graded">投诉详情</span></label>
                   <div class="col-sm-12">
                    	<iframe name="description" id="myFrameDescription" src="form-editor-book.html" width="100%" height="402px" frameborder="no" border="0" marginwidth="0" marginheight="0" ></iframe>
                   </div>
                   <input type="hidden" id="description" name="po.description"></input>
               </div>
           </form>
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

	<script src="assets/js/page/complain.js"></script>
	
	
	<script src="assets/js/upload/jquery.form.min.js"  type="text/javascript"></script>
 	<script src="assets/js/upload/fileinput.min.js"  type="text/javascript"></script>
    <script src="assets/js/upload/fileinput_locale_zh.js" type="text/javascript"></script>
    
	 <script src="assets/js/bootstrap-table.js"></script>
   
    <script src="assets/js/bootstrap-table-zh-CN.js"></script>
    <script src="assets/js/table/conplain-table.js"></script>
</body>
<!--  /Body -->
</html>
