package yxm.zyf.love.result;


/**
 * 
 * 类名: CommonResult
 * 包名：  yxm.zyf.love.result
 * 作者：  Zhangyf
 * 时间：  2018年10月24日 下午6:14:03
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年10月24日]新建类 by Zhangyf
 *
 * @param <T>
 */
public class CommonResult<T> extends Result {

    private T content;

    public CommonResult<T> success() {
        this.success = true;
        return this;
    }

    public CommonResult<T> fail() {
        this.success = false;
        return this;
    }

    public CommonResult<T> content(T content) {
        this.content = content;
        return this;
    }

    public CommonResult<T> displayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
        return this;
    }

    public CommonResult<T> errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public CommonResult<T> errorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
        return this;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommonResult [content=" + content + super.toString() +"]";
    }
}
