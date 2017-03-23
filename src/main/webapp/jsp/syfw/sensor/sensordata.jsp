<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String categories="[ '狗', '猫', '兔子', '老虎', '大象']";
String data="[10,13,15,17,19]";

%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Highcharts Example</title>

		<script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		//x轴值
		var categories=<%=categories%>;

		//y轴值
		var data=<%=data%>;
				
		//创建图表
		var chart;
		$(document).ready(function() {
			chart = new Highcharts.Chart( {
				chart : {
					renderTo : 'container',
					type : 'bar',
					events : {
						load : st// 定时器
					}
				},
				title : {
					text : '各类传感器实时采集值'
				},
				xAxis : { 
					categories : categories,
					title : {
						text : 'name'
					}
					
				},
				yAxis : {
					min : 0,
					title : {
						text : 'number'
					}
				},
		        legend: {
		            enabled: false
		        },
				tooltip : {
					formatter : function() {
						return '' + this.series.name + ': ' + this.y + '';
					}
				},
		        credits : {
		            enabled: false
		        },
				plotOptions : {
					series : {
						stacking : 'normal'
					}
				}, 
				series : [ {
					name : '个',
					data : data
				} ]
			});
			
			
		});


		//10秒钟刷新一次数据
		function st() {
			setInterval("getData()", 10000);
		}

		//动态更新图表数据
		function getData() {
			
			var categories = [];
			$.ajax({
				  type: "post",
				  url: "/epcisclient-web/syfw/sensor_test.action",			 
				  dataType: "json",
				  success : function(data){
					  //alert(data);
					  var json = JSON.parse(data);//将后台传回的字符串转换成json对象，和eval功能类似
					  var d = [];
					  $.each(json,function(n,item){
						  d.push(item.data);
						  categories.push(item.categories);
					  });
					 //d =[2,5,6,8];
					  //alert("d"+d);
					  //alert("categories" +categories);
					 chart.series[0].setData(d);
					 chart.xAxis[0].setCategories(categories);
				  },
				  error: function (msg) {
		                alert("请求失败"+msg);
		            }
				  
		  });
		}

		</script>
	</head>
	<body>
<script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/highcharts.js" charset="utf-8"></script>
<!-- <script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/funnel.js"></script> -->
<script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/highcharts-more.js"></script>

<div id="container" ></div>
	</body>
</html>
