package yxm.zyf.love;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import yxm.zyf.love.domian.RoomDO;
import yxm.zyf.love.entity.LocationPointDO;
import yxm.zyf.love.mapper.LocationPointMapper;
import yxm.zyf.love.mapper.RoomMapper;
import yxm.zyf.love.redistool.RedisClient;
import yxm.zyf.love.utils.LoggerUtil;
import yxm.zyf.love.utils.StringUtil;
import yxm.zyf.love.utils.URLencord;
import yxm.zyf.love.vo.payVo;

@RestController
public class hospitalpay {
    private final static Logger logger = Logger.getLogger(hospitalpay.class);//给类初始化日志对象

    @Autowired
    private RoomMapper roomMapper;
    
    @Autowired
    private LocationPointMapper locationPointMapper;

    
    @Autowired
    private RedisClient redisClinet;

    @ResponseBody
    @RequestMapping(value = "pay")
    public void pay(HttpServletRequest req, @RequestBody String a) {
        System.out.println(req.getAttribute("industry"));
        System.out.println(req.getParameter("industry"));
        Map<String, Object> map = StringUtil.transStringToMap(URLencord.URLDecoderString(a), "&", "=");
        for (String key : map.keySet()) {
            System.out.println("key:" + key + ", value:" + map.get(key));
        }
        System.out.println(map);
        System.out.println(JSON.parseObject(JSON.toJSONString(map)));
        payVo payvo = JSON.parseObject(JSON.toJSONString(map), payVo.class);
        System.out.println(payvo);
    }
    
    @ResponseBody
    @RequestMapping(value = "pays")
    public void pays(HttpServletRequest req, @RequestBody payVo vo) {
        
        System.out.println(vo);
    }

    @ResponseBody
    @RequestMapping(value = "room", produces = { "application/json;charset=UTF-8" })
    public RoomDO room() {
        RoomDO roomdo = null;
        try {
            roomdo = JSON.parseObject(redisClinet.get("room"), RoomDO.class);
            LoggerUtil.info(logger, "从redis获取room的值:{0}", roomdo);
            if (roomdo == null) {
                roomdo = roomMapper.selectByPrimaryKey(1);
                LoggerUtil.info(logger, "从db获取room的值:{0}", roomdo);
                redisClinet.set("room", JSON.toJSONString(roomdo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoggerUtil.info(logger, "出参roomdo：{0}", roomdo);//打印info级别的日志
        return roomdo;
    }
    
    @ResponseBody
    @RequestMapping(value = "location")
    public LocationPointDO location() {
        LocationPointDO locationPointDO = null;
        locationPointDO = locationPointMapper.selectByPrimaryKey(1147);
        LoggerUtil.info(logger, "出参locationPointDO：{0}", locationPointDO);//打印info级别的日志
        System.out.println(locationPointDO);
        return locationPointDO;
    }
    
    @ResponseBody
    @RequestMapping(value = "uplocation")
    public LocationPointDO uplocation() {
        LocationPointDO locationPointDO = null;
        locationPointDO = locationPointMapper.selectByPrimaryKey(1147);
        locationPointDO.setCity("合肥肥");
        locationPointMapper.updateByPrimaryKey(locationPointDO);
        LoggerUtil.info(logger, "出参locationPointDO：{0}", locationPointDO);//打印info级别的日志
        System.out.println(locationPointDO);
        return locationPointDO;
    }
    
    @RequestMapping(value = "showsession")
    @ResponseBody
    public String showsession(HttpServletRequest request) {
       HttpSession session=request.getSession();
       System.out.println("@@@@" +session.getId());
       LoggerUtil.info(logger, "获取show sessionId：{0}", session.getId());
       return session.getId();
    }
}
