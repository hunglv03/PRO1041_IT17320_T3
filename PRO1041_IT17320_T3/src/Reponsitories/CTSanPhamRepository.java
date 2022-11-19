/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import Util.DBContext11;
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

    final String INSERT_SQL = "INSERT INTO CHITIETSP(IdSP,IdSize,IdMauSac,IdNhaCungCap,IdChatLieu,MoTa,SoLuongTon,GiaNhap,GiaBan) VALUES(?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE CHITIETSP SET IdSP = ?, IdSize = ?, IdMauSac = ?, IdNhaCungCap = ?, IdChatLieu = ? WHERE ID = ?";
    final String DELETE_SQL = "DELETE FROM CHITIETSP WHERE ID = ?";

    public CTSanPhamRepository() {
    }

    public List<CTSanPhamViewModel> GetAll() {
        String SELECT_CHITIETSP = "SELECT * FROM CHITIETSP";
        List<CTSanPhamViewModel> _lstCTSanPham = new ArrayList<>();
        try ( Connection conn = DBContext11.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_CHITIETSP);
            while (rs.next()) {
                _lstCTSanPham.add(new CTSanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai GetAll");
        }
        return _lstCTSanPham;
    }

    //add
    public boolean Add(CTSanPhamViewModel obj) {
        try ( Connection conn = DBContext11.getConnection()) {
            Statement st = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);
            stmt.setString(1, obj.getIdSp());
            stmt.setString(2, obj.getIdSize());
            stmt.setString(3, obj.getIdMauSac());
            stmt.setString(4, obj.getIdNhaCungCap());
            stmt.setString(5, obj.getIdChatLieu());
            stmt.setString(6, obj.getMoTa());
            stmt.setString(7, obj.getSoLuongTon());
            stmt.setString(8, obj.getGiaNhap());
            stmt.setString(9, obj.getGiaBan());
            stmt.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai Add");
            return false;
        }
    }

    //
    public boolean Update(CTSanPhamViewModel obj) {
        try ( Connection conn = DBContext11.getConnection()) {
            Statement st = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL);
            stmt.setString(1, obj.getIdSp());
            stmt.setString(2, obj.getIdSize());
            stmt.setString(3, obj.getIdMauSac());
            stmt.setString(4, obj.getIdNhaCungCap());
            stmt.setString(5, obj.getIdChatLieu());
            stmt.setString(6, obj.getMoTa());
            stmt.setString(7, obj.getSoLuongTon());
            stmt.setString(8, obj.getGiaNhap());
            stmt.setString(9, obj.getGiaBan());
            stmt.setString(10, obj.getId());
            stmt.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi khong the ket noi vao CSDL tai Add");
            return false;
        }
    }

    public boolean Delete(CTSanPhamViewModel obj) {
        try ( Connection conn = DBContext11.getConnection()) {
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

//    public static void main(String[] args) {
//        CTSanPhamRepository ctsp = new CTSanPhamRepository();
//        for (var x : ctsp.GetAll()) {
//            System.out.println(x.toString());
//        }
//    }
}
