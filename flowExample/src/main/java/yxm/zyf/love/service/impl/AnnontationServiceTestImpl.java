package yxm.zyf.love.service.impl;

import org.springframework.stereotype.Service;

import yxm.zyf.love.annontation.AoundAnnotation;

@Service
public class AnnontationServiceTestImpl {

    @AoundAnnotation
    public boolean anoundTest() throws Exception{
        System.out.println("进入方法");
        throw new Exception("报错了");
        //return true;
    }
}
