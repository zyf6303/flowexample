$(function(){
	domInit();
});
	
function domInit(){
	$(".content_btn").click(function(){
		jumpTarget();
	})
}

function jumpTarget(){
	var outtradenoval;
	var outtradeno=$(".out_trade_no").val();
	var tradeno=$(".trade_no").val();
	console.log('outtradeno:'+outtradeno);
	console.log('tradeno:'+tradeno);
	if(!outtradeno && !tradeno){
		alert("两个单号至少填一个，谢谢！");
		return;
	}else if(!outtradeno){
		outtradenoval = tradeno;
		console.log('outtradenoval:'+outtradenoval);
	}else{
		outtradenoval = outtradeno;
		console.log('outtradenoval:'+outtradenoval);
	}
	$.ajax({
	type:"post",
	url:"http://medicalinsproddev.alipay-eco.com/medicalinsprod/payquery",
	async:true,
	data:JSON.stringify({
		"out_trade_no": outtradenoval
	}),
	dataType: 'json',
	contentType: "application/json; charset=utf-8",
	success:function(res){
		if(res.code == 'S'){
			alert(res.message);
		}else{
			alert("提交失败，请重新提交");
		}
	},
	error:function(){
		alert("请求出错，请重新提交");
	}
});
}
	
