package yxm.zyf.love.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yxm.zyf.love.model.vo.ProdSerDTO;
import yxm.zyf.love.service.SynAsynThreadTestService;

@RestController
public class ThreadSearchProd {
    @Resource(name="synAsynThreadTestServiceImpl")
    private SynAsynThreadTestService synAsynThreadTestService;
    @RequestMapping(value="search")
    public ProdSerDTO search(HttpServletRequest request){
        String word=request.getParameter("word");
        return synAsynThreadTestService.searchProd(word);
    }
    
    @RequestMapping(value="searchcb")
    public ProdSerDTO searchcb(HttpServletRequest request){
        String word=request.getParameter("word");
        return synAsynThreadTestService.searchProdcb(word);
    }
    
    @RequestMapping(value="dealbind")
    public String dealbind(HttpServletRequest request) throws IOException{
        //String word=request.getParameter("word");
        synAsynThreadTestService.dealBindInfo();
        return "ok";
    }
}
