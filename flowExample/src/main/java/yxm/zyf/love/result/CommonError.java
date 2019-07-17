package yxm.zyf.love.result;

/**
 * 
 * 类名: CommonError
 * 包名：  yxm.zyf.love.result
 * 作者：  Zhangyf
 * 时间：  2018年10月24日 下午6:15:31
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年10月24日]新建类 by Zhangyf
 *
 */
public class CommonError {
    private String errorCode;

    private String errorDesc;

    private String location;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
