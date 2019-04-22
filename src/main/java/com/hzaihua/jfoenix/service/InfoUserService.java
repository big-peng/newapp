package com.hzaihua.jfoenix.service;

import com.hzaihua.jfoenix.dao.InfoUserDao;
import com.hzaihua.jfoenix.entity.InfoUser;
import com.hzaihua.jfoenix.util.PswMD5;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 该接口在用户管理模块会使用到，其中包括用户密码验证、用户管理测点查询、用户信息修改、用户删除等等方法
 */

@Service
public class InfoUserService{
    @Resource
    private InfoUserDao infoUserDao;
    /**
     * 该接口为验证密码是否正确的方法，主要是在用户登录的时候调用的，验证用户输入的密码是否与数据库中该登录名的密码相同
     * @param userName 用户登录的时候输入的用户名
     * @param password 用户登录的时候输入的密码
     * @return 相同返回true，不同返回false
     */
    public String pwdIsTrue(String userName,String password){
        InfoUser infoUser = infoUserDao.queryByUserName(userName);
        System.out.println(infoUser);
        if (infoUser!=null){
            String truePwd = infoUser.getPassword();
            String pwdMD5 = PswMD5.EncoderByMD5(password);
            if(truePwd.equals(pwdMD5)){
                return "登录成功";
            }else{
                return "登录失败，密码错误";
            }
        }else{
            return "登录失败，用户名不存在";
        }
    }

    /**
     * 用户修改信息的方法，其中方法中可以进行一些用户信息的验证，也就是用户输入的信息是否符合格式等其他的要求，当然，验证的功能也可以由页面层直接完成
     * @param infoUser 用户修改之后的信息，其中要保证用户的登录名是不变的，因为我们需要根据用户登录名主键进行修改
     * @return 修改成功则返回字符串修改成功，某一项不符合要求则返回具体哪一项不符合要求
     */
    public void updateInfoUser(InfoUser infoUser){
        infoUserDao.updateByUserName(infoUser);
    }

    /**
     * 根据用户名删除用户，在该方法中可能还需要进行管理员权限的验证，因为用户原则上是不能轻易删除的
     * @param userName 要删除的用户名
     * @return 返回是否删除成功
     */
    public boolean deleteByUserName(String userName){
        if(infoUserDao.deleteByUserName(userName)){
            return true;
        }
        return false;
    }

    /**
     * 查询全部的用户，该方法一般是在添加测点的时候调用的，因为添加测点需要填写该测点是由哪一个用户来进行管理的，所以需要将所有用户展示出来进行选择
     * @return 返回所有用户的对象集合
     */
    public ObservableList<InfoUser> queryAllInfoUser(){
        ObservableList<InfoUser> result = FXCollections.observableArrayList();
        result.setAll(infoUserDao.queryAll());
        return result;
    }

    /**
     * 该方法为软件用户管理模块中，某一个用户通过多个条件来查询下级用户时调用的模糊查询的方法
     * @param infoUser 模糊查询时需要的对象，该对象中没有值的属性表示不根据该条件查询
     * @return 返回模糊查询得到的结果
     */
    public List<InfoUser> queryLike(InfoUser infoUser){
        return null;
    }

    /**
     * 和修改用户信息差不多，方法内部需要进行信息格式的验证，当然也可以在添加用户的页面直接进行验证
     * @param infoUser 新增的用户信息对象
     * @return 新增成功则返回字符串新增成功，某一项不符合要求则返回具体哪一项不符合要求
     */
    public void addInfoUser(InfoUser infoUser){
        infoUserDao.insertUser(infoUser);
    }

    /**
     * 该方法为根据父级用户来查询该用户的所有下级用户
     * @param parentUserName 要查询的用户名
     * @return 返回该用户的所有下级用户信息集合
     */
    public List<InfoUser> queryByParentUserName(String parentUserName){
        return null;
    }

    /**
     * 根据用户名查询当前登录的用户信息
     * */
    public InfoUser queryByUserName(String userName){
        return infoUserDao.queryByUserName(userName);
    }

    /**
     * 模糊查询，根据用户名称或者姓名或者电话号码查询用户
     * */
    public InfoUser queryUserByNameOrPhone(String userName,String nickName,String phone){
        InfoUser infoUser = infoUserDao.queryUserByNameOrPhone(userName,nickName,phone);
        return infoUser;
    }

    /**
     * 修改密码
     * */
    public void updatePassword(String userType,String password){
        infoUserDao.updatePassword(userType,password);
    }
}
