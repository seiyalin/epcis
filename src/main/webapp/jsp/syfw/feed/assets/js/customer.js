$(document).ready(function(){
	$("#loginOutBtn").on("click", function () {
	bootbox.confirm({
			message: '<span><i class="glyphicon glyphicon-question-sign yellow"></i></span>&nbsp;&nbsp;<span class="font">确定注销吗?</span>',
			className: "bdmp_confirm",
			callback: function(result) {
				if (result) {
					$.post("portal/logout.do",{},function(data) {
						if(data.success){
							$.fn.bdmp.message.success("注销成功!");
							location.href ="login.jsp";
						}else{
							$.fn.bdmp.message.error(data.message);
						}
					}, 'json');
				}
			}
		});
	});

	var html = "";
	var data = eval("(" + $("#menus").val() + ")");
    if(data != null && data != '' && data.length > 0){
    	for(var i = 0; i< data.length; i++){
        	var isLeaf = data[i].isLeaf;
        	if(isLeaf){
        		html +='<li>'
        			+ '    <a href="' + data[i].url + '">'
        			+ '        <i class="menu-icon glyphicon glyphicon-tasks"></i>'
        			+ '        <span class="menu-text"> ' + data[i].text + ' </span>'
        			+ '    </a>'
        			+ '</li>';
        	}else{
        		html += '<li>'
        		+ '    <a href="#" class="menu-dropdown">'
        		+ '        <i class="menu-icon glyphicon glyphicon-tasks"></i>'
        		+ '        <span class="menu-text"> ' + data[i].text + ' </span>'
        		+ '        <i class="menu-expand"></i>'
        		+ '    </a>'
        		+ '    <ul class="submenu">';
        		
        		var children = data[i].children;
        		
    			for(var j = 0; j < children.length; j++){
    				isLeaf = children[j].isLeaf;
    				if(isLeaf){
            			html += '        <li>'
    	            		+ '            <a href="' + children[j].url + '">'
    	            		+ '                <span class="menu-text">' + children[j].text + '</span>'
    	            		+ '            </a>'
    	            		+ '        </li>';
    				}else{
            			html += '<li>'
    	            		+ '    <a href="#" class="menu-dropdown">'
    	            		+ '        <i class="menu-icon glyphicon glyphicon-tasks"></i>'
    	            		+ '        <span class="menu-text"> ' + children[j].text + ' </span>'
    	            		+ '        <i class="menu-expand"></i>'
    	            		+ '    </a>'
    	            		+ '    <ul class="submenu">';
            			children = children[j].children;
            			for(var k = 0; k < children.length; k++){
                			html += '        <li>'
    		            		+ '            <a href="' + children[k].url + '">'
    		            		+ '                <span class="menu-text">' + children[k].text + '</span>'
    		            		+ '            </a>'
    		            		+ '        </li>';
                		}
            			html += '    </ul>'
    	            		 + '</li>';
            		}
        		}
        		
        		html += '    </ul>'
        		+ '</li>';
        	}
        }
        $("#menuId").html(html);
    }

    
    var href=window.location.href;
	href = href.substring(href.lastIndexOf("/")+1,href.length);
	var e_a = $("a[href$='"+href+"']");
	if(e_a!=undefined){
		e_a.parent("li").addClass("active");
		if(e_a.parent("li").parent("ul").hasClass("submenu")){
			e_a.parent("li").parent("ul").parent("li").addClass("open");
			//e_a.parent("li").parent("ul").parent("li").addClass("active");
		}
	}
	
	
});

