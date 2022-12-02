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
    private String ma;
    private String ngayThanhToan;
    private int trangThai;
    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String id, String ma, String ngayThanhToan, int trangThai, String tenNguoiNhan, String diaChi, String sdt) {
        this.id = id;
        this.ma = ma;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "id=" + id + ", ma=" + ma + ", ngayThanhToan=" + ngayThanhToan + ", trangThai=" + trangThai + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChi=" + diaChi + ", sdt=" + sdt + '}';
    }

}
