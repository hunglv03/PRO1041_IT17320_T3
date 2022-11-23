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
public class NhaCungCapVM {

    private String id;
    private String maNCC;
    private String tenNCC;



    public NhaCungCapVM() {
    }

    public NhaCungCapVM(String id, String ma, String ten) {
        this.id = id;
        this.maNCC = ma;
        this.tenNCC = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return maNCC;
    }

    public void setMa(String ma) {
        this.maNCC = ma;
    }

    public String getTen() {
        return tenNCC;
    }

    public void setTen(String ten) {
        this.tenNCC = ten;
    }

    @Override
    public String toString() {
        return "NhaCungCapVM{" + "id=" + id + ", ma=" + maNCC + ", ten=" + tenNCC + '}';
    }

}
