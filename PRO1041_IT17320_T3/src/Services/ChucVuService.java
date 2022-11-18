/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ViewModels.ChucVuViewModel;
import java.util.List;

/**
 *
 * @author NamNguyenTien
 */
public interface ChucVuService {
    boolean add(); 
    boolean update();
    boolean delete();
     
    List<ChucVuViewModel> GetAll();
}
