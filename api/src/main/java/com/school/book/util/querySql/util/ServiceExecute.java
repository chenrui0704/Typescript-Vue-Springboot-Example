package com.school.book.util.querySql.util;

import com.school.book.util.querySql.util.jdbc.DBUtil;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ServiceExecute {

    private static GlobalConfig globalConfig;
    private static Properties serviceProperties;
    private static Map<String, List<Element>> sqlXmlMap;
    private static DBUtil dbUtil;
    private static Logger logger = LoggerFactory.getLogger(ServiceExecute.class);

    static {
        initialization();
    }

    public static Object execute(String serviceName, Map<String,String> parameter) {
        preventDanger(parameter);
        Map<String, String> sqlMap = getSqlMapToExecute(serviceName, parameter);
        if(null == sqlMap){
            return null;
        }
        Map<String, Object> data = execute(sqlMap);
        return data;
    }

    private static Map<String, Object> execute(Map<String, String> sqlMap){
        Map<String, Object> data = new HashMap<>();
        sqlMap.forEach((key, sql) -> {
            logger.info("sql : " + sql);
            data.put(key, dbUtil.select(sql));
        });
        return data;
    }

    // 初始化
    private static void initialization() {
        globalConfig = GlobalConfig.getGlobalConfig();
        serviceProperties = globalConfig.getServiceProperties();
        sqlXmlMap = globalConfig.getSqlXmlMap();
        dbUtil = DBUtil.getInstance();
    }

    // 获取要执行的sql列表
    private static Map<String, String> getSqlMapToExecute(String serviceName, Map<String, String> parameter) {
        // 例如: user.query
        String queryString = serviceProperties.getProperty(serviceName);
        if (null == queryString || "" == queryString) {
            return null;
        }
        Map<String, String> sqlMap = new HashMap<>();
        String[] queryArray = queryString.split(",");
        for (String s : queryArray) {
            String xmlName = s.substring(0, s.indexOf("."));
            String id = s.substring(s.indexOf(".") + 1);
            sqlMap.put(s.replace(".",""), getSql(xmlName, id, parameter));
        }
        return sqlMap;
    }


    // 获取Sql
    private static String getSql(String xmlName, String id, Map<String, String> parameter) {

        List<Element> list = sqlXmlMap.get(xmlName);
        for (Element element : list) {
            if (element.attribute("id").getValue().equals(id)) {
                String sql = element.getStringValue();
                sql = sqlHandle(sql, parameter);
                return sql;
            }
        }
        return "";
    }

    // 处理
    private static String sqlHandle(String sql, Map<String, String> parameter){
        sql = sql.replaceAll("\n", "")
                .replaceAll("\r", "");

        while(true){
            int beginIndex = sql.indexOf("[");
            if(beginIndex == -1){
                break;
            }
            int endIndex = sql.indexOf("]") + 1;
            String beginString = sql.substring(beginIndex, endIndex);
            String endString = "";
            if(beginString.contains("#")){
                String currentKey = beginString.substring(beginString.indexOf("{") + 1,beginString.indexOf("}"));
                if(parameter.containsKey(currentKey) && parameter.get(currentKey) != null && parameter.get(currentKey) != ""){
                    if(beginString.contains("%")){
                        endString = beginString.replaceAll("#\\{"+currentKey+"}", parameter.get(currentKey));
                    }else{
                        endString = beginString.replaceAll("#\\{"+currentKey+"}", "'" + parameter.get(currentKey) + "'");
                    }
                    endString = endString.replace("[","").replace("]","");
                    sql = sql.replace(beginString,endString);
                }else{
                    sql = sql.replace(beginString,"");
                }
            }else if(beginString.contains("$")){
                String currentKey = beginString.substring(beginString.indexOf("{") + 1,beginString.indexOf("}"));
                if(beginString.contains("%")){
                    endString = beginString.replaceAll("\\$\\{"+currentKey+"}", parameter.get(currentKey));
                }else{
                    if(parameter.get(currentKey) == null || parameter.get(currentKey) == ""){
                        endString = beginString.replaceAll("\\$\\{"+currentKey+"}", "" + parameter.get(currentKey) + "");
                    }else{
                        endString = beginString.replaceAll("\\$\\{"+currentKey+"}", "'" + parameter.get(currentKey) + "'");
                    }
                }
                endString = endString.replace("[","").replace("]","");
                sql = sql.replace(beginString,endString);
            }
        }
        return sql;
    }


    private static void preventDanger(Map<String, String> parameter){
        String[] keywords = {"master", "truncate", "insert", "delete", "update", "declare", "alert", "drop"};
        for (String key : parameter.keySet()) {
            String value = parameter.get(key);
            for (String keyword : keywords) {
                value = value.replaceAll(keyword,"");
            }
            parameter.put(key,value);
        }
    }

}
