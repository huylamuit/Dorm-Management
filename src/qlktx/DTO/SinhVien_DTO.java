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
public class SinhVien_DTO {
    private String MaSV;// mã sinh viên
    private String Password;// password sinh viên
    private String CCCD;// căn cước công dân sinh viên
    private String Ten;// tên sinh viên
    private Date NgaySinh;// ngày sinh sinh viên
    private String DiaChi;// địa chỉ sinh viên
    private String Truong;// trường đang học của sinh viên
    private String Toa;// tòa 
    private String Phong;// phòng
    private String SoDT;

    public SinhVien_DTO() {
    }

    public SinhVien_DTO(String MaSV, String Password, String CCCD, String Ten, Date NgaySinh, String DiaChi, String Truong, String Toa, String Phong, String SoDT) {
        this.MaSV = MaSV;
        this.Password = Password;
        this.CCCD = CCCD;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.Truong = Truong;
        this.Toa = Toa;
        this.Phong = Phong;
        this.SoDT = SoDT;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getMaSV() {
        return MaSV;
    }

    public String getTruong() {
        return Truong;
    }

    public String getToa() {
        return Toa;
    }

    public String getPhong() {
        return Phong;
    }

    public Date getNgaySinh() {
        return NgaySinh;
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

    public String getDiaChi() {
        return DiaChi;
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

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public void setTruong(String Truong) {
        this.Truong = Truong;
    }

    public void setToa(String Toa) {
        this.Toa = Toa;
    }

    public void setPhong(String Phong) {
        this.Phong = Phong;
    }
    
    
}
