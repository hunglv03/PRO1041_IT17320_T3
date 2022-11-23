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
    private String maSP;
    private String tenSP;
    private int donGia;
    private double soLuong;
    private String mauSac;
    private String chatlieu;
    private String kichThuoc;

    public QLSPVM() {
    }

    public QLSPVM(String maSP, String tenSP, int donGia, double soLuong, String mauSac, String chatlieu, String kichThuoc) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.chatlieu = chatlieu;
        this.kichThuoc = kichThuoc;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    @Override
    public String toString() {
        return "QLSPVM{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", donGia=" + donGia + ", soLuong=" + soLuong + ", mauSac=" + mauSac + ", chatlieu=" + chatlieu + ", kichThuoc=" + kichThuoc + '}';
    }


}
