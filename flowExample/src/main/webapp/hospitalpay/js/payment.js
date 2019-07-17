$(function(){
	domInit();
});
	
function domInit(){
	$(".content_btn").click(function(){
		jumpTarget();
	})
}

function jumpTarget(){
	var industryoptions=$(".industry option:selected");  //获取select选中的项
	var industryval=industryoptions.val();   //拿到选中项的值
	var sceneoptions=$(".scene option:selected");  //获取select选中的项
	var sceneval=sceneoptions.val();   //拿到选中项的值
	var outtradeno=$(".out_trade_no").val();
	var sellerid=$(".seller_id").val();
	var totalamount=$(".total_amount").val();
	var subjectval=$(".subject").val();
	var bodyval=$(".body").val();
	var extendparams=$(".extend_params").val();
	var orgno=$(".org_no").val();
	var orgname=$(".org_name").val();
	var serialno=$(".serial_no").val();
	var requestcontent=$(".request_content").val();
	var patientcard_no=$(".patient_card_no").val();
	var patientname=$(".patient_name").val();
	var patientmobile=$(".patient_mobile").val();
	var medicalcardinstid=$(".medical_card_inst_id").val();
	$.ajax({
	type:"post",
	url:"http://localhost:8080/pays",
	async:true,
	data:JSON.stringify({
	//	"industry": industryval,
		"scene": sceneval,
		"out_trade_no": outtradeno,
		"seller_id": sellerid,
		"total_amount": totalamount,
		"subject": subjectval,
		"body": bodyval,
		"extend_params": extendparams,
		"org_no": orgno,
		"org_name": orgname,
		"serial_no": serialno,
		"request_content": requestcontent,
		"patient_card_no": patientcard_no,
		"patient_name": patientname,
		"patient_mobile": patientmobile,
		"medical_card_inst_id": medicalcardinstid
	}),
	dataType: 'json',
	contentType: "application/json; charset=utf-8",
	success:function(res){
		if(res.code == 'S'){
	      alert(res.message);
	      window.location.href=res.payUrl;
	    }else{
	      alert(res.message);
	    }},
	error:function(){
		alert("请求出错，请重新提交");
	}
});
}
	
