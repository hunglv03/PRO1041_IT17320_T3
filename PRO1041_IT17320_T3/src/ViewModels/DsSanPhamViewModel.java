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
public class DsSanPhamViewModel {
    private String id;
    private String sanPham;
    private String size;
    private String mauSac;
    private String ncc;
    private String chatLieu;
    private int soLuong;
    private double giaBan;

    public DsSanPhamViewModel() {
    }

    public DsSanPhamViewModel(String id, String sanPham, String size, String mauSac, String ncc, String chatLieu, int soLuong, double giaBan) {
        this.id = id;
        this.sanPham = sanPham;
        this.size = size;
        this.mauSac = mauSac;
        this.ncc = ncc;
        this.chatLieu = chatLieu;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
        this.sanPham = sanPham;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getNcc() {
        return ncc;
    }

    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

//    @Override
//    public String toString() {
//        return "DsSanPhamViewModel{" + "id=" + id + ", sanPham=" + sanPham + ", size=" + size + ", mauSac=" + mauSac + ", ncc=" + ncc + ", chatLieu=" + chatLieu + ", soLuong=" + soLuong + ", giaBan=" + giaBan + '}';
//    }

    
    
    
}
