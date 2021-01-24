function getTime(){
	//document对象：代表整个HTML文档，可以用来访问页面中的所有的元素
	var time =document.getElementById('time');
	//简单使用，后期会学习jQuery封装，Vue封装
	var now=new Date();
	var year=now.getFullYear();
	var month=(now.getMonth()+1)<10?"0"+(now.getMonth()+1):now.getMonth()+1;
	var day = (now.getDate())<10?"0"+(now.getDate()):now.getDate();
	var week =now.getDay();//0,1,2,3,4,5,6
	var hour =(now.getHours())<10?"0"+(now.getHours()):now.getHours();
	var minute =(now.getMinutes())<10?"0"+(now.getMinutes()):now.getMinutes();
	var second = (now.getSeconds())<10?"0"+(now.getSeconds()):now.getSeconds();
//三目运算符
	/*if(week==0)
		var week="日";
	else if(week==1)
		var week="一";
	else if(week==2)
		var week="二";
	else if(week==3)
		var week="三";
	else if(week==4)
		var week="四";
	else if(week==5)
		var week="五";
	else if(week==6)
		var week="六";*/

	time.innerHTML = year+'年'+month+'月'+day+'日'+' '+changeWeek(week)+' '+hour+':'+minute+':'+second;
	//time.innerHTML = year+'年'+month+'月'+day+'日'+''+changeWeek(week)+' '+changeNum(hour)+':'+changeNum(minute)+':'+changeNum(second);
}
//将数字0-6转变为
function changeWeek(num){
	switch(num){
	case 0:
		return '星期日';
		break;
	case 1:
		return '星期一';
		break;
	case 2:
		return '星期二';
		break;
	case 3:
		return '星期三';
		break;
	case 4:
		return '星期四';
		break;
	case 5:
		return '星期五';
		break;
	case 6:
		return '星期六';
		break;
	}
}
/*//优化，可替代上面的三目运算符
function changeNum(num){
	if(num < 10){
		return '0'+num;
	}else{
		return num;
	}
}*/


//在整个HTML文档加载完之后会触发
window.onload=function(){
	getTime();
	setInterval(getTime,1000);//每执行一秒就调用
}


/*getTime();
setInterval(getTime,1000);//每执行一秒就调用
*/
