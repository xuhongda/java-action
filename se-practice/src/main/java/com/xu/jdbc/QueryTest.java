package com.xu.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhongda on 2018/11/1
 * com.xu.jdbc
 * javase-practice
 */
public class QueryTest {

    private Connection conn = null;

    /**
     * 采用高版本连接驱动需要注意一些问题，driver  以及 url 需要指定时间
     */ {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        String username = "root";
        String password = "123456";


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        //language=MySQL
        String sql = "select * from test.users where id<100";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            String columnName;
            Map<Integer, String> map = new HashMap<>(5);
            for (int i = 1; i < columnCount; i++) {
                columnName = metaData.getColumnName(i);
                map.put(i, columnName);
            }
            /*jdbc 查询结果*/
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("passWord");
                String userSex = resultSet.getString("user_sex");
                System.out.println(id + userName + passWord + userSex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
