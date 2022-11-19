/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Reponsitories.CTSanPhamRepository;
import Services.CTSanPhamService;
import ViewModels.CTSanPhamViewModel;
import java.util.List;

/**
 *
 * @author Lvh9x
 */
public class CTSanPhamServiceImpl implements CTSanPhamService {

    private CTSanPhamRepository repoCTSP = new CTSanPhamRepository();

    @Override
    public String them(CTSanPhamViewModel ct) {
        if (repoCTSP.Add(ct)) {
            return "Thêm thành công ";
        }
        return "Thêm không thành công ";
    }

    @Override
    public String sua(CTSanPhamViewModel ct) {
        if (repoCTSP.Update(ct)) {
            return "Sửa thành công ";
        }
        return "Sửa không thành công ";
    }

    @Override
    public String xoa(CTSanPhamViewModel ct) {
        if (repoCTSP.Delete(ct)) {
            return "Xóa thành công ";
        }
        return "Xóa không thành công ";
    }

    @Override
    public List<CTSanPhamViewModel> GetAll() {
        return repoCTSP.GetAll();
    }

}
