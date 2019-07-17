/**
 *
 */
package yxm.zyf.love.entity.message;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * 类名: ResultMessage
 * 包名：  yxm.zyf.love.entity.message
 * 作者：  Zhangyf
 * 时间：  2018年10月19日 上午10:58:32
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年10月19日]新建类 by Zhangyf
 *
 * @param <T>
 */
public class ResultMessage<T> implements Serializable {
    private static final long serialVersionUID = 1911921008127610877L;

    private boolean isSuccess = true;

    private String resultCode;

    private String resultMsg;

    private T obj;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
