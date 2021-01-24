package com.muldini.virus.biz.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muldini.virus.access.AccessHelper;
import com.muldini.virus.access.AreaTreeDao;
import com.muldini.virus.common.AreaTree;

public class AreaTreeService {
	    public static final AreaTreeService INSTANCE = new AreaTreeService();

	    private AccessHelper accessHelper = AccessHelper.INSTANCE; // 资源访问助手
	    public AreaTreeService() {
		}
	    
	    public void createAreaTree(AreaTree areaTree) {

	        // 创建数据库连接，并关闭自动提交（autoCommit）。
	        Connection connection = accessHelper.createConnection(false);

	        // 创建DAO对象。
	        AreaTreeDao areaTreeDao = new AreaTreeDao(connection);
	        
	        try {
	            // 判断是否有同名的image，若有则返回false。
	        	areaTreeDao.createAreaTreeDao(areaTree);

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
	    
	    public boolean retrieveareaTreeByTime(String time) {
	        Connection connection = accessHelper.createConnection();

	     // 创建DAO对象。
	        AreaTreeDao areaTreeDao = new AreaTreeDao(connection);
	        boolean t = false;
	        try {
	            t = areaTreeDao.retrieveareaByTime(time);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return t;
	    }
	    
	    public AreaTree retrieveArea() {
	        Connection connection = accessHelper.createConnection();
	     // 创建DAO对象。
	        AreaTreeDao areaTreeDao = new AreaTreeDao(connection);
	        AreaTree areaTree = null;
	        try {
	        	areaTree = areaTreeDao.retrieveArea();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return areaTree;
	    }
	    
	    public List retrieveListareaByTime(String time) {
	    	Connection connection = accessHelper.createConnection();
		     // 创建DAO对象。
		        AreaTreeDao areaTreeDao = new AreaTreeDao(connection);
	        List result = new ArrayList();
	        try {
	            result = areaTreeDao.retrieveListareaByTime(time);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return result;
	    }
	    
	    public List retrieveTop5ListareaByTime(String time) {
	    	Connection connection = accessHelper.createConnection();
		     // 创建DAO对象。
		        AreaTreeDao areaTreeDao = new AreaTreeDao(connection);
	        List result = new ArrayList();
	        try {
	            result = areaTreeDao.retrieveListareaByTime(time);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return result;
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
