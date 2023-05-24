/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DTO;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Administrator
 */
public class LuuTru_DTO {
    private String MaLT;
    private String MaSV;
    private String Phong;
    private String Toa;
    private Date NgayThue;
    private Date NgayKT;
    private boolean DaThanhToan;

    public LuuTru_DTO() {
    }

    public LuuTru_DTO(String MaLT, String MaSV, String Phong, String Toa, Date NgayThue, Date NgayKT, boolean DaThanhToan) {
        this.MaLT = MaLT;
        this.MaSV = MaSV;
        this.Phong = Phong;
        this.Toa = Toa;
        this.NgayThue = NgayThue;
        this.NgayKT = NgayKT;
        this.DaThanhToan = DaThanhToan;
    }

    public void setMaLT(String MaLT) {
        this.MaLT = MaLT;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public void setPhong(String Phong) {
        this.Phong = Phong;
    }

    public void setToa(String Toa) {
        this.Toa = Toa;
    }

    public void setNgayThue(Date NgayThue) {
        this.NgayThue = NgayThue;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }

    public void setDaThanhToan(boolean DaThanhToan) {
        this.DaThanhToan = DaThanhToan;
    }

    public String getMaLT() {
        return MaLT;
    }

    public String getMaSV() {
        return MaSV;
    }

    public String getPhong() {
        return Phong;
    }

    public String getToa() {
        return Toa;
    }

    public Date getNgayThue() {
        return NgayThue;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public boolean isDaThanhToan() {
        return DaThanhToan;
    }
}
