package yxm.zyf.love.vo;

public class PersonInfoVo {
    private String ownerName;
    private String ownerID;
    private String ownerMobile;
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getOwnerID() {
        return ownerID;
    }
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }
    public String getOwnerMobile() {
        return ownerMobile;
    }
    public void setOwnerMobile(String ownerMobile) {
        this.ownerMobile = ownerMobile;
    }
    @Override
    public String toString() {
        return "PersonInfo [ownerName=" + ownerName + ", ownerID=" + ownerID + ", ownerMobile=" + ownerMobile + "]";
    }
    
}
