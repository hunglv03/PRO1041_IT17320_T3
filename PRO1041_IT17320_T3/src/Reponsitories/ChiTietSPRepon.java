/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.ChiTietSP;
import Util.DBContext1;
import ViewModels.ChiTietSPViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class ChiTietSPRepon {
    public void insert(ChiTietSP cs) {
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "INSERT INTO ChiTietSP" + "(MoTa,SoLuongTon,GiaNhap,GiaBan)" + "VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cs.getMoTa());
            ps.setInt(2, cs.getSoLuong());
            ps.setDouble(3, cs.getGiaNhap());
            ps.setDouble(4, cs.getGiaBan());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void update(ChiTietSP cs, String id) {
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "UPDATE ChiTietSP SET " + "MoTa=?,SoLuongTon=?,GiaNhap=?,GiaBan=? WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cs.getMoTa());
            ps.setInt(2, cs.getSoLuong());
            ps.setDouble(3, cs.getGiaNhap());
            ps.setDouble(4, cs.getGiaBan());
            ps.setString(5, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "DELETE FROM ChiTietSP WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public ArrayList<ChiTietSPViewModel> getAll(){
        ArrayList<ChiTietSPViewModel> listCS=new ArrayList<>();
        try {
            Connection conn=DBContext1.getConnection();
            String sql="SELECT * FROM ChiTietSP";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {                
                listCS.add(new ChiTietSPViewModel(rs.getString("Id"),rs.getString("MoTa"),rs.getInt("SoLuongTon"),rs.getDouble("GiaNhap"),rs.getDouble("GiaBan")));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listCS;
        
    }
}
