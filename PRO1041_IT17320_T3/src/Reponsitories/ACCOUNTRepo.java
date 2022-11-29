/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.ACCOUNT;
import Util.DBContext;
import ViewModels.ACCOUNTVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ACCOUNTRepo {

    

    
    
    public ACCOUNT login(String userName, String pass){
        String sql="SELECT * FROM Account WHERE Username=? AND Passwords=?";
        
        try {
            Connection conn=DBContext.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, pass);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            if(rs.next()==false){
                return null;
            }
            String role=rs.getString("VaiTro");
            ACCOUNT a=new ACCOUNT(userName, pass, pass);
            return a;
            
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
