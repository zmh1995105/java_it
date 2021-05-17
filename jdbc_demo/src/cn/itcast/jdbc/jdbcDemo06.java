package cn.itcast.jdbc;

import java.sql.*;

// 执行ddl语句

public class jdbcDemo06 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3",
                    "root", "passwd");
            String sql = "select * from account";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            // 游标向下移动一行
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble(3);

                System.out.println(id + "---" + name + "---" + balance);
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
