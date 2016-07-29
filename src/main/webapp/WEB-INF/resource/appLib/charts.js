//实时空气排行
$(function(){
	
	var reqest_data = [];  //所有的空气质量数据
	var max_area = [];
	var max_aqi = [];
	var min_area = [];
	var min_aqi = [] ;
	var date = "";
	//优（绿色）、良（黄色）、轻度污染（橙色）、中度污染（红色）、重度污染（紫色）、严重污染（褐红色）
	//AQI指数在50以下时，对应的空气质量就是优，51—100为良，101-150为中度污染，151-200重度污染，201-300重度污染，300以上严重污染
	var color = ['64CF29','FFCB00','FF6734','D32F30','933569','952322'];
	var relve = ['优','良','轻度污染','中度污染','重度污染','严重污染'];
	
	
	Search(); //实时查询所有的空气质量数据
	function Search() {
		$.ajax({
			url: 'api/queryAqi', //暂时访问这个地址（到时候要在数据酷中查询）
			type: 'POST',
			async: false,
			data: {},
			dataType: "json",
			success: function(data, textStatus){
				reqest_data = data;
				date = data[0].time_point.replace("T"," ").replace("Z","");
				show_rang(data);
				init();
				showCityRangeDataAsc(data);
			},
			error: function(){
			}
		});
	}
	
	//全国实时空气排行后十名和前十名
	function show_rang(data) {
		var j = 0;
		max_area = [];
		max_aqi = [];
		min_area = [];
		min_aqi = [];
		for(var i = data.length-1 ; j < 10 ; j++,i-- ){
			max_area.push(data[i].area);
			max_aqi.push(data[i].aqi);
			min_area.push(data[j].area);
			min_aqi.push(data[j].aqi);
		}
	}
	
	
	
	//展示排名数据(正序)
	function showCityRangeDataAsc(data) {
		var html="";
		if(data!=null){
			for(var i=0;i<data.length;i++){
				var position  = (data[i].area == null ? "暂无":data[i].area);
				html+="<tr>"+
				"<td>"+parseInt(i+1)+"</td>"
				+"<td>"+position+"</td>"
				+"<td>"+data[i].aqi+"</td>"
				+"<td >"+data[i].quality+"("+data[i].level+")"+"</td>" 
				+"<td>"+data[i].primary_pollutant+"</td>" 
				+"<td>"+data[i].pm2_5+"</td>" 
				+"<td>"+data[i].pm10+"</td>" 
				+"<td>"+data[i].co+"</td>" 
				+"<td>"+data[i].no2+"</td>" 
				+"<td>"+data[i].o3+"</td>" 
				+"<td>"+data[i].o3_8h+"</td>" 
				+"<td>"+data[i].so2+"</td>" 
				+"</tr>";
			}
		}
		$("#date").empty().append("&nbsp;&nbsp;&nbsp;&nbsp;"+date+" 发布");
		$("#chartslist").empty().html(html);
	}
	
	//倒叙展示数据
	function showCityRangeDataDesc(data) {
		var html="";
		if(data!=null){
			for(var i=data.length;i > 0;i--){
				var position  = (data[i-1].area == null ? "暂无":data[i-1].area);
				html+="<tr>"+
				"<td>"+parseInt(i)+"</td>"
				+"<td>"+position+"</td>"
				+"<td>"+data[i-1].aqi+"</td>"
				+"<td >"+data[i-1].quality+"("+data[i-1].level+")"+"</td>" 
				+"<td>"+data[i-1].primary_pollutant+"</td>" 
				+"<td>"+data[i-1].pm2_5+"</td>" 
				+"<td>"+data[i-1].pm10+"</td>" 
				+"<td>"+data[i-1].co+"</td>" 
				+"<td>"+data[i-1].no2+"</td>" 
				+"<td>"+data[i-1].o3+"</td>" 
				+"<td>"+data[i-1].o3_8h+"</td>" 
				+"<td>"+data[i-1].so2+"</td>" 
				+"</tr>";
			}
		}
		$("#date").empty().append("&nbsp;&nbsp;&nbsp;&nbsp;"+date+" 发布");
		$("#chartslist").empty().html(html);
	}
	
	$("#btn_asc").click(function() {
		showCityRangeDataAsc(reqest_data);
	});
	
	$("#btn_desc").click(function() {
		showCityRangeDataDesc(reqest_data);
	});
	
	
	function init(){
		var col = "952322";
		if(max_aqi[0] < 300 && max_aqi[0] > 201){
			col = "FFCB00";
		}else if(max_aqi[0] <= 200 && max_aqi[0] > 150){
			col = "FF6734";
		}else if(max_aqi[0] <= 150 && max_aqi[0] > 100){
			col = "D32F30";
		}
		else if(max_aqi[0] <= 100 && max_aqi[0] > 50){
			col = "933569";
		}
		bar('aqi—min-chart',"全国空气质量指数(AQI)前十名",min_aqi,min_area,"64CF29");
		bar('aqi—max-chart',"全国空气质量指数(AQI)后十名",max_aqi,max_area,col);
	}
	
	//柱状图
	function bar(optionID,text,aqi,area,col) {
		
		var myChart = echarts.init(document.getElementById(optionID));
		option = {
			    title : {
			        text: text,
			        subtext: date+' 发布',
			        left: 'center',
			        textStyle: {
			            color: '#'+col
			        }
			    },
			    backgroundColor: '#f1f4f7',
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:[]
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            dataView : {show: true, readOnly: false},
			            magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            data : area
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            min:0, 
				        max:500
			        }
			    ],
			    series : [
			       
			        {
			            name:'AQI',
			            type:'bar',
			            data:aqi,
			            itemStyle:{
			            	normal: {
			            		color:'#'+col,
			            		label:{
			            			color:'#'+col, 
				            		show: true,
				            		position:'top'
			            		}
			            	}
						}
			          /*  markPoint : {
			                data : [
			                    {name : 'AQI最高', value : 182.2, xAxis: 7, yAxis: 183},
			                    {name : 'AQI最低', value : 2.3, xAxis: 11, yAxis: 3}
			                ]
			            },*/
			           /* markLine : {
			                data : [
			                    {type : 'average', name : '平均值'}
			                ]
			            }*/
			        }
			    ]
			};
		myChart.setOption(option);

	}
	
	
	
});