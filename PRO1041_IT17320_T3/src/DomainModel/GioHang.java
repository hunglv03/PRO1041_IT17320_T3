/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class GioHang {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private Double donGia;

    public GioHang() {
    }

    public GioHang(String maSP, String tenSP, int soLuong, Double donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "GioHang{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
    
    
    
    
    
}
