package yxm.zyf.love.utils;

import yxm.zyf.love.model.vo.UserDTO;

public class Test {
    public static <T> void main(String[] args) {
        JdbcUtils<UserDTO> t = new JdbcUtils<UserDTO>() {
        };
        t.setJdbcUrl("jdbc:mysql:///epay?characterEncoding=UTF-8");
        t.setUser("root");
        t.setPassword("123");
        /*t.setJdbcUrl("jdbc:mysql://rm-wz9h3u1u161ppeg83o.mysql.rds.aliyuncs.com:3306/bridge-db-test?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull");
        t.setUser("serviceuser");
        t.setPassword("ser&Psd_test01");*/
        //query(t);
        //insert(t);
        update(t);
    }

    private static <T> void query(JdbcUtils<T> t) {
        String sql = "SELECT * FROM phone WHERE id=1";
        try {
            T user = t.query(sql);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static <T> void insert(JdbcUtils<T> t) {
        String sql = "INSERT into phone (`name`,`age`,`add`,`time`,`date`,`gmt`,`iphone`,`vivo`,`oppo`,`huawei`,`xiaomi`,`xiaodong`,`xiaoxi`,`xiaohu`,`xiaoqi`)"
                + " values('宇翊','21','23',now(),now(),now(),1,2,3,4,5,6,7,8,9)";
        try {
            int user = t.insert(sql);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static <T> void update(JdbcUtils<T> t) {
        String sql = "update phone set name='予以I' where id=2 ";
        try {
            int user = t.insert(sql);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}