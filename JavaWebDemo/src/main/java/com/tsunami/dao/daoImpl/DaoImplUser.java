package com.tsunami.dao.daoImpl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tsunami.dao.DaoUser;
import com.tsunami.entity.User;
import lee.DBConn.DBConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodingTest on 2017/7/29.
 */
public class DaoImplUser implements DaoUser {
    DBConnection dbConnection = new DBConnection();
    //核心类，获取连接池（JdbcUtils.getDataSource()）
    QueryRunner runner = new QueryRunner(dbConnection.getDataSources());

    //登录
    @Override
    public Boolean Login(String name, String password) throws SQLException {
        //String message=null;
        boolean flag =false;
        long result =(long)runner.query("select count(*) from users where username='"+name+"'",new ScalarHandler());
        int num =(int)result;
        if(num==0){
            //message="The Username is not here,please sinup or input again 测试";
            return flag;
        }else{
            User user=runner.query("select password from users where username=?",new BeanHandler<User>(User.class),name);
            if (!password.equals(user.getPassword())){
               // message="The password error! Fail to login";
                return flag;
            }else {
                flag =true;
            }
        }
        return flag;
    }

    //注册
    @Override
    public Boolean Register(User user) throws SQLException {
        boolean falg=false;
        if (runner.update("insert into users(username,password,email,phone) values(?,?,?,?)",user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone())!=0){
            falg=true;
        }
        return falg;
    }

    //查找所有的数据
    @Override
    public List<User> FindAllUser() throws SQLException {
        return runner.query("select * from users",new BeanListHandler<User>(User.class));
    }

    @Test
    public void test() throws SQLException{
        FindAllUser().forEach(System.out::println);
    }
}
