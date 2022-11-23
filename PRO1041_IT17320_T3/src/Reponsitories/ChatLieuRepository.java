/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;


import Util.DBContext11;
import ViewModels.ChatLieuViewModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Lvh9x
 */
public class ChatLieuRepository {

    final String INSERT = "INSERT INTO CHATLIEU(MaCL,TenCL) VALUES(?,?)";
    final String UPDATE = "UPDATE CHATLIEU SET MaCL = ?, TenCL = ? WHERE Id = ?";
    final String DELETE = "DELETE FROM CHATLIEU WHERE Id = ?";

    public ChatLieuRepository() {
    }

    public List<ChatLieuViewModel> GetAll() {
        String SELECT_CHATLIEU = "SELECT * FROM CHATLIEU";
        List<ChatLieuViewModel> _lstChatLieu = new ArrayList<>();
        try ( Connection conn = DBContext11.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_CHATLIEU);
            while (rs.next()) {
                _lstChatLieu.add(new ChatLieuViewModel(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println("Không thể kết nối lại GetAll");
        }
        return _lstChatLieu;
    }

    //add
    public boolean Add(ChatLieuViewModel cl) {
        try ( Connection conn = DBContext11.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(INSERT);
            ps.setString(1, cl.getMa());
            ps.setString(2, cl.getTen());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi tại AddRepo");
            return false;
        }
    }

    public boolean Update(ChatLieuViewModel cl) {
        try ( Connection conn = DBContext11.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(UPDATE);
            ps.setString(1, cl.getMa());
            ps.setString(2, cl.getTen());
            ps.setString(3, cl.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi tại UpdateRepo");
            return false;
        }
    }

    public boolean Delete(ChatLieuViewModel cl) {
        try ( Connection conn = DBContext11.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(DELETE);
            ps.setString(1, cl.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi tại DeleteRepo");
            return false;
        }
    }
}
