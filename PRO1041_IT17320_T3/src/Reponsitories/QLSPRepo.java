/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import Util.DBContext1;
import ViewModels.QLSPVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class QLSPRepo {

    public ArrayList<QLSPVM> getAll() {
        ArrayList<QLSPVM> listALL = new ArrayList<>();
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "SELECT SanPham.TenSP,MauSac.TenMS,ChatLieu.TenCL,Size.TenSIZE,NhaCungCap.TenNCC,ChiTietSP.SoLuongTon,ChiTietSP.GiaNhap,ChiTietSP.GiaBan FROM ChiTietSP  \n"
                    + "inner join SanPham ON ChiTietSP.IdSP=SanPham.Id\n"
                    + "inner join MauSac ON ChiTietSP.IdMauSac=MauSac.Id\n"
                    + "inner join ChatLieu ON ChiTietSP.IdChatLieu=ChatLieu.Id\n"
                    + "inner join Size ON ChiTietSP.IdSize=Size.Id\n"
                    + "inner join NhaCungCap ON ChiTietSP.IDNhaCungCap=NhaCungCap.Id\n";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listALL.add(new QLSPVM(rs.getString("TenSP"), rs.getString("TenMS"), rs.getString("TenCL"),
                        rs.getString("TenSIZE"), rs.getString("TenNCC"), rs.getInt("SoLuongTon"), rs.getDouble("GiaNhap"), rs.getDouble("GiaBan")));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listALL;

    }

    public void insert(QLSPVM qlsp) {
        try {
            Connection conn = DBContext1.getConnection();
            String sql = "INSERT INTO ChiTietSP " + "inner join SanPham ON ChiTietSP.IdSP=SanPham.Id\n"
                    + "inner join MauSac ON ChiTietSP.IdMauSac=MauSac.Id\n"
                    + "inner join ChatLieu ON ChiTietSP.IdChatLieu=ChatLieu.Id\n"
                    + "inner join Size ON ChiTietSP.IdSize=Size.Id\n"
                    + "inner join NhaCungCap ON ChiTietSP.IDNhaCungCap=NhaCungCap.Id\n" +"(SanPham.TenSP,MauSac.TenMS,ChatLieu.TenCL,Size.TenSIZE,NhaCungCap.TenNCC,ChiTietSP.SoLuongTon,ChiTietSP.GiaNhap,ChiTietSP.GiaBan)" +"VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, qlsp.getTenSP());
            
            
            ps.setString(2, qlsp.getMauSac());
            ps.setString(3, qlsp.getChatlieu());
            ps.setString(4, qlsp.getSize());
            ps.setString(5, qlsp.getNcc());
            ps.setInt(6, qlsp.getSoLuong());
            ps.setDouble(7, qlsp.getGiaNhap());
            ps.setDouble(7, qlsp.getGiaBan());
            ps.execute();
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
