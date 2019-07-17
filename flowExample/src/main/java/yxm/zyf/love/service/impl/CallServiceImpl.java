package yxm.zyf.love.service.impl;

import org.springframework.stereotype.Service;

import yxm.zyf.love.service.CallService;

@Service
public class CallServiceImpl implements CallService {

    @Override
    public String callHttp() {
        
        return "200";
    }

}
