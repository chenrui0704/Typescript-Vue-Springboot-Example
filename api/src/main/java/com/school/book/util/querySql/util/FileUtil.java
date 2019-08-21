package com.school.book.util.querySql.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    /**
     * 根据传来的文件夹路径，遍历文件夹下所有文件
     *
     * @param directoryPath 要遍历的路径
     * @return list
     * 编写时间  2018年6月4日 14:24:06
     * @author Cr
     * @since 1.8
     */
    public static List<File> getAllFileByPath(String directoryPath) {
        List<File> list = new ArrayList<>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return list;
        }
        File[] files = baseFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                list.addAll(getAllFileByPath(file.getAbsolutePath()));
            } else {
                list.add(file);
            }
        }
        return list;
    }

}
