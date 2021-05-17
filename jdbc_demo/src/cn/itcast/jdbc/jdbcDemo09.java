package cn.itcast.jdbc;


import cn.itcast.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 登录案例
 */
public class jdbcDemo09 {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        System.out.println("please input username:");
        String username = sc.nextLine();
        System.out.println("please input password:");
        String password = sc.nextLine();
        // call func
        boolean flag = new jdbcDemo09().login(username, password);
        // output
        if (flag) {
            System.out.println("successfully login");
        } else {
            System.out.println("failed to login");
        }
    }

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = '" + username +
                    "' and password = '" + password + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn, rs);
        }
        return false;
    }

    /**
     * 使用安全的方式防止sql注入
     * @param username
     * @param password
     * @return
     */
    public boolean login2(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            pst = conn.prepareStatement(sql);
            // 执行查询不需要传递sql
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pst, conn, rs);
        }
        return false;
    }
}
