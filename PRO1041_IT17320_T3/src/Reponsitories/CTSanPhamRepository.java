/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import Util.DBContex2;
import ViewModels.CTSanPhamViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Lvh9x
 */
public class CTSanPhamRepository {

    final String INSERT_SQL = "INSERT INTO CHITIETSP(IdSP,IdSize,IdMauSac,IdNhaCungCap,IdChatLieu,MoTa,SoLuongTon,GiaBan,GiaNhap) VALUES(?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE CHITIETSP SET IdSP = ?, IdSize = ?, IdMauSac = ?, IdNhaCungCap = ?, IdChatLieu = ? WHERE ID = ?";
    final String DELETE_SQL = "DELETE FROM CHITIETSP WHERE ID = ?";// câu này nó cần mỗi cái id để xóa 

    public CTSanPhamRepository() {
    }

    public List<CTSanPhamViewModel> GetAll() {
        String SELECT_CHITIETSP = "SELECT * FROM CHITIETSP";
        List<CTSanPhamViewModel> _lstCTSanPham = new ArrayList<>();
        try ( Connection conn = DBContex2.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_CHITIETSP);
            while (rs.next()) {
                _lstCTSanPham.add(new CTSanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10)));
            }
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai GetAll");
        }
        return _lstCTSanPham;
    }

    //add
    public boolean Add(CTSanPhamViewModel obj) {
        try ( Connection conn = DBContex2.getConnection()) {
            Statement st = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);
            stmt.setString(1, obj.getIdSp());
            stmt.setString(2, obj.getIdSize());
            stmt.setString(3, obj.getIdMauSac());
            stmt.setString(4, obj.getIdNhaCungCap());
            stmt.setString(5, obj.getIdChatLieu());
            stmt.setString(6, obj.getMoTa());
            stmt.setDouble(7, obj.getSoLuongTon());
            stmt.setDouble(8, obj.getGiaBan());
            stmt.setDouble(9, obj.getGiaNhap());
            stmt.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai Add");
            return false;
        }
    }

    //
    public boolean Update(CTSanPhamViewModel obj) { //để là model
        try ( Connection conn = DBContex2.getConnection()) {
            Statement st = conn.createStatement();
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
            stmt.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai Add");
            return false;
        }
    }

    public boolean Delete(CTSanPhamViewModel obj) { //xóa theo id hoặc mã cho dễ . mà cái này cuxgn k care lắm
        try ( Connection conn = DBContex2.getConnection()) {
            Statement st = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement(DELETE_SQL);
            stmt.setString(1, obj.getId());
            stmt.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai Add");
            return false;
        }
    }

    public static void main(String[] args) {
        CTSanPhamRepository ctsp = new CTSanPhamRepository();
        for (CTSanPhamViewModel x : ctsp.GetAll()) {
            System.out.println(x.toString());
        }
    }
}
