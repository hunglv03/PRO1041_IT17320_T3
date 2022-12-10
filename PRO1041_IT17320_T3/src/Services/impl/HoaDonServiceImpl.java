/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModel.HoaDon;
import Reponsitories.HoaDonRepo;
import Services.HoaDonService;
import ViewModels.HoaDonViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kieu Oanh
 */
public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepo hdRepo;

    public HoaDonServiceImpl() {
        this.hdRepo = new HoaDonRepo();
    }

     public String them(HoaDon hd) {// đổi tất cả thêm sang kiểu ctsp
        if (hdRepo.Add(hd)) {
            return "Thêm thành công ";
        }
        return "Thêm không thành công ";
    }
    public List<HoaDonViewModel> GetAll() {
        return this.hdRepo.GetAll();
    }

    public static void main(String[] args) {
        HoaDonServiceImpl hd = new HoaDonServiceImpl();
        for (HoaDonViewModel x : hd.GetAll()) {
            x.toString();
        }
    }

//    @Override
//    public String add(HoaDon hd) {
//        if (hdRepo.add(hd)) {
//            return "Them thanh cong";
//        }
//        return "Them that bai";
//    }
//
//    @Override
//    public String update(String MaHD) {
//        if (hdRepo.update(MaHD)) {
//            return "Update thanh cong";
//        }
//        return "Update that bai";
//    }

}
