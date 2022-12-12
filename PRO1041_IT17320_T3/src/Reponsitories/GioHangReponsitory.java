/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.HoaDon;
import Util.DBContext1;
import ViewModels.GioHangViewModel;
import ViewModels.HoaDonViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class GioHangReponsitory {
    public GioHangReponsitory(){
    
    }
    
    public ArrayList<GioHangViewModel> GetAll(){
        ArrayList<GioHangViewModel> list = new ArrayList<>();
        String sql = "select MaSP, TenSP, SoLuong, DonGia\n" +
"from HoaDonChiTiet join ChiTietSP on HoaDonChiTiet.IdChiTietSP = ChiTietSP.Id\n" +
"				   join SanPham on SanPham.Id = ChiTietSP.IdSP";
        try {
            Connection conn = DBContext1.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(new GioHangViewModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            System.out.println("Loi khong ket noi tai GetAll()");
        }
        return list;
    }
    
    public static void main(String[] args) {
        GioHangReponsitory g = new GioHangReponsitory();
        for (GioHangViewModel x : g.GetAll()) {
            System.out.println(x.toString());
        }
    }
    
        public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> listHD = new ArrayList<>();
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "Select Id,Ma,NgayThanhToan,TinhTrang From HoaDon where TinhTrang = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Chờ thanh toán");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                
                String id = rs.getString("Id");
                String mahd = rs.getString("MaHD");
                String ngaytao = rs.getString("NgayThanhToan");
                String tt = rs.getString("TinhTrang");
                HoaDon hd = new HoaDon(id, id, id, tt, ngaytao, 0);
                listHD.add(hd);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return listHD;
    }
        
        
    public void insertHDR(HoaDonViewModel hd) {

        try {
            Connection conn = DBContext1.getConnection();
            String sql = "Insert into HoaDon " + "(Ma,NgayThanhToan,TinhTrang)" + " Values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMa());
            ps.setString(2,  hd.getNgayThanhToan());
            ps.setInt(3, hd.getTinhTrang());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }
    
    
}
