package yxm.zyf.love.mapper;

import org.apache.ibatis.annotations.Mapper;

import yxm.zyf.love.entity.ProdDO;

@Mapper
public interface ProdMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProdDO record);

    int insertSelective(ProdDO record);

    ProdDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProdDO record);

    int updateByPrimaryKey(ProdDO record);
}