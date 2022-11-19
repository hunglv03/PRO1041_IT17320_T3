/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
