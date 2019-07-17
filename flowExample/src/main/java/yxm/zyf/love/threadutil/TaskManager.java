package yxm.zyf.love.threadutil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

/**
 * 类名: ArticleTaskManager
 * 包名：  com.iemia.task
 * 作者：  Guanfm
 * 时间：  2017年11月29日 下午6:01:43
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2017年11月29日]新建类 by Guanfm
 *
 */
public class TaskManager {
    private final static Logger logger = Logger.getLogger(TaskManager.class);

    private Integer TASK_QUEUE_CAPACITY = 10000;

    //线程池
    private ExecutorService executor = null;

    //线程安全类
    private BlockingQueue<TaskDO> taskQueue = null;

    public void init() {
        taskQueue = new LinkedBlockingQueue<TaskDO>(TASK_QUEUE_CAPACITY);
        //        executor = Executors.newSingleThreadExecutor();
        //        executor.submit(new ArticleProcessor(this));
    }

    public void shutdown() {
        if (executor != null) {
            executor.shutdownNow();
        }
    }

    public Integer getTaskSize() {
        return taskQueue.size();
    }

    public boolean addTask(TaskDO task) {
        boolean offered = taskQueue.offer(task);
        if (!offered) {
            //            LoggerUtil.warn(logger, "CP异步请求卡密进货任务队列已满，订单[{0}]无法立即交易,等待下次调度执行", task.getOrder().getOrderNo());
        }
        return offered;
    }

    public TaskDO claimTask() {
        TaskDO task = null;
        try {
            task = taskQueue.take();
        } catch (InterruptedException e) {
            //            LoggerUtil.error(e, logger, "CP异步卡密线程领取交易订单中断");
        }
        return task;
    }

}
