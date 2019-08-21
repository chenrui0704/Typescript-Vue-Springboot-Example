package com.school.book.util.querySql.util.jdbc;



import com.school.book.util.querySql.util.GlobalConfig;

import java.util.Properties;

public class DataSource {

    private String url;
    private String username;
    private String password;
    private String driver;

    private static DataSource dataSource;

    private DataSource (){};

    public static DataSource getInstance(){
        if(null == dataSource){
            createInstance();
        }
        return dataSource;
    }

    private static void createInstance(){
        Properties properties = GlobalConfig.getGlobalConfig().getQuerySqlProperties();
        dataSource = new DataSource();
        dataSource.setUrl(properties.getProperty("db.url"));
        dataSource.setDriver(properties.getProperty("db.driver"));
        dataSource.setPassword(properties.getProperty("db.password"));
        dataSource.setUsername(properties.getProperty("db.username"));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
