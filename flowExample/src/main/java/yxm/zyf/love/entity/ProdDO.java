package yxm.zyf.love.entity;

public class ProdDO {
    private Long id;

    private String pname;

    private String pnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    @Override
    public String toString() {
        return "ProdDO [id=" + id + ", pname=" + pname + ", pnum=" + pnum + "]";
    }
    
    
    public static void main(String[] args) {
        int[] a = new int[3];
        a[3] = 10;


    }
    
}