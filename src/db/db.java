package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {
    private Connection dbConn;
    private Statement stateMent;

    public db() {
        // SQL Server 2005（及以上） JDBC驱动
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        // SQL Server 2005（及以上） URL
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=魏遇卿pay202180129";
        String userName = "sa";// 默认用户名
        String userPwd = "358614401";// 密码

        try {
            Class.forName(driverName);
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("Connection Successful!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int executeUpdate(String sql) throws SQLException {
        stateMent = dbConn.createStatement();
        return stateMent.executeUpdate(sql);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        stateMent = dbConn.createStatement();
        return stateMent.executeQuery(sql);
    }

    public void closeConn() throws SQLException {
        stateMent.close();
        dbConn.close();
    }
}
