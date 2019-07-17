package yxm.zyf.love;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import yxm.zyf.love.service.CallService;
import yxm.zyf.love.utils.LoggerUtil;

@RestController
public class CallServiceController {
    private final static Logger logger = Logger.getLogger(CallServiceController.class);
    
    @Resource(name="callServiceImpl")
    private CallService callService;
    
    @RequestMapping(value="call")
    public String call(){
        LoggerUtil.info(logger, "请求call");
        String rs=callService.callHttp();
        return rs;
    } 
    
    @RequestMapping(value="posttest")
    public String testpost1(){
        return  "redirect:https://www.baidu.com/";
    }
}