$.fn.bdmp={
		datatableConf:{
			"sDom" : "Tflt<'row DTTTFooter'<'col-sm-6'i><'col-sm-6'p>>",
			"aLengthMenu": [
                [5, 10, 20, 50, 100],[5, 10, 20, 50, 100]
            ],
			"iDisplayLength" : 5,
			/* "sPaginationType": "full_numbers", */
			"oTableTools": {
			    "aButtons": [
			    	/* "copy", "csv", "xls", "pdf", "print" */
			    ],
			    "sSwfPath": "assets/js/swf/copy_csv_xls_pdf.swf"
			},
			"language" : {
				"search" : "",
				"sLengthMenu" : "_MENU_",
				"sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
				"oPaginate" : {
					"sFirst" : "首页",    
                    "sPrevious" : "上一页",    
                    "sNext" : "下一页",    
                    "sLast" : "尾页" 
				},
				"sZeroRecords": "抱歉， 没有找到",
				"sInfoEmpty": "没有数据"
			},
			"bProcessing": true, //当datatable获取数据时候是否显示正在处理提示信息。
			"bServerSide": true, //客户端处理分页
			"sServerMethod": "POST",   //以post的方式提交数据
			"aaSorting" : []
		},
		
		registerCheckboxAction:function(tableId,callback){
			//datatable checkbox选中
		    $("#"+tableId).on("click","input.checkboxes",function() {
//		    	var checked = $(this).is(":checked");
		    	var checked = $(this).prop("checked");
				if (!checked) {
					if ( $(this).hasClass("single-checkbox")){
						var $set = $("#"+tableId+" .checkboxes");
						$set.each(function() {
								$(this).prop("checked", false);
								$(this).parents('tr').removeClass("active");
						});
					}
					$(this).parents('tr').addClass("active");
				} else {
					$(this).parents('tr').removeClass("active");
				}
				var $set=$("#"+tableId+" .checkboxes");
		        $("#"+tableId+" .group-checkable").prop("checked",$set.length==$set.filter(":checked").length);
		        /*if(callback){
		        	callback();
		        }
		        e.stopPropagation();*/
			});
			
			//datatable全选
			$("#"+tableId).on("click",".group-checkable",function() {
				var $set = $("#"+tableId+" .checkboxes");
				var checked = $(this).is(":checked");
				$set.each(function() {
					if (checked) {
						$(this).prop("checked", true);
						$(this).parents('tr').addClass("active");
					} else {
						$(this).prop("checked", false);
						$(this).parents('tr').removeClass("active");
					}
				});
				if(callback){
		        	callback("all");
		        }
			});
			
			//datatable行选中
			$("#"+tableId).on("click","tbody tr",function() {
				/*var check = $(this).find(".checker input[type='checkbox']");*/
				var check = $(this).find("input[type='checkbox']");
				if (check.is(":checked")) {
					check.prop("checked", false);
					$(this).removeClass("active");
				} else {
					if (check.hasClass("single-checkbox")){
						var $set = $("#"+tableId+" .checkboxes");
						$set.each(function() {
								$(this).prop("checked", false);
								$(this).parents('tr').removeClass("active");
						});
					}
					check.prop("checked", true);
					$(this).addClass("active");
				}
				var $set=$("#"+tableId+" .checkboxes");
		        $("#"+tableId+" .group-checkable").prop("checked",$set.length==$set.filter(":checked").length);
		        if(callback){
		        	callback($(this));
		        }
			});
		}
};

/*弹出框*/
$.fn.bdmp.message={
		success:function(content){
			Notify(content, 'bottom-right', '3000', 'success', 'fa-check', true);
		},
		
		info:function(content){
			Notify(content, 'bottom-right', '3000', 'info', 'fa-envelope', true);
		},
		
		warning:function(content){
			Notify(content, 'bottom-right', '3000', 'warning', 'fa-warning', true);
		},
		
		error:function(content){
			Notify(content, 'bottom-right', '3000', 'danger', 'fa-bolt', true);
		}
		
};

/*增加请求参数*/
$.fn.bdmp.addParam = function(array,ob){
	$.each(array,function(i,n){  
        if(ob.name==n.name){
        	n.value=ob.value;
        	return;
        }
    });
	array.push({"name":ob.name, "value":ob.value});
	return;
};

$.fn.bdmp.page={
		/*根据起始行和每页行数获得页数*/
		div:function(exp1, exp2){
			var n1 = Math.round(exp1); //四舍五入     
		    var n2 = Math.round(exp2); //四舍五入    
		  
		    var rslt = n1 / n2; //除    
		    if (rslt >= 0) {  
		        rslt = Math.floor(rslt); //返回小于等于原rslt的最大整数。     
		    }  
		    else {  
		        rslt = Math.ceil(rslt); //返回大于等于原rslt的最小整数。     
		    }  
		    return rslt;  
		},
		
		/*获得当前页*/
		currentPage:function(oTable){
			var tableSetings=oTable.fnSettings()  
		    var paging_length=tableSetings._iDisplayLength;//当前每页显示多少  
		    var page_start=tableSetings._iDisplayStart;//当前页开始  
		    return page=this.div(page_start,paging_length);
		}
}

