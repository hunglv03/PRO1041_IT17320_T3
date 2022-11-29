/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModel.ChiTietSP;
import ViewModels.ChiTietSPViewModel;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public interface ChiTietSPService {
    
    ArrayList<ChiTietSPViewModel> getAll();
    void insert(ChiTietSP cs);
    void update(ChiTietSP cs,String id);
    void delete(String id);
}
