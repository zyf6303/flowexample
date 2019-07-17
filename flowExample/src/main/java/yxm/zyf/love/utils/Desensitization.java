package yxm.zyf.love.utils;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 类名: Desensitization
 * 包名：  yxm.zyf.love.utils
 * 作者：  Zhangyf
 * 时间：  2018年11月29日 下午5:18:08
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年11月29日]新建类 by Zhangyf
 *
 */
public class Desensitization {
    /**
     * 手机号码脱敏类型（显示前3后4）
     */
    public static int typeMobileNo = 1;

    /**
     * 姓名脱敏类型（显示前0后4）
     */
    public static int typeRealName = 2;

    /**
     * 银行帐号脱敏类型（显示前6后4）
     */
    public static int typeBankNo = 3;

    /**
     * 证件号码脱敏类型（显示前1后1）
     */
    public static int typeCardNo = 4;

    /**
     * 报文脱敏调用方法
     * @param orgString  报文
     * @param beforeSignStr 脱敏字段前标识
     * @param afterSignStr 脱敏数据后标识
     * @param type 脱敏类型
     * @return
     */
    public static String desensitiz(String orgString, String beforeSignStr, String afterSignStr, int type) {
        int tmp = orgString.indexOf(beforeSignStr);
        if (tmp == -1) {
            return orgString;
        }
        int s = tmp + beforeSignStr.length();
        int t = orgString.indexOf(afterSignStr);

        if (s > t) {
            return orgString;
        }

        String getSignStr = orgString.substring(s, t);

        StringBuffer result = new StringBuffer().append(orgString.substring(0, s));
        result.append(desing(getSignStr, type));
        result.append(orgString.substring(t, orgString.length()));

        return result.toString();
    }

    /**
     * 根据脱敏类型进行字段脱敏
     * @param signStr
     * @param type
     * @return
     */
    public static String desing(String signStr, int type) {
        String result = "";
        if (StringUtils.isBlank(signStr)) {
            return result;
        }
        switch (type) {
            case 1://手机号码脱敏类型（显示前3后4）
                result = desingByMobile(signStr);
                break;
            case 2://姓名脱敏类型（显示前0后4）
                result = desingByName(signStr);
                break;
            case 3://银行帐号脱敏类型（显示前6后4）
                result = desingByBankCardNo(signStr);
                break;
            case 4://证件号码脱敏类型（显示前1后1）
                result = desingByCardNo(signStr);
                break;
            case 5://证件号码脱敏类型（显示后4）
                result = desingBySocietyCardNo(signStr);
                break;
            default:
                result = StringUtil.fillAsterisk(signStr.length());
                break;
        }
        return result;
    }

    private static String desingByMobile(String signStr) {
        if (signStr.length() < 7) {
            return signStr;
        }
        return signStr.substring(0, 3) + StringUtil.fillAsterisk(signStr.length() - 7) + signStr.substring(signStr.length() - 4);

    }

    private static String desingByName(String signStr) {
        if (signStr.length() < 2) {
            return signStr;
        }
        return StringUtil.fillAsterisk(1) + signStr.substring(1);

    }

    private static String desingByBankCardNo(String signStr) {
        if (signStr.length() < 10) {
            return signStr;
        }
        return signStr.substring(0, 6) + StringUtil.fillAsterisk(signStr.length() - 10) + signStr.substring(signStr.length() - 4);

    }

    private static String desingByCardNo(String signStr) {
        if (signStr.length() < 2) {
            return signStr;
        }
        return signStr.substring(0, 1) + StringUtil.fillAsterisk(signStr.length() - 2) + signStr.substring(signStr.length() - 1);

    }

    private static String desingBySocietyCardNo(String signStr) {
        if (signStr.length() < 4) {
            return signStr;
        }
        return StringUtil.fillAsterisk(signStr.length() - 4) + signStr.substring(signStr.length() - 4);
    }
    
    public static void main(String[] args) {
       System.out.println( desing("20202020", 4));
    }
}