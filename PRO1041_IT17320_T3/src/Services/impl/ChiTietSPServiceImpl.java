/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModel.ChiTietSP;
import Reponsitories.ChiTietSPRepon;
import Services.ChiTietSPService;
import ViewModels.ChiTietSPViewModel;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class ChiTietSPServiceImpl implements ChiTietSPService{
    private ChiTietSPRepon csRepo;
    public ChiTietSPServiceImpl(){
        this.csRepo=new ChiTietSPRepon();
    }
    public void insert(ChiTietSP cs){
        this.csRepo.insert(cs);
    }
    public void update(ChiTietSP cs,String id){
        this.csRepo.update(cs, id);
    }
    public void delete(String id){
        this.csRepo.delete(id);
    }
    public ArrayList<ChiTietSPViewModel> getAll(){
        return this.csRepo.getAll();
    }
}
