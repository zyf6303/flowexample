package yxm.zyf.love.threadutil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.log4j.Logger;

import yxm.zyf.love.utils.HttpRequestUtils;

public class Processor implements Callable<Object> {

    /*public static final String APP_ID = "2015091400277942";

    public static final String APP_PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJo/bi5nzun66qb+njFqlBF27TUzC7YpVHA7REZFx0AvSWMNGHOn73HpFagFFNiyXcObQBJ928nvqwv3FkfSWI4wu6fFGMWF1e8c9J7ordyZSwS4jpT+WDxzR07WndD0lOdHnJtHdjsNG7vttTKKjwoXBCEOvBZZBI01qiur8dW5AgMBAAECgYEAiMi5J5PM7LcjQYXHuSC/P6GMB0JGH3sVMxWLnRmh8Sw90wW46k9BSm2dU8t1yhiah6z0K7HKp4/OyiSKcJR7C/RlmddOcfDbNb4BLCTmljY7yinleQ7wnCBLg0ALy+2RxP1emJoAlM3prqyGPhnfno2LoQGvEh7ZFIoz/Utj9IECQQDLso6s31yxhNPZpVLtBoDTqCBADSaQCuXjo1S0YK0gYMZUK9CpFvhUrrJkqtVfSQn5CTOpB3+igEQ9jF7fXhERAkEAwdpx0ZTc80B3biXZsodwpc1Rm6vr2ri3XR9LYltAhDdcBSeQfkXSuTU2FexJ9E5LA1WHiW3LPejUagMC9c96KQJAL9Mlcmsi3T79al1JggMD3i3cHI253xnf7blcWtlT7IUsK3j6Dakp9t/pXH9Lh4qjf8fsTCRJkEKjQvwhDjqMsQJBAKIx1Z2Xwi69N7AvdzBK5lOzsJ5hgFtmxfTiZD6NPzPg5dtiOSGN5jwUa4Z4R4BjqZvGijrQZIcOMfvpPSbSS9ECQFyBZ4RzvFfgtvr1I/q7vTfHJUD/2Ow2jvZb7Vk5aHc9qjlju3ODlWOCvVH3GP+FDdeHvoPswbg4fQIJQl4AkDU=";

    public static final String CHARSET = "UTF-8";

    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhl9HARli/ZoqZy92p84YuvEXgKA0aJk5Ei5s0G1hhFm6chooKBffgxM1wIql9kDJU17wFGbW273kPRX38lWjvy+faPe+QCmBR9vXASRGjH/6e90Wn2tFW/F4byO9mUg56ASkyJuwbolwE0W5/toB7WnoJCl/14qaha8lEkEvUQ4hg5imr/xMvGyAOHiFODZHBg1ddXXzbCZ0PJkBRs4T8CQduDzkkuuPZqPY4W+JrBRVt/sBSLYXUYYeUuN3i2ptkV+0+zGFp0SKP36lv2awODU7LKPnjJMqeAA8bIrH2KUH6fX0kaYpob/TXXFIvR1YleJr5hxiQFMOVpKQwyQbHwIDAQAB";
*/
    private final static Logger logger = Logger.getLogger(Processor.class);

    private final TaskManager articleTaskManager;

    private Connection conn = null;

    public Processor(Connection conn, TaskManager articleTaskManager) {
        this.articleTaskManager = articleTaskManager;
        this.conn = conn;
    }

    //    @Override
    public Object call() throws Exception {
        while (!Thread.currentThread().isInterrupted()) {
            TaskDO articleTask = articleTaskManager.claimTask();

            try {
                process(articleTask);
                //此处进行交付前置机
                //				 camiloServiceImplClient.doSyncCpInventory(cpInventoryTask.getOrder(),"System",null);
            } catch (Exception e) {
                //				 LoggerUtil.error(e, logger, "CP交易失败，订单号: {0}, 原因: {1}", cpInventoryTask.getOrder().getOrderNo(), e.getMessage());
                logger.error(e);

            }
        }

        return null;
    }

    private void process(TaskDO articleTask) {
        System.out.println("会员卡数据迁移开始， 参数=" + articleTask);
        //do delete card
        deleteCard(articleTask);
    }

    public void deleteCard(TaskDO articleTask) {
        
        /*AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", CHARSET,
                ALIPAY_PUBLIC_KEY, "RSA");
        AlipayMarketingCardDeleteRequest request = new AlipayMarketingCardDeleteRequest();
        //AlipayMarketingCardDeleteModel alipayMarketingCardDeleteModel=new AlipayMarketingCardDeleteModel();
        //        tempMarketingCardDO vo = CardMapper.selectByPrimaryKey(a);
        //        System.out.println(vo);
        String outSerialNo = System.currentTimeMillis() + "";
        Map<String, String> map = new HashMap<>();

         alipayMarketingCardDeleteModel.setOutSerialNo(outSerialNo);
        alipayMarketingCardDeleteModel.setReasonCode("USER_UNBUND");
        alipayMarketingCardDeleteModel.setTargetCardNoType("BIZ_CARD");
        alipayMarketingCardDeleteModel.setTargetCardNo(vo.getBizCardNo());
        alipayMarketingCardDeleteModel.setExtInfo("{}");
        map.put("out_serial_no", outSerialNo);
        map.put("target_card_no", articleTask.getBizCardNo());
        map.put("target_card_no_type", "BIZ_CARD");
        map.put("reason_code", "USER_UNBUND");
        map.put("ext_info", "{}");
        //        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(alipayMarketingCardDeleteModel));
        request.setBizModel(alipayMarketingCardDeleteModel);
        request.setBizContent(JSON.toJSONString(map));
        //        System.out.println();
        AlipayMarketingCardDeleteResponse response = null;
        try {
            response = alipayClient.execute(request);
            System.out.println("调用完成" + JSON.toJSONString(request));
            System.out.println("调用完成response" + JSON.toJSONString(response));
            if (response != null && response.isSuccess()) {
                updateArticleStatus(articleTask, 1);
                System.out.println("删除成功" + articleTask.getId());
            } else {
                updateArticleStatus(articleTask, -1);
                System.out.println("调用失败" + articleTask.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("处理异常；" + articleTask.getId());
            updateArticleStatus(articleTask, -2);
        }*/
        httpreq();
    }

    public int updateArticleStatus(TaskDO task, int status) {
        int inserts = 0;
        try {
            QueryRunner run = new QueryRunner();
            // Execute the SQL update statement and return the number of
            // inserts that were made
            inserts = run.update(conn, "update temp_marketing_card1 set status = ? where id = ?", new Object[]{ status, task.getId() });

            logger.info("update article status " + inserts + " id:" + task.getId() + ", status:" + status);

        } catch (SQLException sqle) {
            // Handle it
            logger.error("update article error:" + sqle.getMessage());
        }
        return inserts;
    }
    
    public void httpreq(){
        HttpRequestUtils.getRequest("http://localhost:8080/room", "");
    }
}
