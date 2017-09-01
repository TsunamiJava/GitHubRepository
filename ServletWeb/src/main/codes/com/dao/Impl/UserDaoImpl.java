package com.dao.Impl;

import com.dao.IUserDao;
import com.entity.Users;
import com.utils.DBConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import javax.swing.plaf.ListUI;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by CodingTest on 2017/8/2.
 */
public class UserDaoImpl implements IUserDao {
    private DBConnection dbConnection =new DBConnection();
    //核心类，获取连接池（JdbcUtils.getDataSource()）
    private QueryRunner runner = new QueryRunner(dbConnection.getDataSources());
    private boolean flag = false;

    @Override
    public boolean Login(Users users) throws SQLException {
        Users user=runner.query("select password from users where username=?",new BeanHandler<Users>(Users.class),users.getUsername());
        if (users.getPassword().equals(user.getPassword())) flag = true;
        return flag;
    }

    @Override
    public boolean UserIsNew(Users users) throws SQLException {
        long result =(long)runner.query("select count(*) from users where username='"+users.getUsername()+"'",new ScalarHandler());
        if ((int)result!=0) flag=true;
        return flag;
    }

    @Override
    public boolean Register(Users users) throws SQLException {
        if(runner.update("insert into users(username,password,email,phone) values(?,?,?,?)",users.getUsername(),users.getPassword(),users.getEmail(),users.getPhone())!=0) flag=true;
        return flag;
    }

    @Override
    public boolean DeteleById(int id) throws SQLException {
        if (runner.update("delete from users where id = ?",id)!=0) flag=true;
        return flag;
    }

    @Override
    public boolean UpdataById(Users users) throws SQLException {
        if (runner.update("update users set username=?,password=?,email=?,phone=? where id=?",users.getUsername(),users.getPassword(),users.getEmail(),users.getPhone(),users.getId())!=0) flag=true;
        return flag;
    }

    @Override
    public Users SelectById(int id) throws SQLException {
        Users users=runner.query("select * from users where id=?",new BeanHandler<Users>(Users.class),id);
        return users;
    }

    @Override
    public List<Users> SelectAllUser() throws SQLException {
        List<Users> allusers = runner.query("select * from users",new BeanListHandler<Users>(Users.class));
        return allusers;
    }

    @Override
    public List<Users> SelectLIKEUser(String string) throws SQLException {
        List<Users> likeusers = runner.query("select * from users where username like '%"+string+"%'",new BeanListHandler<Users>(Users.class));
        return likeusers;
    }

    @Override
    public int SelectPageNumbers() throws SQLException {
        long result =(long)runner.query("select count(*) from users",new ScalarHandler());
        return (int)result;
    }

    @Override
    public int SelectPageLIKENumbers(String string) throws SQLException {
        long result =(long)runner.query("select count(*) from users where username like '%"+string+"%'",new ScalarHandler());
        return (int)result;
    }

    @Override
    public List<Users> SelectPageUser(int start, int rows) throws SQLException {
        List<Users> pageUsers=runner.query("select * from users limit "+start+","+rows,new BeanListHandler<Users>(Users.class));
        return pageUsers;
    }

    @Override
    public List<Users> SelectLIKEPageUser(String string, int start, int rows) throws SQLException {
        List<Users> pageUsers=runner.query("select * from users where username like  '%"+string+"%' limit "+start+","+rows,new BeanListHandler<Users>(Users.class));
        return pageUsers;
    }
}
