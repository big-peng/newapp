package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.InfoNoiseManagerDao;
import com.hzaihua.jfoenix.entity.InfoNoiseManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InfoNoiseManagerService {
    @Resource
    private InfoNoiseManagerDao infoNoiseManagerDao;

    /**
     * 添加前端设备设置参数到数据库
     * */
    public void saveInfoNoiseManager(InfoNoiseManager infoNoiseManager){
        infoNoiseManagerDao.insertNoiseManager(infoNoiseManager);
    }

    /**
     * 根据NoiseCode查询出一个NoiseManager对象
     * */
    public void queryByNoiseCode(String noiseCode){
        infoNoiseManagerDao.queryNoiseManagerByNoiseCode(noiseCode);
    }

    /**
     * 修改通过上面方法查出的对象中的某些属性
     * */
    public void updateNoiseManager(InfoNoiseManager infoNoiseManager){
        infoNoiseManagerDao.updateNoiseManager(infoNoiseManager);
    }
}