$.fn.bdmp.check={
	checkCHS : function(value){
		return /^[\u0391-\uFFE5]+$/.test(value);
	},
	
	checkZIP : function(value){
		return /^[1-9]\d{5}$/.test(value);
	},
	
	checkQQ : function(value){
		return /^[1-9]\d{4,10}$/.test(value);
	},
	
	checkTel : function(value){
		return /^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/.test(value);
	},
	checkEmail : function(value){
		return /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(value);
	},
	checkMobile : function(value){
		return /^1[3|4|5|8][0-9]\d{4,8}$/.test(value);
	},
	
	checkLoginName : function(value){
		return /^[\u0391-\uFFE5\w]+$/.test(value);
	},
	checkEqualTo : function(value){
		return /^[\u0391-\uFFE5]+$/.test(value);
	},
	
	checkNumber : function(value){
		return /^\d+$/.test(value);
	},
	checkDouble:function(value){
		return /^\d{0,8}(\.\d{0,2})?$/.test(value);
	},
	checkRequired:function(value){
		return value!=undefined && value!=null && value!="" && value!="undefined";
	},
	hasChineseChar : function(value){
		return /.*[\u4e00-\u9fa5].*/.test(value);
	},
	checkFullLoginName : function(value){
		return /^[a-zA-Z_0-9.@-]+$/.test(value);
	},
};

/*$(document).ready(function(){
	$("li[mod]").click(function(){
		var name = $.trim($($(this).find(".menu-text")[0]).html());
		var mod = $(this).attr("mod");
		var url = $(this).attr("url");
		var close = $(this).attr("close");
		var choose = $(".tabbable a[href='#"+mod+"']");
		if(choose.length>0){
			var parent = choose.parent("li");
			parent.addClass("active");
			parent.siblings("li").removeClass("active");
			$("#"+mod).addClass("in").addClass("active");
			$("#"+mod).siblings("div").removeClass("in").removeClass("active");
		}else{
			$(".nav-tabs li").removeClass("active");
			if(close!='false'){
				$(".nav-tabs").append('<li class="active"><a style="padding-right:10px" data-toggle="tab" href="#'+mod+'">'+name+'<span style="margin-left:10px;cursor:pointer" class="typcn typcn-times" tabclose="'+mod+'"></span></a></li>');
			}else{
				$(".nav-tabs").append('<li class="active"><a data-toggle="tab" href="#'+mod+'">'+name+'</a></li>');
			}
			$(".tab-content .tab-pane").removeClass("in").removeClass("active");
			var content = "";
			content += '<div id="'+mod+'" class="tab-pane in active">';
			content += '<iframe id="'+mod+'-iframe" scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:500px;"></iframe>>';	
			content += '</div>';
			$(".tab-content").append(content);
		}
	});
	
	$(".nav-tabs").on("click", "[tabclose]", function (e) {
		var mod = $(this).attr("tabclose");
		if ($(".nav-tabs .active a").attr("href") == "#" + mod) {
			$(".tabbable a[href='#"+mod+"']").parent("li").prev().addClass('active');
	        $("#" + mod).prev().addClass('active');
	    }
	    $(".tabbable a[href='#"+mod+"']").parent("li").remove();
	    $("#" + mod).remove();
    });
});*/


