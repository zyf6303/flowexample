package yxm.zyf.love.entity.message;

import java.util.Map;

/**
 * 
 * 类名: Response
 * 包名：  yxm.zyf.love.entity.message
 * 作者：  Zhangyf
 * 时间：  2018年10月19日 上午10:57:33
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年10月19日]新建类 by Zhangyf
 *
 */
public class Response {
    private Head head;
    private Map<String, Object> body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
