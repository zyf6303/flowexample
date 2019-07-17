package yxm.zyf.love;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yxm.zyf.love.vo.DataDto;

@RestController
public class ParseJsonController {
    @RequestMapping(value = "parse")
    public void pay(HttpServletRequest req, @RequestBody DataDto vo) {
        System.out.println(vo);
    }
}
