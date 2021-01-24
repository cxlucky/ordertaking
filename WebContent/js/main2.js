function getTime(){
	var now=new Date();
	var year=now.getFullYear();
	var month=(now.getMonth()+1+'').padStart(2,'0');
	var day = (now.getDate()+'').padStart(2,'0');
	var week ="星期"+"日一二三四五六".charAt(now.getDay());//0,1,2,3,4,5,6
	var hour =(now.getHours()+'').padStart(2,'0');
	var minute =(now.getMinutes()+'').padStart(2,'0');
	var second = (now.getSeconds()+'').padStart(2,'0');
	
	content=`${year}年${month}月${day}日 ${week} ${hour}:${minute}:${second}`;
	$('#time').text(content);

}


getTime();
setInterval(getTime,1000);//每执行一秒就调用

//提示：


