package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.entity.DustID;

import java.util.List;

/**
 * 该接口类主要实现的是DustID数据表的查询和插入,其他数据表的接口与该接口基本相同，理论上来说是不需要修改和删除的方法的
 */
//@Service
public class DataService {
    /**
     * 该接口为数据插入的统一接口，接口中要实现的为自动进行分表并将数据插入到对应的表中，而调用该接口的只需要将数据传入该接口方法即可，内部会调用数据库的所有表查询、表名获取、根据表名插入数据等等接口方法
     * @param dustID
     * @return 返回数据是否插入成功
     */
    public boolean addDustID(DustID dustID){
        return false;
    }

    /**
     * 该方法为数据的查询方法，主要根据时间的范围进行查询，该方法内部会根据时间的范围来确定要查询的表，从而将数据整合为一个数据对象的集合，调用该方法的只需要将要查询的时间范围传入该方法即可
     * @param startTime 查询的数据开始时间
     * @param endTime 查询的数据结束时间
     * @return 返回查询结果的对象集合
     */
    public List<DustID> queryByDate(String startTime, String endTime){
        return null;
    }
}







