/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

/**
 *
 * @author Kieu Oanh
 */
public class HoaDonViewModel {
    private String id;
    private KhachHangVM idKH;
    private NhanVienViewModel idNV;;
    private String ma;
    private String ngayThanhToan;
    private int tinhTrang;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String id, KhachHangVM idKH, NhanVienViewModel idNV, String ma, String ngayThanhToan, int tinhTrang) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KhachHangVM getIdKH() {
        return idKH;
    }

    public void setIdKH(KhachHangVM idKH) {
        this.idKH = idKH;
    }

    public NhanVienViewModel getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVienViewModel idNV) {
        this.idNV = idNV;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "id=" + id + ", idKH=" + idKH + ", idNV=" + idNV + ", ma=" + ma + ", ngayThanhToan=" + ngayThanhToan + ", tinhTrang=" + tinhTrang + '}';
    }

   
    
}
