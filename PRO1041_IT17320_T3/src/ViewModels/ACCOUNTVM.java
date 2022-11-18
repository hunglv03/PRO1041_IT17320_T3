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
public class ACCOUNTVM {

    private String id;
    private String tenCV;
    private String mk;

    public ACCOUNTVM() {
    }

    public ACCOUNTVM(String id, String tenCV, String mk) {
        this.id = id;
        this.tenCV = tenCV;
        this.mk = mk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

}
