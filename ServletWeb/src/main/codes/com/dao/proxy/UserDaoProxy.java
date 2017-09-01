package com.dao.proxy;

import com.dao.IUserDao;
import com.dao.Impl.UserDaoImpl;
import com.entity.Users;
import com.utils.DBConnection;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by CodingTest on 2017/8/2.
 */
public class UserDaoProxy implements IUserDao {
   // private DBConnection dbConnection =new DBConnection();
    private IUserDao dao=new UserDaoImpl();
    private boolean flag=false;
    @Override
    public boolean Login(Users users) throws SQLException {
        flag=this.dao.Login(users);
        return flag;
    }

    @Override
    public boolean UserIsNew(Users users) throws SQLException {
        flag=this.dao.UserIsNew(users);
        return flag;
    }

    @Override
    public boolean Register(Users users) throws SQLException {
        flag=this.dao.Register(users);
        return flag;
    }

    @Override
    public boolean DeteleById(int id) throws SQLException {
        flag=this.dao.DeteleById(id);
        return flag;
    }

    @Override
    public boolean UpdataById(Users users) throws SQLException {
        flag=this.dao.UpdataById(users);
        return flag;
    }

    @Override
    public Users SelectById(int id) throws SQLException {
        return dao.SelectById(id);
    }

    @Override
    public List<Users> SelectAllUser() throws SQLException {
        return dao.SelectAllUser();
    }

    @Override
    public List<Users> SelectLIKEUser(String string) throws SQLException {
        return dao.SelectLIKEUser(string);
    }

    @Override
    public int SelectPageNumbers() throws SQLException {
        return dao.SelectPageNumbers();
    }

    @Override
    public int SelectPageLIKENumbers(String string) throws SQLException {
        return dao.SelectPageLIKENumbers(string);
    }

    @Override
    public List<Users> SelectPageUser(int start, int rows) throws SQLException {
        return dao.SelectPageUser(start,rows);
    }

    @Override
    public List<Users> SelectLIKEPageUser(String string, int start, int rows) throws SQLException {
        return dao.SelectLIKEPageUser(string,start,rows);
    }
}
