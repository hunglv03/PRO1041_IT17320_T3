/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModel.ACCOUNT;
import Reponsitories.ACCOUNTRepo;
import Services.ACCOUNTService;
import ViewModels.ACCOUNTVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ACCOUNTServiceimpl implements ACCOUNTService {

    private ACCOUNTRepo aRepo;

    public ACCOUNTServiceimpl() {
        this.aRepo = new ACCOUNTRepo();
    }

    public void insert(ACCOUNT a) {
        this.aRepo.insert(a);
    }

    public void update(ACCOUNT a, String id) {
        this.aRepo.update(a, id);
    }

    public void delete(String id) {
        this.aRepo.delete(id);
    }

    public ArrayList<ACCOUNTVM> getListACC() {
        return this.aRepo.all();
    }




}
