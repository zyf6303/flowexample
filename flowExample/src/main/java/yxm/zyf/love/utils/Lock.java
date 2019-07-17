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
public class Lock {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///epay?characterEncoding=UTF-8", "root", "123");
        Lock lock = new Lock();
        Thread[] threads = new Thread[200];
        for (int i = 0; i < 200; i++) {
            //int finalI = i;
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
           // createOrder(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateCount(Connection connection, Stock stock) throws SQLException {
        String sql = "update stock set count = count -1,version = version + 1 where version = " + stock.getVersion();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int update = preparedStatement.executeUpdate();
        if (update == 0) throw new RuntimeException("没抢到");
    }

    public Stock check(Connection connection) throws SQLException {
        String sql = "select * from stock where id = 1";
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
