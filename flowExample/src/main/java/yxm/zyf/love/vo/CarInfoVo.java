package yxm.zyf.love.vo;

public class CarInfoVo {
    private String licenseNo;
    private String frameNo;
    private String brandCode;
    private String engineNo;
    private String isTrans;
    private String transDate;
    private String firstRegisterDate;
    public String getLicenseNo() {
        return licenseNo;
    }
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }
    public String getFrameNo() {
        return frameNo;
    }
    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }
    public String getBrandCode() {
        return brandCode;
    }
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }
    public String getEngineNo() {
        return engineNo;
    }
    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }
    public String getIsTrans() {
        return isTrans;
    }
    public void setIsTrans(String isTrans) {
        this.isTrans = isTrans;
    }
    public String getTransDate() {
        return transDate;
    }
    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }
    public String getFirstRegisterDate() {
        return firstRegisterDate;
    }
    public void setFirstRegisterDate(String firstRegisterDate) {
        this.firstRegisterDate = firstRegisterDate;
    }
    @Override
    public String toString() {
        return "CarIInfoVo [licenseNo=" + licenseNo + ", frameNo=" + frameNo + ", brandCode=" + brandCode + ", engineNo=" + engineNo + ", isTrans="
                + isTrans + ", transDate=" + transDate + ", firstRegisterDate=" + firstRegisterDate + "]";
    }
    
    
}
