/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModel.HoaDon;
import Reponsitories.HoaDonRepo;
import Services.HoaDonService;
import ViewModels.HoaDonMenuVM;
import ViewModels.HoaDonViewModel;
import java.util.ArrayList;

/**
 *
 * @author Kieu Oanh
 */
public class HoaDonServiceImpl implements HoaDonService {

<<<<<<< Updated upstream
    private HoaDonRepo hdRepo;
    public HoaDonServiceImpl(){
        this.hdRepo=new HoaDonRepo();
    }
//    public void insert(HoaDon hd){
//        this.nccRepo.add(hd);
//    }
    public void update(HoaDon hd,String id){
        this.hdRepo.update(hd,id);
    }
    public void delete(String id){
        this.hdRepo.delete(id);
    }
    public ArrayList<HoaDonViewModel> getAll(){
        return this.hdRepo.GetAll();
=======
    private HoaDonRepo nccRepo;

    public HoaDonServiceImpl() {
        this.nccRepo = new HoaDonRepo();
    }

    public void insert(HoaDon hd) {
        this.nccRepo.add(hd);
    }

    public void update(HoaDon hd, String id) {
        this.nccRepo.update(hd, id);
    }

    public void delete(String id) {
        this.nccRepo.delete(id);
    }

    public ArrayList<HoaDonViewModel> getAll() {
        return this.nccRepo.GetAll();
>>>>>>> Stashed changes
    }

    public static void main(String[] args) {
        HoaDonServiceImpl hd = new HoaDonServiceImpl();
        for (HoaDonViewModel x : hd.getAll()) {
            x.toString();
        }
    }

<<<<<<< Updated upstream
    @Override
    public String add(HoaDon hd) {
        if (hdRepo.add(hd)) {
            return "Them thanh cong";
        }
        return "Them that bai";
    }


 

   


   




    
=======
>>>>>>> Stashed changes
}
