/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DTO;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class TruongToa_DTO {
    private String MaTT;// mã trưởng tòa
    private String Password;// password trưởng tòa
    private String CCCD;// căn cước công dân trưởng tòa
    private String Ten;// tên trưởng tòa
    private Date NgaySinh;// tuổi trưởng tòa
    private String DiaChi;// địa chỉ trưởng tòa
    private String toa;

    public TruongToa_DTO() {
    }

    public TruongToa_DTO(String MaTT, String Password, String CCCD, String Ten, Date NgaySinh, String DiaChi, String toa) {
        this.MaTT = MaTT;
        this.Password = Password;
        this.CCCD = CCCD;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.toa = toa;
    }

    public String getMaTT() {
        return MaTT;
    }

    public String getPassword() {
        return Password;
    }

    public String getCCCD() {
        return CCCD;
    }

    public String getTen() {
        return Ten;
    }

    public String getToa() {
        return toa;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setToa(String toa) {
        this.toa = toa;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setMaTT(String MaTT) {
        this.MaTT = MaTT;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
}
