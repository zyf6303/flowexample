package yxm.zyf.love.domian;

public class RoomDO {
    private Integer id;

    private String roomId;

    private String baseInfo;

    private Integer createTime;

    private String ip;

    private Integer port;

    private Integer creator;

    private String users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(String baseInfo) {
        this.baseInfo = baseInfo;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "RoomDO [id=" + id + ", roomId=" + roomId + ", baseInfo=" + baseInfo + ", createTime=" + createTime + ", ip=" + ip + ", port=" + port
                + ", creator=" + creator + ", users=" + users + "]";
    }
    
}