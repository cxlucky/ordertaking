<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@page
	import="java.util.List,java.util.ArrayList,com.muldini.virus.common.StringConstant"%>
<%@page
	import="com.muldini.virus.common.ChinaTotal,com.muldini.virus.common.AreaTree"%>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>/css/main.css"/>
<title>疫情情况</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/4.3.0/echarts.min.js"></script>
</head>
 <body>
    <div id='main'style = 'width:500px; height:500px;'></div>
    <%
     ChinaTotal chinaTotal = (ChinaTotal) session.getAttribute(StringConstant.REQ_UPLOAD_MSG);
     List<AreaTree> areaTree = (ArrayList<AreaTree>) session.getAttribute(StringConstant.REQ_UPLOAD_AREA);
    %>

    <body>
	<!-- 1、title：全国疫情/全球疫情 -->
	<!-- 第一种方式：CSS----style属性的设置 -->
	<!-- <div style="border: 1px solid red;font-size: 40px;background-color: #333333">
		<span>全国疫情展示</span>&nbsp;&nbsp;<a href="world.html">全球疫情展示</a>
	</div> -->
	<div id="title">
		<span class="china_title">全国疫情展示</span>
	</div>
	<!-- 2、时间：当前系统的时间 -->
	<div id="time">时间</div>
	<!-- 3、左边的图1 
	<div id="left1">
		<div id="left1" style="width: 100%;height:100%;"></div>
	</div>-->
	<!-- 4、左边的图2-->
	<div id="left2">
		<div id="left2" style="width: 100%;height:100%;"></div>
	</div> 
	<!-- 5、中间1 -->
	<div id="mid1">
		<div class="num"><h1><%=chinaTotal.getLocalConfirm() %></h1></div>
		<div class="num"><h1><%=chinaTotal.getNowConfirm() %></h1></div>
		<div class="num"><h1><%=chinaTotal.getNoInfect() %></h1></div>
		<div class="num"><h1><%=chinaTotal.getConfirm() %></h1></div>
		<div class="txt"><h2>本土现有确诊</h2></div>
		<div class="txt"><h2>现有确诊</h2></div>
		<div class="txt"><h2>无症状感染者</h2></div>
		<div class="txt"><h2>累计确诊</h2></div>
	</div>
	
	
	<!-- 6、中间2：china_map -->
	<div id="mid2">
		<div id="china_map"></div>
	</div>
	<!-- 7、右边的图1 -->
	<div id="right1">
		<div id="right1" style="width: 100%;height:100%;"></div>
	
	</div>
	
	<!-- 8、右边的图2 -->
	<div id="right2" style = "color:white">
		<h2>今日热点:</h2>
		<h2 style = "color:white;font-size:100%;">&nbsp;&nbsp;&nbsp;&nbsp;1.全国模范！黑龙江这些集体、个人入选拟表彰名单</h2>
		<h2 style = "color:white;font-size:100%;">&nbsp;&nbsp;&nbsp;&nbsp;2.熬夜、高脂饮食…200斤小伙头晕两年，体检才发现是高血压</h2>
		<h2 style = "color:white;font-size:100%;">&nbsp;&nbsp;&nbsp;&nbsp;3.注意！国庆假期返程高峰即将来临，咋走？</h2>
		<h2 style = "color:white;font-size:100%;">&nbsp;&nbsp;&nbsp;&nbsp;4.绥化加速改造市本级隔离点 为疫情防控提供隔离场所保障</h2>
		<h2 style = "color:white;font-size:100%;">&nbsp;&nbsp;&nbsp;&nbsp;5.【要闻】工农区为疫情防控一线工作人员免费检测核酸</h2>
		<h2 style = "color:white;font-size:100%;">&nbsp;&nbsp;&nbsp;&nbsp;6.黑龙江省多地开展养老、儿童服务机构疫情防控和安全隐患大排查</h2>
	</div>
	
	
    <script type="text/javascript" src="<%=basePath%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/main2.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/echarts.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/china.js"></script>
	<script src="<%=basePath%>/js/echarts-wordcloud.min.js"></script>
	<script src="<%=basePath%>/js/vintage.js"></script>
	<script type="text/javascript">
	var mid2_chart=echarts.init(document.getElementById('mid2'),'#FFFF99');

	var option = {
			title:{
				text:'中国疫情图',
				left:'center'	
			},
			tooltip:{
				trigger:'item'
			},
			visualMap: { // 左侧小导航图标
		        show: true,
		        x: 'left',
		        y: 'bottom',
		        textStyle: {
		            fontSize: 8,
		        },
		        splitList: [{ start: 1,end: 9 },
		            {start: 10, end: 99 }, 
					{ start: 100, end: 999 },
		            {  start: 1000, end: 9999 },
		            { start: 10000 }],
		        color: ['#8A3310', '#C64918', '#E55B25', '#F2AD92', '#F9DCD1']
		    },
		    series: [{
		        name: '累计确诊人数',
		        type: 'map',
		        mapType: 'china',
		        roam: false, // 禁用拖动和缩放
		        itemStyle: { // 图形样式
		            normal: {
		                borderWidth: .5, //区域边框宽度
		                borderColor: '#009fe8', //区域边框颜色
		                areaColor: "#ffefd5", //区域颜色
		            },
		            emphasis: { // 鼠标滑过地图高亮的相关设置
		                borderWidth: .5,
		                borderColor: '#4b0082',
		                areaColor: "#fff",
		            }
		        },
		        label: { // 图形上的文本标签
		            normal: {
		                show: true, //省份名称
		                fontSize: 8,
		            },
		            emphasis: {
		                show: true,
		                fontSize: 8,
		            }
		        },
		        data:[
		        	{'name': '<%=areaTree.get(0).getName() %>','value':'<%=areaTree.get(0).getConfirm() %>'}
		        	<%
		        	   for(int i = 1; i<areaTree.size();i++){
		        		   String str =",{'name':'"+areaTree.get(i).getName()+"', 'value':'"+areaTree.get(i).getConfirm()+"'}";
		        	%>
		        	   <%=str%>
		        	<%}%>
		        ] 
		    }]
	};
	mid2_chart.setOption(option);
	
	
	
	var myChart = echarts.init(document.getElementById('left2'),'#FFFF99');
	option = {
		    title: {
		        text: '境外输入城市TOP5',
		        left: 'center'
		    },
		    tooltip: {
		        trigger: 'item',
		        formatter: '{a} <br/>{b} : {c} ({d}%)'
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: ['<%=areaTree.get(0).getName() %>', '<%=areaTree.get(1).getName() %>', '<%=areaTree.get(2).getName() %>', '<%=areaTree.get(3).getName() %>', '<%=areaTree.get(4).getName() %>']
		    },
		    series: [
		        {
		            name: '城市',
		            type: 'pie',
		            radius: '55%',
		            center: ['50%', '60%'],//饼图的中心坐标
		            data: [
		                {value: <%=areaTree.get(0).getConfirm() %>, name: '<%=areaTree.get(0).getName() %>'},
		                {value: <%=areaTree.get(1).getConfirm() %>, name: '<%=areaTree.get(1).getName() %>'},
		                {value: <%=areaTree.get(2).getConfirm() %>, name: '<%=areaTree.get(2).getName() %>'},
		                {value: <%=areaTree.get(3).getConfirm() %>, name: '<%=areaTree.get(3).getName() %>'},
		                {value: <%=areaTree.get(4).getConfirm() %>, name: '<%=areaTree.get(4).getName() %>'}
		            ],
		            emphasis: {
		                itemStyle: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};
	myChart.setOption(option);

	

    var myChart = echarts.init(document.getElementById('right1'),'#FFFF99');
    var option = {
        title: {
            text: '全国确诊省市TOP5',
            left:'left',//组件根据相对应的位置自动对齐
            textStyle:{
            	color:'#996699',
            	fontWeight:'bolder',
            	fontSize:20
            },
            
       
        },//标题
        tooltip: {
        	show:true,
        	trigger:'axis',
        	axisPointer:{// 坐标轴指示器，坐标轴触发的时候有效的
        		type:'shadow' //shadow 阴影指示器
        	}
        },//提示框组件
        grid:{
        	left:'7%',
        	right:'4%',
        	bottom:'3%',
        	containLabel:true
        },
        
        xAxis: {
        	show:true,
        	type:'category',
            data: ['<%=areaTree.get(0).getName() %>', '<%=areaTree.get(1).getName() %>', '<%=areaTree.get(2).getName() %>', '<%=areaTree.get(3).getName() %>', '<%=areaTree.get(4).getName() %>'],
            axisTick:{
            	alignWithLabel:true
            },
        },//x轴
        yAxis: {
        	type:'value',
        	axisLabel:{//是否显示刻度标签
        		show:true,
        		color:'white',
        		fontSize:12
        	},
        	splitLine:{
        		lineStyle:{
        			type:'dashed' //分割线
        		}
        	}
        	
        },//y轴
        color:['#996699'],
        series: [{
            name: '累计确诊',
            type: 'bar',
            data: [<%=areaTree.get(0).getConfirm() %>, <%=areaTree.get(1).getConfirm() %>, <%=areaTree.get(2).getConfirm() %>, <%=areaTree.get(3).getConfirm() %>, <%=areaTree.get(4).getConfirm() %>],
            label:{
            	show:true,
            	position: 'top',
            	textStyle:{
            		color:'white'
            	}
            }
        }]//系列列表。每个系列通过 type 决定自己的图表类型
    };

    // 5、使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

	

	</script>
  </body>
</html>