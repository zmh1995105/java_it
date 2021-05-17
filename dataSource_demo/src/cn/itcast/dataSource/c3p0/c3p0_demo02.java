package cn.itcast.dataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0_demo02 {
    public static void main(String[] args) throws SQLException {
        // 使用默认配置
        DataSource ds = new ComboPooledDataSource();
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);

            if (i == 5) {
                conn.close();
            }
        }
        testConfig();
    }

    public static void testConfig() throws SQLException {
        // 使用指定配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        for (int i = 1; i <= 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
        }
    }
}
