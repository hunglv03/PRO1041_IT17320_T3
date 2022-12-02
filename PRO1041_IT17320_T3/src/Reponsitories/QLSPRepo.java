/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.CTSanPham;
import Util.DBContext;
import Util.DBContext1;
import ViewModels.CTSanPhamViewModel;
import ViewModels.ChatLieuViewModel;
import ViewModels.MauSacViewModel;
import ViewModels.NhaCungCapVM;
import ViewModels.QLSPVM;
import ViewModels.SanPhamViewmodel;
import ViewModels.SizeVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QLSPRepo {

    final String INSERT_SQL = "INSERT INTO CHITIETSP(IdSP,IdSize,IdMauSac,IDNhaCungCap,IdChatLieu,MoTa,SoLuongTon,GiaBan,GiaNhap) VALUES(?,?,?,?,?,?,?,?,?)";

    final String DELETE_SQL = "DELETE FROM CHITIETSP WHERE ID = ?";// câu này nó cần mỗi cái id để xóa 

    public QLSPRepo() {
    }

    public List<QLSPVM> GetAll() {
        String SELECT_CHITIETSP = "select b.Id as 'IdCTSP',b.IdSP as 'idSP',m.TenSP as 'tenSP',\n"
                + "		b.IdSize as 'idSize',n.TenSIZE as 'tenSize',\n"
                + "		b.IdMauSac as 'idMS',v.TenMS as 'tenMS',\n"
                + "		b.IdChatLieu as 'idCL',c.TenCL as 'tenCL',\n"
                + "		b.IDNhaCungCap as 'idNCC',x.TenNCC as 'tenNCC',\n"
                + "\n"
                + "MoTa, SoLuongTon,GiaBan,GiaNhap  from ChiTietSP b\n"
                + "left join SanPham m on b.IdSP=m.Id\n"
                + "	join Size n on b.IdSize=n.Id\n"
                + "	join MauSac v on b.IdMauSac=v.Id\n"
                + "	join ChatLieu c on b.IdChatLieu = c.Id\n"
                + "	join NhaCungCap x on b.IDNhaCungCap = x.Id";
        List<QLSPVM> _lstCTSanPham = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_CHITIETSP);
            while (rs.next()) {
                String idCTSP = rs.getString("IdCTSP");
                String moTa = rs.getString("MoTa");
                Double soLuong = rs.getDouble("SoLuongTon");
                Double giaBan = rs.getDouble("GiaBan");
                Double giaNhap = rs.getDouble("GiaNhap");

                String idSP = rs.getString("idSP");
                String idSize = rs.getString("idSize");
                String idMauSac = rs.getString("idMS");
                String idChatLieu = rs.getString("idCL");
                String idNcc = rs.getString("idNCC");

                String tenSP = rs.getString("tenSP");
                String tenSize = rs.getString("tenSize");
                String tenMauSac = rs.getString("tenMS");
                String tenChatLieu = rs.getString("tenCL");
                String tenNcc = rs.getString("tenNCC");

                SanPhamViewmodel spv = new SanPhamViewmodel();
                spv.setId(idSP);
                spv.setTen(tenSP);

                SizeVM sv = new SizeVM();
                sv.setId(idSize);
                sv.setTen(tenSize);

                MauSacViewModel msv = new MauSacViewModel();
                msv.setId(idMauSac);
                msv.setTen(tenMauSac);

                ChatLieuViewModel clv = new ChatLieuViewModel();
                clv.setId(idChatLieu);
                clv.setTen(tenChatLieu);

                NhaCungCapVM nccv = new NhaCungCapVM();
                nccv.setId(idNcc);
                nccv.setTenNCC(tenNcc);

                ///
                QLSPVM qlctsp = new QLSPVM();
                qlctsp.setMoTa(moTa);
                qlctsp.setSoLuongTon(soLuong);
                qlctsp.setGiaBan(giaBan);
                qlctsp.setGiaNhap(giaNhap);

                _lstCTSanPham.add(qlctsp);
            }
            return _lstCTSanPham;
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai GetAll");
            return null;
        }
    }

    //add
    public boolean Add(CTSanPham obj) {
        try ( Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);
            String idSP = null;
            if (obj.getIdSp() != null) {
                idSP = obj.getIdSp();
            }
            String idSize = null;
            if (obj.getIdSize() != null) {
                idSize = obj.getIdSize();
            }
            String idMauSac = null;
            if (obj.getIdMauSac() != null) {
                idMauSac = obj.getIdMauSac();
            }
            String idNcc = null;
            if (obj.getIdNhaCungCap() != null) {
                idNcc = obj.getIdNhaCungCap();
            }
            String idCL = null;
            if (obj.getIdChatLieu() != null) {
                idCL = obj.getIdChatLieu();
            }
            stmt.setString(1, idSP);
            stmt.setString(2, idSize);
            stmt.setString(3, idMauSac);
            stmt.setString(4, idNcc);
            stmt.setString(5, idCL);
            stmt.setString(6, obj.getMoTa());
            stmt.setDouble(7, obj.getSoLuongTon());
            stmt.setDouble(8, obj.getGiaBan());
            stmt.setDouble(9, obj.getGiaNhap());
            stmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi khong the ket noi vao CSDL tai Add");
            return false;
        }
    }

    final String UPDATE_SQL = "UPDATE CHITIETSP SET IdSP = ?, IdSize = ?, IdMauSac = ?, IDNhaCungCap = ?, IdChatLieu = ?, MoTa = ?, SoLuongTon = ?, GiaBan = ?, GiaNhap = ? WHERE ID = ?";

    public boolean Update(CTSanPham obj) { //để là model
        try ( Connection conn = DBContext.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL);
            stmt.setString(1, obj.getIdSp());
            stmt.setString(2, obj.getIdSize());
            stmt.setString(3, obj.getIdMauSac());
            stmt.setString(4, obj.getIdNhaCungCap());
            stmt.setString(5, obj.getIdChatLieu());
            stmt.setString(6, obj.getMoTa());
            stmt.setDouble(7, obj.getSoLuongTon());
            stmt.setDouble(8, obj.getGiaBan());
            stmt.setDouble(9, obj.getGiaNhap());
            stmt.setString(10, obj.getId());
            stmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi không thể kết nối tại Update");
            return false;
        }
    }

    public boolean Delete(CTSanPhamViewModel obj) { //xóa theo id hoặc mã cho dễ . mà cái này cuxgn k care lắm
        try ( Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement(DELETE_SQL);
            stmt.setString(1, obj.getId());
            stmt.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai Delete");
            return false;
        }
    }

    public static void main(String[] args) {
        CTSanPhamRepository ctsp = new CTSanPhamRepository();
        for (CTSanPhamViewModel x : ctsp.GetAll()) {
            System.out.println(x.toString());
        }
    }

    public boolean Add(QLSPVM ql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean Update(QLSPVM ql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean Delete(QLSPVM ql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
