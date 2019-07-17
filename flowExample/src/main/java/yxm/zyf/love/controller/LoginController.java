package yxm.zyf.love.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import yxm.zyf.love.model.vo.UserDTO;
import yxm.zyf.love.result.CommonResult;
import yxm.zyf.love.service.LoginService;
import yxm.zyf.love.utils.LoggerUtil;

@RestController
@RequestMapping(value="shopmanager")
public class LoginController {
    private final static Logger logger=Logger.getLogger(LoginController.class);
    
    @Resource(name="loginServiceImpl")
    private LoginService loginService;
    
    File uploadPath;
    
    
    @RequestMapping(value="login")
    @ResponseBody
    public String test(HttpServletRequest request){
        String userName=request.getParameter("username");
        String passWord=request.getParameter("password");
        LoggerUtil.info(logger, "登录用户名：{0}，密码：{1}", userName,passWord);
        CommonResult<UserDTO> result = loginService.login(userName, passWord);
        if(result.getSuccess()){
            HttpSession session=request.getSession();
            session.setAttribute("userName", result.getContent().getLogName());
            return "登录成功";
        }
        return "登录失败";
    }
    
    @RequestMapping(value="upload")
    @ResponseBody
    public void upload(HttpServletRequest request,MultipartHttpServletRequest req) throws IOException, FileUploadException{
        /*获取文件*/
        MultipartFile file=req.getFile("file");
        System.out.println(file);
        //ServletInputStream inputStream = req.getInputStream();
        InputStream ris = file.getInputStream();
        StringBuilder content = new StringBuilder();
        byte[] b = new byte[1024];
        int lens = -1;
        while ((lens = ris.read(b)) > 0) {
            content.append(new String(b, 0, lens));
        }
        String strcont = content.toString();

        System.out.println(strcont.length());
        //获取表单参数
        System.out.println(request.getParameter("username"));

    }  
    
    @RequestMapping(value="set")
    @ResponseBody
    public String set(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("name", "张");
        return "set成功";
    }
    
    @RequestMapping(value="get")
    @ResponseBody
    public String get(HttpServletRequest request){
        HttpSession session = request.getSession();
        String attribute = (String)session.getAttribute("name");
        System.out.println(attribute);
        String attribute2 = (String)session.getAttribute("namew");
        System.out.println(attribute2);
        return attribute;
    }
    
}
