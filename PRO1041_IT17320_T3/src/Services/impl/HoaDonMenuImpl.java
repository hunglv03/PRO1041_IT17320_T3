/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import Reponsitories.HoaDonMenuRepo;
import Services.HoaDonMenuService;
import ViewModels.HoaDonMenuVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonMenuImpl implements HoaDonMenuService {

    private HoaDonMenuRepo hdmRepo;

    public HoaDonMenuImpl() {
        this.hdmRepo = new HoaDonMenuRepo();
    }

    public ArrayList<HoaDonMenuVM> getAll() {
        return this.hdmRepo.getAll();
    }

}
