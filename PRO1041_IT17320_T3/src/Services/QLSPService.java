/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ViewModels.QLSPVM;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface QLSPService {

    ArrayList<QLSPVM> getALL();
    void insert(QLSPVM qlsp);
}
