package com.muldini.virus.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.muldini.virus.common.ChinaTotal;

public class ChinaTotalDao {
	private Connection connection;

    public ChinaTotalDao(Connection connection) {
        this.connection = connection;
    }

    public int createChinaTotalDao(ChinaTotal chinaTotal) throws SQLException {
        int result = 0;
        String sql = "insert into chinaTotal (confirm , heal ,dead, nowConfirm, suspect, nowSevere, importedCase, noInfect ,showLocalConfirm ,showlocalinfeciton ,localConfirm, noInfectH5 ,localConfirmH5 ,lastupdatetime) values(?, ?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            // 创建statement。
            statement = connection.prepareStatement(sql);
            int i = 0;
            statement.setString(++i, chinaTotal.getConfirm());
            statement.setString(++i, chinaTotal.getHeal());
            statement.setString(++i, chinaTotal.getDead());
            statement.setString(++i, chinaTotal.getNowConfirm());
            statement.setString(++i, chinaTotal.getSuspect());
            statement.setString(++i, chinaTotal.getNowSevere());
            statement.setString(++i, chinaTotal.getImportedCase());
            statement.setString(++i, chinaTotal.getNoInfect());
            statement.setString(++i, chinaTotal.getShowLocalConfirm());
            statement.setString(++i, chinaTotal.getShowlocalinfeciton());
            statement.setString(++i, chinaTotal.getLocalConfirm());
            statement.setString(++i, chinaTotal.getNoInfectH5());
            statement.setString(++i, chinaTotal.getLocalConfirmH5());
            statement.setString(++i, chinaTotal.getLastupdatetime());
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
    
    public ChinaTotal retrieveChina() throws SQLException {

        String sql ="SELECT * FROM chinatotal ORDER BY id DESC LIMIT 1";
        PreparedStatement statement = null;
    	ChinaTotal chinaTotal = null;

        try {
            // 创建statement。
            statement = connection.prepareStatement(sql);
            // 执行statement，并取得结果。
            ResultSet resultSet = statement.executeQuery();
        	chinaTotal = new ChinaTotal();

            // 处理结果。
            while (resultSet.next()) {
                chinaTotal.setId(resultSet.getInt("id"));
                chinaTotal.setConfirm(resultSet.getString("confirm"));
                chinaTotal.setHeal(resultSet.getString("heal"));
                chinaTotal.setDead(resultSet.getString("dead"));
                chinaTotal.setNowConfirm(resultSet.getString("nowConfirm"));
                chinaTotal.setSuspect(resultSet.getString("suspect"));
                chinaTotal.setNowSevere(resultSet.getString("nowSevere"));
                chinaTotal.setImportedCase(resultSet.getString("importedCase"));
                chinaTotal.setNoInfect(resultSet.getString("noInfect"));
                chinaTotal.setShowLocalConfirm(resultSet.getString("showLocalConfirm"));
                chinaTotal.setShowlocalinfeciton(resultSet.getString("showlocalinfeciton"));
                chinaTotal.setLocalConfirm(resultSet.getString("localConfirm"));
                chinaTotal.setNoInfectH5(resultSet.getString("noInfectH5"));
                chinaTotal.setLocalConfirmH5(resultSet.getString("localConfirmH5"));
                chinaTotal.setLastupdatetime(resultSet.getString("lastupdatetime"));
            }
        } finally {
            // 关闭statement，以释放占用的资源。
            if (statement != null) {
                statement.close();
            }
        }
        return chinaTotal;
    }
    
    public boolean retrievechinaByTime(String time) throws SQLException {

        time = "%" + time + "%"; // 支持模糊查询
        String sql = "select * from chinatotal "
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
}
