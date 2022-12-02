/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.HoaDon;
import Util.DBContext;
import ViewModels.HoaDonViewModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Kieu Oanh
 */
public class HoaDonRepo {
    public boolean add(HoaDon hd) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO HOADON(MaHD,NgayThanhToan,TinhTrang) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMa());
            ps.setString(2, hd.getNgayThanhToan());
            ps.setInt(3, hd.getTinhTrang());
            ps.execute();
            System.out.println("Truy vấn thành công");
            return true;
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Lỗi kết nối tại Add");
            return false;
        }
    }
    
    public boolean update(HoaDon hd, String id){
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE HoaDon SET MaHD=?,NgayThanhToan=?,TinhTrang=? WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMa());
            ps.setString(2, hd.getNgayThanhToan());
            ps.setInt(3, hd.getTinhTrang());

            ps.setString(7, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
            return false;
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Lỗi không thể kết nối tại Update");
            return false;
        }
    }
    
    public boolean delete( String id) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "DELETE FROM HoaDon WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
            return true;
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Lỗi không thể kết nối tại Delete");
            return false;
        }
    }
    
    public ArrayList<HoaDonViewModel> GetAll(){
        ArrayList<HoaDonViewModel> lstHoaDon = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM HoaDon";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                lstHoaDon.add(new HoaDonViewModel(rs.getString("Id"), rs.getString("MaHD"), rs.getString("NgayThanhToan"),
                        rs.getInt("TinhTrang")));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Lỗi không thể kết nối tại GetAll");
        }
        return lstHoaDon;
    }
    
    public static void main(String[] args) {
        HoaDonRepo hd = new HoaDonRepo();
        for (HoaDonViewModel x : hd.GetAll()) {
            x.toString();
        }
    }
}
