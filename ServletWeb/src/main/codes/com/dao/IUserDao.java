package com.dao;

import com.entity.Users;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by CodingTest on 2017/8/2.
 */
public interface IUserDao {
    public boolean Login(Users users) throws SQLException;
    public boolean UserIsNew(Users users) throws SQLException;
    public boolean Register(Users users) throws SQLException;
    public boolean DeteleById(int id) throws SQLException;
    public boolean UpdataById(Users users) throws SQLException;
    public Users SelectById(int id) throws  SQLException;
    public List<Users> SelectAllUser() throws SQLException;
    public List<Users> SelectLIKEUser(String string) throws SQLException;
    public int SelectPageNumbers() throws SQLException;
    public int SelectPageLIKENumbers(String string) throws SQLException;
    public List<Users> SelectPageUser(int start,int rows) throws SQLException;
    public List<Users> SelectLIKEPageUser(String string,int start,int rows) throws SQLException;

}
