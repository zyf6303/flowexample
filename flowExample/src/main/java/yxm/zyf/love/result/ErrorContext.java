package yxm.zyf.love.result;


import java.util.List;

/**
 * 
 * 类名: ErrorContext
 * 包名：  yxm.zyf.love.result
 * 作者：  Zhangyf
 * 时间：  2018年10月24日 下午6:15:47
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年10月24日]新建类 by Zhangyf
 *
 */
public class ErrorContext {

    private List<CommonError> errorStack;

    public List<CommonError> getErrorStack() {
        return errorStack;
    }

    public void setErrorStack(List<CommonError> errorStack) {
        this.errorStack = errorStack;
    }
}
