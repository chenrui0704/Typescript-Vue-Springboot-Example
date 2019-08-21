package com.school.book.util.querySql.util.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultData {

    private static Logger logger = LoggerFactory.getLogger(ResultData.class);


    public static List<Map<String, Object>> getDataByResult(ResultSet resultSet) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            Integer columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                for (Integer i = 0; i < columnCount; i++) {
                    map.put(resultSet.getMetaData().getColumnName(i + 1), resultSet.getObject(i + 1));
                }
                list.add(map);
            }
        } catch (Exception e) {
            logger.error("数据转换异常, e:" + e + "e.getMessage():" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

}
