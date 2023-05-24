/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DTO;

/**
 *
 * @author Administrator
 */
public class TaiKhoanDN_DTO {
    private String ID;
    private String Password;

    public TaiKhoanDN_DTO(String ID, String Password) {
        this.ID = ID;
        this.Password = Password;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public TaiKhoanDN_DTO() {
    }
    
}
