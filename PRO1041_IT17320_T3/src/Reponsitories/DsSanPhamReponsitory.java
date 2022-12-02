/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import Util.DBContext;
import ViewModels.DsSanPhamViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DsSanPhamReponsitory {

    public ArrayList<DsSanPhamViewModel> getAll() {
        ArrayList<DsSanPhamViewModel> listS = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.TenSP,Size.TenSIZE,MauSac.TenMS,NhaCungCap.TenNCC,ChatLieu.TenCL,ChiTietSP.SoLuongTon,ChiTietSP.GiaBan FROM ChiTietSP\n"
                    + "                     inner join SanPham ON ChiTietSP.IdSP=SanPham.Id\n"
                    + "                     inner join Size ON ChiTietSP.IdSize=Size.Id\n"
                    + "                     inner join MauSac ON ChiTietSP.IdMauSac=MauSac.Id\n"
                    + "                     inner join NhaCungCap ON ChiTietSP.IDNhaCungCap=NhaCungCap.Id\n"
                    + "                     inner join ChatLieu ON ChiTietSP.IdChatLieu=ChatLieu.Id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listS.add(new DsSanPhamViewModel(rs.getString("TenSP"), rs.getString("TenSIZE"), rs.getString("TenMS"), rs.getString("TenNCC"), rs.getString("TenCL"),
                        rs.getInt("SoLuongTon"), rs.getDouble("GiaBan")));
            }
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listS;

    }

    public ArrayList<DsSanPhamViewModel> findSanPham(String sanPham) {
        ArrayList<DsSanPhamViewModel> listFind = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.TenSP,Size.TenSIZE,MauSac.TenMS,NhaCungCap.TenNCC,ChatLieu.TenCL,ChiTietSP.SoLuongTon,ChiTietSP.GiaBan FROM ChiTietSP\n"
                    + "                     inner join SanPham ON ChiTietSP.IdSP=SanPham.Id\n"
                    + "                     inner join Size ON ChiTietSP.IdSize=Size.Id\n"
                    + "                     inner join MauSac ON ChiTietSP.IdMauSac=MauSac.Id\n"
                    + "                     inner join NhaCungCap ON ChiTietSP.IDNhaCungCap=NhaCungCap.Id\n"
                    + "                     inner join ChatLieu ON ChiTietSP.IdChatLieu=ChatLieu.Id WHERE SanPham.TenSP LIKE '%" + sanPham + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listFind.add(new DsSanPhamViewModel(rs.getString("TenSP"), rs.getString("TenSIZE"), rs.getString("TenMS"), rs.getString("TenNCC"), rs.getString("TenCL"),
                        rs.getInt("SoLuongTon"), rs.getDouble("GiaBan")));
            }
            System.out.println("Tìmthành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listFind;

    }
    
    public ArrayList<DsSanPhamViewModel> findMauSac(String mauSac) {
        ArrayList<DsSanPhamViewModel> listFind = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.TenSP,Size.TenSIZE,MauSac.TenMS,NhaCungCap.TenNCC,ChatLieu.TenCL,ChiTietSP.SoLuongTon,ChiTietSP.GiaBan FROM ChiTietSP\n"
                    + "                     inner join SanPham ON ChiTietSP.IdSP=SanPham.Id\n"
                    + "                     inner join Size ON ChiTietSP.IdSize=Size.Id\n"
                    + "                     inner join MauSac ON ChiTietSP.IdMauSac=MauSac.Id\n"
                    + "                     inner join NhaCungCap ON ChiTietSP.IDNhaCungCap=NhaCungCap.Id\n"
                    + "                     inner join ChatLieu ON ChiTietSP.IdChatLieu=ChatLieu.Id WHERE SanPham.TenSP LIKE '%" + mauSac + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listFind.add(new DsSanPhamViewModel(rs.getString("TenSP"), rs.getString("TenSIZE"), rs.getString("TenMS"), rs.getString("TenNCC"), rs.getString("TenCL"),
                        rs.getInt("SoLuongTon"), rs.getDouble("GiaBan")));
            }
            System.out.println("Tìmthành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listFind; 
    }
    
    public ArrayList<DsSanPhamViewModel> findChatLieu(String chatLieu) {
        ArrayList<DsSanPhamViewModel> listFind = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.TenSP,Size.TenSIZE,MauSac.TenMS,NhaCungCap.TenNCC,ChatLieu.TenCL,ChiTietSP.SoLuongTon,ChiTietSP.GiaBan FROM ChiTietSP\n"
                    + "                     inner join SanPham ON ChiTietSP.IdSP=SanPham.Id\n"
                    + "                     inner join Size ON ChiTietSP.IdSize=Size.Id\n"
                    + "                     inner join MauSac ON ChiTietSP.IdMauSac=MauSac.Id\n"
                    + "                     inner join NhaCungCap ON ChiTietSP.IDNhaCungCap=NhaCungCap.Id\n"
                    + "                     inner join ChatLieu ON ChiTietSP.IdChatLieu=ChatLieu.Id WHERE SanPham.TenSP LIKE '%" + chatLieu + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listFind.add(new DsSanPhamViewModel(rs.getString("TenSP"), rs.getString("TenSIZE"), rs.getString("TenMS"), rs.getString("TenNCC"), rs.getString("TenCL"),
                        rs.getInt("SoLuongTon"), rs.getDouble("GiaBan")));
            }
            System.out.println("Tìmthành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listFind; 
    }
    
    public ArrayList<DsSanPhamViewModel> findSize(String size) {
        ArrayList<DsSanPhamViewModel> listFind = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.TenSP,Size.TenSIZE,MauSac.TenMS,NhaCungCap.TenNCC,ChatLieu.TenCL,ChiTietSP.SoLuongTon,ChiTietSP.GiaBan FROM ChiTietSP\n"
                    + "                     inner join SanPham ON ChiTietSP.IdSP=SanPham.Id\n"
                    + "                     inner join Size ON ChiTietSP.IdSize=Size.Id\n"
                    + "                     inner join MauSac ON ChiTietSP.IdMauSac=MauSac.Id\n"
                    + "                     inner join NhaCungCap ON ChiTietSP.IDNhaCungCap=NhaCungCap.Id\n"
                    + "                     inner join ChatLieu ON ChiTietSP.IdChatLieu=ChatLieu.Id WHERE SanPham.TenSP LIKE '%" + size + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listFind.add(new DsSanPhamViewModel(rs.getString("TenSP"), rs.getString("TenSIZE"), rs.getString("TenMS"), rs.getString("TenNCC"), rs.getString("TenCL"),
                        rs.getInt("SoLuongTon"), rs.getDouble("GiaBan")));
            }
            System.out.println("Tìmthành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listFind; 
    }
    
    public ArrayList<DsSanPhamViewModel> findNCC(String ncc) {
        ArrayList<DsSanPhamViewModel> listFind = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT SanPham.TenSP,Size.TenSIZE,MauSac.TenMS,NhaCungCap.TenNCC,ChatLieu.TenCL,ChiTietSP.SoLuongTon,ChiTietSP.GiaBan FROM ChiTietSP\n"
                    + "                     inner join SanPham ON ChiTietSP.IdSP=SanPham.Id\n"
                    + "                     inner join Size ON ChiTietSP.IdSize=Size.Id\n"
                    + "                     inner join MauSac ON ChiTietSP.IdMauSac=MauSac.Id\n"
                    + "                     inner join NhaCungCap ON ChiTietSP.IDNhaCungCap=NhaCungCap.Id\n"
                    + "                     inner join ChatLieu ON ChiTietSP.IdChatLieu=ChatLieu.Id WHERE SanPham.TenSP LIKE '%" + ncc + "%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listFind.add(new DsSanPhamViewModel(rs.getString("TenSP"), rs.getString("TenSIZE"), rs.getString("TenMS"), rs.getString("TenNCC"), rs.getString("TenCL"),
                        rs.getInt("SoLuongTon"), rs.getDouble("GiaBan")));
            }
            System.out.println("Tìmthành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listFind; 
    }
    
    
    
}
