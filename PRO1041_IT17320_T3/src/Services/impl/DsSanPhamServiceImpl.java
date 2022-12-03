/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import Reponsitories.DsSanPhamReponsitory;
import Services.DsSanPhamService;
import ViewModels.DsSanPhamViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DsSanPhamServiceImpl implements DsSanPhamService{
    private DsSanPhamReponsitory dsRepo;
    
    public DsSanPhamServiceImpl(){
        this.dsRepo=new DsSanPhamReponsitory();
    }
    
    public ArrayList<DsSanPhamViewModel> getAll(){
        return this.dsRepo.getAll();
    }
    
    public ArrayList<DsSanPhamViewModel> findSanPham(String sanPham){
        return this.dsRepo.findSanPham(sanPham);
    }
    
    public ArrayList<DsSanPhamViewModel> findMauSac(String mauSac){
        return this.dsRepo.findMauSac(mauSac);
    }
    public ArrayList<DsSanPhamViewModel> findSize(String size){
        return this.dsRepo.findMauSac(size);
    }
    public ArrayList<DsSanPhamViewModel> findNCC(String ncc){
        return this.dsRepo.findMauSac(ncc);
    }
    public ArrayList<DsSanPhamViewModel> findChatLieu(String chatLieu){
        return this.dsRepo.findMauSac(chatLieu);
    }
}
