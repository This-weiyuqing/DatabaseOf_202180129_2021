package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlTest {

    public static void main(String[] args) {

        String driverName = "com.mysql.cj.jdbc.Driver";

        String dbURL="jdbc:mysql://localhost:3306/mysql?&useSSL=false&serverTimezone=Asia/Shanghai";  //websql为数据库名

        String userName = "root";

        String userPwd = "358614401";

        try {

            Class.forName(driverName);

            Connection con= DriverManager.getConnection(dbURL, userName, userPwd);

            System.out.println("连接数据库成功");

        }  catch (Exception e) {


            e.printStackTrace();

            System.out.print("连接失败");

        }
    }

}