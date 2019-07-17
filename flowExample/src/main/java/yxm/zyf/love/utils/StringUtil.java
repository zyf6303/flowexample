package yxm.zyf.love.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StringUtil {
    /**
     * 如果字符串为null，返回为空，去掉空格
     * @param strs
     * @return
     */
    public static String dealString(String strs) {
        if (strs == null) {
            return "";
        } else {
            return strs.trim();
        }
    }

    /**
     * 将字符增加到长度length, 前面补0
     * @param strs
     * @param length
     * @return
     */
    public static String fillNumberToString(int orgInt, int length) {
        String strs = Integer.toString(orgInt);
        StringBuffer sbf = new StringBuffer();
        for (int i = 0, t = length - strs.length(); i < t; i++) {
            sbf.append("0");
        }
        sbf.append(strs);
        return sbf.toString();

    }

    /**
     * 将字符串增加到长度length, 后面补空格
     * @param orgInt
     * @param length
     * @return
     */
    public static String fillString(String strs, int length) {
        StringBuffer sbf = new StringBuffer();
        sbf.append(strs);
        for (int i = 0, t = 20 - strs.length(); i < t; i++) {
            sbf.append(" ");
        }
        return sbf.toString();

    }

    /**
     * 功能: 输出nums个星号*
     * 描述: TODO(这里详细说明方法) 
     * 参数: @param nums
     * 参数: @return
     * 返回类型： String
     * @exception
     * @since  1.0.0
     */
    public static String fillAsterisk(int nums) {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0, t = nums; i < t; i++) {
            sbf.append("*");
        }
        return sbf.toString();
    }

    /**
     * 功能: 取得20位流水号
     * 描述: 取得20位流水号
     * 参数: @return
     * 返回类型： String
     * @exception
     * @since  1.0.0
     */
    public static String getServial() {
        int max = 10000;
        int min = 0;
        Random random = new Random();
        int rdom = random.nextInt(max) % (max - min + 1) + min;

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd" + fillNumberToString(rdom, 6) + "HHmmss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    /** 
     * 方法名称:transStringToMap 
     * 传入参数:mapString 形如 username'chenziwen^password'1234 
     * 返回值:Map 
    */
    //    public static Map<String, Object> transStringToMap(String mapString, String separator, String pairSeparator) {
    //        Map<String, Object> map = new HashMap<String, Object>();
    //        StringTokenizer items;
    //        for (StringTokenizer entrys = new StringTokenizer(mapString, separator); entrys.hasMoreTokens(); map
    //                .put(items.nextToken(), items.hasMoreTokens() ? ((Object) (items.nextToken())) : null)) {
    //            items = new StringTokenizer(entrys.nextToken(), pairSeparator);
    //        }
    //        return map;
    //    }
    public static Map<String, Object> transStringToMap(String mapString, String separator, String pairSeparator) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] fSplit = mapString.split(separator);
        for (int i = 0; i < fSplit.length; i++) {
            if (isEmpty(fSplit[i])) {
                continue;
            }
            String[] sSplit = fSplit[i].split(pairSeparator);
            String value = fSplit[i].substring(fSplit[i].indexOf('=') + 1, fSplit[i].length());
            map.put(sSplit[0], value);
        }

        return map;
    }

    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }

    public static boolean isBlank(String str) {
        int length;
        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }
        for (int i = 0; i < length; ++i) {
            if (!(Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNotBlank(String str) {
        int length;
        if ((str == null) || ((length = str.length()) == 0)) {
            return false;
        }
        for (int i = 0; i < length; ++i) {
            if (!(Character.isWhitespace(str.charAt(i)))) {
                return true;
            }
        }

        return false;
    }

    //    public static void main(String[] args) {
    //        String str = "RespCode=ZF0000&Plain=RespCode=ZF0000~~RespMsg=交易成功~~TradeResult=0&Signature=05ba9a1cd05d95572c29726e6ff2f2b8f4879889948af05da9c656a8e3b799a8097bd260158e823e4e3a8dcf723189c09816ede5f82d8681abbf18bb8bab023949f766df004e09385b7c62fdb792385d45dbbf4bc7b77b1f9552af3dc023d362742e009207e3ef5e33e57f66dce1d10e28a3a55ad9bde1c7d25f6fa96a8a0449";
    //        Map<String, Object> map = StringUtil.transStringToMap(str, "&", "=");
    //        for (String key : map.keySet()) {
    //            System.out.println("key:" + key + ", value:" + map.get(key));
    //        }
    //
    //    }
}
