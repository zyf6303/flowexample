package yxm.zyf.love.utils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.log4j.Logger;

public class HttpRequestUtils {
    
    private final static Logger logger = Logger.getLogger(HttpRequestUtils.class);

    public static String getRequest(String url,String params){
        GetMethod getMethod = null;
        try {
            //String datas="json="+params;   
            HttpClient httpClient = new HttpClient();
            // GET 查询交易报文
            getMethod = new GetMethod();
            getMethod.setPath(url);// 设置服务的url  
            getMethod.setRequestHeader("Content-Type", "text/html;charset=UTF-8");// 设置请求头编码  
            // 设置连接超时  
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(20 * 1000);
            // 设置读取超时  
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(20 * 1000);
            getMethod.setQueryString(params);
            int responseCode = httpClient.executeMethod(getMethod);
            System.out.println(responseCode);
            // 取得查询交易结果
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String responseStr = new String(getMethod.getResponseBody());
                LoggerUtil.info(logger, "调用https服务, 参数={0}|{1}, responseCode={2}", java.net.URLDecoder.decode(params, "UTF-8"), responseCode);
                return responseStr;
            } else {
                LoggerUtil.info(logger, "调用https服务, 参数={0}|{1}, responseCode={2}", java.net.URLDecoder.decode(params, "UTF-8"), responseCode);
            }
        } catch (Exception e) {
            LoggerUtil.error(e, logger, "http请求异常：{0}", url);
        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();//释放连接
            }
        }
        return null;
    }
    
    public static String postRequest(String url,String params){
        PostMethod postMethod = null;
        try {
            byte b[] = params.getBytes();//把字符串转换为二进制数据                       
            RequestEntity requestEntity = new ByteArrayRequestEntity(b);
            HttpClient httpClient = new HttpClient();
            // POST 查询交易报文
            postMethod = new PostMethod();
            postMethod.setPath(url);// 设置服务的url  
            postMethod.setRequestHeader("Content-Type", "text/html;charset=UTF-8");// 设置请求头编码  
            // 设置连接超时  
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(20 * 1000);
            // 设置读取超时  
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(20 * 1000);
            postMethod.setRequestEntity(requestEntity);// 设置数据  
            int responseCode = httpClient.executeMethod(postMethod);
            LoggerUtil.info(logger, "调用https服务, 参数={0}, responseCode={1}", params, responseCode);
            // 取得查询交易结果
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String responseStr = new String(postMethod.getResponseBody());
                LoggerUtil.info(logger, "请求返回的结果入参：{0}，出参：{1}", params, responseStr);
                return responseStr;
            } else {
                LoggerUtil.info(logger, "调用http服务异常");
            }
        } catch (Exception e) {
            LoggerUtil.error(e, logger, "调用人社服务器HTTP错误：url:{0},e:{1}", url, e.getMessage());
            
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(postRequest("https://medicalinsprodsit.alipay-eco.com/medicalinsprod/silivecertify/getuserinfo","1"));
    }
}
