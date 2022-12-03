/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.KhachHang;
import Util.DBContext1;
import ViewModels.KhachHangVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KhachHangRepo {

    public void insert(KhachHang kh) {
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "INSERT INTO KhachHang" + "(MaKH,TenKH,GioiTinh,Sdt,DiaChi,TrangThai)" + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setInt(3, kh.getGioiTinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getDiaChi());
            ps.setInt(6, kh.getTrangThai());
            ps.execute();
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void update(KhachHang kh, String id) {
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "UPDATE KhachHang SET " + "MaKH=?,TenKH=?,GioiTinh=?,Sdt=?,DiaChi=?,TrangThai=? WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setInt(3, kh.getGioiTinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getDiaChi());
            ps.setInt(6, kh.getTrangThai());
            ps.setString(7, id);
            ps.execute();
            System.out.println("Sửa thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "DELETE FROM KhachHang WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public ArrayList<KhachHangVM> getall() {
        ArrayList<KhachHangVM> listKhachHang = new ArrayList<>();
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("MaKH");
                String ten = rs.getString("TenKH");
                int gioitinh = rs.getInt("GioiTinh");
                String sdt = rs.getString("Sdt");
                String diachi = rs.getString("DiaChi");
                int trangthai = rs.getInt("TrangThai");
                KhachHangVM kh = new KhachHangVM(id, ma, ten, gioitinh, sdt, diachi, trangthai);
                listKhachHang.add(kh);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listKhachHang;

    }

    public KhachHang getListSDT(String sdt) {
        KhachHang KH = null;
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "select * from KhachHang where Sdt=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("MaKH");
                String hoTen = rs.getString("TenKH");

                int gioiTinh = rs.getInt("GioiTinh");

                String dc = rs.getString("DiaChi");
                int tt = rs.getInt("TrangThai");
                KH = new KhachHang(id, ma, hoTen, gioiTinh, sdt, dc, tt);

            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return KH;
    }
}
