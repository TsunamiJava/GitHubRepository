package com.tsunami.dao.daoImpl;

import com.tsunami.entity.User;
import lee.DBConn.CURDTest.users;
import lee.DBConn.DBConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * Created by CodingTest on 2017/7/29.
 */
public class Test {
    DBConnection dbConnection = new DBConnection();
    //核心类，获取连接池（JdbcUtils.getDataSource()）
    QueryRunner runner = new QueryRunner(dbConnection.getDataSources());

    @org.junit.Test
    public void domeGetCounts() throws SQLException {
//        String message=null;
//        long result =(long)runner.query("select count(*) from users where username='admin'",new ScalarHandler());
//        int num =(int)result;
//        if (num==0){
//            message="不存在该用户";
//            System.out.println(message);
//        }
        users userpassword = runner.query("select password from users where username=?",new BeanHandler<users>(users.class),"Cookietest");
        System.out.println(userpassword.getPassword());

    }
    @org.junit.Test
    public void test() throws SQLException{
        User user=new User("test2","123","dd@qq.com","12345689");
        System.out.println(Register(user));
    }

    public boolean Register(User user) throws SQLException {
        boolean falg=false;
        if (runner.update("insert into users(username,password,email,phone) values(?,?,?,?)",user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone())!=0){
            falg=true;
        }
        return falg;
    }
}
