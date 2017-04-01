var catalogyIds;
$(document).ready(function(){
	$.get("complaint_getList.do?",function(data){
			
		console.log(data);
	});
	});


function checkImgType(ths){  
        if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ths)) {         
            return false;  
        }  
    return true;  
} 
$(document).ready(function(){
	var oTable = $("#product_datatable").dataTable(
			$.extend($.fn.bdmp.datatableConf,{
				"sAjaxSource": "complaint_getList.do?", 
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
					  "mData": null,
					  "bSortable": false,
					  "bSearchable": false,
					  "mRender": function (data) {
						  return data.beComp;
						/*  var status = data.status;
						  if(status == "success"){
							  return data.beComp;
						  }else{
							  return '<font color="red">未处理</font>';
						  }*/
				 		} 
					},
			   		{
					  "aTargets": [2],
					  "mData": null,
					  "bSortable": false,
					  "bSearchable": false,
					  "mRender": function (data) {
						 /* print(data.cmp_content);*/
						  return data.cmp_content;
					  
					}
			   		},
			   		{
					  "aTargets": [3],
					  "mData": null,
					  "bSortable": false,
					  "bSearchable": false,
					  "mRender": function (data, type, full) {
						  return data.tele;
					  
					  }
					},
					{
					  "aTargets": [4],
					  "mData": null,
					  "bSortable": false,
					  "bSearchable": false,
					  "mRender": function (data, type, full) {
						  return data.status;
						  /*var status = data.status;
						  if(status == "success"){
							  return '<font color="green">已处理</font>';
						  }else{
							  return '<font color="red">未处理</font>';
						  }*/
				 		} 
					},{
					  "aTargets": [5],
					  "mData": null,
					  "bSortable": false,
					  "bSearchable": false,
					  "mRender": function (data) {
					
						  if(data.success == "true"){
							  return '2017年'+data.compTime.day+'月'+data.compTime.hours+'日';
						  }else{
							  return '没有数据';
						  }
				 		} 
			   		}], 
				"fnInitComplete": function (oSettings,json) {
					//增加搜索
					$("#product_datatable_filter").append('<label><span class="input-icon"><input id="name" class="form-control input-sm" type="text" placeholder="请输入名称"><i class="glyphicon glyphicon-search blue"></i></span></label>');
					var phtml='<label style="margin-left:20px;">'
						+'<span>状态 ：</span>'
						+'<select  aria-controls="product_datatable" class="form-control input-sm" id="status">'
				        +'<option value="" selected="selected">全部</option><option value="2">上架</option><option value="1">下架</option>'
				        +'</select>'
				        +'</label>';
					$("#product_datatable_filter").append(phtml);
					//增加搜素查询
			    	$("#product_datatable_length").prepend('<a id="resetButton" href="javascript:void(0);" class="btn btn-yellow" style="margin-right: 10px;"><i class="fa fa-mail-reply"></i>重置</a>');
			    	$("#product_datatable_length").prepend('<a id="searchButton" href="javascript:void(0);" class="btn btn-blue" style="margin-right: 10px;"><i class="fa fa-search"></i>搜索</a>');
			    },
			    "fnDrawCallback": function(oSettings){
			    	$("#product_datatable .group-checkable").prop("checked", false);
			    	/*renderButtonFn();*/
			    },
			    "fnServerParams": function (aoData) {
			    	$.fn.bdmp.addParam(aoData,{"name":"name", "value":$.trim($("#product_datatable_filter #name").val())});
			    	$.fn.bdmp.addParam(aoData,{"name":"status", "value":$.trim($("#product_datatable_filter #status").val())});
			    },
			    
			})
			);
});
$("#addButton").on("click", function () {
	$.ajax({
        url: 'feed_getAll.do',
        type: 'POST',
        dataType: 'json',
        success: function (response) {
        	$("#addDialog #brand").find("option").remove();
        	$("#addDialog #brand").append($("<option>").text("请选择").val("0"));
            if (response.success===true){
            	for(var i=0;i<response.aaData.length;i++){
            		if(response.aaData[i].id == 10001)
            			continue;
            		var option = $("<option>").text(response.aaData[i].name).val(response.aaData[i].id);
            		$("#addDialog #brand").append(option);
            	}
            	
            	catalogyIds = new Array();
        		var addDialog = bootbox.dialog({
                    message: $("#addDialog").html(),
                    title: "添加投诉",
                    className: "modal-darkorange",
                    buttons: {
                        "保存": {
                            className: "btn-primary",
                            callback: function () {

                            	var cmp_content = addDialog.find("#cmp_content").val();  
        						var complainant = addDialog.find("#complainant").val();
        						var tele = addDialog.find("#tele").val();
        						var beComp = addDialog.find("#beComp").val();
        						var price = addDialog.find("#price").val();
        						
        						
        						var pirceUnit = addDialog.find("#pirceUnit").val();  
        						var description = addDialog.find("#description").val();
        						$(".bootbox-body #description").attr("value",$(".bootbox-body #myFrameDescription").contents().find("#editor").html());
        						
        						addDialog.find("#catalogies").val(catalogyIds);
        						//异步提交表单
        						addDialog.find("form").ajaxSubmit({
          						    type:'post',
          						    url: 'complaint_insert.do?',
          						    success:function(result){
//          						    	var result = jQuery.parseJSON(data);
          						    	if(result.success==true){
          						    		$.fn.bdmp.message.success("添加成功!");
          						    		oTable.fnReloadAjax();
          							   		addDialog.modal("hide");
          	                   				return true;
          						    	}else{
          						    		$.fn.bdmp.message.error(result.message);
          						    		return false;
          						    	}
          						    },
          						    error:function(XmlHttpRequest,textStatus,errorThrown){
          						    	$.fn.bdmp.message.error("添加失败!");
          								return false;
          						    }
          						});
        						
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
            
        						
                            
                        }
                    }
        		});
            
        
	
});
                           
                 
        		
            
                
		