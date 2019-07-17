package yxm.zyf.love.vo;

import java.util.List;

public class DataDto {
    private String cityCode;

    private String insurerCode;

    private String responseNo;

    private String biNCD;

    private String ciNCD;

    private CarInfoVo1 carInfo;

    private PersonInfoVo1 personInfo;

    private List<CoverageVO> coverageList;

    public class CarInfoVo1 {
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
            return "CarIInfoVo [licenseNo=" + licenseNo + ", frameNo=" + frameNo + ", brandCode=" + brandCode + ", engineNo=" + engineNo
                    + ", isTrans=" + isTrans + ", transDate=" + transDate + ", firstRegisterDate=" + firstRegisterDate + "]";
        }
    }

    public class PersonInfoVo1 {
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

    public class CoverageVO1 {
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
            return "CoverageVO [coverageCode=" + coverageCode + ", coverageName=" + coverageName + ", insuredAmount=" + insuredAmount + ", flag="
                    + flag + "]";
        }
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getInsurerCode() {
        return insurerCode;
    }

    public void setInsurerCode(String insurerCode) {
        this.insurerCode = insurerCode;
    }

    public String getResponseNo() {
        return responseNo;
    }

    public void setResponseNo(String responseNo) {
        this.responseNo = responseNo;
    }

    public String getBiNCD() {
        return biNCD;
    }

    public void setBiNCD(String biNCD) {
        this.biNCD = biNCD;
    }

    public String getCiNCD() {
        return ciNCD;
    }

    public void setCiNCD(String ciNCD) {
        this.ciNCD = ciNCD;
    }

    public CarInfoVo1 getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfoVo1 carInfo) {
        this.carInfo = carInfo;
    }

    public PersonInfoVo1 getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfoVo1 personInfo) {
        this.personInfo = personInfo;
    }

    public List<CoverageVO> getCoverageList() {
        return coverageList;
    }

    public void setCoverageList(List<CoverageVO> coverageList) {
        this.coverageList = coverageList;
    }

    @Override
    public String toString() {
        return "DataDto [cityCode=" + cityCode + ", insurerCode=" + insurerCode + ", responseNo=" + responseNo + ", biNCD=" + biNCD + ", ciNCD="
                + ciNCD + ", carInfo=" + carInfo + ", personInfo=" + personInfo + ", coverageList=" + coverageList + "]";
    }
    
}
