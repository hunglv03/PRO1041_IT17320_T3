/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ViewModels.ChatLieuViewModel;
import ViewModels.DsSanPhamViewModel;
import ViewModels.MauSacViewModel;
import ViewModels.NhaCungCapVM;
import ViewModels.SizeVM;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DsSanPhamService {
    
    ArrayList<DsSanPhamViewModel> GetAll();
    ArrayList<DsSanPhamViewModel> getAll(String input);
    
    ArrayList<DsSanPhamViewModel> findSanPham(String sanPham);
    
    
    
    ArrayList<DsSanPhamViewModel> GetAllSize(String input);
    ArrayList<DsSanPhamViewModel> GetAllCL(String input);
    ArrayList<DsSanPhamViewModel> GetAllMS(String input);
    ArrayList<DsSanPhamViewModel> GetAllNCC(String input);
    
}
