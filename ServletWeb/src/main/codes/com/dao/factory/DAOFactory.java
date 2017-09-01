package com.dao.factory;

import com.dao.IUserDao;
import com.dao.Impl.UserDaoImpl;
import com.dao.proxy.UserDaoProxy;

/**
 * Created by CodingTest on 2017/8/2.
 */
public class DAOFactory {
    public static IUserDao getIUserDao(){
        return new UserDaoProxy();
    }
}
