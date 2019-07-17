/*
 * 深圳市医贝科技有限公司源代码，版权归深圳市医贝科技有限公司所有。
 *
 * 项目名称 : medicalinscore-common
 * 文件名称 : TestThread.java
 * 创建日期 : 2018年11月12日 下午7:22:56
 * 版本 : V1.0
 * Copyright: Copyright (c) 2018
 *
 * 描述 : TODO
 */
package yxm.zyf.love.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThread {

    private static int nThreads = Runtime.getRuntime().availableProcessors() * 2 + 1;

    private static ExecutorService executors = Executors.newFixedThreadPool(nThreads, new ThreadFactory() {

        private final String threadNamePrefix = "si_query_task_";

        private final AtomicInteger count = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(Thread.currentThread().getThreadGroup(), r, threadNamePrefix + count.getAndIncrement());
            t.setDaemon(true);
            return t;
        }
    });

    public static void main(String[] args) {

        List<Future<String[]>> fList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int nextInt = new Random().nextInt(100);
            Future<String[]> f = executors.submit(new TestTaskcb(nextInt));
            fList.add(f);
        }

        for (Future<String[]> future : fList) {
            try {
                String[] result = future.get();
               // System.out.println(result[0] + " , 结果   " + result[1]);
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
            }
        }
        System.out.println("call线程结束");
        

        for (int i = 0; i < 10; i++) {
            final int nextInt = new Random().nextInt(100);
            executors.execute(new TestTaskvoid(nextInt));
        }
        System.out.println("void线程结束");
        
        System.out.println("main 线程结束 ");

    }

    static class TestTaskcb implements Callable<String[]> {

        private int i;

        public TestTaskcb(int i) {
            this.i = i;
        }

        @Override
        public String[] call() throws Exception {
            String result = i % 2 == 0 ? "S" : "F";
            // 业务处理逻辑
            //Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "第" + i + "次任务");
            return new String[]{ Thread.currentThread().getName(), result };
        }
    }
    
    static class TestTaskvoid implements Runnable {

        private int i;

        public TestTaskvoid(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "第" + i + "次任务");
        }
    }
}
