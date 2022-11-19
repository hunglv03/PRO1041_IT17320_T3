/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.CTSanPhamViewModel;
import java.util.List;

/**
 *
 * @author Lvh9x
 */
public interface CTSanPhamService {

    public String them(CTSanPhamViewModel ct);

    public String sua(CTSanPhamViewModel ct);

    public String xoa(CTSanPhamViewModel ct);

    public List<CTSanPhamViewModel> GetAll();
}
