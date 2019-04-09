package com.hzaihua.jfoenix.util;

import java.util.Calendar;
import java.util.Date;

public class TableNameUtil {
    /**
     * 该方法可以通过时间以及表名前缀获取该时间对应的数据表名，格式为prefix_201903
     * @param prefix 表名的前缀
     * @param date 表名所对应的时间
     * @return 当前时间的表名
     */
    public static String getTableName(String prefix,Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        StringBuffer tableName = new StringBuffer(prefix);
        tableName.append("_").append(year);
        if (month<10){
            tableName.append(0).append(month);
        }else {
            tableName.append(month);
        }
        System.out.println(tableName);
        return tableName.toString();
    }
}
