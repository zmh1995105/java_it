package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class jdbcDemo08 {
    public static void main(String[] args) {
        List<Emp> emps = new jdbcDemo08().findAll();
        System.out.println(emps);
        System.out.println(emps.size());
    }

    /**
     * use jdbcutils
     * @return
     */
    public List<Emp> findAll() {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "passwd");
            conn = JDBCUtils.getConnection();
            String sql = "select * from emp";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date join_date = rs.getDate("join_date");
                double salary = rs.getDouble("salary");
                double bouns = rs.getDouble("bouns");
                int dept_id = rs.getInt("dept_id");
                emp = new Emp();
                emp.setId(id);
                list.add(emp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn, rs);
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
        }
        return list;
    }
}
