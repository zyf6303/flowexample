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

import java.io.UnsupportedEncodingException;

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
public class URLencord {

    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String URLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
