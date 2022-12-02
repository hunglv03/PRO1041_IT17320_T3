/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import Util.DBContext;
import ViewModels.HoaDonMenuVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonMenuRepo {

    public ArrayList<HoaDonMenuVM> getAll() {
        ArrayList<HoaDonMenuVM> listHDM = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT HoaDon.MaHD,HoaDon.NgayThanhToan,HoaDon.TrangThai,HoaDon.Sdt,NhanVien.TenNV,KhachHang.TenKH FROM HoaDon\n"
                    + "inner join NhanVien ON HoaDon.IdNV=NhanVien.Id\n"
                    + "inner join KhachHang ON HoaDon.IdKH = KhachHang.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listHDM.add(new HoaDonMenuVM(rs.getString("MaHD"),rs.getString("NgayThanhToan"),rs.getInt("TrangThai"),rs.getString("Sdt"),rs.getString("TenNV"),rs.getString("TenKH")));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listHDM;

    }
}
