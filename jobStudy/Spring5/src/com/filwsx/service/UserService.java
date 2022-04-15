package com.filwsx.service;

import com.filwsx.dao.UserDao;
import com.filwsx.dao.UserDaoImpl;

/**
 * @author filwsx
 * @create 2022-04-01 18:04
 */
public class UserService {

    private UserDao userDao;

    //2. xml外部bean
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add start...");
        // 1.传统方法
        // UserDao userDao = new UserDaoImpl();

        userDao.update();
        System.out.println("service add close...");
    }

}
