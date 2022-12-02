/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

/**
 *
 * @author Admin
 */
public class QLHoaDonViewModel {
    private String maHD;
    private String ngayThanhToan;
    private int trangThai;
    private String tenKH;
    private String tenNV;

    public QLHoaDonViewModel() {
    }

    public QLHoaDonViewModel(String maHD, String ngayThanhToan, int trangThai, String tenKH, String tenNV) {
        this.maHD = maHD;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
        this.tenKH = tenKH;
        this.tenNV = tenNV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }


    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    @Override
    public String toString() {
        return "QLHoaDonViewModel{" + "maHD=" + maHD + ", ngayThanhToan=" + ngayThanhToan + ", trangThai=" + trangThai + ", tenKH=" + tenKH + ", tenNV=" + tenNV + '}';
    }

 
    
    
}
