/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModel.HoaDonChiTiet;
import Reponsitories.HoaDonChiTietRepo;
import Services.HoaDonChiTietService;
import ViewModels.HoaDonChiTietViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    HoaDonChiTietRepo hoaDonChiTietRepo = new HoaDonChiTietRepo();

    @Override
    public ArrayList<HoaDonChiTietViewModel> getall() {
        return hoaDonChiTietRepo.GetAll();
    }

    @Override
    public String add(HoaDonChiTiet hdct) {
        if (hoaDonChiTietRepo.add(hdct)) {
            return "Them thanh cong";
        }
        return "Them that bai";
    }

}
