package com.tsunami.dao;

import com.tsunami.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by CodingTest on 2017/7/29.
 */
public interface DaoUser {
    public Boolean Login(String name,String password) throws SQLException;

    public Boolean Register(User user) throws SQLException;

    public List<User> FindAllUser() throws SQLException;
}
