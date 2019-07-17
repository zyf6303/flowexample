package yxm.zyf.love.vo;

import java.util.List;

public class DataVo {
    private String cityCode;
    private String insurerCode;
    private String responseNo;
    private String biNCD;
    private String ciNCD;
    private CarInfoVo carInfo;
    private PersonInfoVo  personInfo;
    private List<CoverageVO> coverageList;
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
    public CarInfoVo getCarInfo() {
        return carInfo;
    }
    public void setCarInfo(CarInfoVo carInfo) {
        this.carInfo = carInfo;
    }
    public PersonInfoVo getPersonInfo() {
        return personInfo;
    }
    public void setPersonInfo(PersonInfoVo personInfo) {
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
        return "DataVo [cityCode=" + cityCode + ", insurerCode=" + insurerCode + ", responseNo=" + responseNo + ", biNCD=" + biNCD + ", ciNCD="
                + ciNCD + ", carInfo=" + carInfo + ", personInfo=" + personInfo + ", coverageList=" + coverageList + "]";
    }
    
}
