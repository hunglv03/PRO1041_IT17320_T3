/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import Util.DBContext;
import Util.DBContext1;
import ViewModels.HoaDonChoViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonChoRepo {
    public HoaDonChoRepo(){
        
    }
    
    public ArrayList<HoaDonChoViewModel> GetAll(){
        ArrayList<HoaDonChoViewModel> list = new ArrayList<>();
        String sql = "select MaHD, TenNV, TenKH, HoaDon.TinhTrang, HoaDon.NgayThanhToan from HoaDon join NhanVien on HoaDon.IdNV = NhanVien.Id\n" +
"							 join KhachHang on HoaDon.IdKH = KhachHang.Id";
        try {
            Connection conn = DBContext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(new HoaDonChoViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println("Loi ket noi tai GetAll()");
        }
        return list;
    }
}
