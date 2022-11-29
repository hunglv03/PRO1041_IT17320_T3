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
}
