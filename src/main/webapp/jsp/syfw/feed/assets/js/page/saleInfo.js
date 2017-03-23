var catalogyIds;

/* 
 * 判断图片类型 
 *  
 * @param ths  
 *          type="file"的javascript对象 
 * @return true-符合要求,false-不符合 
 */  
function checkImgType(ths){  
        if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ths)) {  
            return false;  
        }  
    return true;  
} 

$(document).on("click",".modal-dialog span[data-role='remove']",function(){
	var parentSpan = $(this).parent();
	if(typeof(parentSpan.attr("catalogyValue"))!="undefined"){
		catalogyIds.splice($.inArray(parentSpan.attr("catalogyValue"),catalogyIds),1);
	}
	parentSpan.remove();
});

$(document).ready(function(){
	var oTable = $("#product_datatable").dataTable(
			$.extend($.fn.bdmp.datatableConf,{
				"sAjaxSource": "sale_getList.do?", 
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
					  "bSearchable": false ,
					
					},
			   		{
					  "aTargets": [2],
					  "mData": "epc",
					  "bSortable": false,
					  "bSearchable": false
					},
			   		{
					  "aTargets": [3],
					  "mData": "aquaticName",
					  "bSortable": false,
					  "bSearchable": false
					},
					{
					  "aTargets": [4],
					  "mData": "payStyle",
					  "bSortable": false,
					  "bSearchable": false,
					
					},{
					  "aTargets": [6],
					  "mData": "finishTime",
					  "bSortable": false,
					  "bSearchable": false 
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
			    	renderButtonFn();
			    },
			    "fnServerParams": function (aoData) {
			    	$.fn.bdmp.addParam(aoData,{"name":"name", "value":$.trim($("#product_datatable_filter #name").val())});
			    	$.fn.bdmp.addParam(aoData,{"name":"status", "value":$.trim($("#product_datatable_filter #status").val())});
			    }
			})
		);
    
    //注册删添加销售订单事件
	$("#addButton").on("click", function () {
		$.ajax({
            url: 'sale_getAll.do',
            type: 'POST',
            dataType: 'json',
            success: function (response) {
            	$("#addDialog #brand").find("option").remove();
            	$("#addDialog #brand").append($("<option>").text("请选择").val("0"));
                if (response.success===true){
                	catalogyIds = new Array();
            		var addDialog = bootbox.dialog({
                        message: $("#addDialog").html(),
                        title: "添加销售单",
                        className: "modal-darkorange",
                        buttons: {
                            "保存": {
                                className: "btn-primary",
                                callback: function () {

            						var name = addDialog.find("#name").val();
            						var no = addDialog.find("#no").val();
            						var brief = addDialog.find("#epc").val();
            						
            						
            						var pitcure = addDialog.find("#tranno").val();  
            						var nameEn = addDialog.find("#aquaticName").val();
            						
            						var price = addDialog.find("#price").val();
            						var expiration = addDialog.find("#weight").val();  
            						var expirationUnit = addDialog.find("#payStyle").val();
            						var sourceArea = addDialog.find("#finishTime").val();
            						var catalog = addDialog.find("catalogies").val();
        
            					
            						addDialog.find("#catalogies").val(catalogyIds);
            						//异步提交表单
            						addDialog.find("form").ajaxSubmit({
              						    type:'post',
              						    url: 'sale_insert.do',
              						    success:function(result){
//              						    	var result = jQuery.parseJSON(data);
              						    	if(result.success==true){
              						    		$.fn.bdmp.message.success("添加成功!");
//              						    		oTable.fnReloadAjax();
//              						    		oTable.fnReloadAjax();
              							   		addDialog.modal("hide");
              							   		
              							   	//让浏览器自动刷新
              							      history.go(0)
              							    location.reload()
              							    location=location
              							    location.assign(location)
              							    document.execCommand('Refresh')
              							    window.navigate(location)
              							    location.replace(location)
              							    document.URL=location.href
              							   		
              							   		
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

            		addDialog.find("#selectCatalogyBt").on("dblclick", function () {
            			
            			
            			var catalogyDialog = bootbox.dialog({
            	            message: $("#catalogyDialog").html(),
            	            title: "商品分类",
            	            className: "modal-darkorange",
            	            openCallback : function(){
            	            	var DataSourceTree = function (options) {
            		                this._data = options.data;
            		                this._delay = options.delay;
            		            };

            		            DataSourceTree.prototype = {
            		                data: function (options, callback) {
            		                    var self = this;
            		                    if(options.id != null && options.id != '' && options.id != 'undefined'){
            		                    	$.ajax({
            			                            url: 'sale_getCatalogyTreeList.do',
            			                            type: 'POST',
            			                            dataType: 'json',
            			                            data:{parentId:options.id},
            			                            success: function (response) {
            			                                if (response.success){
            			        							setTimeout(function () {
            			        		                        var data = $.extend(true, [], response.aaData);
            			        		                        callback({ data: data });
            			        		                    }, this._delay)
            			        						}
            			                            },
            			                            error: function (response) {
            			                                
            			                            }
            			                    });
            		                    }else{
            		                    	setTimeout(function () {
            		                    	/* jQuery.extend()函数的返回值是Object类型，返回扩展了其他对象的属性后的目标对象(即参数target)。 */
            			                        var data = $.extend(true, [], self._data);
            			                        callback({ data: data });
            			                    }, this._delay);
            		                    }
            		                }
            		            };
            	           
            		            $.ajax({
            		                url: 'sale_getCatalogyTreeList.do',
            		                type: 'POST',
            		                dataType: 'json',
            		                success: function (response) {
            		                    if (response.success===true){
            								 var treeDataSource = new DataSourceTree({
            									data: response.aaData,
            									delay: 400
            								});
            	
            								 catalogyDialog.find('#catalogyTree').tree({
            									dataSource: treeDataSource,
            									multiSelect: true,
            									loadingHTML: '<div class="tree-loading"><i class="fa fa-rotate-right fa-spin"></i></div>'
            								});
            								 
            							}
            		                },
            		                error: function (response) {
            		                    
            		                }
            				    });
            	            },
            	            buttons: {
            	            	"保存": {
            	                    className: "btn-primary",
            	                    callback: function () {
            	                    	var obj = catalogyDialog.find('#catalogyTree').tree('selectedItems');
            	                    	var flag = false;
            	                    	for(var i = 0; i< obj.length; i++){
            	                    		flag = flag || true;
            	                    		var id = obj[i].id + "";
            	                    		var name = obj[i].name;
            	                    		if($.inArray(id, catalogyIds) == -1){
                                        		catalogyIds.push(id);
                                        		addDialog.find("#catalogiesStr").append('<span class="tag label label-info" catalogyValue="'+ id +'">' + name +'<span data-role="remove"></span></span>');
                                        	}
            	                    	}
            	                        
            	                        if(!flag){
            	                        	catalogyIds.clear();
            	                        }
            	                    }
            	            	},
            	                "关闭": {
            	                    className: "btn-default",
            	                    callback: function () {
            	                    	catalogyDialog.css("overflow","auto");
            	                    	return true;
            	                    }
            	                }
            	            }
            			});
            			
            			
            		});
                	
                	
			}},
            error: function (response) {
            }
       });
		
		
		
		
		
		
    });
	
    //注册修改按钮事件
    $("#updateButton").on("click", function () {
    	if(oTable.$("tr.active").size() != 1){
    		$.fn.bdmp.message.warning("请选择一条记录进行修改!");
    	}else{
    		
    		
    		$.ajax({
                url: 'brand/getAll.do',
                type: 'POST',
                dataType: 'json',
                success: function (response) {
                	$("#updateDialog #brand").find("option").remove();
                	$("#updateDialog #brand").append($("<option>").text("请选择").val("0"));
                    if (response.success===true){
                    	for(var i=0;i<response.aaData.length;i++){
                    		if(response.aaData[i].id == 10001)
                    			continue;
                    		var option = $("<option>").text(response.aaData[i].name).val(response.aaData[i].id);
                    		$("#updateDialog #brand").append(option);
                    	}
                    	
                    	$("#updateDialog #catalogiesStr").html('');
                		var row = oTable.fnGetData(oTable.$("tr.active")[0]);
            			$.ajax({
            				url: 'product/loadForUpdate.do?id='+row.id,
            				type: 'POST',
            				dataType: 'json',
            				success: function (response) {
            					if (response.success){
            						$("#updateDialog #file1").attr("value",response.aaData.thumbnail);
            						$("#updateDialog #file2").attr("value",response.aaData.pitcure);
            						$("#updateDialog #name").attr("value",response.aaData.name);
            						$("#updateDialog #brief").attr("value",response.aaData.brief);
            						$("#updateDialog #no").attr("value",response.aaData.no);
            						$("#updateDialog #description").attr("value",response.aaData.description);
            						$("#updateDialog #id").attr("value",response.aaData.id);
            						$("#updateDialog #logoImg").attr("src",response.aaData.thumbnail);
            						
            						$("#updateDialog #nameEn").attr("value",response.aaData.nameEn);
            						$("#updateDialog #specification").attr("value",response.aaData.specification);
            						$("#updateDialog #price").attr("value",response.aaData.price);
            						$("#updateDialog #expiration").attr("value",response.aaData.expiration);
            						$("#updateDialog #expirationUnit").attr("value",response.aaData.expirationUnit);
            						
            						$("#updateDialog #sourceArea").attr("value",response.aaData.sourceArea);
            						
            						$("#updateDialog #brand option[value="+row.brand+"] ").attr("selected",true);
            						$("#updateDialog #expirationUnit option[value="+row.expirationUnit+"] ").attr("selected",true);
            						
            						
            						catalogyIds = response.aaData.catalogies;
            						var catalogiesDesc = response.aaData.catalogiesName;
            						for(var i = 0; i< catalogyIds.length; i++){
            							$("#updateDialog #catalogiesStr").append('<span class="tag label label-info" catalogyValue="'+ catalogyIds[i] +'">' + catalogiesDesc[i] +'<span data-role="remove"></span></span>');
            						}
            						
            						var updateDialog = bootbox.dialog({
            				            message: $("#updateDialog").html(),
            				            title: "修改商品信息",
            				            className: "modal-darkorange",
            				            buttons: {
            				                "保存": {
            				                    className: "btn-primary",
            				                    callback: function () {

            				                    	var thumbnail = updateDialog.find("#file1").val();  
            				                    	var pitcure = updateDialog.find("#file2").val();  
            				                    	
            										var name = updateDialog.find("#name").val();
            										var no = updateDialog.find("#no").val();
            										var brief = updateDialog.find("#brief").val();
            										
            										var nameEn = updateDialog.find("#nameEn").val();
            										var specification = updateDialog.find("#specification").val();
            										
            										var price = updateDialog.find("#price").val();
            										var expiration = updateDialog.find("#expiration").val();  
            										var expirationUnit = updateDialog.find("#expirationUnit").val();
            										var sourceArea = updateDialog.find("#sourceArea").val();
            										
            										
            										if (updateDialog.find("#file1").attr("value") == "") {
            											$.fn.bdmp.message.error("请上传缩略图!");
            											return false;
            										}
            										
            	            						if(thumbnail!="" && !checkImgType(thumbnail)){
            	            							$.fn.bdmp.message.error("缩略图非图像类型!");
            	            							return false;	
            	            						}
            	            						
            	            						if (updateDialog.find("#file2").attr("pitcure")  == "") {
            	            							$.fn.bdmp.message.error("请上传大图!");
            	            							return false;
            	            						}
            	            						
            	            						if(pitcure!="" && !checkImgType(pitcure)){
            	            							$.fn.bdmp.message.error("大图非图像类型!");
            	            							return false;	
            	            						}
            	            						
            										
            										if (name == "") {
            											$.fn.bdmp.message.error("名字不能为空!");
            											return false;
            										}
            								
            										if (name.length > 50) {
            											$.fn.bdmp.message.error("名字长度不能超过50!");
            											return false;
            										}
            										
            										if (nameEn == "") {
            											$.fn.bdmp.message.error("英文名字不能为空!");
            											return false;
            										}
            								
            										if (nameEn.length > 50) {
            											$.fn.bdmp.message.error("英文名字长度不能超过50!");
            											return false;
            										}
            								
            								
            										if (no == "") {
            											$.fn.bdmp.message.error("货号不能为空!");
            											return false;
            										}
            										
            										if (no.length > 30) {
            											$.fn.bdmp.message.error("货号长度不能超过30!");
            											return false;
            										}
            										
            										if (specification == "") {
            											$.fn.bdmp.message.error("规格不能为空!");
            											return false;
            										}
            										
            										if (specification.length > 50) {
            											$.fn.bdmp.message.error("规格长度不能超过50!");
            											return false;
            										}
            										
            										if (price == "") {
            											$.fn.bdmp.message.error("价格不能为空!");
            											return false;
            										}
            										
            										if(isNaN(price)){
            	            							$.fn.bdmp.message.error("价格必须是数字!");
            	            							return false;
            	            						}
            	            						
            										
            										if (expiration == "") {
            											$.fn.bdmp.message.error("保质期不能为空!");
            											return false;
            										}

            										if(isNaN(expiration)){
            	            							$.fn.bdmp.message.error("保质期必须是数字!");
            	            							return false;
            	            						}
            	            						
            										
            										if (expirationUnit == "") {
            											$.fn.bdmp.message.error("保质期单位不能为空!");
            											return false;
            										}
            										
            										
            										if (brief == "") {
            											$.fn.bdmp.message.error("简介不能为空!");
            											return false;
            										}
            								
            										if (brief.length > 100) {
            											$.fn.bdmp.message.error("简介长度不能超过50!");
            											return false;
            										}
            										
            										if (sourceArea == "") {
            											$.fn.bdmp.message.error("原产地不能为空!");
            											return false;
            										}
            										
            										if (sourceArea.length > 50) {
            											$.fn.bdmp.message.error("原产地长度不能超过50!");
            											return false;
            										}
            										
            										if (catalogyIds.length == 0) {
            											$.fn.bdmp.message.error("分类不能为空!");
            											return false;
            										}
            									
            										$(".bootbox-body #description").attr("value",$(".bootbox-body #myFrameDescription").contents().find("#editor").html());
            										updateDialog.find("#catalogies").val(catalogyIds);
            										//异步提交表单
            										updateDialog.find("form").ajaxSubmit({
            				  						    type:'post',
            				  						    url: 'product/update.do',
            				  						    success:function(data){
            				  						    	if(data.success==true){
            				  						    		$.fn.bdmp.message.success("修改成功!");
            				  						    		oTable.fnReloadAjax();
            				  						    		updateDialog.modal("hide");
            				  	                   				return true;
            				  						    	}else{
            				  						    		$.fn.bdmp.message.error(data.message);
            				  						    		return false;
            				  						    	}
            				  						    },
            				  						    error:function(XmlHttpRequest,textStatus,errorThrown){
            				  						    	$.fn.bdmp.message.error("修改失败!");
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
            						
            						updateDialog.find("#selectCatalogyBt").on("dblclick", function () {
            							
            							var catalogyDialog = bootbox.dialog({
            					            message: $("#catalogyDialog").html(),
            					            title: "商品分类",
            					            className: "modal-darkorange",
            					            openCallback : function(){
            					            	var DataSourceTree = function (options) {
            						                this._data = options.data;
            						                this._delay = options.delay;
            						            };

            						            DataSourceTree.prototype = {
            						                data: function (options, callback) {
            						                    var self = this;
            						                    if(options.id != null && options.id != '' && options.id != 'undefined'){
            						                    	$.ajax({
            							                            url: 'sale_getCatalogyTreeList.do',
            							                            type: 'POST',
            							                            dataType: 'json',
            							                            data:{parentId:options.id},
            							                            success: function (response) {
            							                                if (response.success){
            							        							setTimeout(function () {
            							        		                        var data = $.extend(true, [], response.aaData);
            							        		                        callback({ data: data });
            							        		                    }, this._delay)
            							        						}
            							                            },
            							                            error: function (response) {
            							                                
            							                            }
            							                    });
            						                    }else{
            						                    	setTimeout(function () {
            							                        var data = $.extend(true, [], self._data);
            							                        callback({ data: data });
            							                    }, this._delay);
            						                    }
            						                }
            						            };
            					           
            						            $.ajax({
            						                url: 'sale_getCatalogyTreeList.do',
            						                type: 'POST',
            						                dataType: 'json',
            						                success: function (response) {
            						                    if (response.success===true){
            												 var treeDataSource = new DataSourceTree({
            													data: response.aaData,
            													delay: 400
            												});
            					
            												 catalogyDialog.find('#catalogyTree').tree({
            													dataSource: treeDataSource,
            													multiSelect: true,
            													loadingHTML: '<div class="tree-loading"><i class="fa fa-rotate-right fa-spin"></i></div>'
            												});
            												 
            											}
            						                },
            						                error: function (response) {
            						                    
            						                }
            								    });
            					            },
            					            buttons: {
            					            	"保存": {
            					                    className: "btn-primary",
            					                    callback: function () {

            					                    	var obj = catalogyDialog.find('#catalogyTree').tree('selectedItems');
            					                    	var flag = false;
            					                    	for(var i = 0; i< obj.length; i++){
            					                    		flag = flag || true;
            					                    		var id = obj[i].id + "";
            					                    		var name = obj[i].name;
            					                    		if($.inArray(id, catalogyIds) == -1){
            				                            		catalogyIds.push(id);
            				                            		updateDialog.find("#catalogiesStr").append('<span class="tag label label-info" catalogyValue="'+ id +'">' + name +'<span data-role="remove"></span></span>');
            				                            	}
            					                    	}
            					                        
            					                        
            					                        if(!flag){
            					                        	catalogyIds.clear();
            					                        }
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
            					}
            				},
            				error: function (response) {
            					
            				}
            			});
    			}},
                error: function (response) {
                	alert("服务器端响应失败");
                }
           });
    		
    		
    		
    		
    		
		}
    });
    
    //注册详细按钮事件
    $("#detailButton").on("click", function () {
    	
    	var row = oTable.fnGetData(oTable.$("tr.active")[0]);
		var id = row.id;
		var _title="商品 - "+row.name+" - 详细信息";
		$.ajax({
    		type : "GET",
    		url : "product/load.do",
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
    
    //注册上架按钮事件
    $("#enableButton").on("click", function () {
    	if(oTable.$("tr.active").size() == 0){
    		$.fn.bdmp.message.warning("请选择记录!");
    	}else{
    		var ids = "";
    		$.each(oTable.$("tr.active"),function(i,n){  
                if(i==0){
                    ids += oTable.fnGetData(n).id;  
                }else {
                    ids += (","+oTable.fnGetData(n).id); 
                } 
            });
    		
    		bootbox.confirm({
		        message: '<span><i class="glyphicon glyphicon-question-sign yellow"></i></span>&nbsp;&nbsp;<span class="font">确定上架吗?</span>',
		        className: "bdmp_confirm",
		        callback: function(result) {
		        	if (result) {
		        		$.post("product/putOnPullOff.do",{ids:ids, status:2},function(data) {
							if(data.success){
								$.fn.bdmp.message.success("操作成功!");
								oTable.fnReloadAjax();
						   	}else{
								$.fn.bdmp.message.error(data.message);
							}
						}, 'json');
		            }
			    }
	    	});
    	}
    });
    
    //注册下架按钮事件
    $("#disableButton").on("click", function () {
    	if(oTable.$("tr.active").size() == 0){
    		$.fn.bdmp.message.warning("请选择记录!");
    	}else{
    		var ids = "";
    		$.each(oTable.$("tr.active"),function(i,n){  
                if(i==0){
                    ids += oTable.fnGetData(n).id;  
                }else {
                    ids += (","+oTable.fnGetData(n).id); 
                } 
            });
    		
    		bootbox.confirm({
		        message: '<span><i class="glyphicon glyphicon-question-sign yellow"></i></span>&nbsp;&nbsp;<span class="font">确定下架吗?</span>',
		        className: "bdmp_confirm",
		        callback: function(result) {
		        	if (result) {
		        		$.post("product/putOnPullOff.do",{ids:ids, status:1},function(data) {
							if(data.success){
								$.fn.bdmp.message.success("操作成功!");
								oTable.fnReloadAjax();
						   	}else{
								$.fn.bdmp.message.error(data.message);
							}
						}, 'json');
		            }
			    }
	    	});
    	}
    });
    
    //注册删除按钮事件
    $("#deleteButton").on("click", function () {
    	if(oTable.$("tr.active").size() == 0){
    		$.fn.bdmp.message.warning("请选择记录!");
    	}else{
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
		        		$.post("sale_delete.do",{ids:ids},function(data) {
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
    	}
    });
    
    
  //注册checkbox以及行选中事件
    $.fn.bdmp.registerCheckboxAction("product_datatable",renderButtonFn);
    
    
    function renderButtonFn(){
    	var enableButtonFlag = true;
    	var disableButton = true;
    	$.each(oTable.$("tr.active"),function(i,n){
    		if(oTable.fnGetData(n).status == 2){
    			enableButtonFlag = false;
    		}else if(oTable.fnGetData(n).status == 1){
    			disableButton = false;
    		}
        });
    	if(oTable.$("tr.active").size()==1){
    		$("#updateButton").removeAttr("disabled");
    		$("#detailButton").removeAttr("disabled");
    	}else{
    		$("#updateButton").attr("disabled","disabled");
    		$("#detailButton").attr("disabled","disabled");
    	}
    	if(oTable.$("tr.active").size()>0){
    		$("#deleteButton").removeAttr("disabled");
    	}else{
    		$("#deleteButton").attr("disabled","disabled");
    	}
    	if(enableButtonFlag&&oTable.$("tr.active").size()>0){
    		$("#enableButton").removeAttr("disabled");
    	}else{
    		$("#enableButton").attr("disabled","disabled");
    	}
    	if(disableButton&&oTable.$("tr.active").size()>0){
    		$("#disableButton").removeAttr("disabled");
    	}else{
    		$("#disableButton").attr("disabled","disabled");
    	}
    }

    
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
    	$("#product_datatable_filter #name").val("");
    	$("#product_datatable_filter #status").val("");
    	oTable.fnReloadAjax();
    });
});