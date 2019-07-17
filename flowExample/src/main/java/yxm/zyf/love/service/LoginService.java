package yxm.zyf.love.service;

import yxm.zyf.love.model.vo.UserDTO;
import yxm.zyf.love.result.CommonResult;

public interface LoginService {
    public CommonResult<UserDTO> login(String UserName,String password);
}
