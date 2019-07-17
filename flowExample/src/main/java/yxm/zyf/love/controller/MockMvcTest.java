package yxm.zyf.love.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import yxm.zyf.love.entity.User;

@RestController
@RequestMapping("/user") //在类上声明了/user，在方法中就可以省略了
public class MockMvcTest {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getInfo(@PathVariable String id) {
        System.out.println("123");
        User user = new User();
        user.setUserName("tom");
        return user;
    }
}
