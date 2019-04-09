package com.hzaihua.newapp.dao;

import com.hzaihua.newapp.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectAll();
}
