$(function(){
	domInit();
});
	
function domInit(){
	$(".content_btn").click(function(){
		jumpTarget();
	})
}

function jumpTarget(){
	var outtradeno=$(".out_trade_no").val();
	var tradeno=$(".trade_no").val();
	var refundamount=$(".refund_amount").val();
	var refundreason=$(".refund_reason").val();
	var outrequestno=$(".out_request_no").val();
	/*var operatorid=$(".operator_id").val();
	var storeid=$(".store_id").val();
	var terminalid=$(".terminal_id").val();*/
	$.ajax({
	type:"post",
	url:"http://medicalinsproddev.alipay-eco.com/medicalinsprod/cancel",
	async:true,
	data:JSON.stringify({
		"out_trade_no": outtradeno,
		"trade_no": tradeno,
		"refund_amount": refundamount,
		"refund_reason": refundreason,
		"out_request_no": outrequestno
		/*"operator_id": operatorid,
		"store_id": storeid,
		"terminal_id": terminalid*/
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
	
