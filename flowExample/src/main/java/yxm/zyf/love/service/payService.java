package yxm.zyf.love.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class payService {

    public Map<String, String> pay(){
    Map<String, String> map=new HashMap<>();
    map.put("aa", "sss");
    map.put("bb", "gggg");
    map.put("cc", "ccccc");
    map.put("ddd", "ddddd");
    return map;
    }
}
