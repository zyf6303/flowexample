package yxm.zyf.love.threadutil;

public class TaskDO {

    private Long id;

    private String traceId;

    private String userId;

    private String bizCardNo;

    private String templateId;

    private String cityCode;

    private String status;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizCardNo() {
        return bizCardNo;
    }

    public void setBizCardNo(String bizCardNo) {
        this.bizCardNo = bizCardNo;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AlipayMarketingCardTask [id=" + id + ", traceId=" + traceId + ", userId=" + userId + ", bizCardNo=" + bizCardNo + ", templateId="
                + templateId + ", cityCode=" + cityCode + ", status=" + status + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

}
