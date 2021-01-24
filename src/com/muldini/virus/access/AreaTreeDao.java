package com.muldini.virus.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muldini.virus.common.AreaTree;

public class AreaTreeDao {
	private Connection connection;

    public AreaTreeDao(Connection connection) {
        this.connection = connection;
    }

    public int createAreaTreeDao(AreaTree areaTree) throws SQLException {
        int result = 0;
        String sql = "insert into areatree (name,count_confirm,count_confirmcuts,count_wzz_add,confirm,dead,heal,wzz,suspect,nowconfirm,showheal,showrate,lastupdatetime ) values(?, ?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            // 创建statement。
            statement = connection.prepareStatement(sql);
            int i = 0;
            statement.setString(++i, areaTree.getName());
            statement.setString(++i, areaTree.getCount_confirm());
            statement.setString(++i, areaTree.getCount_confirmcuts());
            statement.setString(++i, areaTree.getCount_wzz_add());
            statement.setString(++i, areaTree.getConfirm());
            statement.setString(++i, areaTree.getDead());
            statement.setString(++i, areaTree.getHeal());
            statement.setString(++i, areaTree.getWzz());
            statement.setString(++i, areaTree.getSuspect());
            statement.setString(++i, areaTree.getNowconfirm());
            statement.setString(++i,areaTree.getShowheal());
            statement.setString(++i, areaTree.getShowrate());
            statement.setString(++i,areaTree.getLastupdatetime() );
            // 执行statement，并取得结果。
            result = statement.executeUpdate();

        } finally {
            // 关闭statement，以释放占用的资源。
            if (statement != null) {
                statement.close();
            }
        }
        return result;
    }
    
    public AreaTree retrieveArea() throws SQLException {

        String sql ="SELECT * FROM areatree ORDER BY id DESC LIMIT 1";
        PreparedStatement statement = null;
    	AreaTree areaTree = null;

        try {
            // 创建statement。
            statement = connection.prepareStatement(sql);
            // 执行statement，并取得结果。
            ResultSet resultSet = statement.executeQuery();
            areaTree = new AreaTree();

            // 处理结果。
            while (resultSet.next()) {
            	areaTree.setId(resultSet.getInt("id"));
            	areaTree.setName(resultSet.getString("name"));
            	areaTree.setCount_confirm(resultSet.getString("count_confirm"));
            	areaTree.setCount_confirmcuts(resultSet.getString("count_confirmcuts"));
            	areaTree.setCount_wzz_add(resultSet.getString("count_wzz_add"));
            	areaTree.setConfirm(resultSet.getString("confirm"));
            	areaTree.setDead(resultSet.getString("dead"));
            	areaTree.setHeal(resultSet.getString("heal"));
            	areaTree.setWzz(resultSet.getString("wzz"));
            	areaTree.setSuspect(resultSet.getString("suspect"));
            	areaTree.setNowconfirm(resultSet.getString("nowconfirm"));
            	areaTree.setShowheal(resultSet.getString("showheal"));
            	areaTree.setShowrate(resultSet.getString("showrate"));
            	areaTree.setLastupdatetime(resultSet.getString("lastupdatetime"));
            }
        } finally {
            // 关闭statement，以释放占用的资源。
            if (statement != null) {
                statement.close();
            }
        }
        return areaTree;
    }
    
    public boolean retrieveareaByTime(String time) throws SQLException {

        time = "%" + time + "%"; // 支持模糊查询
        String sql = "select * from areatree "
                + "where lastupdatetime like ?";
        PreparedStatement statement = null;
        boolean t = false;
        try {
            // 创建statement。
            statement = connection.prepareStatement(sql);
            statement.setString(1, time);

            // 执行statement，并取得结果。
            ResultSet resultSet = statement.executeQuery();
            
            // 处理结果。
            while (resultSet.next()) {
                t = true;
            }
        } finally {
            // 关闭statement，以释放占用的资源。
            if (statement != null) {
                statement.close();
            }
        }
        return t;
    }
    
    public List retrieveListareaByTime(String time) throws SQLException {
        List result = new ArrayList();        
        
        time = "%" + time + "%"; // 支持模糊查询
        String sql = "select * from areatree "
                + "where lastupdatetime like ?";
        PreparedStatement statement = null;
        try {
            // 创建statement。
            statement = connection.prepareStatement(sql);
            statement.setString(1, time);

            // 执行statement，并取得结果。
            ResultSet resultSet = statement.executeQuery();

            // 处理结果。
            while (resultSet.next()) {
                AreaTree areaTree = new AreaTree();         
                areaTree.setName(resultSet.getString("name"));
            	areaTree.setCount_confirm(resultSet.getString("count_confirm"));
            	areaTree.setCount_confirmcuts(resultSet.getString("count_confirmcuts"));
            	areaTree.setCount_wzz_add(resultSet.getString("count_wzz_add"));
            	areaTree.setConfirm(resultSet.getString("confirm"));
            	areaTree.setDead(resultSet.getString("dead"));
            	areaTree.setHeal(resultSet.getString("heal"));
            	areaTree.setWzz(resultSet.getString("wzz"));
            	areaTree.setSuspect(resultSet.getString("suspect"));
            	areaTree.setNowconfirm(resultSet.getString("nowconfirm"));
            	areaTree.setShowheal(resultSet.getString("showheal"));
            	areaTree.setShowrate(resultSet.getString("showrate"));
            	areaTree.setLastupdatetime(resultSet.getString("lastupdatetime"));
                result.add(areaTree);
            }
        } finally {
            // 关闭statement，以释放占用的资源。
            if (statement != null) {
                statement.close();
            }
        }
        return result;
    }
    
    public List retrieveTop5ListareaByTime(String time) throws SQLException {
        List result = new ArrayList();        
        time = "%" + time + "%"; // 支持模糊查询
        String sql = "select top 5 * from areatree ORDER BY confirm DESC"
                + "where lastupdatetime like ? ";
        PreparedStatement statement = null;
        try {
            // 创建statement。
            statement = connection.prepareStatement(sql);
            statement.setString(1, time);

            // 执行statement，并取得结果。
            ResultSet resultSet = statement.executeQuery();

            // 处理结果。
            while (resultSet.next()) {
                AreaTree areaTree = new AreaTree();         
                areaTree.setName(resultSet.getString("name"));
            	areaTree.setCount_confirm(resultSet.getString("count_confirm"));
            	areaTree.setCount_confirmcuts(resultSet.getString("count_confirmcuts"));
            	areaTree.setCount_wzz_add(resultSet.getString("count_wzz_add"));
            	areaTree.setConfirm(resultSet.getString("confirm"));
            	areaTree.setDead(resultSet.getString("dead"));
            	areaTree.setHeal(resultSet.getString("heal"));
            	areaTree.setWzz(resultSet.getString("wzz"));
            	areaTree.setSuspect(resultSet.getString("suspect"));
            	areaTree.setNowconfirm(resultSet.getString("nowconfirm"));
            	areaTree.setShowheal(resultSet.getString("showheal"));
            	areaTree.setShowrate(resultSet.getString("showrate"));
            	areaTree.setLastupdatetime(resultSet.getString("lastupdatetime"));
                result.add(areaTree);
            }
        } finally {
            // 关闭statement，以释放占用的资源。
            if (statement != null) {
                statement.close();
            }
        }
        return result;
    }
}
