package com.school.book.util.querySql.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class GlobalConfig {

    private static GlobalConfig globalConfig;
    private static Properties querySqlProperties;
    private static Properties serviceProperties;
    private static Logger logger = LoggerFactory.getLogger(GlobalConfig.class);
    private static Map<String,List<Element>> sqlXmlMap = new HashMap<>();
    private static List<File> xmlFile;

    private GlobalConfig(){};

    static{
        globalConfig = new GlobalConfig();
        initializationConfig();
    }

    // 初始化配置
    private static void initializationConfig(){
        initializationQueryXmlFile();
        initializationQuerySqlProperties();
        initializationServiceProperties();
        initializationSqlXmlMap();
    }

    private static void initializationQueryXmlFile(){
        String path = GlobalConfig.class.getResource("/").getPath() + "sqlXml";
        xmlFile = FileUtil.getAllFileByPath(path);
    }

    private static void initializationQuerySqlProperties(){
        querySqlProperties = new Properties();
        try {
            querySqlProperties.load(new InputStreamReader(new ClassPathResource("querySql.properties").getInputStream(), "utf-8"));
        } catch (Exception e) {
            logger.error("全局配置文件异常, e: " + e + "\t e.getMessage(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void initializationServiceProperties(){
        serviceProperties = new Properties();
        try {
            serviceProperties.load(new InputStreamReader(new ClassPathResource("service.properties").getInputStream(), "utf-8"));
        } catch (Exception e) {
            logger.error("初始化配置文件异常, e: " + e + "\t e.getMessage(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void initializationSqlXmlMap(){
        SAXReader reader = new SAXReader();
        xmlFile.forEach(x-> {
            Document document = null;
            try {
                document = reader.read(GlobalConfig.class.getResourceAsStream("/sqlXml/" + x.getName()));
                sqlXmlMap.put(StringUtil.getFileName(x), document.getRootElement().elements());
            } catch (Exception e) {
                logger.error("sqlXml解析失败, e:" + e + "\t e.getMessage(): " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    public static GlobalConfig getGlobalConfig(){ return  globalConfig; }

    public Properties getQuerySqlProperties() { return querySqlProperties; }

    public Properties getServiceProperties() { return serviceProperties; }

    public Map<String,List<Element>> getSqlXmlMap() { return sqlXmlMap; }


}
