/*
 * 深圳市医贝科技有限公司源代码，版权归深圳市医贝科技有限公司所有。
 *
 * 项目名称 : medicalinscore-service-gzhrss
 * 文件名称 : URLencord.java
 * 创建日期 : 2018年3月26日 下午2:50:59
 * 版本 : V1.0
 * Copyright: Copyright (c) 2018
 *
 * 描述 : TODO
 */
package yxm.zyf.love.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 类名: URLencord
 * 包名：  com.alipayeco.medicalinscore.service.gzhrss.util
 * 作者：  Zhangyf
 * 时间：  2018年3月26日 下午2:50:59
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年3月26日]新建类 by Zhangyf
 *
 */
public class JsonParse {
    public static void main(String[] args) {
        String data = "{\"cityCode\":\"441900\",\"insurerCode\":\"TAIC,YGBX\",\"responseNo\":\"409007ee-3979-437c-ac56-b242266aa36f\",\"biNCD\":\"0.70\",\"ciNCD\":\"0.9\",\"carInfo\":{\"licenseNo\":\"豫JCC522\",\"frameNo\":\"LDCC13L26A1****84\",\"brandCode\":\"3baaa591-c7b0-48f9-8c1c-d624dad1f525\",\"engineNo\":\"870**86\",\"isTrans\":\"0\",\"transDate\":null,\"firstRegisterDate\":\"2011-01-14\"},\"personInfo\":{\"ownerName\":\"张三\",\"ownerID\":\"220284198507051612\",\"ownerMobile\":\"13800013800\"},\"coverageList\":[{\"coverageCode\":\"A\",\"coverageName\":\"机动车损失保险\",\"insuredAmount\":\"Y\",\"flag\":null},{\"coverageCode\":\"B\",\"coverageName\":\"商业第三者责任险 \",\"insuredAmount\":\"300000\",\"flag\":null},{\"coverageCode\":\"MA\",\"coverageName\":\"机动车损失保险不计免赔\",\"insuredAmount\":\"Y\",\"flag\":null},{\"coverageCode\":\"D3\",\"coverageName\":\"车上人员责任保险(驾驶员)\",\"insuredAmount\":\"20000\",\"flag\":null},{\"coverageCode\":\"MD3\",\"coverageName\":\"车上人员责任保险不计免赔(驾驶员)\",\"insuredAmount\":\"Y\",\"flag\":null},{\"coverageCode\":\"X1\",\"coverageName\":\"发动机涉水损失险\",\"insuredAmount\":\"Y\",\"flag\":null},{\"coverageCode\":\"MX1\",\"coverageName\":\"发动机涉水损失险不计免赔\",\"insuredAmount\":\"Y\",\"flag\":null}]}";
        JSONObject obj = JSON.parseObject(data);
        System.out.println(obj.hashCode());
        System.out.println(obj.getString("personInfo"));
        String str = obj.getJSONObject("personInfo").getString("ownerName");
        System.out.println(str.hashCode());
        
        String a="1";
        String b="1";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

}
