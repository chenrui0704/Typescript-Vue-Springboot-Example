package com.school.book.util.querySql.util.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class DBUtil {

    private static Logger logger = LoggerFactory.getLogger(DBUtil.class);
    private static DataSource dataSource = DataSource.getInstance();
    private static DBUtil dbUtil;
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;


    private DBUtil() {
    }

    public static DBUtil getInstance() {
        if (null == dbUtil) {
            createInstance();
        }
        return dbUtil;
    }

    private static DBUtil createInstance() {
        dbUtil = new DBUtil();
        try {
            Class.forName(dbUtil.dataSource.getDriver());
        } catch (ClassNotFoundException e) {
            logger.error("驱动加载异常， e: " + e + "\t e.getMessage():" + e.getMessage());
            e.printStackTrace();
        }
        return dbUtil;
    }


    private Connection getConnection() {
        try {
            connection = DriverManager.getConnection(this.dataSource.getUrl(), this.dataSource.getUsername(), this.dataSource.getPassword());
            return connection;
        } catch (SQLException e) {
            logger.error("数据库链接异常， e: " + e + "\t e.getMessage():" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Map<String, Object>> select(String sql) {
        ResultSet resultSet = null;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            return ResultData.getDataByResult(resultSet);
        } catch (SQLException e) {
            logger.error("SQL执行失败， e: " + e + "\t e.getMessage():" + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            closeAll(connection, preparedStatement, resultSet);
        }
    }

    private void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (null != connection) {
                connection.close();
            }
            if (null != preparedStatement) {
                preparedStatement.close();
            }
            if (null != resultSet) {
                resultSet.close();
            }
        } catch (SQLException e) {
            logger.error("关闭资源失败， e: " + e + "\t e.getMessage():" + e.getMessage());
            e.printStackTrace();
        }
    }

}
