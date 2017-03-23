$(document).ready(function(){
	//定义datatable
	var oTable = $("#productCategory_datatable").dataTable(
		$.extend($.fn.bdmp.datatableConf,{
			"sAjaxSource": "productCategory/getList.do", //ajax请求地址
			"aoColumns" : [
				{
				  "aTargets": [0],
				  "mData": null,
				  "bSortable": false,
				  "bSearchable": false ,
				  "mRender": function (data, type, full) {
					  return '<label class="checkbox_label"><input class="colored-blue checkboxes" type="checkbox"><span class="text"></span></label>';
			 		} 
		   		},
		   		{
				  "aTargets": [1],
				  "mData": "name",
				  "bSortable": false,
				  "bSearchable": false,
				},
				{
				  "aTargets": [2],
				  "mData": "orderNo",
				  "bSortable": false,
				  "bSearchable": false
				},
				{
				  "aTargets": [3],
				  "mData": "id",
				  "bSortable": false,
				  "bSearchable": false,
				  "bVisible":false
				}], 
			"fnInitComplete": function (oSettings,json) {
				//增加搜索
				$("#productCategory_datatable_filter").append('<label style="margin-left:20px;"><span class="input-icon"><input id="name" class="form-control input-sm" type="text" placeholder="请输入名称"><i class="glyphicon glyphicon-search blue"></i></span></label>');
		    	
		    	//增加搜素查询
		    	$("#productCategory_datatable_length").prepend('<a id="resetButton" href="javascript:void(0);" class="btn btn-yellow" style="margin-right: 10px;"><i class="fa fa-mail-reply"></i>重置</a>');
		    	$("#productCategory_datatable_length").prepend('<a id="searchButton" href="javascript:void(0);" class="btn btn-blue" style="margin-right: 10px;"><i class="fa fa-search"></i>搜索</a>');
		    },
		    "fnDrawCallback": function(oSettings){
		    	$("#productCategory_datatable .group-checkable").prop("checked", false);
		    	renderButtonFn();
		    },
		    "fnServerParams": function (aoData) {
		    	//搜素设置参数
		    	$.fn.bdmp.addParam(aoData,{"name":"name", "value":$.trim($("#productCategory_datatable_filter #name").val())});
		    }
		})
	);

	//注册删添加钮事件
	$("#addButton").on("click", function () {
		 var addDialog = bootbox.dialog({
             message: $("#addDialog").html(),
             title: "添加",
             className: "modal-darkorange",
             buttons: {
                 "保存": {
                     className: "btn-primary",
                     callback: function () {
			 
 						var name = addDialog.find("#name").val();
 						var orderNo = addDialog.find("#orderNo").val();
 				
 						if (name == "") {
 							$.fn.bdmp.message.error("名称不能为空!");
 							return false;
 						}
 				
 						if (name.length > 30) {
 							$.fn.bdmp.message.error("姓名长度不能超过30!");
 							return false;
 						}
 						
 						if (orderNo == "") {
 							$.fn.bdmp.message.error("排序号不能为空!");
 							return false;
 						}
 						
 						$.post("productCategory/insert.do",addDialog.find("form").serialize(),function(data) {
 							if(data.success){
 								$.fn.bdmp.message.success("添加成功!");
 								oTable.fnReloadAjax();
 						   		addDialog.modal("hide");
                    				return true;
 							}else{
 								$.fn.bdmp.message.error(data.message);
 								return false;
 							}
 						}, 'json');
 						
                     	return false;
                     }
                 },
                 "关闭": {
                     className: "btn-default",
                     callback: function () {
                     	return true;
                     }
                 }
             }
         });
    });
    
    //注册修改按钮事件
    $("#updateButton").on("click", function () {
    	var row = oTable.fnGetData(oTable.$("tr.active")[0]);
    	$("#updateDialog #name").attr("value",row.name);
    	$("#updateDialog #orderNo").attr("value",row.orderNo);
     	$("#updateDialog #id").attr("value",row.id);
    	
    	var updateDialog = bootbox.dialog({
               message: $("#updateDialog").html(),
               title: "修改",
               className: "modal-darkorange",
               buttons: {
                   "保存": {
                       className: "btn-primary",
                       callback: function () {
    		
	       						var name = updateDialog.find("#name").val();
	       						var orderNo = updateDialog.find("#orderNo").val();
     						
	       						if (name == "") {
	       							$.fn.bdmp.message.error("名称不能为空!");
	       							return false;
	       						}
	       				
	       						if (name.length > 30) {
	       							$.fn.bdmp.message.error("名称长度不能超过30!");
	       							return false;
	       						}
	       				
	       						if (orderNo == "") {
	       							$.fn.bdmp.message.error("排序号不能为空!");
	       							return false;
	       						}
	       				
 	      						var data = updateDialog.find("form").serialize();
 	                          	data += "&id=" + row.id;
 	  							$.post("productCategory/update.do",data,function(data) {
 	  								if(data.success){
 	  									$.fn.bdmp.message.success("修改成功!");
 	  									oTable.fnReloadAjax();
 	  							   		updateDialog.modal("hide");
 	                         				return true;
 	  								}else{
 	  									$.fn.bdmp.message.error(data.message);
 	  									return false;
 	  								}
 	  							}, 'json');
							
 	  							return false;
                       }
                   },
                   "关闭": {
                       className: "btn-default",
                       callback: function () {
                       	return true;
                       }
                   }
               }
           });
    	
    });
    
    //注册删除按钮事件
    $("#deleteButton").on("click", function () {

    	var ids = "";
		$.each(oTable.$("tr.active"),function(i,n){  
            if(i==0){
                ids += oTable.fnGetData(n).id;  
            }else {
                ids += (","+oTable.fnGetData(n).id); 
            } 
        });
    	
    	bootbox.confirm({
		        message: '<span><i class="glyphicon glyphicon-question-sign yellow"></i></span>&nbsp;&nbsp;<span class="font">确定删除吗?</span>',
		        className: "bdmp_confirm",
		        callback: function(result) {
		        	if (result) {
		        		$.post("productCategory/delete.do",{ids:ids},function(data) {
							if(data.success){
								$.fn.bdmp.message.success("删除成功!");
								oTable.fnReloadAjax();
						   	}else{
								$.fn.bdmp.message.error(data.message);
							}
						}, 'json');
		            }
			    }
	    	});
//    	}
    });
    
    //注册刷新按钮事件
    $("#refreshButton").on("click", function () {
    	oTable.fnPageChange($.fn.bdmp.page.currentPage(oTable)); 
    });
    
    //注册搜索按钮事件
    $(document).on("click","#searchButton", function () {
    	oTable.fnReloadAjax();
    });
    
    //注册重置按钮事件
    $(document).on("click","#resetButton", function () {
    	$("#productCategory_datatable_filter #name").val("");
    	$("#productCategory_datatable_filter #code").val("");
    	oTable.fnReloadAjax();
    });
    
    //注册checkbox以及行选中事件
    $.fn.bdmp.registerCheckboxAction("productCategory_datatable",renderButtonFn);
    
    function renderButtonFn(){
    	var deleteButtonFlag = true;
    	
    	$.each(oTable.$("tr.active"),function(i,n){
    		if(oTable.fnGetData(n).defaulted){
    			deleteButtonFlag = false;
    		}
        });
    	
    	if(oTable.$("tr.active").size()==1){
    		$("#updateButton").removeAttr("disabled");
    	}else{
    		$("#updateButton").attr("disabled","disabled");
    	}
    	if(oTable.$("tr.active").size()>0){
    		$("#deleteButton").removeAttr("disabled");
    	}else{
    		$("#deleteButton").attr("disabled","disabled");
    	}
    	
    	if(deleteButtonFlag&&oTable.$("tr.active").size()>0){
    		$("#deleteButton").removeAttr("disabled");
    	}else{
    		$("#deleteButton").attr("disabled","disabled");
    	}
    	
    }
});