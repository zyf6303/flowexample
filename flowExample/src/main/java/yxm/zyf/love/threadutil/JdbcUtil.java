package yxm.zyf.love.threadutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class JdbcUtil{
    /*private static String url = "jdbc:mysql://rm-wz9h3u1u161ppeg83o.mysql.rds.aliyuncs.com:3306/bridge-db-test?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&connectTimeout=0&socketTimeout=0";

    private static String user = "serviceuser";

    private static String password = "ser&Psd_test01";*/
    
    private static String url = "jdbc:mysql://localhost:3306/epay?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&connectTimeout=0&socketTimeout=0";

    private static String user = "root";

    private static String password = "123";

    private JdbcUtil() {
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void free(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}