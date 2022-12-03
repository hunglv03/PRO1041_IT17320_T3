/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import Util.DBContext1;
import ViewModels.HoaDonViewModel;
import ViewModels.QLHoaDonViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class QLHoaDonReponsitory {
    public ArrayList<QLHoaDonViewModel> getListQLHoaDon() {
        ArrayList<QLHoaDonViewModel> listQLHD = new ArrayList<>();
        try {

            Connection conn = DBContext1.getConnection();
            String sql = "SELECT HoaDon.MaHD,HoaDon.NgayThanhToan,HoaDon.TinhTrang,NhanVien.TenNV,KhachHang.TenKH FROM HoaDon JOIN NhanVien ON HoaDon.IdNV=NhanVien.Id"
                    + "inner JOIN KhachHang ON HoaDon.IdKH=KhachHang.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listQLHD.add(new QLHoaDonViewModel(rs.getString("MaHD"),rs.getString("NgayThanhToan"),rs.getInt("TinhTrang"),
                rs.getString("TenNV"),rs.getString("TenKH")));
            }
            System.out.println("HoaDon Thanh Cong");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return listQLHD;
    }
}
