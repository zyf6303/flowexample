package yxm.zyf.love.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yxm.zyf.love.entity.UserDO;
import yxm.zyf.love.model.vo.UserDTO;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String userNo);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(String userNo);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    int selectCountByNP(@Param("userName") String userName,@Param("passWord") String passWord);

    UserDTO selectByUserName(@Param("userName") String userName);

    int updateByName(UserDTO userDTO);
}