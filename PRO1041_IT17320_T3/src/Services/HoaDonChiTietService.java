/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModel.HoaDonChiTiet;
import ViewModels.HoaDonChiTietViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface HoaDonChiTietService {
    ArrayList<HoaDonChiTietViewModel> getall();
    public String add(HoaDonChiTiet hdct);
}
