package cn.itcast.jdbc;


import cn.itcast.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 事务管理
 */
public class jdbcDemo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            String sql = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";
            pstmt1 = conn.prepareStatement(sql);
            pstmt2 = conn.prepareStatement(sql2);
            // 设置参数
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 1);
            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 2);

            pstmt1.executeUpdate();

            // 手动制造异常
            int i = 3 / 0;
            pstmt2.executeUpdate();
            conn.commit();
        } catch (Exception e1) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            e1.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1, conn);
            JDBCUtils.close(pstmt2, null);
        }
    }
}
