package util.basis.CURD;

import entity.User;
import util.basis.connect.DBconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodingTest on 2017/7/31.
 */
public class Test {
    DBconnection dbc=new DBconnection();

    /**
     * 添加数据
     * @param user
     * @return
     */
    public boolean demoAdd(User user){
        return dbc.update("insert into users(username,password,email,phone) values(?,?,?,?)",
                user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone())>0;
    }

    /**
     * 修改数据
     * @param user
     * @return
     */
    public boolean demoUpdate(User user){
        return dbc.update("update users set username=?,password=?,email=?,phone=? where id=?",
                user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),user.getId())>0;
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    public boolean demoDelete(int id){
        return dbc.update("delete from user where id=?",id)>0;
    }

    /**
     * 查询全部数量
     * @return
     */
    public int demoCountAll(){
        return _Count( dbc.query("select count(*) from users"));
    }

    private int _Count(ResultSet rs){
        int count=0;
        try {
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbc.closeAll();
        }
        return count;
    }
    /**
     * 按id查询
     * @param id
     * @return
     */
    public User demoQueryById(int id){
        return _user(dbc.query("select * from users where id=?",id));
    }

    private User _user(ResultSet rs){
        User user=null;
        try {
            if (rs.next()){
                user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbc.closeAll();
        }
        return user;
    }

    /**
     * 查询全部
     * @return
     */
    public List<User> demoqueryAll(){
        return _userList(dbc.query("select * from users"));
    }

    private List<User> _userList(ResultSet rs){
        List<User> _list = new ArrayList<User>();
        try {
            while (rs.next()){
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                _list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbc.closeAll();
        }
        return _list;
    }

    @org.junit.Test
    public void test(){
        demoqueryAll().forEach(System.out::println);
    }
}
