/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import Reponsitories.HoaDonChoRepo;
import Services.HoaDonChoService;
import ViewModels.HoaDonChoViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonChoServiceImpl implements HoaDonChoService{
    HoaDonChoRepo hoaDonChoRepo = new HoaDonChoRepo();
    public HoaDonChoServiceImpl(){
        
    }

    @Override
    public ArrayList<HoaDonChoViewModel> getall() {
        return hoaDonChoRepo.GetAll();
    }
    
    
}
