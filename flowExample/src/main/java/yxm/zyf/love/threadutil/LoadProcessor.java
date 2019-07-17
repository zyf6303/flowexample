package yxm.zyf.love.threadutil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;


//加载的类
public class LoadProcessor implements Callable {

    private final static Logger logger = Logger.getLogger(LoadProcessor.class);

    private final TaskManager alipayMarketingCardTaskManager;

    private Connection conn = null;

    private final static int MAX_BATCH_SIZE = 5000;

    public LoadProcessor(Connection conn, TaskManager alipayMarketingCardTaskManager) {
        this.alipayMarketingCardTaskManager = alipayMarketingCardTaskManager;
        this.conn = conn;
    }

    @Override
    public Object call() throws Exception {
        //        while (!Thread.currentThread().isInterrupted()) {
        //ArticleTask articleTask = articleTaskManager.claimTask();
        try {
            int end = 0;
            int start = 1; //1701317
            int maxId = 1701316; //2958932 1257616
            for (; start <= maxId;) {
                if (alipayMarketingCardTaskManager.getTaskSize() < 20000) {
                    end = start + MAX_BATCH_SIZE;
                    System.out.println("深圳数据迁移, 加载数据：start ={0}，end={1}" + start + ",end=" + end);

                    loadDataFromDestination(start, end);
                    start = end;
                    Thread.sleep(100); //休息5s
                } else {
                    System.out.println("深圳数据迁移, 队列超过2000,等待loading数据");
                    Thread.sleep(5000); //休息5s
                }
            }

            System.out.println("深圳数据迁移， 数据加载完成");
        } catch (Exception e) {
            System.out.println("loadDataFromDestination error" + e);
            e.printStackTrace();
        }

        return null;
    }

    public List<TaskDO> loadDataFromDestination(int start, int end) {
        // 0. update addtional data
        // updateBusinessInfoAddition();
        logger.info("load data from db");
        List<TaskDO> hotlist = new ArrayList<TaskDO>();
        //        try {
        //            conn = JdbcUtil46.getConnection();
        //        } catch (SQLException e) {
        //            e.printStackTrace();
        //        }
        StringBuilder sb = new StringBuilder(
                "SELECT `id`,`user_id` as userId,`biz_card_no` as bizCardNo,`template_id` as TemplateId,`city_code` as cityCode,`status`,`memo` FROM `temp_marketing_card1`");
        sb.append(" where status = 0");
        sb.append(" and city_code = 'SZ0755'");
        sb.append(" and id >=  " + start);
        sb.append(" and id <=  " + end);
        logger.info("sql:" + sb.toString());
        try {
            QueryRunner qr = new QueryRunner();
            hotlist = qr.query(conn, sb.toString(), new BeanListHandler<TaskDO>(TaskDO.class));
            if (hotlist != null && !hotlist.isEmpty()) {
                for (TaskDO task : hotlist) {
                    //in queue
                    boolean inqueue = alipayMarketingCardTaskManager.addTask(task);
                    //lock article
                    if (inqueue) {
                        System.out.println("入队列成功");
                    } else {
                        logger.info("入队列失败：" + task.getId());
                    }
                }
            }
            //            }
            //            logger.info("article list:" + hotlist.size());
        } catch (SQLException e) {
            e.printStackTrace();
            //        } finally {
            //            DbUtils.closeQuietly(conn);
        }

        return hotlist;
    }

    /*public int updateArticleStatus(Article article, int status) {
        int inserts = 0;
        try {
            QueryRunner run = new QueryRunner();
            // Execute the SQL update statement and return the number of
            // inserts that were made
            inserts = run.update(conn, "update temp_marketing_card set status = ? where id = ?", new Object[]{ status, article.getId() });

            logger.info("update article status " + inserts + " id:" + article.getId() + ", status:" + status);

        } catch (SQLException sqle) {
            // Handle it
            logger.error("update article error:" + sqle.getMessage());
        }
        return inserts;
    }*/
}
