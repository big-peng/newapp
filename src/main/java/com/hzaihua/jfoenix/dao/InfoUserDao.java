package com.hzaihua.jfoenix.dao;

import com.hzaihua.jfoenix.entity.InfoUser;

import java.util.List;

public interface InfoUserDao {
    /**
     * 查询全部的用户，该接口只能是最高级管理员的用户才可以调用
     * @return 获取的用户信息使用List进行封装，并通过Response响应到前端进行数据展示
     */
    public List<InfoUser> queryAll();

    /**
     * 根据用户登录名进行查询，主要是在登录的时候调用
     * @param userName 传入用户的登录名
     * @return 返回一个该登录名的用户的InfoUser用户信息类，用来进一步判断密码是否正确，没有该登录名则返回值为null
     */
    public InfoUser queryByUserName(String userName);

    /**
     * 根据父级用户登录名进行查询
     * @param parentUserName 传入的父级用户登录名
     * @return 返回值为以该登录名为父级用户登录名的List集合
     */
    public List<InfoUser> queryByParentUser(String parentUserName);

    /**
     * 根据用户信息中的登录名进行用户信息的修改，理论上来说，主键登录名是没有办法修改的
     * @param user 传入一个包含要修改的登录名的新的用户信息
     * @return 返回是否修改成功
     */
    public boolean updateByUserName(InfoUser user);

    /**
     * 根据用户登录名进行用户的删除，一般情况下是不允许用户删除的，该接口只能最高级管理员进行调用
     * @param userName 传入要删除的用户登录名
     * @return 返回是否删除成功
     */
    public boolean deleteByUserName(String userName);

        /**
         * 插入新用户调用的接口
         * @param user 新的用户信息，需要该对象中的用户登录名为唯一
         * @return 返回是否插入成功
         */
        public boolean insertUser(InfoUser user);
}
