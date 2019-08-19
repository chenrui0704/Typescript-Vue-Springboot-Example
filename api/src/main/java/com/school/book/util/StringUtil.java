package com.school.book.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringUtil {
    /**
     * 日期转字符   yyyyMMdd
     * @param date
     * @return
     */
    public static String DateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        return formatter.format(date);
    }

    /**
     * 日期转字符   yyyyMMdd
     * @param date
     * @return
     */
    public static String DateToStringNoChar(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(date);
    }

    /**
    * @Description:    获取map中的String值
    * @Author:         lixiang
    * @CreateDate:     2019/5/5 11:37
    * @UpdateUser:
    * @UpdateDate:
    * @UpdateRemark:
    * @Version:        1.0
    */
    public static String getMapStringValue(Map<String, Object> map, String key){
        return map.containsKey(key) ?( map.get(key) == null ? "" : map.get(key).toString()) : "";
    }

    /**
    * @Description:    为空验证
    * @Author:         lixiang
    * @CreateDate:     2019/5/5 10:30
    * @UpdateUser:
    * @UpdateDate:
    * @UpdateRemark:
    * @Version:        1.0
    */
    public static Boolean isEmpty(Object object){
        return object == null || "".equals(object.toString());
    }

    /**
    * @Description:    非空验证
    * @Author:         lixiang
    * @CreateDate:     2019/5/5 10:30
    * @UpdateUser:
    * @UpdateDate:
    * @UpdateRemark:
    * @Version:        1.0
    */
    public static Boolean isNotEmpty(Object object){
        return !isEmpty(object);
    }

    /**
     * 根据传来的数值字符串和分割的字符，将字符串分割成集合
     *
     * @param str            需要转换的数字字符串
     * @param splitCondition 分割条件
     * @return list 转换后的数值集合
     * @author Cr
     * 编写时间 : 2018年10月9日 13:16:07
     */
    public static List<Integer> numberStringConvertnumberList(String str, String splitCondition) {
        List<Integer> list = new ArrayList<>();
        for (String s : str.split(splitCondition)) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }

    /**
     * 根据传来的数值字符串和分割的字符，将字符串分割成集合
     *
     * @param str            需要转换的数字字符串
     * @param splitCondition 分割条件
     * @return list 转换后的数值集合
     * @author Cr
     * 编写时间 : 2018年10月9日 13:16:07
     */
    public static List<String> stringConverList(String str, String splitCondition) {
        List<String> list = new ArrayList<>();
        for (String s : str.split(splitCondition)) {
            list.add(s);
        }
        return list;
    }


    /**
     * 根据传来的字符串，获取索引之后的数字
     *
     * @param str   需要转换的字符串
     * @param index 索引位置
     * @return 转换后的数字
     * @author Cr
     * 编写时间 : 2018年10月9日 13:16:07
     */
    public static Integer StringConvertIntgerByIndex(String str, int index) {
        return str == null ? null : Integer.parseInt(str.substring(index));
    }

    /**
     * @return 获取当前时间的字符串
     * @author Cr
     * 编写时间 : 2018年10月22日 12:59:20
     */
    public static String getCurrentTimeToString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

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
     * 获取文件格式函数    .png  =  png
     *
     * @param fileName 要获取格式的文件名
     * @return 文件格式
     * 编写时间  2018年5月24日 08:48:04
     * @author Cr
     * @since 1.8
     */
    public static String getFileFormat(String fileName) {
        String format = fileName.substring(fileName.lastIndexOf(".") + 1);
        return format;
    }

    /**
     * 获取文件格式函数    .png  =  png
     *
     * @param file 要获取格式的文件
     * @return 文件格式
     * 编写时间  2018年5月24日 08:48:04
     * @author Cr
     * @since 1.8
     */
    public static String getFileFormat(File file) {
        return getFileFormat(file.getName());
    }

    public static String dateToString(Date date, String type) {
        String result = (date.getYear() + 1900) + "-" + ((date.getMonth() + 1) > 12 ? 1 : date.getMonth() + 1) + "-" + date.getDate();
        if (type.equals("time")) {
            result += " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        }
        return result;
    }


    /**
     * 根据字符串内容  和要分割的字符 和 在分割字符前拼接的字符 转换字符串
     *
     * @param content     字符串内容
     * @param split       分割的字符
     * @param beforeSplit 分割字符前拼接的字符
     * @return 转换后的字符串
     * 编写时间 2018年11月12日14:29:11
     * @author Cr
     * @since 1.8
     */
    public static String stringConvertToBeforeSplitStringAndSplitString(String content, String split, String beforeSplit) {
        String str = "";
        String contents[] = content.split(split);
        for (int i = 0; i < contents.length; i++) {
            str += contents[i] + beforeSplit + split;
        }
        return str.substring(0, str.length() - 1);
    }

    public static String stringListConvertToStringByAfterAppendString(List<String> list, String afterApeendString) {
        String str = "";
        for (String s : list) {
            str += s + afterApeendString;
        }
        return str.substring(0, str.length() - 1);
    }

    public static Long stringConvertDataTimeMillis(String data){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = null;
        try {
            d1= formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d1.getTime();
    }


    /**
     * 获取生成的UUID
     *
     * @date 2019-07-10
     * @author Cr
     * @since 1.8
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * 根据长度获取生成的UUID
     *
     * @date 2019-07-10
     * @author Cr
     * @since 1.8
     */
    public static String getUUIDByLength(Integer length){
        return UUID.randomUUID().toString().substring(0,length);
    }



}
