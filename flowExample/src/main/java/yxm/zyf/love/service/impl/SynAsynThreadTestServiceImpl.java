package yxm.zyf.love.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import yxm.zyf.love.entity.ProdDO;
import yxm.zyf.love.entity.UserBindInfoDO;
import yxm.zyf.love.mapper.ProdMapper;
import yxm.zyf.love.mapper.UserBindInfoMapper;
import yxm.zyf.love.model.vo.ProdSerDTO;
import yxm.zyf.love.service.SynAsynThreadTestService;
import yxm.zyf.love.threadutil.SaveInfoCallProcessor;
import yxm.zyf.love.threadutil.SaveInfoProcessor;
import yxm.zyf.love.utils.HttpRequestUtils;
import yxm.zyf.love.utils.LoggerUtil;
import yxm.zyf.love.utils.URLencord;
/**
 * 
 * 类名: SynAsynThreadTestServiceImpl
 * 包名：  yxm.zyf.love.service.impl
 * 作者：  Zhangyf
 * 时间：  2018年11月14日 下午3:58:20
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年11月14日]新建类 by Zhangyf
 *
 */
@Service
public class SynAsynThreadTestServiceImpl implements SynAsynThreadTestService {
    private static final Logger logger = Logger.getLogger(SynAsynThreadTestServiceImpl.class);

    private static int nThreads = Runtime.getRuntime().availableProcessors() * 2 + 1; //创建的线程数理论最优值是cpu核数的2n+1
    
    @Autowired
    private UserBindInfoMapper userBindInfoMapper;
    
    @Autowired
    private ProdMapper prodMapper;

