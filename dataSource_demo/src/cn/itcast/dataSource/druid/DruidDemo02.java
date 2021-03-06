package cn.itcast.dataSource.druid;

import cn.itcast.dataSource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo02 {
    public static void main(String[] args) {
        /**
         * 完成添加操作，给account表添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into account values(null, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "jason");
            pstmt.setInt(2, 3000);
            int count = pstmt.executeUpdate();
            System.out.println(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }
}
