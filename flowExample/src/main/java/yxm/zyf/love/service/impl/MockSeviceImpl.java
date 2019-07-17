package yxm.zyf.love.service.impl;

import org.springframework.stereotype.Service;

import yxm.zyf.love.service.MockService;

@Service
public class MockSeviceImpl implements MockService {

    @Override
    public String call() {
        return "hello";
    }

}
