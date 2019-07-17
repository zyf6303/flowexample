package yxm.zyf.love.utils;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;


/**
 * @author Zhangyufeng
 *
 */
public class LoggerUtil {

    private static final String TRACE_MARKER = "[TraceId:{0}] ";

    /**
     * 生成trace的模板
     * 
     * @param template
     * @param parameters
     * @return
     */
    public static String getMessage(String template, Object... parameters) {

        return MessageFormat.format(TRACE_MARKER, getTraceId()) + MessageFormat.format(template, parameters);
    }

    /**
     * <p>
     * 生成调试级别日志
     * </p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成debug级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param logger
     *            logger引用
     * @param template
     *            带参数的日志模板
     * @param parameters
     *            参数集合
     */
    public static void debug(Logger logger, String template, Object... parameters) {
        if (logger.isDebugEnabled()) {
            logger.debug(getMessage(template, parameters));
        }
    }

    /**
     * <p>
     * 生成调试级别日志
     * </p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成info级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param logger
     *            logger引用
     * @param template
     *            带参数的日志模板
     * @param parameters
     *            参数集合
     */
    public static void info(Logger logger, String template, Object... parameters) {
        if (logger.isInfoEnabled()) {
            logger.info(getMessage(template, parameters));
        }
    }

    /**
     * <p>
     * 生成调试级别日志
     * </p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成warn级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param logger
     *            logger引用
     * @param template
     *            带参数的日志模板
     * @param parameters
     *            参数集合
     */
    public static void warn(Logger logger, String template, Object... parameters) {
        logger.warn(getMessage(template, parameters));
    }

    /**
     * <p>
     * 生成调试级别日志
     * </p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成error级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param logger
     *            logger引用
     * @param template
     *            带参数的日志模板
     * @param parameters
     *            参数集合
     */
    public static void error(Logger logger, String template, Object... parameters) {
        logger.error(getMessage(template, parameters));
    }

    /**
     * <p>
     * exception日志
     * </p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成warn级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param logger
     *            logger引用
     * @param template
     *            带参数的日志模板
     * @param parameters
     *            参数集合
     */
    public static void warn(Throwable e, Logger logger, String template, Object... parameters) {
        logger.warn(getMessage(template, parameters), e);
    }

    /**
     * <p>
     * exception日志
     * </p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成error级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param logger
     *            logger引用
     * @param template
     *            带参数的日志模板
     * @param parameters
     *            参数集合
     */
    public static void error(Throwable e, Logger logger, String template, Object... parameters) {
        logger.error(getMessage(template, parameters), e);
    }

    /**
     * traceid
     * 
     * @return
     */
    private static String getTraceId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//格式化对象
        String tempD = sdf.format(new Date());
        return tempD+((int) (Math.random() * 900) + 100);
    }
}
