package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.InstructionsDao;
import com.hzaihua.jfoenix.entity.Instructions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InstructionsService {

    @Resource
    private InstructionsDao instructionsDao;

    /**
     * 添加指令接口
     * */
    public void saveInstructions(Instructions instructions){
        instructionsDao.insertInstructions(instructions);
    }

    public ObservableList<Instructions> queryInstructByNoiseCode(String noiseCode){
        ObservableList<Instructions> result = FXCollections.observableArrayList();
        result.setAll(instructionsDao.queryInstructionsByNoiseCode(noiseCode));
        return result;
    }

    /**
     * 删除指令接口
     * */
    public void deleteInstructions(String instructFlag){
        instructionsDao.deleteInstruction(instructFlag);
    }
}
