package lee.DBConn.CURDTest;

import lee.DBConn.DBConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by CodingTest on 2017/7/28.
 */
public class Test {

    DBConnection dbConnection = new DBConnection();
    //核心类，获取连接池（JdbcUtils.getDataSource()）
    QueryRunner runner = new QueryRunner(dbConnection.getDataSources());

    //增加
    @org.junit.Test
    public void demoInsert() throws SQLException{
        //执行sql语句
        runner.update("insert into users(username,password,email,phone) values(?,?,?,?)","admin","987654","admin@qq.com","1478523696");
        System.out.println("添加成功");
    }

    //更新
    @org.junit.Test
    public void demoUpdata() throws SQLException{
        runner.update("update users set email=?,phone=? where id=?","Admin@qq.cn","1234567",2);
        System.out.println("修改成功");
    }

    //查询全部
    @org.junit.Test
    public void demoSelectAll() throws SQLException{
        List<users> allusers = runner.query("select * from users",new BeanListHandler<users>(users.class));
        allusers.forEach(System.out::println);
    }

    //分页查询
    @org.junit.Test
    public void demoSelectPage() throws SQLException{
        List<users> allusers = runner.query("select * from users limit 1,5",new BeanListHandler<users>(users.class));
        allusers.forEach(System.out::println);
    }

    //按id查询
    @org.junit.Test
    public void demoSelectByID() throws SQLException{
        users usersid = runner.query("select * from users where id=?",new BeanHandler<users>(users.class),1);
        System.out.println(usersid);
    }

    //Map查询
    @org.junit.Test
    public void demoSelectMap() throws SQLException{
        Map<String,Object> map = runner.query("select * from users where id =?",new MapHandler(),1);
        System.out.println(map);
    }

    //显示数据的数量
    @org.junit.Test
    public void domeGetCounts() throws SQLException{
        Object object =runner.query("select count(*) from users",new ScalarHandler());
        //System.out.println(object.getClass());
        long numlog= (long) object;
        int num = (int) numlog;
        System.out.println(num);
    }

    //删除
    @org.junit.Test
    public void demoDelete() throws SQLException{
        runner.update("delete from users where id = ?",2);
        System.out.println("删除成功");
    }

    @org.junit.Test
    public void test(){
        List<String> strings= Arrays.asList("好，很好，非常好！",
                "好，很好，非常好!", "好，很好，非常好!","好，很好，非常好！",
                "好，很好，非常好!", "好，很好，非常好!","好，很好，非常好！",
                "好，很好，非常好!", "好，很好，非常好!","好，很好，非常好!",
                "好，很好，非常好!", "好，很好，非常好!","好，很好，非常好！",
                "好，很好，非常好!", "好，很好，非常好!","好，很好，非常好！",
                "好，很好，非常好!", "好，很好，非常好!","好，很好，非常好!",
                "好，很好，非常好！" );

        strings.forEach(System.out::print);
    }


}
