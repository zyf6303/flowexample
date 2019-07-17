package yxm.zyf.love.utils;
public class Narcissistic {
 
    /**
     * 计算 8位以内的自幂数
     * @param weishu
     */
    public static void armstrongLessThan8Bit(int weishu) {
        int max = (int) Math.pow(10, weishu) - 1;
        int num = (int)Math.pow(10, weishu-1);
        int a[] = new int[weishu];
        System.out.print(weishu + "位的水仙花数有：\t");
        while (num <= max) {
            int sum = 0;
            for (int i = 0; i < weishu; i++) {
                a[i] = num / (int) Math.pow(10, weishu - i - 1) % 10;
            }
            for (int i = 0; i < weishu; i++) {
                sum = sum + (int) Math.pow(a[i], weishu);
            }
            if (num == sum) {
                System.out.print(num + "\t");
            }
            num++;
        }
    }
 
    public static void main(String[] args) {
        armstrongLessThan8Bit(8);
    }
 
}
