package yxm.zyf.love.vo;

public class payVo {

    private String industry;
    
    private String scene;
    private String seller_id;
    private String out_trade_no;
    private String total_amount;
    
    private String subject;
    private String body;
    private String extend_params;
    private String org_no;
    private String org_name;
    private String serial_no;
    private String request_content;
    private String patient_card_no;
    private String patient_name;
    private String patient_mobile;
    private String medical_card_inst_id;
    public String getIndustry() {
        return industry;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getScene() {
        return scene;
    }
    public void setScene(String scene) {
        this.scene = scene;
    }
    public String getSeller_id() {
        return seller_id;
    }
    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }
    
    public String getOut_trade_no() {
        return out_trade_no;
    }
    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
    public String getTotal_amount() {
        return total_amount;
    }
    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getExtend_params() {
        return extend_params;
    }
    public void setExtend_params(String extend_params) {
        this.extend_params = extend_params;
    }
    public String getOrg_no() {
        return org_no;
    }
    public void setOrg_no(String org_no) {
        this.org_no = org_no;
    }
    public String getOrg_name() {
        return org_name;
    }
    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }
    public String getRequest_content() {
        return request_content;
    }
    public void setRequest_content(String request_content) {
        this.request_content = request_content;
    }
    public String getPatient_card_no() {
        return patient_card_no;
    }
    public void setPatient_card_no(String patient_card_no) {
        this.patient_card_no = patient_card_no;
    }
    public String getPatient_name() {
        return patient_name;
    }
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }
    public String getPatient_mobile() {
        return patient_mobile;
    }
    public void setPatient_mobile(String patient_mobile) {
        this.patient_mobile = patient_mobile;
    }
    
    public String getMedical_card_inst_id() {
        return medical_card_inst_id;
    }
    public void setMedical_card_inst_id(String medical_card_inst_id) {
        this.medical_card_inst_id = medical_card_inst_id;
    }
    
    public String getSerial_no() {
        return serial_no;
    }
    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }
    @Override
    public String toString() {
        return "payVo [industry=" + industry + ", scene=" + scene +  ", seller_id=" + seller_id + ", total_amount="
                + total_amount + ", subject=" + subject + ", body=" + body + ", extend_params=" + extend_params + ", org_no=" + org_no + ", org_name="
                + org_name + ", request_content=" + request_content + ", patient_card_no=" + patient_card_no +  ", patient_name=" + patient_name + ", patient_mobile=" + patient_mobile +",medical_card_inst_id="+medical_card_inst_id+
                ",serial_no="+serial_no+",out_trade_no"+out_trade_no+"]";
    }
    
    
    
}
