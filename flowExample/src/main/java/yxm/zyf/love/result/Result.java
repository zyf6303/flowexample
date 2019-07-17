package yxm.zyf.love.result;

import java.util.Arrays;

/**
 * 
 * 类名: Result
 * 包名：  yxm.zyf.love.result
 * 作者：  Zhangyf
 * 时间：  2018年10月24日 下午6:16:09
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年10月24日]新建类 by Zhangyf
 *
 */
public class Result {

    protected Boolean success;

    protected String errorCode;

    protected String errorDesc;

    protected String displayMessage;

    protected ErrorContext errorContext;

    protected Object[] errorParameters;
    
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

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

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public ErrorContext getErrorContext() {
        return errorContext;
    }

    public void setErrorContext(ErrorContext errorContext) {
        this.errorContext = errorContext;
    }

    public Object[] getErrorParameters() {
        return errorParameters;
    }

    public void setErrorParameters(Object[] errorParameters) {
        this.errorParameters = errorParameters;
    }

    @Override
    public String toString() {
        return "Result [success=" + success + ", errorCode=" + errorCode + ", errorDesc=" + errorDesc + ", displayMessage=" + displayMessage
                + ", errorContext=" + errorContext + ", errorParameters=" + Arrays.toString(errorParameters) + "]";
    }
}
