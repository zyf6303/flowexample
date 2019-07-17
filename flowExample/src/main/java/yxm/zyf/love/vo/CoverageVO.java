package yxm.zyf.love.vo;

public class CoverageVO {
    private String coverageCode;
    private String coverageName;
    private String insuredAmount;
    private String flag;
    public String getCoverageCode() {
        return coverageCode;
    }
    public void setCoverageCode(String coverageCode) {
        this.coverageCode = coverageCode;
    }
    public String getCoverageName() {
        return coverageName;
    }
    public void setCoverageName(String coverageName) {
        this.coverageName = coverageName;
    }
    public String getInsuredAmount() {
        return insuredAmount;
    }
    public void setInsuredAmount(String insuredAmount) {
        this.insuredAmount = insuredAmount;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    @Override
    public String toString() {
        return "CoverageVO [coverageCode=" + coverageCode + ", coverageName=" + coverageName + ", insuredAmount=" + insuredAmount + ", flag=" + flag
                + "]";
    }
    
}
