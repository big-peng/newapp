package com.hzaihua.jfoenix.dao;

import entity.AwaNoiseInstruct;
import java.util.List;

public interface AwaNoiseInstructMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AWA_noise_instruct
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String noiseinstructid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AWA_noise_instruct
     *
     * @mbg.generated
     */
    int insert(AwaNoiseInstruct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AWA_noise_instruct
     *
     * @mbg.generated
     */
    AwaNoiseInstruct selectByPrimaryKey(String noiseinstructid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AWA_noise_instruct
     *
     * @mbg.generated
     */
    List<AwaNoiseInstruct> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AWA_noise_instruct
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AwaNoiseInstruct record);
}