/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import Reponsitories.QLSPRepo;
import Services.QLSPService;
import ViewModels.QLSPVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class QLSPServiceImpl implements QLSPService {

    private QLSPRepo qlspRepo;

    public QLSPServiceImpl() {
        this.qlspRepo = new QLSPRepo();
    }

    public void insert(QLSPVM qlsp){
        this.qlspRepo.insert(qlsp);
    }
    public ArrayList<QLSPVM> getALL() {
        return this.qlspRepo.getAll();
    }
}
