$(function(){
	
	var date_day = [];//日期
	var tem_max = [];//最高温度
	var tem_min = [];//最低温度
	
//---------------------------  历史天气  ------------------
	var year = [2011,2012,2013,2014,2015,2016];
	var month = ["01","02","03","04","05","06","07","08","09","10","11","12"];
	var CityName_zn = ['北京','天津','上海','重庆','哈尔滨','长春','沈阳',
                   '西安','济南','兰州', '郑州','南京','武汉','杭州',
                   '合肥','福州','南昌','长沙','成都','广州','昆明',
                   '南宁','苏州','深圳'];
	
	showSelect();
	function showSelect() {
		//地区
		$("#areaId").empty();
		$("#areaId").append("<option value=''>请选择要查询的地区</option>");
		for(i=0;i<CityName_zn.length;i++){
			$("#areaId").append("<option value='"+CityName_zn[i]+"'>"+CityName_zn[i]+"</option>");
		}
		$("#areaId").chosen({
			'no_results_text':'未查询到结果',
			search_contains: true
		});

		//年
		$("#year").empty();
		$("#year").append("<option value=''>请选择要查询的年份</option>");
		for(var i=0;i<year.length;i++){
			$("#year").append("<option value='"+year[i]+"'>"+year[i]+"</option>");
		}
		$("#year").chosen({
			'no_results_text':'未查询到结果',
			search_contains: true
		});

		//月
		$("#month").empty();
		$("#month").append("<option value=''>请选择要查询的月份</option>");
		for(var i=0;i<month.length;i++){
			$("#month").append("<option value='"+month[i]+"'>"+month[i]+"</option>");
		}
		$("#month").chosen({
			'no_results_text':'未查询到结果',
			search_contains: true
		});


	}
	
	getData("长春","2011-05%"); //默认查询结果
	
	
	//  查询信息
	var local = "长春";
	var his_year = "2011";
	var his_month = "05";
	$("#search").click(function(){
		var areaName = $("#areaId").val();
		var year = $("#year").val();
		var month = $("#month").val();
		if(areaName ==  ""){
			areaName = "长春";
		}
		if(year == ""){
			year = "2011";
		}
		if(month == ""){
			month = "05";
		}
		his_year = year;
		his_month = month;
		var date = year+"-"+month+"%";
		local = areaName;
		
		getData(areaName,date); //查询结果
	});
	
	function getData(areaName,date) {
		$.ajax({
			url: 'historyWather/query',
			type: 'POST',
			async: true,
			data: {city_name:areaName,date:date},
			dataType: "json",
			success: function(data, textStatus){
				stuctDate(data);
			},
			error: function(){
				console.dir("ERROR  table.js ");
			}
		});
	}
	
	function stuctDate(data){
		date_day = [];//日期
		tem_max = [];//最高温度
		tem_min = [];//最低温度
		for ( var i = 0; i < data.length; i++) {
			date_day.push(data[i].date.substr(8,2));
			tem_max.push(data[i].maxtemperature);
			tem_min.push(data[i].mintemperature);
		}
		init();
	}
	
// ---------------------折线图 展示天气温度情况
	
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
			        text: local+his_year+"年"+his_month+"月"+' 历史气温变化',
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
                                {type:'max',name: '月最高', value: -2, xAxis: 1, yAxis: -1.5}
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
			                    {type:'min',name: '月最低', value: -2, xAxis: 1, yAxis: -1.5}
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