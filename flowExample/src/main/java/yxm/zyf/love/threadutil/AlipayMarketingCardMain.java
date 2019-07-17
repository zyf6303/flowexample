/*
 * 广东脑库科技有限公司源代码，版权归广东脑库科技有限公司所有。
 *
 * 项目名称 : wdc
 * 文件名称 : ArticleProcMain.java
 * 创建日期 : 2017年11月29日 下午6:05:39
 * 版本 : V1.0
 * Copyright: Copyright (c) 2017
 *
 * 描述 : TODO
 */
package yxm.zyf.love.threadutil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 * 类名: ArticleProcMain
 * 包名：  com.iemia.task
 * 作者：  Guanfm
 * 时间：  2017年11月29日 下午6:05:39
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :

 *
 */
public class AlipayMarketingCardMain {

    private final static Logger logger = Logger.getLogger(AlipayMarketingCardMain.class);

    /**
     * 功能: (这里用一句话描述这个方法的作用)
     * 描述: TODO(这里详细说明方法) 
     * 参数: @param args
     * 返回类型： void
     * @exception
     * @since  1.0.0
     */
    public static void main(String[] args) {
        int maxThreadSize = 30;
        TaskManager articleTaskManager = new TaskManager();
                articleTaskManager.init();
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ExecutorService service = Executors.newCachedThreadPool();
        LoadProcessor articleLoadProcessor = new LoadProcessor(conn, articleTaskManager);
        service.submit(articleLoadProcessor);
        //maxThreadSize个线程进行修改
        for (int i = 0; i < maxThreadSize; i++) {
            System.err.println("消费线程" + i + "正在消费中。。。。。。。。。。");
            Processor articleProcess = new Processor(conn, articleTaskManager);
            service.submit(articleProcess);
        }

    }

}
