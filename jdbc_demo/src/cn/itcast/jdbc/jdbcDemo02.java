package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo02 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "insert into account values(null, 'jason', 3000)";
            conn = DriverManager.getConnection("jdbc:mysql:///db3",
                    "root", "password");

            stmt = conn.createStatement();

            int count = stmt.executeUpdate(sql);

            System.out.println(count);

            if (count > 0) {
                System.out.println("successfully add");
            } else {
                System.out.println("failed to add");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

//            stmt.close();
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
