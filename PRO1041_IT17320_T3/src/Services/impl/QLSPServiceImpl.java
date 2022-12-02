/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import Reponsitories.QLSPRepo;
import Services.QLSPService;
import ViewModels.QLSPVM;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QLSPServiceImpl implements QLSPService {

    private QLSPRepo qlspRepo;

    @Override
    public String them(QLSPVM ql) {// đổi tất cả thêm sang kiểu ctsp
        if (qlspRepo.Add(ql)) {
            return "Thêm thành công ";
        }
        return "Thêm không thành công ";
    }

    @Override
    public String sua(QLSPVM  ql) {
        if (qlspRepo.Update(ql)) {
            return "Sửa thành công ";
        }
        return "Sửa không thành công ";
    }

    @Override
    public String xoa(QLSPVM  ql) {
        if (qlspRepo.Delete(ql)) {
            return "Xóa thành công ";
        }
        return "Xóa không thành công ";
    }
    @Override
    public List<QLSPVM> GetAll() {
        return qlspRepo.GetAll();
    }
    public static void main(String[] args) {
        QLSPServiceImpl qlsp = new QLSPServiceImpl();
        qlsp.GetAll().forEach(x->{
            System.out.println(x);
        });
    }
}
