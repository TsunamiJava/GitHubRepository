package lee.DBConn;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by CodingTest on 2017/7/28.
 */
public class DBConnection {
    // 定义一个连接池
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /**
     * 从连接池中获取连接
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    /**
     * 获得连接池
     * @return
     */
    public  DataSource getDataSources(){
        return dataSource;
    }
}