    private static ExecutorService executors = Executors.newFixedThreadPool(nThreads, new ThreadFactory() { //创建线程池

        private final String threadName = "threadName_";

        private final AtomicInteger count = new AtomicInteger(1);//原子性操作

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(Thread.currentThread().getThreadGroup(), r, threadName + count.getAndIncrement());
            t.setDaemon(true);
            return t;
        }
    });

    @Override
    public ProdSerDTO searchProd(String word) {
        String url = "https://suggest.taobao.com/sug?code=utf-8&q=" + URLencord.getURLEncoderString(word) + "&callback=cb";
        String response = HttpRequestUtils.getRequest(url, "0");
        LoggerUtil.info(logger, "请求出参：{0}", response);
        if (response != null) {
            ProdSerDTO dto = JSON.parseObject(response, ProdSerDTO.class);
            for (int i = 0; i < dto.getResult().size(); i++) {
                SaveInfoProcessor saveInfoProcessor=new SaveInfoProcessor();
                saveInfoProcessor.setProdMapper(prodMapper);
                ProdDO pDo=new ProdDO();
                List<Object> list =JSONArray.parseArray( dto.getResult().get(i));
                pDo.setPname(list.get(0).toString());
                pDo.setPnum(list.get(1).toString());
                saveInfoProcessor.setProdDo(pDo);
              //  LoggerUtil.info(logger, "i：{0}，参数：{1}",i, pDo);
                executors.execute(saveInfoProcessor);
                LoggerUtil.info(logger, "线程执行结果：{0}", 1);
                
            }
            LoggerUtil.info(logger, "返回请求出参：{0}", dto);
            return dto;
        }
        return null;
    }

   /* public static void main(String[] args) {
        String a = HttpRequestUtils.getRequest("https://suggest.taobao.com/sug?code=utf-8&q=pingguo&callback=cb", "111");
        ProdSerDTO dto = JSON.parseObject(a, ProdSerDTO.class);
        System.out.println(dto);
        for(int i=0; i < dto.getResult().size(); i++){
            ProdDO pDo=new ProdDO();
            List<Object> list =JSONArray.parseArray( dto.getResult().get(i));
            pDo.setPname(list.get(0).toString());
            pDo.setPnum(list.get(1).toString());
            System.out.println(pDo);
        }
        
    }*/

    @Override
    public ProdSerDTO searchProdcb(String word) {
        String url = "https://suggest.taobao.com/sug?code=utf-8&q=" + URLencord.getURLEncoderString(word) + "&callback=cb";
        String response = HttpRequestUtils.getRequest(url, "0");
        LoggerUtil.info(logger, "请求出参：{0}", response);
        if (response != null) {
            ProdSerDTO dto = JSON.parseObject(response, ProdSerDTO.class);
            for (int i = 0; i < dto.getResult().size(); i++) {
                SaveInfoCallProcessor saveInfoCallProcessor=new SaveInfoCallProcessor();
                saveInfoCallProcessor.setProdMapper(prodMapper);
                ProdDO pDo=new ProdDO();
                List<Object> list =JSONArray.parseArray( dto.getResult().get(i));
                pDo.setPname(list.get(0).toString());
                pDo.setPnum(list.get(1).toString());
                saveInfoCallProcessor.setProdDo(pDo);
              //  LoggerUtil.info(logger, "i：{0}，参数：{1}",i, pDo);
                Future<String> rs = executors.submit(saveInfoCallProcessor);
                try {
                    LoggerUtil.info(logger, "线程执行结果：{0}", rs.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                
            }
            LoggerUtil.info(logger, "返回请求出参：{0}", dto);
            return dto;
        }
        return null;
    }
    
    private void saveCardBindUserInfo(UserBindInfoDO userBindInfoDO) {
        LoggerUtil.info(logger, "保存卡绑定用户数据, 参数={0}", userBindInfoDO);
        try {
            if (userBindInfoDO != null) {
                //BeanUtils.copyProperties(userBind, userBindInfoDO);
                //userBindInfoDO.setGmtTime(reqDate);
                userBindInfoDO.setFlg5("0");
                //userBindInfoDO.setInsCode(getInsCode(userBind.getCityCode()));
              //  int row = userBindInfoMapper.countByUserid(userBindInfoDO.getUserId(), userBindInfoDO.getCityCode(), userBindInfoDO.getChannelCode());
              //  if (row == 1) {
             //       userBindInfoMapper.updateByPrimaryKeySelective(userBindInfoDO);
            //    } else {
                    userBindInfoMapper.insert(userBindInfoDO);
            //    }
            }
        } catch (Exception e) {
            LoggerUtil.warn(e, logger, "卡绑定用户数据保存失败！参数={0},exception={1}", userBindInfoDO, e.getMessage());
        }

    }
    public static void main(String[] args) throws IOException {
        /*String str="UserBindInfoDTO [id=null, cityCode=SZ0755, channelCode=alipay, medicalCardId=6046534132, medicalCardNo=B5D296798, userId=2088822372980904, userCardType=01, "
                + "userCardNo=441423197906164214, realName=张国木, mobile=18028739208, agreementNo=null, signStatus=ACTIVED, gmtTime=Fri Nov 16 00:01:03 CST 2018,"
                + " bankCardNo=6214677200006160252, outUserAccount=null, outUserId=null, socialCardNo=441423197906164214, medicalCardValidateDate=Mon Sep 09 00:00:00 CST 2024, "
                + "medicalCardStatus=active, flg1=null, flg2=null, flg3=null, flg4=null, flg5=null, userCertifyPic=null, queryTimes=null, uploadTimes=null,"
                + " cardNo=pre00000000000855587290, cardState=null, medicalCardType=finance, userPhotoUrl=null, chinfo=PDA01B01C01D00, gmtModified=null, relationType=null,"
                + " extendParams={\"insurance_return\":{\"card_query\":{\"cblx\":\"2\",\"dnh\":\"624220840\"}}}, signLevel=null, cityNo=440300, insCode=SZHRSSSEC,"
                + " toString()=com.alipayeco.medicalinscore.facade.dto.UserBindInfoDTO@2319be6f]";
        String c=str.substring(str.indexOf("["), str.lastIndexOf("]")+1);
        c=c.replace("\"", "\\\"");
        c=c.replace("[", "{\"");
        c=c.replace("]", "\"}");
        c=c.replace("=", "\":\"");
        c=c.replace(", ", "\",\"");
        //JSONObject jsonObject=JSON.parseObject(c);
        System.out.println(c);
        UserBindInfoDO strbean=JSON.parseObject(c, UserBindInfoDO.class);
        System.out.println(strbean);*/
        //return strbean;
        
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("E:/test.txt")));
        StringBuffer sb = new StringBuffer();
        String str = null;
        while((str = in.readLine()) != null){
            String a= str;
            a=a.split("参数=")[1].trim();
            UserBindInfoDO userDO=strToBean(a);
           // saveCardBindUserInfo(userDO);
        }
        in.close();
    }

    @Override
    public void dealBindInfo() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("E:/test.txt")));
        StringBuffer sb = new StringBuffer();
        String str = null;
        while((str = in.readLine()) != null){
            String a= str;
            a=a.split("参数=")[1].trim();
            UserBindInfoDO userDO=strToBean(a);
            saveCardBindUserInfo(userDO);
        }
        in.close();
        
    }
    
    private static UserBindInfoDO strToBean(String str){
        String c=str.substring(str.indexOf("["), str.lastIndexOf("]")+1);
        c=c.replace("\"", "\\\"");
        c=c.replace("[", "{\"");
        c=c.replace("]", "\"}");
        c=c.replace("=", "\":\"");
        c=c.replace(", ", "\",\"");
        //JSONObject jsonObject=JSON.parseObject(c);
        System.out.println(c);
        UserBindInfoDO strbean=JSON.parseObject(c, UserBindInfoDO.class);
       return strbean;
    }
}
