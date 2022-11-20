/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.NhanVien;
import Util.DBContext11;
import ViewModels.NhanVienViewModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author NamNguyenTien
 */
public class NhanVienReponsitory {
    public NhanVienReponsitory(){
        
    }
    
    public boolean Add(NhanVien nv){
        try {
            Connection conn = DBContext11.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO NHANVIEN (MA, TEN, EMAIL, NGAYSINH, GIOITINH, SDT, DIACHI, TRANGTHAI) VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getEmail());
            ps.setString(4, nv.getNgaySinh());
            ps.setInt(5, nv.getGioiTinh());
            ps.setString(6, nv.getSdt());
            ps.setString(7, nv.getDiaChi());
            ps.setInt(8, nv.getTrangThai());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi kết nối tại Add()");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean Update(NhanVien nv){
        try {
            Connection conn = DBContext11.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE NHANVIEN SET MA = ?, TEN = ?, EMAIL = ?, NGAYSINH = ?, GIOITINH = ?, SDT = ?, DIACHI = ?, TRANGTHAI = ? WHERE ID = ?");
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getEmail());
            ps.setString(4, nv.getNgaySinh());
            ps.setInt(5, nv.getGioiTinh());
            ps.setString(6, nv.getSdt());
            ps.setString(7, nv.getDiaChi());
            ps.setInt(8, nv.getTrangThai());
            ps.setString(9, nv.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi kết nối tại Update()");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean Delete(NhanVien nv){
        try {
            Connection conn = DBContext11.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM NHANVIEN WHERE ID = ?");        
            ps.setString(1, nv.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi kết nối tại Delete()");
            e.printStackTrace();
            return false;
        }
    }
    
    public List<NhanVienViewModel> GetAll(){
        String SELECT_NHANVIEN = "SELECT * FROM NHANVIEN";
        List<NhanVienViewModel> listnv = new ArrayList<>();
        try ( Connection conn = DBContext11.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_NHANVIEN);
            while (rs.next()) {                
                listnv.add(new NhanVienViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10)));
            }
        } catch (Exception e) {
            System.out.println("Lỗi kết nối tại GetAll()");
            e.printStackTrace();
        }
        return listnv;
    }
    public static void main(String[] args) {
        NhanVienReponsitory nv = new NhanVienReponsitory();
        for (NhanVienViewModel x : nv.GetAll()) {
            x.toString();
        }
    }
}
