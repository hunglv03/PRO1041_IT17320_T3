/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import Reponsitories.ChatLieuRepository;
import Reponsitories.DsSanPhamReponsitory;
import Services.DsSanPhamService;
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
public class DsSanPhamServiceImpl implements DsSanPhamService {

    private DsSanPhamReponsitory dsRepo;
    private ChatLieuRepository clRepo;

    private SizeServiceImpl Sizeservice = new SizeServiceImpl();
    private MauSacServiceImpl SizeserviceMS = new MauSacServiceImpl();
        private ChatLieuServiceImpl SizeserviceCL = new ChatLieuServiceImpl();


    public DsSanPhamServiceImpl() {
        this.dsRepo = new DsSanPhamReponsitory();
        this.clRepo = new ChatLieuRepository();
    }

    public ArrayList<DsSanPhamViewModel> getAll(String input) {
        if (input == null) {
            return dsRepo.getAll();
        }
        ArrayList<DsSanPhamViewModel> tempDSSP = new ArrayList<>();
        for (DsSanPhamViewModel item : dsRepo.getAll()) {
            if (item.getSanPham().toLowerCase().contains(input.toLowerCase()) || item.getMauSac().toLowerCase().contains(input.toLowerCase())
                    || item.getNcc().toLowerCase().contains(input.toLowerCase()) || item.getSize().toLowerCase().contains(input.toLowerCase()
            )) {
                tempDSSP.add(item);
            }
        }
        return tempDSSP;
    }

    @Override
    public ArrayList<DsSanPhamViewModel> GetAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DsSanPhamViewModel> findSanPham(String sanPham) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DsSanPhamViewModel> GetAllSize(String input) {
        if (input == null) {
            return dsRepo.getAll();
        }
        ArrayList<DsSanPhamViewModel> tempSize = new ArrayList<>();
        for (DsSanPhamViewModel item : dsRepo.getAll()) {
            if (item.getSize().toLowerCase().equals(input.toLowerCase())) {
                tempSize.add(item);
            }
        }
        return tempSize;
    }

    @Override
    public ArrayList<DsSanPhamViewModel> GetAllCL(String input) {
        if (input == null) {
            return dsRepo.getAll();
        }
        ArrayList<DsSanPhamViewModel> tempCL = new ArrayList<>();
        for (DsSanPhamViewModel item : dsRepo.getAll()) {
            if (item.getChatLieu().toLowerCase().contains(input.toLowerCase())) {
                tempCL.add(item);
            }
        }
        return tempCL;
    }

    @Override
    public ArrayList<DsSanPhamViewModel> GetAllMS(String input) {
        if (input == null) {
            return dsRepo.getAll();
        }
        ArrayList<DsSanPhamViewModel> tempms = new ArrayList<>();
        for (DsSanPhamViewModel item : dsRepo.getAll()) {
            if (item.getMauSac().toLowerCase().contains(input.toLowerCase())) {
                tempms.add(item);
            }
        }
        return tempms;
    }

    @Override
    public ArrayList<DsSanPhamViewModel> GetAllNCC(String input) {
        if (input == null) {
            return dsRepo.getAll();
        }
        ArrayList<DsSanPhamViewModel> tempncc = new ArrayList<>();
        for (DsSanPhamViewModel item : dsRepo.getAll()) {
            if (item.getNcc().toLowerCase().contains(input.toLowerCase())) {
                tempncc.add(item);
            }
        }
        return tempncc;
    }

}