jQuery.fn.dataTableExt.oApi.fnReloadAjax = function ( oSettings, sNewSource, fnCallback, bStandingRedraw )
{
    // DataTables 1.10 compatibility - if 1.10 then `versionCheck` exists.
    // 1.10's API has ajax reloading built in, so we use those abilities
    // directly.
    if ( jQuery.fn.dataTable.versionCheck ) {
        var api = new jQuery.fn.dataTable.Api( oSettings );
 
        if ( sNewSource ) {
            api.ajax.url( sNewSource ).load( fnCallback, !bStandingRedraw );
        }
        else {
            api.ajax.reload( fnCallback, !bStandingRedraw );
        }
        return;
    }
 
    if ( sNewSource !== undefined && sNewSource !== null ) {
        oSettings.sAjaxSource = sNewSource;
    }
 
    // Server-side processing should just call fnDraw
    if ( oSettings.oFeatures.bServerSide ) {
        this.fnDraw();
        return;
    }
 
    this.oApi._fnProcessingDisplay( oSettings, true );
    var that = this;
    var iStart = oSettings._iDisplayStart;
    var aData = [];
 
    this.oApi._fnServerParams( oSettings, aData );
 
    oSettings.fnServerData.call( oSettings.oInstance, oSettings.sAjaxSource, aData, function(json) {
        /* Clear the old information from the table */
        that.oApi._fnClearTable( oSettings );
 
        /* Got the data - add it to the table */
        var aData =  (oSettings.sAjaxDataProp !== "") ?
            that.oApi._fnGetObjectDataFn( oSettings.sAjaxDataProp )( json ) : json;
 
        for ( var i=0 ; i<aData.length ; i++ )
        {
            that.oApi._fnAddData( oSettings, aData[i] );
        }
 
        oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
 
        that.fnDraw();
 
        if ( bStandingRedraw === true )
        {
            oSettings._iDisplayStart = iStart;
            that.oApi._fnCalculateEnd( oSettings );
            that.fnDraw( false );
        }
 
        that.oApi._fnProcessingDisplay( oSettings, false );
 
        /* Callback user function - for event handlers etc */
        if ( typeof fnCallback == 'function' && fnCallback !== null )
        {
            fnCallback( oSettings );
        }
			    }, oSettings);
};


/************************common js********************************/


function showDeatil(_content,_title){
	$(".detail-container .widget .widget-body").html(_content);
	$(".detail-container .widget .widget-header .widget-caption").html(_title);
	$(".detail-container .widget").show();
	$('.widget-table-container .widget-buttons *[data-toggle="collapse"]').click();
}

$('.widget-buttons *[data-toggle="self-dispose"]').on("click",
		function(n) {
			n.preventDefault();
			var i = $(this),
			t = i.parents(".widget").eq(0);
			t.hide();
			$('.widget-table-container .widget-buttons *[data-toggle="collapse"]').click();
		});


function setImg(fileInput){
	var file = fileInput.files[0];    
    //判断类型是不是图片  
    if(!/image\/\w+/.test(file.type)){     
    	$.fn.bdmp.message.error("请确保文件为图像类型");   
            return false;   
    }   
    var reader = new FileReader();   
    reader.readAsDataURL(file);   
    reader.onload = function(e){   
    	var $img=$(fileInput).parents(".x-img-group").find("img");
    	$img.attr("src",this.result);
    	
    	var dis =$img.css("display");
       if(dis=='none'){
    	   $img.show(300,function(){});
       }
    };
}

/**resize img function*/
function AutoResizeImage(maxWidth,maxHeight,imgUrl){
	var img = new Image();
	img.src = imgUrl;
	var hRatio;
	var wRatio;
	var Ratio = 1;
	var w = img.width;
	var h = img.height;
	wRatio = maxWidth / w;
	hRatio = maxHeight / h;
	if (maxWidth ==0 && maxHeight==0){
		Ratio = 1;
	}else if (maxWidth==0){//
		Ratio = hRatio;
	}else if (maxHeight==0){
		Ratio = wRatio;
	}else {
		Ratio = (wRatio<=hRatio?wRatio:hRatio);
	}
	w = w * Ratio;
	h = h * Ratio;
	img.height = h;
	img.width = w;
	return img;
	}
function showBigImg(imgUrl){
	
	var img =AutoResizeImage(1050,0,imgUrl);
	var htm='<div class="zm-light-box-x1" id="zm-light-box-x1">'+
	'<div class="zm-light-box-x2" id="zm-light-box-x2">'+
	'<img src="'+imgUrl+'" class="zm-light-box-img-el big-img"  height="'+img.height+'" width="'+img.width+'" />'+
	'<div class="zm-light-box-footer">'+
	'<a class="zm-light-box-show-origin" href="'+imgUrl+'" target="_blank">查看原图</a>'+
	'</div></div></div>';
		
	
	bootbox.dialog({
        message: htm,
        className: "big-img-container"
	});
	
	$(".big-img-container .modal-dialog").addClass("zm-light-box");
	$(".big-img-container .modal-content").css({"width": "100%", "background": "transparent"});
	
}
$(document).on("click",".little-img", function () {
	var url =$(this).attr("src");
	if(url!=undefined&&url!=null&&url!=""){
		showBigImg(url);
	}
	
}); 
$(document).on("click",".big-img", function () {
	$(".big-img-container").modal("hide");
});


