/*
 * 深圳市医贝科技有限公司源代码，版权归深圳市医贝科技有限公司所有。
 *
 * 项目名称 : zyf
 * 文件名称 : LoginServiceImpl.java
 * 创建日期 : 2018年10月24日 下午6:19:56
 * 版本 : V1.0
 * Copyright: Copyright (c) 2018
 *
 * 描述 : TODO
 */
package yxm.zyf.love.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yxm.zyf.love.mapper.UserMapper;
import yxm.zyf.love.model.vo.UserDTO;
import yxm.zyf.love.result.CommonResult;
import yxm.zyf.love.service.LoginService;
import yxm.zyf.love.utils.LoggerUtil;

/**
 * 类名: LoginServiceImpl
 * 包名：  yxm.zyf.love.service.impl
 * 作者：  Zhangyf
 * 时间：  2018年10月24日 下午6:19:56
 * 描述: TODO(请在此处详细描述类)
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2018年10月24日]新建类 by Zhangyf
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
    private final static Logger logger = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     */
    @Override
    public CommonResult<UserDTO> login(String UserName, String password) {
        LoggerUtil.info(logger, "service登录用户名：{0}，密码：{1}", UserName, password);
        CommonResult<UserDTO> result = new CommonResult<UserDTO>();
        int row = userMapper.selectCountByNP(UserName, password);
        if (row == 1) {
            LoggerUtil.info(logger, "用户存在");
            UserDTO userDTO = userMapper.selectByUserName(UserName);
            userDTO.setUserStatus("2");
            userMapper.updateByName(userDTO);
            result.setErrorCode("S");
            result.setContent(userDTO);
            result.setSuccess(true);
            return result;
        }
        LoggerUtil.info(logger, "用户不存在");
        result.setSuccess(false);
        result.setErrorCode("F");
        result.setErrorDesc("登录失败，密码或用户名错误");
        return result;
    }

}
