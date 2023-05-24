/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DTO;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ThongBao_DTO {
    private String MaTB;
    private String ChuDe;
    private String NoiDung;
    private Date NgayDang;
    private String TacGia;

    public ThongBao_DTO() {
    }

    public ThongBao_DTO(String MaTB, String ChuDe, String NoiDung, Date NgayDang) {
        this.MaTB = MaTB;
        this.ChuDe = ChuDe;
        this.NoiDung = NoiDung;
        this.NgayDang = NgayDang;
    }

    public ThongBao_DTO(String MaTB, String ChuDe, String NoiDung, Date NgayDang, String TacGia) {
        this.MaTB = MaTB;
        this.ChuDe = ChuDe;
        this.NoiDung = NoiDung;
        this.NgayDang = NgayDang;
        this.TacGia = TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public String getTacGia() {
        return TacGia;
    }

    public ThongBao_DTO(String MaTB, String NoiDung, Date NgayDang, String TacGia) {
        this.MaTB = MaTB;
        this.NoiDung = NoiDung;
        this.NgayDang = NgayDang;
        this.TacGia = TacGia;
    }

    public String getMaTB() {
        return MaTB;
    }

    public String getChuDe() {
        return ChuDe;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public Date getNgayDang() {
        return NgayDang;
    }

    public void setMaTB(String MaTB) {
        this.MaTB = MaTB;
    }

    public void setChuDe(String ChuDe) {
        this.ChuDe = ChuDe;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public void setNgayDang(Date NgayDang) {
        this.NgayDang = NgayDang;
    }
    
    
}
