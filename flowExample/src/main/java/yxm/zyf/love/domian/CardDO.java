package yxm.zyf.love.domian;
public class CardDO {
    private Long id;

    private String userId;

    private String memo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "CardDO [id=" + id + ", userId=" + userId + ", memo=" + memo + "]";
    }

}