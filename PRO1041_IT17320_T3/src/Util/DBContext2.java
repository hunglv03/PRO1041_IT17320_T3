/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Utilities;

/**
 *
 * @author NamNguyenTien
 */
public class DBContext2 {
//    private static final String USERNAME = "NAMNTPH25455";
//    private static final String PASSWORD = "555999";
//    private static final String SERVER = "NAMNGUYENTIEN\\SQLEXPRESS";
//    private static final String PORT = "1433";
//    private static final String DATABASE_NAME = "DBDUAN1_NHOM3";
//    private static final boolean USING_SSL = false;

    private static Connection conn;
    public static Connection getConnection(){
        if(Util.DBContext2.conn == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser="NAMNTPH25455",dbPass="555999",dbUrl="jdbc:sqlserver://localhost:1433"+";databaseName=DBDUAN1_NHOM3";
                Util.DBContext2.conn=DriverManager.getConnection(dbUrl, dbUser, dbPass);
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
