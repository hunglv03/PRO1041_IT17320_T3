/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kieu Oanh
 */
public class DBContext3 {
//     private static Connection conn;
//    public static Connection getConnection(){
//        if(DBContext3.conn==null){
//            try {
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                String dbUser="sa",dbPass="zxcvbnm2003",dbUrl="jdbc:sqlserver://localhost:1433"+";databaseName=DBDUAN1_NHOM3";
//                DBContext3.conn=DriverManager.getConnection(dbUrl, dbUser, dbPass);
//                System.out.println("Kết nối thành công");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//        }
//        return conn;
//    }
    
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "zxcvbnm2003";
    private static final String SERVER = "DESKTOP-NUU3QTR\\SQLEXPRESS";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "DBDUAN1_NHOM3";
    private static final boolean USING_SSL = false;
    
    private static String CONNECT_STRING;
        
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(SERVER).append(":").append(PORT).append(";")
                    .append("databaseName=").append(DATABASE_NAME).append(";")
                    .append("user=").append(USERNAME).append(";")
                    .append("password=").append(PASSWORD).append(";")
                    ;
            if (USING_SSL) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
            System.out.println("Connect String có dạng: " + CONNECT_STRING);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(CONNECT_STRING);
    }
    
    public static void main(String[] args) throws Exception {
        Connection conn = getConnection();
        DatabaseMetaData dbmt = conn.getMetaData();
        System.out.println(dbmt.getDriverName());
        System.out.println(dbmt.getDatabaseProductName());
        System.out.println(dbmt.getDatabaseProductVersion());
    }
}

