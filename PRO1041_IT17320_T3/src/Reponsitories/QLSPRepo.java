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
            String sql = "SELECT SanPham.MaSP,SanPham.TenSP,ChiTietSP.GiaBan,ChiTietSP.SoLuongTon,ChatLieu.TenCL,Size.TenSIZE,MauSac.TenMS FROM ChiTietSP  \n"
                    + "                     inner join SanPham ON ChiTietSP.IdSP=SanPham.Id\n"
                    + "                     inner join MauSac ON ChiTietSP.IdMauSac=MauSac.Id\n"
                    + "                    inner join ChatLieu ON ChiTietSP.IdChatLieu=ChatLieu.Id\n"
                    + "                     inner join Size ON ChiTietSP.IdSize=Size.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listALL.add(new QLSPVM(rs.getString("MaSP"), rs.getString("TenSP"), rs.getInt("GiaBan"), rs.getDouble("SoLuongTon"), rs.getString("TenCL"), rs.getString("TenSIZE"), rs.getString("TenMS")));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listALL;

    }
    

}
