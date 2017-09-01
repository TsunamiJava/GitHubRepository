package test;

import com.dao.factory.DAOFactory;
import com.entity.Users;
import org.junit.Test;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CodingTest on 2017/8/2.
 */
public class testMain {

    @Test
    public void test() throws SQLException {
       // DAOFactory.getIUserDao().SelectPageUser(0,5).forEach(System.out::println);
        System.out.println(DAOFactory.getIUserDao().SelectPageLIKENumbers("t"));
    }

}
