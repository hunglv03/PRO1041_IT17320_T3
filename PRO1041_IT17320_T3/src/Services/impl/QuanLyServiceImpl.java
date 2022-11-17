/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModel.QuanLy;
import Reponsitories.QuanLyReponsitory;
import ViewModels.QuanLyViewModel;
import java.util.ArrayList;
import Services.QuanLyService;

/**
 *
 * @author MyPC
 */
public class QuanLyServiceImpl implements QuanLyService{
    private QuanLyReponsitory qRepo;
    
    public QuanLyServiceImpl(){
        this.qRepo=new QuanLyReponsitory();
    }
    
    public void insert(QuanLy q){
        this.qRepo.insert(q);
    }
    
    public void update(QuanLy q,String id){
        this.qRepo.update(q, id);
    }
    public void delete(String id){
        this.qRepo.delete(id);
    }
    
    public ArrayList<QuanLyViewModel> getAll(){
        return this.qRepo.getAll();
    }
}
