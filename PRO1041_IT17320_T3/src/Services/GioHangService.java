/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ViewModels.GioHangViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface GioHangService {
    ArrayList<GioHangViewModel> getAll();
}
