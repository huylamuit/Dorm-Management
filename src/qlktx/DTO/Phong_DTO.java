/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DTO;

/**
 *
 * @author Administrator
 */
public class Phong_DTO {
    private String MaP;//Mã phòng
    private int LoaiP;//Loại phòng
    private long GiaTien;//Giá phòng
    private String MaT;// mã tòa

    public Phong_DTO(String MaP, int LoaiP, long GiaTien, String MaT) {
        this.MaP = MaP;
        this.LoaiP = LoaiP;
        this.GiaTien = GiaTien;
        this.MaT = MaT;
    }

    public Phong_DTO() {
    }

    public String getMaP() {
        return MaP;
    }

    public int getLoaiP() {
        return LoaiP;
    }

    public long getGiaTien() {
        return GiaTien;
    }

    public String getMaT() {
        return MaT;
    }

    public void setMaP(String MaP) {
        this.MaP = MaP;
    }

    public void setLoaiP(int LoaiP) {
        this.LoaiP = LoaiP;
    }

    public void setGiaTien(long GiaTien) {
        this.GiaTien = GiaTien;
    }

    public void setMaT(String MaT) {
        this.MaT = MaT;
    }
    
}
