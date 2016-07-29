$(function(){
	//------------------全局变量 -------------
	var tem_max = []; //最低温度
	var tem_min = []; //最高温度
	var date_day = []; //近期的日期
	var json_cond_info = ""; //保存图片code和路径到全局变量中
	var local = "";//当前地名
	
	//查询城市名称和城市编码
	$.ajax({
		url: 'area_info/queryAreaInfo',
		type: 'POST',
		async: false,
		data: {},
		dataType: "json",
		success: function(data, textStatus){
			var count = data.length;
			$("#areaId").empty();
			$("#areaId").append("<option value=''>请选择要查询的地区</option>");
			for(i=0;i<count;i++){
				var result = data[i];
				var area= {id : result.id,name : result.province+"-->"+result.city+"-->"+result.county};
				$("#areaId").append("<option value='"+area.id+"'>"+area.name+"</option>");
			}
			$("#areaId").chosen({
				'no_results_text':'未查询到结果',
				search_contains: true
			});
		},
		error: function(){
		}
	});
	
	//从icon.json中获取天气的图片
	loadJson();
	function loadJson() {
		
		$.ajax({
			url: 'resource/json/icon.json',
			type: 'GET',
			async: false,
			data: {},
			dataType: "json",
			success: function(data, textStatus){
				json_cond_info = data.cond_info;
			},
			error: function(){
			}
		});
		
		/*$.getJSON("resource/json/icon.json", function(json){
			json_cond_info = json.cond_info;
		});*/
	}
	
	//进入页面查询长春的天气
	Search_Weather("CN101060101");
	
	//点击查询
	$("#search").click(function() {
		var cityID = $("#areaId").val();
		if(cityID != ""){
			Search_Weather(cityID);
		}
	});
	
	function Search_Weather(cityid){
		$.ajax({
			url: 'api/queryApi',
			type: 'POST',
			async: false,
			data: {cityid:cityid},
			dataType: "json",
			success: function(data, textStatus){
				if(data == null){
					alert("请求超时，请检查你的网络！");
				}else{
					Show_Weather(data.data[0]);
				}
			},
			error: function(){
			}
		});
	}
	
	
	//显示天气预报
	function Show_Weather(data){
		if(data!=null){
			
			var daily_forecast = data.daily_forecast;
			var basc = data.basic;
			local = basc.city;
			var Html = "";
			tem_max = [];  //先清空里面的数据
			tem_min = [];
			date_day = [];
			for(var i=0;i<daily_forecast.length;i++){
				tem_max.push(parseFloat(daily_forecast[i].tmp.max));
				tem_min.push(parseFloat(daily_forecast[i].tmp.min));
				date_day.push(daily_forecast[i].date);
				var href = "";
				for ( var int = 0; int < json_cond_info.length; int++) {
					if(daily_forecast[i].cond.code_d == json_cond_info[int].code){
						href = json_cond_info[int].icon;
						break;
					}
				}
				Html+="<div class='col-xs-6 col-md-1-5'><h3><span>"+basc.city+"</span></h3><p>"+daily_forecast[i].date+"</p>" +
						"<p><img class='pngtqico' id='pngtqico' src="+href+" style='border: 0; width: 46px; height: 46px' /></p>" +
						"<p><font color='#4899be' id='tmp_max'>"+daily_forecast[i].tmp.max+"℃"+"</font>~<font id='tmp_min' color='#f00'>"+daily_forecast[i].tmp.min+"℃"+"</font></p>" +
						"<p id='cond_txt_d'>"+daily_forecast[i].cond.txt_d+"</p>" +
						"<p id='wind_dir_sc' style='height: 18px; overflow: hidden'>"+daily_forecast[i].wind.dir+" "+daily_forecast[i].wind.sc+"</p>" +
						"</div>";
			}
			init(); //初始化图标数据
			$("#sixday").empty().append(Html);
		}
	}
	
	// ---------------------折线图 展示近期的天气温度情况
	
	function init(){
		//折线图
		line('line-chart');
	}
	
	//折线图
	function line(optionID)
	{
		var myChart = echarts.init(document.getElementById(optionID));
		var option = {
			    title: {
			        text: local+'未来一周气温变化',
			        subtext: '数据来源互联网'
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['最高气温','最低气温']
			    },
			    toolbox: {
			        show: true,
			        feature: {
			            dataZoom: {},
			            dataView: {readOnly: false},
			            magicType: {type: ['line', 'bar']},
			            restore: {},
			            saveAsImage: {}
			        }
			    },
			    xAxis:  {
			        type: 'category',
			        boundaryGap: false,
			        data: date_day
			    },
			    yAxis: {
			        type: 'value',
			        axisLabel: {
			            formatter: '{value} °C'
			        }
			    },
			    series: [
			        {
			            name:'最高气温',
			            type:'line',
			            data:tem_max,
			            markPoint: {
			                data: [
                                {type:'max',name: '周最高', value: -2, xAxis: 1, yAxis: -1.5}
			                ]
			            },
			            markLine: {
			                data: [
			                    {type: 'average', name: '平均值'}
			                ]
			            }
			        },
			        {
			            name:'最低气温',
			            type:'line',
			            data:tem_min,
			            markPoint: {
			                data: [
			                    {type:'min',name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
			                ]
			            },
			            markLine: {
			                data: [
			                    {type: 'average', name: '平均值'}
			                ]
			            }
			        }
			    ]
			};


		myChart.setOption(option);
	}
	
});