package util.basis.connect;

import org.junit.Test;

import java.sql.*;

/**
 * Created by CodingTest on 2017/7/31.
 */
public class DBconnection {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/databasestest";
    public static final String USER = "root";
    public static final String PWD = "mysql";
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * 加载驱动
     */
    public DBconnection(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败！！");
            e.printStackTrace();
        }
    }

    /**
     * 返回数据库连接
     * @return
     */
    public Connection getConn(){
        try {
            con = DriverManager.getConnection(URL,USER,PWD);
            System.out.println("连接成功");
        } catch (SQLException e) {
            System.out.println("连接数据库失败！！");
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭数据库资源
     */
    public void closeAll(){
        //按顺序关闭资源
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  Update操作
     * @param sql
     * @param pras
     * @return
     */
    public int update(String sql,Object... pras){
        int res = 0;
        con = getConn();
        try {
            ps=con.prepareStatement(sql);
            if (pras!=null){
                for (int i = 0; i <pras.length ; i++) {
                    ps.setObject(i+1,pras[i]);
                }
            }
            res=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return res;
    }

    /**
     * Query操作
     * @param sql
     * @param pras
     * @return
     */
    public ResultSet query(String sql,Object... pras){
        con=getConn();
        try {
            ps=con.prepareStatement(sql);
            if (pras!=null){
                for (int i = 0; i < pras.length; i++) {
                    ps.setObject(i+1,pras[i]);
                }
            }
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rs;
    }
}
