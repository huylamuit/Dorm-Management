/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DTO;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class HoaDonDienNuoc_DTO {
    private String MaHD;
    private String Toa;
    private String Phong;
    private String ChiTiet;
    private Date NgayTao;
    private boolean ThanhToan;
    private Date NgayTT;
    private long TongTien;

    public HoaDonDienNuoc_DTO(String MaHD, String Toa, String Phong, 
            String ChiTiet, Date NgayTao, boolean ThanhToan, Date NgayTT, long TongTien) {
        this.MaHD = MaHD;
        this.Toa = Toa;
        this.Phong = Phong;
        this.ChiTiet = ChiTiet;
        this.NgayTao = NgayTao;
        this.ThanhToan = ThanhToan;
        this.NgayTT = NgayTT;
        this.TongTien = TongTien;
    }
    
    public HoaDonDienNuoc_DTO() {
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }

    public long getTongTien() {
        return TongTien;
    }

    public boolean isThanhToan() {
        return ThanhToan;
    }

    public Date getNgayTT() {
        return NgayTT;
    }

    public void setThanhToan(boolean ThanhToan) {
        this.ThanhToan = ThanhToan;
    }

    public void setNgayTT(Date NgayTT) {
        this.NgayTT = NgayTT;
    }    

    public String getMaHD() {
        return MaHD;
    }

    public String getToa() {
        return Toa;
    }

    public String getPhong() {
        return Phong;
    }

    public String getChiTiet() {
        return ChiTiet;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setToa(String Toa) {
        this.Toa = Toa;
    }

    public void setPhong(String Phong) {
        this.Phong = Phong;
    }

    public void setChiTiet(String ChiTiet) {
        this.ChiTiet = ChiTiet;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }
    
}
