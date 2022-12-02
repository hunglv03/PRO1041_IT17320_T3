/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.CTSanPham;
import ViewModels.CTSanPhamViewModel;
import ViewModels.SizeVM;
import java.util.List;

/**
 *
 * @author Lvh9x
 */
public interface CTSanPhamService {

    public String them(CTSanPham ct);

    public String sua(CTSanPham ct);

    public String xoa(CTSanPhamViewModel ct);

    public List<CTSanPhamViewModel> GetAll();

    public List<CTSanPhamViewModel> getAll(String input);


}
