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
public class QLSPVM {

    private String moTa;
    private double soLuongTon;//đây sửa nữa này
    private double giaBan;
    private double giaNhap;

    public QLSPVM() {
    }

    public QLSPVM(String id, SanPhamViewmodel idSp, SizeVM idSize, MauSacViewModel idMauSac, NhaCungCapVM idNhaCungCap, ChatLieuViewModel idChatLieu, String moTa, double soLuongTon, double giaBan, double giaNhap) {

        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(double soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    @Override
    public String toString() {
        return "QLSPVM{" + "moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaBan=" + giaBan + ", giaNhap=" + giaNhap + '}';
    }

}
