/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModel.HoaDon;
import ViewModels.HoaDonViewModel;
import java.util.ArrayList;

/**
 *
 * @author Kieu Oanh
 */
public interface HoaDonService {

    ArrayList<HoaDonViewModel> getAll();

    void insert(HoaDon hd);

    void update(HoaDon hd, String id);

    void delete(String id);

}
