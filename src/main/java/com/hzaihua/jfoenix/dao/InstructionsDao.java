package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.Instructions;

import java.util.List;

public interface InstructionsDao {
    /**
    * 添加指令列表
    * */
    void insertInstructions(Instructions instructions);

    /**
     * 根据设备类型查询该设备相关指令
     * */
    List queryInstructionsByNoiseCode(String noiseCode);

    /**
     * 删除指令列表
     * */
    void deleteInstruction(String instructFlag);
}
