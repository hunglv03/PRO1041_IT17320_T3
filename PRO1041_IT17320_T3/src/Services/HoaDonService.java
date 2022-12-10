/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModel.HoaDon;
import ViewModels.HoaDonViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kieu Oanh
 */
public interface HoaDonService {

    public List<HoaDonViewModel> GetAll();

    String them(HoaDon hd);

    public void add(HoaDon hd);

    public Iterable<HoaDonViewModel> getAll();

}
