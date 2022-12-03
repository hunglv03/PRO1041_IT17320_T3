/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import Reponsitories.QLHoaDonReponsitory;
import Services.QLHoaDonService;
import ViewModels.QLHoaDonViewModel;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class QLHoaDonServiceImpl implements QLHoaDonService{
    private QLHoaDonReponsitory qlhdRepon;
    
    public QLHoaDonServiceImpl(){
        this.qlhdRepon=new QLHoaDonReponsitory();
    }
    
    public ArrayList<QLHoaDonViewModel> getListQLHoaDon(){
        return this.qlhdRepon.getListQLHoaDon();
    }
}
