/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModel.NhaCungCap;
import ViewModels.NhaCungCapViewModel;
import java.util.ArrayList;

/**
 *
 * @author Kieu Oanh
 */
public interface NhaCungCapImpl {

    ArrayList<NhaCungCapViewModel> getListNcc();

    void insert(NhaCungCap ncc);

    void update(NhaCungCap ncc, String d);

    void delete(String id);

}
