/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.HoaDon;
import Util.DBContext;
import ViewModels.HoaDonViewModel;
import ViewModels.KhachHangVM;
import ViewModels.NhanVienViewModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kieu Oanh
 */
public class HoaDonRepo {

    final String INSERT_SQL = "INSERT INTO HoaDon(IdKH,IdNV,MaHD,NgayThanhToan,TinhTrang) VALUES(?,?,?,?,?)";
    
    public HoaDonRepo() {
    }
    
    public List<HoaDonViewModel> GetAll() {
        String SELECT_CHITIETSP = "SELECT b.Id as 'IdHD',b.IdKH as 'IdKH', n.TenKH as 'TenKH',b.IdNV as 'IdNV', m.TenNV as 'TenNV',MaHD,NgayThanhToan,TinhTrang FROM HoaDon b\n"
                + "left join KhachHang n on n.Id = b.IdKH\n"
                + "	join NhanVien m on m.Id = b.IdNV";
        List<HoaDonViewModel> _lstCTSanPham = new ArrayList<>();
        try (Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_CHITIETSP);
            while (rs.next()) {
                String id = rs.getString("IdHD");
                String maHD = rs.getString("MaHD");
                String ntt = rs.getString("NgayThanhToan");
                int tt = rs.getInt("TinhTrang");
                
                String idKH = rs.getString("IdKH");
                String tenKH = rs.getString("TenKH");
                
                String idNV = rs.getString("IdNV");
                String tenNV = rs.getString("TenNV");
                
                KhachHangVM khv = new KhachHangVM();
                khv.setId(idKH);
                khv.setTenKH(tenKH);
                
                NhanVienViewModel nvv = new NhanVienViewModel();
                nvv.setId(idNV);
                nvv.setTennv(tenNV);
//                KhachHangVM khv = new KhachHangVM();
//                khv.setId(id);
//                khv.setTenKH(tenKH);
//                NhanVienViewModel nvv = new NhanVienViewModel();
//                nvv.setId(id);
//                nvv.setTennv(tenNV);
                ///
                HoaDonViewModel hdvv = new HoaDonViewModel();
                hdvv.setId(id);
                hdvv.setIdKH(khv);
                hdvv.setIdNV(nvv);
                hdvv.setMa(maHD);
                hdvv.setNgayThanhToan(ntt);
                hdvv.setTinhTrang(tt);
                
                _lstCTSanPham.add(hdvv);
            }
            return _lstCTSanPham;
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai GetAll");
            return null;
        }
    }

    //add
    public boolean Add(HoaDon obj) {
        try (Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);
            String idKH = null;
            if (obj.getIdKH() != null) {
                idKH = obj.getIdKH();
            }
            
            String idNV = null;
            if (obj.getIdNV() != null) {
                idNV = obj.getIdNV();
            }
            
            stmt.setString(1, idKH);
            stmt.setString(2, idNV);
            stmt.setString(3, obj.getMa());
            stmt.setString(4, obj.getNgayThanhToan());
            stmt.setInt(5, obj.getTinhTrang());
            
            stmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi khong the ket noi vao CSDL tai Add");
            return false;
        }
    }
    
    public static void main(String[] args) {
        HoaDonRepo hd = new HoaDonRepo();
        for (HoaDonViewModel x : hd.GetAll()) {
            x.toString();
        }
    }
}
