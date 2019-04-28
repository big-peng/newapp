package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.UserToMeasure;

public interface UserToMeasureDao {
    void insert(UserToMeasure userToMeasure);
    void deleteByUserName(String userName);
}
