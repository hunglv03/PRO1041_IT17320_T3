/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModel.NhaCungCap;
import Reponsitories.NhaCungCapRepo;
import Services.NhaCungCapService;
import ViewModels.NhaCungCapVM;
import java.util.ArrayList;

/**
 *
 * @author Kieu Oanh
 */
public class NhaCungCapServiceimpl implements NhaCungCapService{

    private NhaCungCapRepo nccRepo;
    public NhaCungCapServiceimpl(){
        this.nccRepo=new NhaCungCapRepo();
    }
    public void insert(NhaCungCap ncc){
        this.nccRepo.insert(ncc);
    }
    public void update(NhaCungCap ncc,String id){
        this.nccRepo.update(ncc, id);
    }
    public void delete(String id){
        this.nccRepo.delete(id);
    }
    public ArrayList<NhaCungCapVM> getAll(){
        return this.nccRepo.getAll();
    }
    
}
