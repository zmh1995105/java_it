package cn.itcast.jdbc;

import java.sql.*;

public class jdbc_demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3",
                "root", "password");
        // 定义sql语句
        String sql = "update account set balance = 500 where id = 1";

        // 获取执行sql的对象
        Statement stmt = conn.createStatement();

        int count = stmt.executeUpdate(sql);
        System.out.println(count);
        // 关闭连接
        stmt.close();
        conn.close();

    }
}
