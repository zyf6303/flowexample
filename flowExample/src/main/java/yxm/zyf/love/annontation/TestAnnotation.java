package yxm.zyf.love.annontation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yxm.zyf.love.DemoApplication;
import yxm.zyf.love.service.impl.AnnontationServiceTestImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestAnnotation {

    @Autowired
    private AnnontationServiceTestImpl a;
    
    @Test
    public void testA() throws Exception{
        System.out.println("单元测试开始");
        a.anoundTest();
        System.out.println("单元测试完成");
    }
    
    
}
