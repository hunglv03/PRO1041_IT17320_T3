/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import DomainModel.CTSanPham;
import Reponsitories.CTSanPhamRepository;
import Reponsitories.ChatLieuRepository;
import Services.CTSanPhamService;
import ViewModels.CTSanPhamViewModel;
import ViewModels.SizeVM;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Lvh9x
 */
public class CTSanPhamServiceImpl implements CTSanPhamService {

    private CTSanPhamRepository repoCTSP = new CTSanPhamRepository();
    private ChatLieuRepository repoCL = new ChatLieuRepository();

    @Override
    public String them(CTSanPham ct) {// đổi tất cả thêm sang kiểu ctsp
        if (repoCTSP.Add(ct)) {
            return "Thêm thành công ";
        }
        return "Thêm không thành công ";
    }

    @Override
    public String sua(CTSanPham ct) {
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
    public static void main(String[] args) {
        CTSanPhamServiceImpl ctsp = new CTSanPhamServiceImpl();
        ctsp.GetAll().forEach(x->{
            System.out.println(x);
        });
    }

    @Override
    public List<CTSanPhamViewModel> getAll(String input) {
        if (input == null) {
            return repoCTSP.GetAll();
        }
        List<CTSanPhamViewModel> tempctsp = new ArrayList<>();
        for (CTSanPhamViewModel x : repoCTSP.GetAll()) {
            if (x.getIdSp().getTen().toLowerCase().contains(input.toLowerCase()) || x.getIdSize().getTen().toLowerCase().contains(input.toLowerCase()) || x.getIdMauSac().getTen().toLowerCase().contains(input.toLowerCase()) || x.getIdChatLieu().getTen().toLowerCase().contains(input.toLowerCase())) {
                tempctsp.add(x);
            }
        }
        return tempctsp;
    }
}




