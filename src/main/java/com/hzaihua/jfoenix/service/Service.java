package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.entity.DustID;
import com.hzaihua.jfoenix.entity.InfoMeasure;
import com.hzaihua.jfoenix.entity.InfoNoiseDevice;
import com.hzaihua.jfoenix.entity.InfoUser;

import java.util.List;

/**
 * 该接口类主要实现的是DustID数据表的查询和插入,其他数据表的接口与该接口基本相同，理论上来说是不需要修改和删除的方法的
 */
public class Service  {
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


/**
 * 该接口在用户管理模块会使用到，其中包括用户密码验证、用户管理测点查询、用户信息修改、用户删除等等方法
 */
class InfoUserService{
    /**
     * 该接口为验证密码是否正确的方法，主要是在用户登录的时候调用的，验证用户输入的密码是否与数据库中该登录名的密码相同
     * @param userName 用户登录的时候输入的用户名
     * @param password 用户登录的时候输入的密码
     * @return 相同返回true，不同返回false
     */
    public boolean pwdIsTrue(String userName,String password){
        return true;
    }

    /**
     * 用户修改信息的方法，其中方法中可以进行一些用户信息的验证，也就是用户输入的信息是否符合格式等其他的要求，当然，验证的功能也可以由页面层直接完成
     * @param infoUser 用户修改之后的信息，其中要保证用户的登录名是不变的，因为我们需要根据用户登录名主键进行修改
     * @return 修改成功则返回字符串修改成功，某一项不符合要求则返回具体哪一项不符合要求
     */
    public String updateInfoUser(InfoUser infoUser){
        return null;
    }

    /**
     * 根据用户名删除用户，在该方法中可能还需要进行管理员权限的验证，因为用户原则上是不能轻易删除的
     * @param userName 要删除的用户名
     * @return 返回是否删除成功
     */
    public boolean deleteByUserName(String userName){
        return false;
    }

    /**
     * 查询全部的用户，该方法一般是在添加测点的时候调用的，因为添加测点需要填写该测点是由哪一个用户来进行管理的，所以需要将所有用户展示出来进行选择
     * @return 返回所有用户的对象集合
     */
    public List<InfoUser> queryAllInfoUser(){
        return null;
    }

    /**
     * 和修改用户信息差不多，方法内部需要进行信息格式的验证，当然也可以在添加用户的页面直接进行验证
     * @param infoUser 新增的用户信息对象
     * @return 新增成功则返回字符串新增成功，某一项不符合要求则返回具体哪一项不符合要求
     */
    public String addInfoUser(InfoUser infoUser){
        return null;
    }

    /**
     * 该方法为根据父级用户来查询该用户的所有下级用户
     * @param parentUserName 要查询的用户名
     * @return 返回该用户的所有下级用户信息集合
     */
    public List<InfoUser> queryByParentUserName(String parentUserName){
        return null;
    }
}


/**
 * 该接口主要用来进行设备的管理，其中包括新增测点、查询所有测点、查询某测点下设备、查询所有设备、删除测点、修改测点参数等方法
 */
class DeviceManageService{
    /**
     * 该方法实现的是测点的新增功能，新增测点的过程中添加测点信息的时候，需要直接添加下级设备(当然，也可以不添加)，下级设备可以直接新增设备，也可以从没有测点归属的设备中添加，当然，这需要由页面的操作逻辑决定
     * 添加测点的逻辑也可以是软件中没有单独的设备添加，也就是设备添加之后就必须要选定测点，那么在该方法中就需要先向数据库中添加设备信息，在将测点信息添加到数据库中
     * @param infoMeasure 新增的测点信息对象
     * @param noiseDevices 新增的测点要添加的设备信息对象集合
     * @return 返回是否添加成功
     */
    public boolean addMeasure(InfoMeasure infoMeasure, List<InfoNoiseDevice> noiseDevices){
        return false;
    }

    /**
     * 查询所有的测点，该方法是软件的主界面会调用的方法
     * @return 返回所有的测点信息集合
     */
    public List<InfoMeasure> queryAllMeasure(){
        return null;
    }

    /**
     * 根据测点的编号来查询该测点下级设备的参数信息，该方法的实现会比较复杂，首先要根据测点编号查询该条测点信息中多个设备的类型ID和设备ID组，之后根据设备类型ID得到该设备需要去哪张表里查，然后再根据设备编号来查询得出该设备的详细信息
     * @param measureCode 要查询的测点编号
     * @return 返回该测点下的设备的信息对象集合，计划是将所有的设备信息字段都集中到同一个实体类中，根据类中的设备类型来决定显示哪些字段，这样会比较容易实现该方法；或者是通过switch来判断查询哪一个设备数据表
     */
    public List<InfoNoiseDevice> queryDeviceByMeasureCode(String measureCode){
        return null;
    }

    /**
     * 编辑测点调用的方法，该方法实现的逻辑和新增测点类似，主要就是把新增换成了修改，以及设备可能会新增、修改以及删除，要注意的是测点中的设备编号不可以修改
     * @param infoMeasure 修改之后的测点信息
     * @param noiseDevices 修改之后测点下级的设备的信息，该删除的删除，该修改的修改，该新增的新增
     * @return 返回是否修改成功
     */
    public boolean updateMeasure(InfoMeasure infoMeasure, List<InfoNoiseDevice> noiseDevices){
        return false;
    }

    /**
     * 删除测点时调用的方法，但是原则上测点时不轻易删除的，所以方法中可能需要进行管理员或者其他权限的验证，首先要将该测点下的设备删除，完成之后在进行该测点的删除
     * @param measureCode 要删除的测点编号
     * @return 返回是否删除成功
     */
    public boolean deleteMeasure(String measureCode){
        return false;
    }
}

