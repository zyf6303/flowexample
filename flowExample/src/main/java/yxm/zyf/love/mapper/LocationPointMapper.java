package yxm.zyf.love.mapper;

import org.apache.ibatis.annotations.Mapper;

import yxm.zyf.love.entity.LocationPointDO;

@Mapper
public interface LocationPointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LocationPointDO record);

    int insertSelective(LocationPointDO record);

    LocationPointDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LocationPointDO record);

    int updateByPrimaryKey(LocationPointDO record);
}