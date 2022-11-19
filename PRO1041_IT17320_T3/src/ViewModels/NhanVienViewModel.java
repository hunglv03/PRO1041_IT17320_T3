/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

/**
 *
 * @author NamNguyenTien
 */
public class NhanVienViewModel {
    private String id;
    private String idCV;
    private String ma;
    private String ten;
    private String email;
    private String ngaySinh;
    private int gioiTinh;
    private String sdt;
    private String diaChi;
    private int trangThai;

    public NhanVienViewModel() {
    }

    public NhanVienViewModel(String id, String idCV, String ma, String ten, String email, String ngaySinh, int gioiTinh, String sdt, String diaChi, int trangThai) {
        this.id = id;
        this.idCV = idCV;
        this.ma = ma;
        this.ten = ten;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
    @Override
    public String toString() {
        return "NhanVienViewModel{" + "id=" + id + ", idCV=" + idCV + ", ma=" + ma + ", ten=" + ten + ", email=" + email + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", diaChi=" + diaChi + ", trangThai=" + trangThai + '}';
    }
    
}
