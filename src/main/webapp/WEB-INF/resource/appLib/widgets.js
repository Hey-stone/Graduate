//实时的PM
$(function(){
	
	var geoCoordMap = {
		    "海门":[121.15,31.89],
		    "鄂尔多斯":[109.781327,39.608266],
		    "招远":[120.38,37.35],
		    "舟山":[122.207216,29.985295],
		    "齐齐哈尔":[123.97,47.33],
		    "盐城":[120.13,33.38],
		    "赤峰":[118.87,42.28],
		    "青岛":[120.33,36.07],
		    "乳山":[121.52,36.89],
		    "金昌":[102.188043,38.520089],
		    "泉州":[118.58,24.93],
		    "莱西":[120.53,36.86],
		    "日照":[119.46,35.42],
		    "胶南":[119.97,35.88],
		    "南通":[121.05,32.08],
		    "拉萨":[91.11,29.97],
		    "云浮":[112.02,22.93],
		    "梅州":[116.1,24.55],
		    "文登":[122.05,37.2],
		    "上海":[121.48,31.22],
		    "攀枝花":[101.718637,26.582347],
		    "威海":[122.1,37.5],
		    "承德":[117.93,40.97],
		    "厦门":[118.1,24.46],
		    "汕尾":[115.375279,22.786211],
		    "潮州":[116.63,23.68],
		    "丹东":[124.37,40.13],
		    "太仓":[121.1,31.45],
		    "曲靖":[103.79,25.51],
		    "烟台":[121.39,37.52],
		    "福州":[119.3,26.08],
		    "瓦房店":[121.979603,39.627114],
		    "即墨":[120.45,36.38],
		    "抚顺":[123.97,41.97],
		    "玉溪":[102.52,24.35],
		    "张家口":[114.87,40.82],
		    "阳泉":[113.57,37.85],
		    "莱州":[119.942327,37.177017],
		    "湖州":[120.1,30.86],
		    "汕头":[116.69,23.39],
		    "昆山":[120.95,31.39],
		    "宁波":[121.56,29.86],
		    "湛江":[110.359377,21.270708],
		    "揭阳":[116.35,23.55],
		    "荣成":[122.41,37.16],
		    "连云港":[119.16,34.59],
		    "葫芦岛":[120.836932,40.711052],
		    "常熟":[120.74,31.64],
		    "东莞":[113.75,23.04],
		    "河源":[114.68,23.73],
		    "淮安":[119.15,33.5],
		    "泰州":[119.9,32.49],
		    "南宁":[108.33,22.84],
		    "营口":[122.18,40.65],
		    "惠州":[114.4,23.09],
		    "江阴":[120.26,31.91],
		    "蓬莱":[120.75,37.8],
		    "韶关":[113.62,24.84],
		    "嘉峪关":[98.289152,39.77313],
		    "广州":[113.23,23.16],
		    "延安":[109.47,36.6],
		    "太原":[112.53,37.87],
		    "清远":[113.01,23.7],
		    "中山":[113.38,22.52],
		    "昆明":[102.73,25.04],
		    "寿光":[118.73,36.86],
		    "盘锦":[122.070714,41.119997],
		    "长治":[113.08,36.18],
		    "深圳":[114.07,22.62],
		    "珠海":[113.52,22.3],
		    "宿迁":[118.3,33.96],
		    "咸阳":[108.72,34.36],
		    "铜川":[109.11,35.09],
		    "平度":[119.97,36.77],
		    "佛山":[113.11,23.05],
		    "海口":[110.35,20.02],
		    "江门":[113.06,22.61],
		    "章丘":[117.53,36.72],
		    "肇庆":[112.44,23.05],
		    "大连":[121.62,38.92],
		    "临汾":[111.5,36.08],
		    "吴江":[120.63,31.16],
		    "石嘴山":[106.39,39.04],
		    "沈阳":[123.38,41.8],
		    "苏州":[120.62,31.32],
		    "茂名":[110.88,21.68],
		    "嘉兴":[120.76,30.77],
		    "长春":[125.35,43.88],
		    "胶州":[120.03336,36.264622],
		    "银川":[106.27,38.47],
		    "张家港":[120.555821,31.875428],
		    "三门峡":[111.19,34.76],
		    "锦州":[121.15,41.13],
		    "南昌":[115.89,28.68],
		    "柳州":[109.4,24.33],
		    "三亚":[109.511909,18.252847],
		    "自贡":[104.778442,29.33903],
		    "吉林":[126.57,43.87],
		    "阳江":[111.95,21.85],
		    "泸州":[105.39,28.91],
		    "西宁":[101.74,36.56],
		    "宜宾":[104.56,29.77],
		    "呼和浩特":[111.65,40.82],
		    "成都":[104.06,30.67],
		    "大同":[113.3,40.12],
		    "镇江":[119.44,32.2],
		    "桂林":[110.28,25.29],
		    "张家界":[110.479191,29.117096],
		    "宜兴":[119.82,31.36],
		    "北海":[109.12,21.49],
		    "西安":[108.95,34.27],
		    "金坛":[119.56,31.74],
		    "东营":[118.49,37.46],
		    "牡丹江":[129.58,44.6],
		    "遵义":[106.9,27.7],
		    "绍兴":[120.58,30.01],
		    "扬州":[119.42,32.39],
		    "常州":[119.95,31.79],
		    "潍坊":[119.1,36.62],
		    "重庆":[106.54,29.59],
		    "台州":[121.420757,28.656386],
		    "南京":[118.78,32.04],
		    "滨州":[118.03,37.36],
		    "贵阳":[106.71,26.57],
		    "无锡":[120.29,31.59],
		    "本溪":[123.73,41.3],
		    "克拉玛依":[84.77,45.59],
		    "渭南":[109.5,34.52],
		    "马鞍山":[118.48,31.56],
		    "宝鸡":[107.15,34.38],
		    "焦作":[113.21,35.24],
		    "句容":[119.16,31.95],
		    "北京":[116.46,39.92],
		    "徐州":[117.2,34.26],
		    "衡水":[115.72,37.72],
		    "包头":[110,40.58],
		    "绵阳":[104.73,31.48],
		    "乌鲁木齐":[87.68,43.77],
		    "枣庄":[117.57,34.86],
		    "杭州":[120.19,30.26],
		    "淄博":[118.05,36.78],
		    "鞍山":[122.85,41.12],
		    "溧阳":[119.48,31.43],
		    "库尔勒":[86.06,41.68],
		    "安阳":[114.35,36.1],
		    "开封":[114.35,34.79],
		    "济南":[117,36.65],
		    "德阳":[104.37,31.13],
		    "温州":[120.65,28.01],
		    "九江":[115.97,29.71],
		    "邯郸":[114.47,36.6],
		    "临安":[119.72,30.23],
		    "兰州":[103.73,36.03],
		    "沧州":[116.83,38.33],
		    "临沂":[118.35,35.05],
		    "南充":[106.110698,30.837793],
		    "天津":[117.2,39.13],
		    "富阳":[119.95,30.07],
		    "泰安":[117.13,36.18],
		    "诸暨":[120.23,29.71],
		    "郑州":[113.65,34.76],
		    "哈尔滨":[126.63,45.75],
		    "聊城":[115.97,36.45],
		    "芜湖":[118.38,31.33],
		    "唐山":[118.02,39.63],
		    "平顶山":[113.29,33.75],
		    "邢台":[114.48,37.05],
		    "德州":[116.29,37.45],
		    "济宁":[116.59,35.38],
		    "荆州":[112.239741,30.335165],
		    "宜昌":[111.3,30.7],
		    "义乌":[120.06,29.32],
		    "丽水":[119.92,28.45],
		    "洛阳":[112.44,34.7],
		    "秦皇岛":[119.57,39.95],
		    "株洲":[113.16,27.83],
		    "石家庄":[114.48,38.03],
		    "莱芜":[117.67,36.19],
		    "常德":[111.69,29.05],
		    "保定":[115.48,38.85],
		    "湘潭":[112.91,27.87],
		    "金华":[119.64,29.12],
		    "岳阳":[113.09,29.37],
		    "长沙":[113,28.21],
		    "衢州":[118.88,28.97],
		    "廊坊":[116.7,39.53],
		    "菏泽":[115.480656,35.23375],
		    "合肥":[117.27,31.86],
		    "武汉":[114.31,30.52],
		    "大庆":[125.03,46.58],
		    "黄山":[118.317325,29.709239],
		    "阿克苏地区":[80.265068,41.170712],
		    "防城港":[108.345478,21.614631],
		    "大兴安岭地区":[124.711526,52.335262],
		    "阿里地区":[80.105498,32.503187],
		    "鹰潭":[117.033838,28.238638],
		    "抚州":[116.358351,27.98385],
		    "鸡西":[130.975966,45.300046],
		    "伊春":[128.899396,47.724775],
		    "钦州":[108.624175,21.967127],
		    "双鸭山":[131.157304,46.643442],
		    "南平":[118.178459,26.635627],
		    "宣城":[118.757995,30.945667],
		    "丽江":[100.233026,26.872108],
		    "上饶":[117.971185,28.44442],
		    "朝阳":[120.451176,41.576758],
		    "郴州":[113.032067,25.793589],
		    "七台河":[131.015584,45.771266],
		    "吉安":[114.986373,27.111699],
		    "来宾":[109.229772,23.733766],
		    "龙岩":[117.02978,25.091603],
		    "五家渠":[87.526884,44.167401],
		    "伊犁哈萨克州":[81.317946,43.92186],
		    "玉树州":[97.008522,33.004049],
		    "赣州":[114.940278,25.85097],
		    "佳木斯":[130.361634,46.809606],
		    "漳州":[117.661801,24.510897],
		    "大理州":[100.225668,25.589449],
		    "池州":[117.489157,30.656037],
		    "莆田":[119.007558,25.431011],
		    "六安":[116.507676,31.752889],
		    "阿勒泰地区":[88.13963,47.848393],
		    "永州":[111.608019,26.434516],
		    "三明":[117.635001,26.265444],
		    "淮南":[117.018329,32.647574],
		    "楚雄州":[101.546046,25.041988],
		    "贺州":[111.552056,24.414141],
		    "宜春":[114.391136,27.8043],
		    "咸宁":[114.328963,29.832798],
		    "景德镇":[117.214664,29.29256],
		    "四平":[124.370785,43.170344],
		    "黔西南州":[107.517156,26.258219],
		    "新余":[114.930835,27.810834],
		    "辽阳":[123.18152,41.269402],
		    "兴安盟":[122.070317,46.076268],
		    "贵港":[109.602146,23.0936],
		    "毕节":[105.28501,27.301693],
		    "乌兰察布":[113.114543,41.034126],
		    "酒泉":[98.510795,39.744023],
		    "甘南州":[102.911008,34.986354],
		    "乌海":[106.825563,39.673734],
		    "白山":[126.427839,41.942505],
		    "河池":[108.062105,24.695899],
		    "山南地区":[91.766529,29.236023],
		    "德宏州":[98.578363,24.436694],
		    "百色":[106.616285,23.897742],
		    "鹤岗":[130.277487,47.332085],
		    "林芝地区":[94.362348,29.654693],
		    "吕梁":[111.134335,37.524366],
		    "陇南":[104.929379,33.388598],
		    "锡林郭勒盟":[116.090996,43.944018],
		    "怀化":[109.97824,27.550082],
		    "固原":[106.285241,36.004561],
		    "达州":[107.502262,31.209484],
		    "乐山":[103.761263,29.582024],
		    "临沧":[100.08697,23.886567],
		    "安康":[109.029273,32.6903],
		    "益阳":[112.355042,28.570066],
		    "衡阳":[112.607693,26.900358],
		    "汉中":[107.028621,33.077668],
		    "巴中":[106.753669,31.858809],
		    "辽源":[125.145349,42.902692],
		    "昌都地区":[97.178452,31.136875],
		    "松原":[124.823608,45.118243],
		    "庆阳":[107.638372,35.734218],
		    "宁德":[119.527082,26.65924],
		    "铁岭":[123.844279,42.290585],
		    "晋中":[112.736465,37.696495],
		    "天水":[105.724998,34.578529],
		    "鞍山":[122.995632,41.110626],
		    "崇左":[107.353926,22.404108],
		    "阜新":[121.648962,42.011796],
		    "安庆":[117.043551,30.50883],
		    "日喀则地区":[88.885148,29.267519],
		    "萍乡":[113.852186,27.622946],
		    "凉山州":[102.258746,27.886762],
		    "海北州":[100.901059,36.959435],
		    "朔州":[112.433387,39.331261],
		    "铜仁地区":[109.191555,27.718346],
		    "白城":[122.841114,45.619026],
		    "铜陵":[117.816576,30.929935],
		    "六盘水":[104.846743,26.584643],
		    "保山":[99.167133,25.111802],
		    "平凉":[106.684691,35.54279],
		    "中卫":[105.189568,37.514951],
		    "红河州":[103.384182,23.366775],
		    "文山州":[104.24401,23.36951],
		    "通辽":[122.263119,43.617429],
		    "忻州":[112.733538,38.41769],
		    "武威":[102.634697,37.929996],
		    "商洛":[109.939776,33.868319],
		    "榆林":[109.741193,38.290162],
		    "鹤壁":[114.295444,35.748236],
		    "随州":[113.37377,31.717497],
		    "海东地区":[102.10327,36.502916],
		    "定西":[104.626294,35.579578],
		    "蚌埠":[117.363228,32.939667],
		    "宿州":[116.984084,33.633891],
		    "十堰":[110.787916,32.646907],
		    "绥化":[126.99293,46.637393],
		    "广安":[106.633369,30.456398],
		    "阜阳":[115.819729,32.896969],
		    "恩施州":[109.48699,30.283114],
		    "海西州":[97.370785,37.374663],
		    "广元":[105.829757,32.433668],
		    "周口":[114.649653,33.620357],
		    "甘孜州":[101.963815,30.050663],
		    "襄阳":[112.144146,32.042426],
		    "晋城":[112.851274,35.497553],
		    "孝感":[113.926655,30.926423],
		    "黔东南州":[107.977488,26.583352],
		    "鄂州":[114.890593,30.396536],
		    "黄石":[115.077048,30.220074],
		    "雅安":[103.001033,29.987722],
		    "亳州":[115.782939,33.869338],
		    "濮阳":[115.041299,35.768234],
		    "白银":[104.173606,36.54568],
		    "滁州":[118.316264,32.303627],
		    "阿拉善盟":[105.706422,38.844814],
		    "南阳":[112.540918,32.999082],
		    "湘西州":[109.739735,28.314296],
		    "邵阳":[111.46923,27.237842],
		    "黄冈":[114.879365,30.447711],
		    "张掖":[100.455472,38.932897],
		    "漯河":[114.026405,33.575855],
		    "黄南州":[102.019988,35.517744],
		    "荆门":[112.204251,31.03542],
		    "淮北":[116.794664,33.971707],
		    "临夏州":[103.212006,35.599446],
		    "娄底":[112.008497,27.728136],
		    "商丘":[115.650497,34.437054],
		    "吐鲁番地区":[89.184078,42.947613],
		    "内江":[105.066138,29.58708],
		    "驻马店":[114.024736,32.980169],
		    "信阳":[114.075031,32.123274],
		    "那曲地区":[92.060214,31.476004],
		    "昭通":[103.717216,27.336999],
		    "资阳":[104.641917,30.122211],
		    "吴忠":[106.199409,37.986165],
		    "眉山":[103.831788,30.048318],
		    "塔城地区":[82.985732,46.746301],
		    "许昌":[113.826063,34.022956],
		    "遂宁":[105.571331,30.513311],
		    "新乡":[113.883991,35.302616],
		    "喀什地区":[75.989138,39.467664],
		    "克州":[76.172825,39.713431],
		    "和田地区":[79.92533,37.110687]
		};
	
	var all_aqis = []; //保存所有的aqi信息
	var reqest_data = "";
	var city_data = [];
	Search(); //实时查询所有的空气质量数据
	function Search() {
		$.ajax({
			url: 'api/queryAqi',
			type: 'POST',
			async: false,
			data: {},
			dataType: "json",
			success: function(data, textStatus){
				reqest_data = data;
			},
			error: function(){
			}
		});
	}
	
	//计算每个城市的平均值
	function average(aqis) {
		var ref = [];//清空里面的数据
		//var count = 0; //记录有多少个相同的城市
		//var aqi = 0;
		// 浅层复制（只复制顶层的非 object 元素） 
	//	var data = jQuery.extend([], aqis);
		for(var i = 0 ; i < aqis.length ; i++){
			var geoCoord = geoCoordMap[aqis[i].area];
			if (geoCoord) {
				 ref.push({
		                name: aqis[i].area,
		                value: geoCoord.concat(aqis[i].aqi == 0?0:parseInt(aqis[i].aqi))
		            });
				//ref.push(geoCoord.concat(parseInt(aqi/count)));
			}
		}
		return ref;
		/*for(var i = 0 ; i < aqis.length ; i++){  //当返回一个城市所有的监测点是使用
			var areaName = "";
			count = 0;
			aqi = 0;
			for(var j = 0; j < data.length ; j ++){
				if(aqis[i].area == data[j].area){  //同一个城市的
					if(data[j].aqi != 0 || data[j].aqi != '0'){
						count++;
					}
					aqi+=parseFloat(data[j].aqi);
					data.splice(j,1);
					j--;
					areaName = aqis[i].area;
				}
			}
			if(areaName != ""){
				var geoCoord = geoCoordMap[areaName];
				if (geoCoord && aqi != 0) {
					 ref.push({
			                name: areaName,
			                value: geoCoord.concat(aqi == 0?0:parseInt(aqi/count))
			            });
					//ref.push(geoCoord.concat(parseInt(aqi/count)));
				}
			}

		}*/
		
	}
	
	//------------------------------aqi全国分布图
	init();
	function init(){
		
		map('aqi-chart');
	}
	
	//折线图
	function map(optionID)
	{
		var myChart = echarts.init(document.getElementById(optionID));
		
		option = {
			    backgroundColor: '#404a59',
			    title: {
			        text: '全国主要城市空气质量(AQI)',
			        subtext: '数据来源PM25.in',
			        sublink: 'http://www.pm25.in',
			        x:'center',
			        textStyle: {
			            color: '#fff'
			        }
			    },
			    tooltip: {
			        trigger: 'item',
			        formatter: function (params) {
			            return params.name + ' : ' + params.value[2];
			        }
			    },
			    legend: {
			        orient: 'vertical',
			        y: 'bottom',
			        x:'right',
			        data:['pm2.5'],
			        textStyle: {
			            color: '#fff'
			        }
			    },
			    dataRange: {
			        min: 0,
			        max: 500,
			        calculable: true,
			        color: ['#d94e5d','#eac736','#50a3ba'],
			        textStyle: {
			            color: '#fff'
			        }
			    },
			    geo: {
			        map: 'china',
			        label: {
			            emphasis: {
			                show: true,
			                position:'top',
			                textStyle:{
			                	color:'#fff',
			                	fontWeight:'lighter',
			                	fontSize:14
			                }
			            }
			        },
			        itemStyle: {
			            normal: {
			                areaColor: '#323c48',
			                borderColor: '#FFFFF0'
			            },
			            emphasis: {
			                areaColor: '#2a333d'
			            }
			        }
			    },
			    series: [
			        {
			            name: 'aqi',
			            type: 'scatter',
			            coordinateSystem: 'geo',
			            data: average(reqest_data),
			            symbolSize: 12,
			            label: {
			                normal: {
			                    show: false
			                },
			                emphasis: {
			                    show: false
			                }
			            },
			            itemStyle: {
			                emphasis: {
			                    borderColor: '#fff',
			                    borderWidth: 1
			                }
			            }
			        }
			    ]
			};
		
		

			/*option = {
			    title: {
			        text: '全国主要城市空气质量',
			        subtext: '数据来源PM25.in',
			        sublink: 'http://www.pm25.in',
			        left: 'center',
			        textStyle: {
			            color: '#85c226'
			        }
			    },
			    backgroundColor: '#404a59',
			    visualMap: {
			        min: 0,
			        max: 600,
			        splitNumber: 6,
			        inRange: {
			        	color: ['#FF0000','#DB9370','#FF7F00','#FFFF00 ','#00FF00'].reverse(),
			            symbolSize: [60, 100]
			        },
			        textStyle: {
			            color: '#fff'
			        }
			    },
			    geo: {
			        map: 'china',
			        label: {
			            emphasis: {
			                show: true
			            }
			        },
			        itemStyle: {
			            normal: {
			                areaColor: '#404a59',
			                borderColor: '#FFFFF0'
			            },
			            emphasis: {
			                areaColor: '#FFFFF0'
			            }
			        }
			    },
			    series: [{
			        name: 'AQI',
			        type: 'heatmap',
			        coordinateSystem: 'geo',
			        data: average(reqest_data)
			    }]
			};*/

		myChart.setOption(option);
		myChart.on('click', function (params) {
		    var city = params.name;
		    //根据城市名请求该城市的空气时候数据
		    $("#title").empty().append(city+"市每个监测点的详细数据");
		    $("#cityData").show();
		    getCityData(city);
		    get24H_Aqi(city);
		});
	}
	
	
	function getCityData(cityName) {
		 $.ajax({
				url: 'api/queryAqiByCityName',
				type: 'POST',
				async: false,
				data: {cityName:cityName},
				dataType: "json",
				success: function(data, textStatus){
					city_data = data;
					showCityData(data);
				},
				error: function(){
				}
			});
	}
	
	function showCityData(data) {
		var html="";
		if(data!=null){
			for(var i=0;i<data.length;i++){
				var position  = (data[i].position_name == null ? "暂无":data[i].position_name);
				html+="<tr>"+
				"<td>"+position+"</td>"
				+"<td>"+data[i].aqi+"</td>"
				+"<td >"+data[i].quality+"</td>" 
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
		$("#title_time").empty().append("&nbsp;&nbsp;&nbsp;&nbsp;"+data[0].time_point.replace("T"," ").replace("Z","")+" 发布");
		$("#widgetslist").empty().html(html);
	}
	
	//根据城市名，获取24小时之内的数据
	function get24H_Aqi(area) {
		var obj = {
				area:area
		};
		$.ajax({
			url: 'historyair/queryAqi_24h',
			type: 'POST',
			async: false,
			data: obj,
			dataType: "json",
			success: function(data, textStatus){
				Construct_24H_aqi(data);
				$("#aqi_24h").show();
				line('aqi-line',area,'748D99','434343');
			},
			error: function(){
			}
		});
	}
	
	var aqi_24h = [];
	var time_24h = [];
	//构造24小时之内的数据
	function Construct_24H_aqi(data) {
		if(data.length == 0){
			alert("暂无数据！");
			return ;
		}
		var d = new Date();
		var hour = d.getHours();
		for ( var i = 0; i < data.length; i++) {
			aqi_24h.push(data[i].aqi);
			if (hour == 25) {
				hour = 00;
			}
			time_24h.push(hour+++"时");
		}
	}
	
	
	//绘制24小时折线图
	function line(optionID,area,titlt_col,bg_col) {
		var myChart = echarts.init(document.getElementById(optionID));
		
		option = {
			    title: {
			        text: area+' 最近24小时空气质量指数(AQI)趋势',
			        subtext: '数据来源于互联网',
			        textStyle: {
			            color: '#'+titlt_col
			        }
			    },
			    backgroundColor: '#'+bg_col,
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['AQI']
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
			    	splitLine:{ 
			    		show:false,  //去掉每条数据的竖线
			    		lineStyle:{
			    			color:'#'+titlt_col
			    		}
			    	}, 
			    	axisLabel : {
			    		show : true,
			    		textStyle : {
			    			color : '#'+titlt_col
			    		}
			    	},
			        type: 'category',
			        boundaryGap: false,
			        data: time_24h
			    },
			    yAxis: {   
			    	axisLabel : {
			    		show : true,
			    		textStyle : {
			    			color : '#'+titlt_col
			    		}
			    	},
			    	type : 'value',
			    	min:0, 
			    	max:500
			    },
			    series: [
			       
			        {
			            name:'AQI',
			            type:'line',
			            data:aqi_24h,
			            itemStyle:{
			            	normal: {
			            		color:'#64CF29',
			            		label:{
				            		show: true,
				            		position:'top'
			            		},
			            		textStyle:{
			            			color : '#'+titlt_col
			            		}
			            	}
						}
			           
			        }
			    ]
			};
		
		myChart.setOption(option);

	}
	
});