package yxm.zyf.love.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 类名: Lock
 * 包名：  yxm.zyf.love.utils
 * 作者：  Zhangyf
 * 时间：  2019年4月10日 下午5:18:12
 * 描述: 乐观锁
 * @since 1.0.0
 *
 * 修改历史 :
 * 1. [2019年4月10日]新建类 by Zhangyf
 *
 */
public class LockSecond {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///epay?characterEncoding=UTF-8", "root", "123");
        
        LockSecond lock = new LockSecond();
        Thread[] threads = new Thread[200];
        for (int i = 0; i < 200; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    lock.service(connection);
                }
            };
        }
        for (int i = 0; i < 200; i++) {
            threads[i].start();
        }
    }

    public void service(Connection connection) {
        try {
            Stock stock1 = check(connection);
            updateCount(connection, stock1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateCount(Connection connection, Stock stock) throws SQLException {
        String sql = "update stock set version = 1 where version = 0" ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int update = preparedStatement.executeUpdate();
        if(update>0){
            System.out.println("上锁成功");
            String sql2 = "update stock set count = count -1 where count >0 and version =1 ";
            preparedStatement = connection.prepareStatement(sql2);
            int executeUpdate = preparedStatement.executeUpdate();
            if(executeUpdate>0){
                String sql3 = "update stock set version = 0 where version =1";
                preparedStatement = connection.prepareStatement(sql3);
                int executeUpdate2 = preparedStatement.executeUpdate();
                if (executeUpdate2 == 0) throw new RuntimeException("解锁失败");
              //  System.out.println("业务成功");
            }
            //if (executeUpdate == 0) throw new RuntimeException("业务失败");
        }
        //if (update == 0) throw new RuntimeException("上锁失败");
    }

    public Stock check(Connection connection) throws SQLException {
        String sql = "select * from stock where id = 2";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Stock stock = null;
        if (resultSet.next()) {
            stock = new Stock();
            stock.setId(resultSet.getInt("id"));
            stock.setCount(resultSet.getInt("count"));
            stock.setVersion(resultSet.getInt("version"));
        }
        if (stock.getCount() < 1) throw new RuntimeException("没有库存了");
        return stock;
    }

}
