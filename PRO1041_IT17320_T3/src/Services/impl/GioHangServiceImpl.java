/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import Reponsitories.GioHangReponsitory;
import Services.GioHangService;
import ViewModels.GioHangViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class GioHangServiceImpl implements GioHangService{

    private GioHangReponsitory gioHangReponsitory;
    
    public GioHangServiceImpl(){
        this.gioHangReponsitory = new GioHangReponsitory();
    }
    
    @Override
    public ArrayList<GioHangViewModel> getAll() {
        return gioHangReponsitory.GetAll();
    }
    
}
