package yxm.zyf.love.utils;

public class TestCPU {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors() * 2 + 1);
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        Runtime.getRuntime().gc();
    }
}
