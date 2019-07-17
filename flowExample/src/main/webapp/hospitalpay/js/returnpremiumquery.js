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
	var outrequestno=$(".out_request_no").val();
	if(!outtradeno && !tradeno || !outrequestno){
		alert("前两个单号至少填一个，最后一个标识为必填项，谢谢！");
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
	url:"http://medicalinsproddev.alipay-eco.com/medicalinsprod/cancelquery",
	async:true,
	data:JSON.stringify({
		"out_trade_no": outtradenoval,
		"out_request_no": outrequestno,
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
	
