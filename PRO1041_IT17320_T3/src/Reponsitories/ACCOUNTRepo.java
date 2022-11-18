/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.ACCOUNT;
import ViewModels.ACCOUNTVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ACCOUNTRepo {
            
    public void insert(ACCOUNT a) {
        try {
            Connection conn = Util.DBContext.getConnection();
            String sql = "INSERT INTO ACCOUNT" + "(TenChucVu,MatKhau)" + "VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getTenCV());
            ps.setString(2, a.getMk());
            ps.execute();
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void update(ACCOUNT a, String id) {
        try {
            Connection conn = Util.DBContext.getConnection();
            String sql = "UPDATE ACCOUNT SET " + "TenChucVu=?,MatKhau=? WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getTenCV());
            ps.setString(2, a.getMk());
            ps.setString(3, id);
            ps.executeUpdate();
            System.out.println("Sửa thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = Util.DBContext.getConnection();
            String sql = "DELETE FROM ACCOUNT WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Xóa thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public ArrayList<ACCOUNTVM> all() {
        ArrayList<ACCOUNTVM> listACC = new ArrayList<>();
        try {
            Connection conn = Util.DBContext.getConnection();
            String sql = "SELECT * FROM ACCOUNT";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ten = rs.getString("TenChucVu");
                String mk = rs.getString("mk");
                ACCOUNT a = new ACCOUNT(id, mk, ten);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listACC;
    }
}
