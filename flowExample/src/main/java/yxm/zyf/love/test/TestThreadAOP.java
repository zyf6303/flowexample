package yxm.zyf.love.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yxm.zyf.love.DemoApplication;
import yxm.zyf.love.service.MockService;
import yxm.zyf.love.utils.ApplicationContextHandle;
import yxm.zyf.love.utils.SpringContextUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestThreadAOP {
    
    private static ExecutorService excutor=Executors.newFixedThreadPool(1);
    
    private ApplicationContextHandle applicationContextHandle;

    @Autowired
    private MockService mockService;
    @Test
    public void testTAOP() throws InterruptedException, ExecutionException{
        Task t=new Task();
        t.setName("zhang");
        t.setMockService(mockService);
        excutor.execute(t);
    }

    class Task implements Runnable{
        private String name;
        
        private MockService mockService;

        
        public MockService getMockService() {
            return mockService;
        }


        public void setMockService(MockService mockService) {
            this.mockService = mockService;
        }


        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            /*String call = mockService.call();
            System.out.println(call);*/
            MockService MockService1 = SpringContextUtil.getBean("mockServiceImpl");
            System.out.println(MockService1.call());
            System.out.println("bsbbsbsbsbbs是");
        }
        
    }
    
    @Test
    public void testoneT(){
        new Thread( new Runnable() {
            public void run() {
                System.out.println("888888888888---");
                MockService mock=(MockService)ApplicationContextHandle.getBean("mockSeviceImpl");
                System.out.println("8888888888889---");
                String call = mock.call();
                System.out.println(call);
            }
        });
    }
}

