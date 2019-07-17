package yxm.zyf.love.entity.message;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * 类名: Head
 * 包名：  yxm.zyf.love.entity.message
 * 作者：  Zhangyf
 * 时间：  2018年10月19日 上午10:58:03
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年10月19日]新建类 by Zhangyf
 *
 */
public class Head {
    private String version;
    private String appid;
    private String function;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String reqTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String respTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String reqTimeZone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String respTimeZone;
    private String reqMsgId;
    private String reserve;
    private String cityCode;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getReqTimeZone() {
        return reqTimeZone;
    }

    public void setReqTimeZone(String reqTimeZone) {
        this.reqTimeZone = reqTimeZone;
    }

    public String getReqMsgId() {
        return reqMsgId;
    }

    public void setReqMsgId(String reqMsgId) {
        this.reqMsgId = reqMsgId;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getRespTime() {
        return respTime;
    }

    public void setRespTime(String respTime) {
        this.respTime = respTime;
    }

    public String getRespTimeZone() {
        return respTimeZone;
    }

    public void setRespTimeZone(String respTimeZone) {
        this.respTimeZone = respTimeZone;
    }
    
    ///*
    public String getCityCode(){
    	return cityCode;
    }
    
    public void setCityCode(String cityCode){
    	this.cityCode = cityCode;
    }
    //*/

    @Override
    public String toString() {
        return "Head{" +
                "version='" + version + '\'' +
                ", appid='" + appid + '\'' +
                ", function='" + function + '\'' +
                ", reqTime='" + reqTime + '\'' +
                ", respTime='" + respTime + '\'' +
                ", reqTimeZone='" + reqTimeZone + '\'' +
                ", respTimeZone='" + respTimeZone + '\'' +
                ", reqMsgId='" + reqMsgId + '\'' +
                ", reserve='" + reserve + '\'' +
                ", cityCoe='" + cityCode + '\'' +
                '}';
    }
}
