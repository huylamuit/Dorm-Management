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
public class ThongTinHoaDon_DTO {
    private String MaHD;
    private String MaSV;
    private String ChiTiet;
    private Date NgayTao;
    private boolean ThanhToan;
    private Date NgayTT;
    private long TongTien;

    public ThongTinHoaDon_DTO() {
    }

    public ThongTinHoaDon_DTO(String MaHD, String MaSV, String ChiTiet, 
            Date NgayTao, boolean ThanhToan, Date NgayTT, long TongTien) {
        this.MaHD = MaHD;
        this.MaSV = MaSV;
        this.ChiTiet = ChiTiet;
        this.NgayTao = NgayTao;
        this.ThanhToan = ThanhToan;
        this.NgayTT = NgayTT;
        this.TongTien = TongTien;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
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

    public String getMaSV() {
        return MaSV;
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

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public void setChiTiet(String ChiTiet) {
        this.ChiTiet = ChiTiet;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }
}
