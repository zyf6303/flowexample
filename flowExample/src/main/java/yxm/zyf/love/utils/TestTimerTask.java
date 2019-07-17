package yxm.zyf.love.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 
 * 类名: TestTimerTask
 * 包名：  yxm.zyf.love.utils
 * 作者：  Zhangyf
 * 时间：  2018年11月16日 下午12:14:43
 * 描述: 测试定时任务
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年11月16日]新建类 by Zhangyf
 *
 */
public class TestTimerTask {
    private static int a = 0;

    public static void main(String[] args) {
        timer3();
    }

    public static void timer() {// 定时执行任务每隔1000毫秒执行一次
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 10); // 控制时 
        c.set(Calendar.MINUTE, 0); // 控制分 
        c.set(Calendar.SECOND, 0); // 控制秒 

        Date time = c.getTime(); // 得到执行任务的时间,此处为当天的10：00：00 
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                a++;
                System.out.print(a);

            }

        }, time, 1000);
    }
    
    public static void timer2() {//每天定时执行一次
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 14); // 控制时 
        c.set(Calendar.MINUTE, 10); // 控制分 
        c.set(Calendar.SECOND, 0); // 控制秒 

        Date time = c.getTime(); // 得到执行任务的时间,此处为当天的14：10：00 
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            
            @Override
            public void run() {
                System.out.println("执行任务");
                
            }
        }, time);
    }
    
    public static void timer3() {//每天定时执行一次
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 14); // 控制时 
        c.set(Calendar.MINUTE, 10); // 控制分 
        c.set(Calendar.SECOND, 0); // 控制秒 

        Date time = c.getTime(); // 得到执行任务的时间,此处为当天的14：10：00 
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            
            @Override
            public void run() {
                System.out.println("执行任务");
            }
        }, 1000, 1000);
    }
}
