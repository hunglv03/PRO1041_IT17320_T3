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



    public ACCOUNT login(String userName, String pass){
        return this.aRepo.login(userName, pass);
    }


}
