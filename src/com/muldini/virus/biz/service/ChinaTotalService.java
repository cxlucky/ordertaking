package com.muldini.virus.biz.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muldini.virus.access.AccessHelper;
import com.muldini.virus.access.ChinaTotalDao;
import com.muldini.virus.common.ChinaTotal;

public class ChinaTotalService {
	    public static final ChinaTotalService INSTANCE = new ChinaTotalService();

	    private AccessHelper accessHelper = AccessHelper.INSTANCE; // 资源访问助手
	    public ChinaTotalService() {
		}
	    
	    public void createchaintotal(ChinaTotal chinaTotal) {

	        // 创建数据库连接，并关闭自动提交（autoCommit）。
	        Connection connection = accessHelper.createConnection(false);

	        // 创建DAO对象。
	        ChinaTotalDao chinaTotalDao = new ChinaTotalDao(connection);
	        
	        try {
	            // 判断是否有同名的image，若有则返回false。
	        	chinaTotalDao.createChinaTotalDao(chinaTotal);

	            // 提交事务。
	            connection.commit();

	        } catch (SQLException e) {

	            // 若抛出异常，需回滚事务，最好如下显式地回滚。
	            rollback(connection);

	            // 将SQLException转化为RuntimeException，如此，该方法调用者就不需显式地处理该SQLException。
	            throw new RuntimeException(e);

	        } finally {
	            // 关闭连接，以释放占用的资源。
	            close(connection);
	        }
	    }
	    
	    public boolean retrievechinaByTime(String time) {
	        Connection connection = accessHelper.createConnection();

	        // 创建DAO对象。
	        ChinaTotalDao chinaTotalDao = new ChinaTotalDao(connection);
	        
	        boolean t = false;
	        try {
	            t = chinaTotalDao.retrievechinaByTime(time);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return t;
	    }
	    
	    public ChinaTotal retrieveChina() {
	        Connection connection = accessHelper.createConnection();
	     // 创建DAO对象。
	        ChinaTotalDao chinaTotalDao = new ChinaTotalDao(connection);
	        ChinaTotal chinaTotal = null;
	        try {
	        	chinaTotal = chinaTotalDao.retrieveChina();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return chinaTotal;
	    }
	    private void rollback(Connection connection) {
	        try {
	            connection.rollback();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    private void close(Connection connection) {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                throw new RuntimeException(e);
	            }
	        }
	    }

}
