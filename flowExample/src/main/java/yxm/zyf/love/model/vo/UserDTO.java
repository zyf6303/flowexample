package yxm.zyf.love.model.vo;

import java.io.Serializable;

public class UserDTO implements Serializable{
    
    /**
     * @Fields serialVersionUID
     * TODO（用一句话描述这个变量表示什么）
     */
    private static final long serialVersionUID = 2314026166567801550L;

    private String userNo;

    private String logName;

    private String certNo;

    private String userStatus;

    private String userPswd;

    private String tranPswd;

    private String pswdLevel;

    private String pswdChgFlg;

    private String userType;

    private String pswdErrSum;

    private String pswdErrTime;

    private String createDate;

    private String createMan;

    private String chgDate;

    private String chgMan;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    public String getTranPswd() {
        return tranPswd;
    }

    public void setTranPswd(String tranPswd) {
        this.tranPswd = tranPswd;
    }

    public String getPswdLevel() {
        return pswdLevel;
    }

    public void setPswdLevel(String pswdLevel) {
        this.pswdLevel = pswdLevel;
    }

    public String getPswdChgFlg() {
        return pswdChgFlg;
    }

    public void setPswdChgFlg(String pswdChgFlg) {
        this.pswdChgFlg = pswdChgFlg;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPswdErrSum() {
        return pswdErrSum;
    }

    public void setPswdErrSum(String pswdErrSum) {
        this.pswdErrSum = pswdErrSum;
    }

    public String getPswdErrTime() {
        return pswdErrTime;
    }

    public void setPswdErrTime(String pswdErrTime) {
        this.pswdErrTime = pswdErrTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public String getChgDate() {
        return chgDate;
    }

    public void setChgDate(String chgDate) {
        this.chgDate = chgDate;
    }

    public String getChgMan() {
        return chgMan;
    }

    public void setChgMan(String chgMan) {
        this.chgMan = chgMan;
    }

    @Override
    public String toString() {
        return "UserDO [userNo=" + userNo + ", logName=" + logName + ", certNo=" + certNo + ", userStatus=" + userStatus + ", userPswd=" + userPswd
                + ", tranPswd=" + tranPswd + ", pswdLevel=" + pswdLevel + ", pswdChgFlg=" + pswdChgFlg + ", userType=" + userType + ", pswdErrSum="
                + pswdErrSum + ", pswdErrTime=" + pswdErrTime + ", createDate=" + createDate + ", createMan=" + createMan + ", chgDate=" + chgDate
                + ", chgMan=" + chgMan + "]";
    }
}
