/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class HoaDonCho {
    private String maHD;
    private String tenNV;
    private String tenKH;
    private int trangThai;
    private String ngayTao;

    public HoaDonCho() {
    }

    public HoaDonCho(String maHD, String tenNV, String tenKH, int trangThai, String ngayTao) {
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "HoaDonCho{" + "maHD=" + maHD + ", tenNV=" + tenNV + ", tenKH=" + tenKH + ", trangThai=" + trangThai + ", ngayTao=" + ngayTao + '}';
    }
    
    
}
