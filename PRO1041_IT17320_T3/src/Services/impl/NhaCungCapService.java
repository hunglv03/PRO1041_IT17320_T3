/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import Services.*;
import DomainModel.NhaCungCap;
import Reponsitories.NhaCungCapRepo;
import ViewModels.NhaCungCapViewModel;
import java.util.ArrayList;

/**
 *
 * @author Kieu Oanh
 */
public class NhaCungCapService  {
    private NhaCungCapRepo dRepo;
    public NhaCungCapService(){
        this.dRepo=new NhaCungCapRepo();
    }
    public void insert(NhaCungCap d) throws Exception{
        this.dRepo.insert(d);
    }
    public void update(NhaCungCap d,String id) throws Exception{
        this.dRepo.update(d, id);
    }
    public void delete(String id) throws Exception{
        this.dRepo.delete(id);
    }
    public ArrayList<NhaCungCapViewModel> getListncc() throws Exception{
        return this.dRepo.all();
    }


   



    }

    


