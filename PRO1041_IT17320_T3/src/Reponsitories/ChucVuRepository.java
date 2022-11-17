/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.ChucVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.DBContext;
import Util.DBContext2;
import ViewModels.ChucVuViewModel;
import java.util.List;

/**
 *
 * @author MyPC
 */
public class ChucVuRepository {
    public boolean add(ChucVu c){
        try {
            Connection conn = DBContext2.getConnection();
            String sql="INSERT INTO ChucVu"+"(Ma,Ten)"+"VALUES(?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, c.getMa());
            ps.setString(2, c.getTen());
            ps.execute();
            System.out.println("Truy vấn thành công");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(ChucVu c) {
        try {
            Connection conn = DBContext2.getConnection();
            String sql = "UPDATE ChucVu SET " + "Ma = ? ,Ten = ? WHERE ID = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getMa());
            ps.setString(2, c.getTen());
            ps.setString(3, c.getId());
            ps.execute();
            System.out.println("Truy vấn thành công");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            Connection conn = DBContext2.getConnection();
            String sql = "DELETE FROM CHUCVU WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public List<ChucVuViewModel> GetAll(){
        List<ChucVuViewModel> listCV = new ArrayList<>();
        try {
            Connection conn = DBContext2.getConnection();
            String sql = "SELECT * FROM ChucVu";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {                
                String id=rs.getString("Id");
                String ma=rs.getString("Ma");
                String ten=rs.getString("Ten");
                
                ChucVuViewModel cv = new ChucVuViewModel(id, ma, ten);
                listCV.add(cv);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCV;
    }
    
    
}
