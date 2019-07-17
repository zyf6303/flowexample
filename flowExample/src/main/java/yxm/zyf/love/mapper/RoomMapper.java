package yxm.zyf.love.mapper;

import org.apache.ibatis.annotations.Mapper;

import yxm.zyf.love.domian.RoomDO;


@Mapper
public interface RoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomDO record);

    int insertSelective(RoomDO record);

    RoomDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomDO record);

    int updateByPrimaryKeyWithBLOBs(RoomDO record);

    int updateByPrimaryKey(RoomDO record);
}