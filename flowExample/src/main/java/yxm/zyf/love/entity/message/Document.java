package yxm.zyf.love.entity.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * 类名: Document
 * 包名：  yxm.zyf.love.entity.message
 * 作者：  Zhangyf
 * 时间：  2018年10月19日 上午10:58:18
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年10月19日]新建类 by Zhangyf
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JacksonXmlRootElement(localName = "document")
public class Document {
    private Request request;

    private Response response;

    private String signature;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Document [request=" + request + ", response=" + response + ", signature=" + signature + "]";
    }

}
