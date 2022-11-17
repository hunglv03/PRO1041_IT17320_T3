/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBContext {
        private static Connection conn;
    public static Connection getConnection(){
        if(DBContext.conn==null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser="sa",dbPass="0123456789",dbUrl="jdbc:sqlserver://localhost:1433"+";databaseName=DBDUAN1__NHOM3";
                DBContext.conn=DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Kết nối thành công");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return conn;
    }
}
