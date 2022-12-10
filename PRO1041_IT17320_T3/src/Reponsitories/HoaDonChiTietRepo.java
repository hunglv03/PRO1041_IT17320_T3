/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;
import DomainModel.HoaDonChiTiet;
import Util.DBContext;
import ViewModels.HoaDonChiTietViewModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class HoaDonChiTietRepo {
    public HoaDonChiTietRepo(){
        
    }
    
    public boolean add(HoaDonChiTiet hdct){
        try {
            Connection conn = DBContext.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO HOADONCHITIET(IDHOADON, IDCHITIETSP,SOLUONG, DONGIA) VALUES(?,?,?,?)");
            ps.setString(1, hdct.getIdHoaDon());
            ps.setString(2, hdct.getIdChiTietSP());
            ps.setInt(3, hdct.getSoLuong());
            ps.setDouble(4, hdct.getDonGia());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi tại Add()");
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<HoaDonChiTietViewModel> GetAll(){
        ArrayList<HoaDonChiTietViewModel> list = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM HOADONCHITIET");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(new HoaDonChiTietViewModel(rs.getString(1),rs.getString(2),rs.getInt(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi tại getall()");
        }
        return list;
    }
    
    public static void main(String[] args) {
        HoaDonChiTietRepo h = new HoaDonChiTietRepo();
        for (HoaDonChiTietViewModel x : h.GetAll()) {
            System.out.println(x.toString());
        }
    }
}
