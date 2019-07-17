package yxm.zyf.love;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import yxm.zyf.love.service.payService;


@RestController
@SpringBootApplication //Spring Boot核心注解，用于开启自动配置
public class DemoApplication {
//程序可以直接在此启动
    @Autowired
    private payService payservice;
    @RequestMapping("/")
    String index(){
      return payservice.pay().toString();
    }
  
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源处理
        registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/META-INF/")
        .addResourceLocations("classpath:/hospitalpay");
    }
}