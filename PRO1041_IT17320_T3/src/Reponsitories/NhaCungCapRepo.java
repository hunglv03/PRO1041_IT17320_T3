/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.NhaCungCap;
import Util.DBContext3;
import ViewModels.NhaCungCapViewModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Kieu Oanh
 */
public class NhaCungCapRepo {

    public void insert(NhaCungCap d) throws Exception {
        try {
            Connection conn = DBContext3.getConnection();
            String sql = "INSERT INTO NhaCungCap" + "(Ma,Ten)" + "VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getMa());
            ps.setString(2, d.getTen());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(NhaCungCap d, String id) throws Exception {
        try {
            Connection conn = DBContext3.getConnection();
            String sql = "UPDATE NhaCungCap SET " + "Ma=?,Ten=? WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getMa());
            ps.setString(2, d.getTen());
            ps.setString(3, id);
            ps.execute();
            System.out.println("Truy vấn thành công");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) throws Exception {
        try {
            Connection conn = DBContext3.getConnection();
            String sql = "DELETE FROM NhaCungCap WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<NhaCungCapViewModel> all() throws Exception {
        ArrayList<NhaCungCapViewModel> listncc = new ArrayList<>();
        try {
            Connection conn = DBContext3.getConnection();
            String sql = "SELECT * FROM NhaCungCap";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                listncc.add(new NhaCungCapViewModel(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten")));
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listncc;
    }


}
