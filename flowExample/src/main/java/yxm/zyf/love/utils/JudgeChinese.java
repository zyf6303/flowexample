package yxm.zyf.love.utils;

public class JudgeChinese {
    public static void main(String[] args) {
        String s = "中文";
        String regex = "[\u4E00-\u9FA5]+";
        if (s.matches(regex)) {
            System.out.println("输入是中文");
        }else{
            System.out.println("输入的不是中文");
        }
    }
}
