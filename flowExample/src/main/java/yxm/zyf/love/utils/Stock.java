package yxm.zyf.love.utils;

public class Stock {

    private int id;
    
    private int version;
    
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Stock [id=" + id + ", version=" + version + ", count=" + count + "]";
    }
    
    
}
