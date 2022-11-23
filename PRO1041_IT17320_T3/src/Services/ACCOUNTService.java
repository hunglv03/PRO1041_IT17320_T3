/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModel.ACCOUNT;
import ViewModels.ACCOUNTVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ACCOUNTService {


    
    ACCOUNT login(String userName, String pass);
}
