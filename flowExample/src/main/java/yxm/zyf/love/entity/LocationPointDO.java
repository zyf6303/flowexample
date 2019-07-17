package yxm.zyf.love.entity;

import java.io.Serializable;

public class LocationPointDO implements Serializable{
    
    /**
     * @Fields serialVersionUID
     * TODO（用一句话描述这个变量表示什么）
     */
    private static final long serialVersionUID = 790538625257815870L;

    private Integer id;

    private String province;

    private String city;

    private Double longitude;

    private Double latitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "LocationPointDO [id=" + id + ", province=" + province + ", city=" + city + ", longitude=" + longitude + ", latitude=" + latitude
                + "]";
    }
    
}