/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModel.HoaDon;
import ViewModels.GioHangViewModel;
import ViewModels.HoaDonViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface GioHangService {
    ArrayList<GioHangViewModel> getAll();
    
    ArrayList<HoaDon> getListHoaDon();
    void insertHDR(HoaDonViewModel hd);
}
