package yxm.zyf.love.utils;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
    private static int count = 0;

    private static volatile int count2 = 0;

    private static AtomicInteger count3 = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                new Thread() {
                    public void run() {
                        count++;
                        count2++;
                        count3.getAndIncrement();
                    }
                }.start();
            }

        }
        // Thread.sleep(2000);
        System.out.println("count: " + count);
        System.out.println("count2: " + count2);
        System.out.println("count3: " + count3);

        Queue<String> q = new LinkedBlockingQueue<>();//进出队列
        q.add("1");
        q.add("2");
        q.add("3");
        q.add("4");
        q.add("5");
        q.add("6");
        q.add("7");
        for (String a : q) {
            System.out.print(a);
        }

        q.poll();

        for (String a : q) {
            System.out.print(a);
        }

        q.poll();

        for (String a : q) {
            System.out.print(a);
        }
        q.poll();

        for (String a : q) {
            System.out.print(a);
        }
        q.poll();

        for (String a : q) {
            System.out.print(a);
        }
        q.poll();

        for (String a : q) {
            System.out.print(a);
        }
        q.poll();

        for (String a : q) {
            System.out.print(a);
        }

    }
}
