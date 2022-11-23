/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Lvh9x
 */
public class CTSanPham {

    private String id;
    private String idSp;
    private String idSize;
    private String idMauSac;
    private String idNhaCungCap;
    private String idChatLieu;
    private String moTa;
    private double soLuongTon;
    private double giaNhap;
    private double giaBan; // thấy sai chua
    

    public CTSanPham() {
    }

    public CTSanPham(String id, String idSp, String idSize, String idMauSac, String idNhaCungCap, String idChatLieu, String moTa, double soLuongTon, double giaNhap, double giaBan) {
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

    public double getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(double soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "CTSanPham{" + "id=" + id + ", idSp=" + idSp + ", idSize=" + idSize + ", idMauSac=" + idMauSac + ", idNhaCungCap=" + idNhaCungCap + ", idChatLieu=" + idChatLieu + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

    

   
    
    
}
