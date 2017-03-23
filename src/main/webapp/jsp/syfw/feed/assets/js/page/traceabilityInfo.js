/**
 * 消费者向服务器追溯请求管理
 */

var catalogyIds;
var operation=0;
$(document).on("click",".modal-dialog #selectCatalogyBt span[data-role='remove']",function(){
	var parentSpan = $(this).parent();
	if(typeof(parentSpan.attr("catalogyValue"))!="undefined"){
		catalogyIds.splice($.inArray(parentSpan.attr("catalogyValue"),catalogyIds),1);
	}
	parentSpan.remove();
});	
//定义datatable
	var oTable = $("#orderInfo_datatable").dataTable(
		$.extend($.fn.bdmp.datatableConf,{
			"sAjaxSource": "trace_getList.do", //ajax请求地址
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
				  "mData": "epc",
				  "bSortable": false,
				  "bSearchable": false
				},{
				  "aTargets": [2],
				  "mData": "aquticName",
				  "bSortable": false,
				  "bSearchable": false
				},{
				  "aTargets": [3],
				  "mData": "pondTime",
				  "bSortable": false,
				  "bSearchable": false
				},{
				  "aTargets": [4],
				  "mData": "detcResult",
				  "bSortable": false,
				  "bSearchable": false
				}], 
			"fnInitComplete": function (oSettings,json) {
				//增加搜索
				$("#orderInfo_datatable_filter").append('<label><span class="input-icon"><input id="orderNo" class="form-control input-sm"  size="60"  type="text" placeholder="请输入追溯码"><i class="glyphicon glyphicon-search blue"></i></span></label>');

				//增加搜素查询
		    	$("#orderInfo_datatable_length").prepend('<a id="resetButton" href="javascript:void(0);" class="btn btn-yellow" style="margin-right: 10px;"><i class="fa fa-mail-reply"></i>重置</a>');
		    	$("#orderInfo_datatable_length").prepend('<a id="searchButton" href="javascript:void(0);" class="btn btn-blue" style="margin-right: 10px;"><i class="fa fa-search"></i>搜索</a>');
		    },
		    "fnDrawCallback": function(oSettings){
		    	$("#orderInfo_datatable .group-checkable").prop("checked", false);
		    	renderButtonFn();
		    },
		    "fnServerParams": function (aoData) {
		    	//搜素设置参数
		    	$.fn.bdmp.addParam(aoData,{"name":"orderNo", "value":$.trim($("#orderInfo_datatable_filter #orderNo").val())});
		    }
		})
	);


	
	
	
	
	//注册删添加钮事件
	$("#orderDetailButton").on("click", function () {
		var row = oTable.fnGetData(oTable.$("tr.active")[0]);
		var id = row.id;
		var _title="详细信息";
		$.ajax({
    		type : "GET",
    		url : "orderInfo/load.do",
    		data:{id:id},
    		async : false,
    		cache : false,
    		dataType : "html",
    		error : function(request) {
    			$.fn.bdmp.message.error("系统错误！");
    		},
    		success : function(data) {
    			showDeatil(data,_title);
    		}
    	});
    });
	
    //注册刷新按钮事件
    $("#refreshButton").on("click", function () {
    	/* oTable.fnReloadAjax(); */
    	oTable.fnPageChange($.fn.bdmp.page.currentPage(oTable)); 
    });
    
    
    
    
    
    
    
    
    function getTableContent(){  
        var nTrs = oTable.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象  
        for(var i = 0; i < nTrs.length; i++){  
            console.log('[获取数据]'+i  + oTable.fnGetData(nTrs[i]));//fnGetData获取一行的数据  
        }  
    }  
    
    
    
    
    
    //注册搜索按钮事件
    $(document).on("click","#searchButton", function () {
    	
//    	getTableContent();
      var  orderNo =	$("#orderInfo_datatable_filter #orderNo").val();
      
		$.ajax({
    		type : "POST",
    		url : "trace_getListByEpc.do",
    		data:"orderNo="+orderNo,
    		async : false,
    		cache : false,
    		dataType : "html",
    		error : function(request) {
    			$.fn.bdmp.message.error("系统错误！");
    		},
    		success : function(data) {
    			showDeatil(data);
    			
//    			showDeatil(data,_title);
    			console.log(data);
//    			show
    		}
    	});
      
      
//      console.log('[获取数据]'+ orderNo);//fnGetData获取一行的数据  
      
//    	oTable
//    	epcTable.fnReloadAjax();
    });
    
    //注册重置按钮事件
    $(document).on("click","#resetButton", function () {
    	$("#orderInfo_datatable_filter #orderNo").val("");
    	oTable.fnReloadAjax();
    });
    
    //注册checkbox以及行选中事件
    $.fn.bdmp.registerCheckboxAction("orderInfo_datatable",renderButtonFn);
    
    function renderButtonFn(){
    	var enableButtonFlag = true;
    	var disableButton = true;
    	$.each(oTable.$("tr.active"),function(i,n){
    		if(oTable.fnGetData(n).status == 1){
    			enableButtonFlag = false;
    		}else if(oTable.fnGetData(n).status == 2){
    			disableButton = false;
    		}
        });
    	if(oTable.$("tr.active").size()==1){
    		$("#detailButton").removeAttr("disabled");
    	}else{
    		$("#detailButton").attr("disabled","disabled");
    	}
    }
