package com.school.book.util.querySql.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    /**
     * 获取文件名   根据文件的.获取   1.xls,   1,   .,
     *
     * @param fileName 要获取文件名的带格式的文件名
     * @return 文件名
     * 编写时间  2018年6月5日 10:27:31
     * @author Cr
     * @since 1.8
     */
    public static String getFileName(String fileName) {
        return fileName.substring(0, fileName.indexOf("."));
    }

    /**
     * 获取文件名称
     *
     * @date 2019-08-20
     * @author Cr
     */
    public static String getFileName(File file) {
        return getFileName(file.getName());
    }

    /**
     * 根据传来字符串和分割的条件，将字符串分割成集合
     *
     * @param str            需要转换的数字字符串
     * @param splitCondition 分割条件
     * @return list 转换后的集合
     * @author Cr
     * 编写时间 : 2018年10月9日 13:16:07
     */
    public static List<String> stringConvertList(String str, String splitCondition) {
        List<String> list = new ArrayList<>();
        String[] array = str.split(splitCondition);
        for (String s : array) {
            list.add(s);
        }
        return list;
    }

}
