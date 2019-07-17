package yxm.zyf.love.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class ApplicationContextHandle implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private final static Logger logger = Logger.getLogger(ApplicationContextHandle.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (logger.isDebugEnabled()) {
            LoggerUtil.debug(logger, "注入ApplicationContext到SpringContextHolder:{0}", applicationContext);
        }

        ApplicationContextHandle.applicationContext = applicationContext;
    }

    /** 
     * 获取对象 
     * 这里重写了bean方法，起主要作用 
     * @param name 
     * @return Object 一个以所给名字注册的bean的实例 
     * @throws BeansException 
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }
}