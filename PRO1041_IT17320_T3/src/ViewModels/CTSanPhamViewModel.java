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
    private SanPhamViewmodel idSp;
    private SizeVM idSize;
    private MauSacViewModel idMauSac;
    private NhaCungCapVM idNhaCungCap;
    private ChatLieuViewModel idChatLieu;
    private String moTa;
    private double soLuongTon;//đây sửa nữa này
    private double giaBan;
    private double giaNhap;

    public CTSanPhamViewModel() {
    }

    public CTSanPhamViewModel(String id, SanPhamViewmodel idSp, SizeVM idSize, MauSacViewModel idMauSac, NhaCungCapVM idNhaCungCap, ChatLieuViewModel idChatLieu, String moTa, double soLuongTon, double giaBan, double giaNhap) {
        this.id = id;
        this.idSp = idSp;
        this.idSize = idSize;
        this.idMauSac = idMauSac;
        this.idNhaCungCap = idNhaCungCap;
        this.idChatLieu = idChatLieu;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPhamViewmodel getIdSp() {
        return idSp;
    }

    public void setIdSp(SanPhamViewmodel idSp) {
        this.idSp = idSp;
    }

    public SizeVM getIdSize() {
        return idSize;
    }

    public void setIdSize(SizeVM idSize) {
        this.idSize = idSize;
    }

    public MauSacViewModel getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(MauSacViewModel idMauSac) {
        this.idMauSac = idMauSac;
    }

    public NhaCungCapVM getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(NhaCungCapVM idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public ChatLieuViewModel getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(ChatLieuViewModel idChatLieu) {
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
        return "CTSanPhamViewModel{" + "id=" + id + ", idSp=" + idSp + ", idSize=" + idSize + ", idMauSac=" + idMauSac + ", idNhaCungCap=" + idNhaCungCap + ", idChatLieu=" + idChatLieu + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaBan=" + giaBan + ", giaNhap=" + giaNhap + '}';
    }

    

    

}
