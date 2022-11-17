/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.QuanLy;
import Util.DBContext1;
import ViewModels.QuanLyViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class QuanLyReponsitory {
    public void insert(QuanLy q) {
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "INSERT INTO QuanLy" + "(Ma,TenQL,NgaySinh,GioiTinh,DiaChi,Sdt,TrangThai)" + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, q.getMa());
            ps.setString(2, q.getTen());
            ps.setString(3, q.getNgaySinh());
            ps.setInt(4, q.getGioiTinh());
            ps.setString(5, q.getDiaChi());
            ps.setString(6, q.getSdt());
            ps.setInt(7, q.getTrangThai());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void update(QuanLy q, String id) {
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "UPDATE QuanLy SET " + "Ma=?,TenQL=?,NgaySinh=?,GioiTinh=?,DiaChi=?,Sdt=?,TrangThai=? WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, q.getMa());
            ps.setString(2, q.getTen());
            ps.setString(3, q.getNgaySinh());
            ps.setInt(4, q.getGioiTinh());
            ps.setString(5, q.getDiaChi());
            ps.setString(6, q.getSdt());
            ps.setInt(7, q.getTrangThai());
            ps.setString(8, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "DELETE FROM QuanLy WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public ArrayList<QuanLyViewModel> getAll() {
        ArrayList<QuanLyViewModel> listQuanLy = new ArrayList<>();
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "SELECT * FROM QuanLy";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                
                
                listQuanLy.add(new QuanLyViewModel(rs.getString("Id"),rs.getString("Ma"),rs.getString("TenQL"),rs.getString("NgaySinh"),
                rs.getInt("GioiTinh"),rs.getString("DiaChi"),rs.getString("Sdt"),rs.getInt("TrangThai")));
            }
            System.out.println("Select thành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listQuanLy;

    }
}
