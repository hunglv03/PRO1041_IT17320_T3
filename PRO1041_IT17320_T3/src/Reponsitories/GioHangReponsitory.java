/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import Util.DBContext1;
import ViewModels.GioHangViewModel;
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
}
