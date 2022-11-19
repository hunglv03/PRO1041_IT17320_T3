/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Lvh9x
 */
public class CTSanPhamViewModel {
    private String id;
    private String idSp;
    private String idSize;
    private String idMauSac;
    private String idNhaCungCap;
    private String idChatLieu;
    private String moTa;
    private String soLuongTon;
    private String giaNhap;
    private String giaBan;

    public CTSanPhamViewModel() {
    }

    public CTSanPhamViewModel(String id, String idSp, String idSize, String idMauSac, String idNhaCungCap, String idChatLieu, String moTa, String soLuongTon, String giaNhap, String giaBan) {
        this.id = id;
        this.idSp = idSp;
        this.idSize = idSize;
        this.idMauSac = idMauSac;
        this.idNhaCungCap = idNhaCungCap;
        this.idChatLieu = idChatLieu;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(String idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public String getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(String idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(String soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "CTSanPhamViewModel{" + "id=" + id + ", idSp=" + idSp + ", idSize=" + idSize + ", idMauSac=" + idMauSac + ", idNhaCungCap=" + idNhaCungCap + ", idChatLieu=" + idChatLieu + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }
    
    
}
