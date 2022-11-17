/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModel.ChucVu;
import Reponsitories.ChucVuRepository;
import Services.ChucVuService;
import ViewModels.ChucVuViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MyPC
 */

public class ChucVuServiceImpl implements ChucVuService{

    
    @Override
    public boolean add() {
        return add();
    }

    @Override
    public boolean update() {
        return update();
    }

    @Override
    public boolean delete() {
        return delete();
    }
    
    
    List<ChucVuViewModel> listCV;
    ChucVuRepository chucVuRepository;
    
    public ChucVuServiceImpl(){
        listCV = new ArrayList<>();
        chucVuRepository = new ChucVuRepository();
        if (!chucVuRepository.GetAll().isEmpty()) {
            listCV = chucVuRepository.GetAll();
        }
    }
    
    public List<ChucVuViewModel> GetAll(){
        return listCV;
    }
    
    public void GetAllFromDB(){
        if (!chucVuRepository.GetAll().isEmpty()) {
            listCV = chucVuRepository.GetAll();
        }
    }
    
    public String add(ChucVu cv){
        if (chucVuRepository.add(cv)) {
            GetAllFromDB();
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }
    
    public String update(ChucVu cv){
        if (chucVuRepository.update(cv)) {
            GetAllFromDB();
            return "Update thành công";
        }
        return "Update thất bại";
    }
    
    public String delete(String id){
        if (chucVuRepository.delete(id)) {
            GetAllFromDB();
            return "Delete thành công";
        }
        return "Delete thất bại";
    }
    
    public ChucVuViewModel GetChucVuByID(String id){
        for (ChucVuViewModel x : listCV) {
            if (x.getId().equals(id)) {
                return x;
            }            
        }
        return null;
    }

    
}
