package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.LpppDao;
import com.hzaihua.jfoenix.entity.Lppp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LpppService {
    @Resource
    private LpppDao lpppDao;

    public void savelppp(Lppp lppp){
        lpppDao.insertlppp(lppp);
    }
}
