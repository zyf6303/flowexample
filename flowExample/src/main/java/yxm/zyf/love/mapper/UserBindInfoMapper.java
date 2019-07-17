package yxm.zyf.love.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yxm.zyf.love.entity.UserBindInfoDO;
@Mapper
public interface UserBindInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserBindInfoDO record);

    UserBindInfoDO selectByPrimaryKey(Integer id);

    List<UserBindInfoDO> selectAll();

    List<UserBindInfoDO> selectBindingAll();

    String selectCardid(UserBindInfoDO record);

    int updateByPrimaryKey(UserBindInfoDO record);

    int updateByKey(UserBindInfoDO userBindInfoDO);

    int updateMarketingCard(UserBindInfoDO userBindInfoDO);

    UserBindInfoDO selectByUserid(@Param("userId") String userId, @Param("cityCode") String cityCode, @Param("channelCode") String channelCode);

    int selectCountByUserid(@Param("userId") String userId);

    UserBindInfoDO selectByUseridAndActived(@Param("userId") String userId, @Param("cityCode") String cityCode,
            @Param("channelCode") String channelCode);

    UserBindInfoDO selectByUserCardNo(@Param("userCardNo") String userCardNo, @Param("cityCode") String cityCode,
            @Param("channelCode") String channelCode);

    UserBindInfoDO selectByUserCardNoLimit(@Param("userCardNo") String userCardNo, @Param("cityCode") String cityCode,
            @Param("channelCode") String channelCode);

    String selectBindStatusByUserid(String userId);

    int countByUserid(@Param("userId") String userId, @Param("cityCode") String cityCode, @Param("channelCode") String channelCode);

    int countByUseridActive(@Param("userId") String userId, @Param("cityCode") String cityCode, @Param("channelCode") String channelCode);

    int countActiveByUserid(String userId);

    int countActiveByUseridandChannelCode(@Param("userId") String userId, @Param("channelCode") String channelCode);

    int countSelectByUseridandChannelCodeUnsignOrDelete(@Param("userId") String userId, @Param("channelCode") String channelCode);

    UserBindInfoDO activeByUseridandChannelCode(@Param("userId") String userId, @Param("channelCode") String channelCode);

    UserBindInfoDO selectByUseridandChannelCodeUnsignOrDelete(@Param("userId") String userId, @Param("channelCode") String channelCode);

    int countActiveByUserCardNo(@Param("userId") String userId, @Param("userCardNo") String userCardNo, @Param("cityCode") String cityCode,
            @Param("channelCode") String channelCode);

    int countActiveByUserCardNoWithoutChannelCode(@Param("userCardNo") String userCardNo);

    int updateByPrimaryKeySelective(UserBindInfoDO record);

    int updateByPrimaryKeySelectiveLock(UserBindInfoDO record);

    int updateByPrimaryKeySelectiveLockTime(@Param("userId") String userId, @Param("channelCode") String channelCode,
            @Param("cityCode") String cityCode, @Param("lastTime") String lastTime, @Param("flg4") String flg4);

    int updateSignStatusById(@Param("id") Integer id, @Param("signStatus") String signStatus);

    int updateSignStatusByUserid(@Param("userId") String userId, @Param("channelCode") String channelCode, @Param("cityCode") String cityCode,
            @Param("signStatus") String signStatus);

    int updateQueryTimesById(@Param("id") Integer id, @Param("queryTimes") Integer queryTimes);

    int updateUploadTimesById(@Param("id") Integer id, @Param("uploadTimes") Integer uploadTimes);

    List<UserBindInfoDO> selectByMap(Map<String, String> paramMap);

    List<UserBindInfoDO> loadSiQueryUserData(@Param("cityCode") String cityCode, @Param("batchSize") Integer batchSize);

    int countUnloadSiUser(@Param("cityCode") String cityCode, @Param("channelCode") String channelCode);

    List<UserBindInfoDO> listBy(@Param("singStatuss") String[] singStatuss, @Param("cardStates") String[] cardStates,
            @Param("beginDate") String beginDate, @Param("endDate") String endDate, @Param("startRow") long startRow, @Param("endRow") long endRow,
            @Param("userBindInfoDO") UserBindInfoDO userBindInfoDO, @Param("flg") String flg);

    Long countsize(@Param("singStatuss") String[] singStatuss, @Param("cardStates") String[] cardStates, @Param("beginDate") String beginDate,
            @Param("endDate") String endDate, @Param("userBindInfoDO") UserBindInfoDO userBindInfoDO);

    UserBindInfoDO selectByUserCardNoAndUserID(@Param("userId") String userId, @Param("userCardNo") String userCardNo,
            @Param("channelCode") String channelCode);

    UserBindInfoDO selectByUserCardIDAndActived(@Param("userCardNo") String userCardNo);

    /**
     * <p>根据身份证号查询用绑定信息</p>
     * @since 2018-09-22 
     * @author Ma
     * @param userCardNo
     * @return
     */
    List<UserBindInfoDO> selectListByUserCardNO(@Param("userCardNo") String userCardNo);

    List<UserBindInfoDO> selectByTime(@Param("cityCode") String cityCode);

    UserBindInfoDO selectActiveByInfo(@Param("channelCode") String channelCode, @Param("cityCode") String cityCode,
            @Param("signStatus") String signStatus, @Param("startRow") int startRow);

    List<UserBindInfoDO> selectActiveInfoByCity(@Param("cityCode") String cityCode, @Param("channelCode") String channelCode,
            @Param("userId") String userId);

    List<UserBindInfoDO> selectInfoByCityAndUserId(@Param("cityCode") String cityCode, @Param("channelCode") String channelCode,
            @Param("userId") String userId);

    /**
     * 获取锁
     */
    int countByUseridAndLock(@Param("userId") String userId, @Param("cityCode") String cityCode, @Param("channelCode") String channelCode);

    UserBindInfoDO selectByUseridAndLock(@Param("userId") String userId, @Param("cityCode") String cityCode,
            @Param("channelCode") String channelCode);

    /**
     * 获取某一时间节点上的用户绑定信息
     * @since 2018-10-21
     * @author Ma
     * @param startDate
     * @param endDate
     * @return
     */
    List<UserBindInfoDO> selectListByGmtModified(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("startRow") int startRow);

    /**
     * 本地绑定域内未绑定数量
     */
    List<UserBindInfoDO> getLocalBindAndOdsUnbindInfo(@Param("insCode") String insCode, @Param("status") String status,
            @Param("signStatus") String signStatus);

    List<UserBindInfoDO> getLocalUnBindAndOdsBindInfo(@Param("insCode") String insCode, @Param("status") String status,
            @Param("signStatus") String signStatus);

    UserBindInfoDO selectUserInfoByKey(@Param("userId") String userId, @Param("cityCode") String cityCode, @Param("insCode") String insCode);
}