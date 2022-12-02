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
public class HoaDonMenuVM {

    private String maHd;
    private String ngayTT;
    private int trangThai;
    private String sdt;
    private String tenNV;
    private String tenKH;

    public HoaDonMenuVM() {
    }

    public HoaDonMenuVM(String maHd, String ngayTT, int trangThai, String sdt, String tenNV, String tenKH) {
        this.maHd = maHd;
        this.ngayTT = ngayTT;
        this.trangThai = trangThai;
        this.sdt = sdt;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
    }

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public String getNgayTT() {
        return ngayTT;
    }

    public void setNgayTT(String ngayTT) {
        this.ngayTT = ngayTT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    @Override
    public String toString() {
        return "HoaDonMenuVM{" + "maHd=" + maHd + ", ngayTT=" + ngayTT + ", trangThai=" + trangThai + ", sdt=" + sdt + ", tenNV=" + tenNV + ", tenKH=" + tenKH + '}';
    }

}
