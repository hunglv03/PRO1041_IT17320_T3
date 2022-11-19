/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModel.NhaCungCap;
import ViewModels.NhaCungCapVM;
import java.util.ArrayList;

/**
 *
 * @author Kieu Oanh
 */
public interface NhaCungCapService {

    ArrayList<NhaCungCapVM> getAll();

    void insert(NhaCungCap ncc);

    void update(NhaCungCap ncc, String id);

    void delete(String id);
}
