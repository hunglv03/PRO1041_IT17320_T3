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
public class HoaDonChoViewModel {
    private String maHD;
    private int trangThai;
    private String ngayTao;

    public HoaDonChoViewModel() {
    }

    public HoaDonChoViewModel(String maHD, int trangThai, String ngayTao) {
        this.maHD = maHD;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
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
        return "HoaDonChoViewModel{" + "maHD=" + maHD + ", trangThai=" + trangThai + ", ngayTao=" + ngayTao + '}';
    }

    
}
