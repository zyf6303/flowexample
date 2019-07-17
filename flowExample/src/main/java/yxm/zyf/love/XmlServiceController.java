package yxm.zyf.love;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import yxm.zyf.love.entity.message.Document;
import yxm.zyf.love.utils.LoggerUtil;
import yxm.zyf.love.utils.ParseDocument;

@RestController
public class XmlServiceController {
    private final static Logger logger = Logger.getLogger(XmlServiceController.class);

    @RequestMapping(value = "service")
    @ResponseBody
    public Document xmlService(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        String line = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            //String data="<document><request id='request'><head><version>1.0.2</version><appid>GUANGZHRSS89</appid><function>alipay.medical.order.pay</function><reqTime>20180329142521</reqTime><reqTimeZone>UTC+8</reqTimeZone><reqMsgId>20180329135529955441492401423202</reqMsgId></head><body><out_order_no>20181017010000000271</out_order_no><out_trade_no>2018101700000130089</out_trade_no><serial_no>TALI061501037</serial_no><bill_no>TALI061500039</bill_no><org_no>440800001</org_no><medical_card_id>aef13ba279f89148fedf8a9f98d979a3857b14376d20708ef93cd77de22d6c64</medical_card_id><medical_card_no>6217002710000684874</medical_card_no><user_id>2088622898822395</user_id><total_amount>100000000.00</total_amount><gmt_out_create>2018-05-28 09:44:56</gmt_out_create><insurance_amount>0.00</insurance_amount><request_content></request_content></body></request></document>";
            String requestData = sb.toString();
            LoggerUtil.info(logger, "服务请求数据：{0}", requestData);
            Document document = ParseDocument.parse(requestData);//解析xml报文
            return document;
        } catch (Exception e) {
            LoggerUtil.warn(e, logger, "系统错误：{0}", e);
            return null;
        } finally {
            try {
                br.close();
            } catch (IOException e) {
            }
        }
    }
}
