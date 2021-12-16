package db;

import java.sql.*;

public class SQLserverTest{
    public static void main(String [] args)
    {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://localhost:1433;databaseName=魏遇卿pay202180129";
        String userName="sa";
        String userPwd="358614401";
        try
        {
            Class.forName(driverName);
            System.out.println("加载驱动成功！");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        try{
            Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println("连接数据库成功！");
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
    }
}

