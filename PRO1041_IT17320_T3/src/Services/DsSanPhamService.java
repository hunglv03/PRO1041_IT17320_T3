/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ViewModels.DsSanPhamViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface DsSanPhamService {
    ArrayList<DsSanPhamViewModel> getAll();
    
    ArrayList<DsSanPhamViewModel> findSanPham(String sanPham);
    
    ArrayList<DsSanPhamViewModel> findMauSac(String mauSac);
    
    ArrayList<DsSanPhamViewModel> findSize(String size);
    ArrayList<DsSanPhamViewModel> findNCC(String ncc);
    ArrayList<DsSanPhamViewModel> findChatLieu(String chatLieu);
    
}
