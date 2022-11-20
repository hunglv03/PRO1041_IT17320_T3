/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModel.NhaCungCap;
import Util.DBContext11;
import ViewModels.NhaCungCapVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Kieu Oanh
 */
public class NhaCungCapRepo {
        public void insert(NhaCungCap ncc) {
        try {
            Connection conn = DBContext11.getConnection();
            String sql = "INSERT INTO NhaCungCap" + "(Ma,Ten)" + "VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ncc.getMa());
            ps.setString(2, ncc.getTen());
            ps.execute();
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void update(NhaCungCap ncc, String id) {
        try {
            Connection conn = DBContext11.getConnection();
            String sql = "UPDATE NhaCungCap SET " + "Ma=?,Ten=? WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ncc.getMa());
            ps.setString(2, ncc.getTen());
            ps.setString(3, id);
            ps.execute();
            System.out.println("Sửa thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = DBContext11.getConnection();
            String sql = "DELETE FROM NhaCungCap WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Xóa thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public ArrayList<NhaCungCapVM> getAll(){
        ArrayList<NhaCungCapVM> listNCC=new ArrayList<>();
        try {
            Connection conn=DBContext11.getConnection();
            String sql="SELECT * FROM NhaCungCap";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {                
                listNCC.add(new NhaCungCapVM(rs.getString("Id"),rs.getString("Ma"),rs.getString("Ten")));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listNCC;
        
    }
}
