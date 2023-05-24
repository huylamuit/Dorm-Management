/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DTO;

/**
 *
 * @author Administrator
 */
public class Toa_DTO {
    private String MaT;
    private String TenT;
    private int SLP;
    private int SLPT;
    private String MaTruongToa;

    public Toa_DTO(String MaT, String TenT, int SLP, int SLPT, String MaTruongToa) {
        this.MaT = MaT;
        this.TenT = TenT;
        this.SLP = SLP;
        this.SLPT = SLPT;
        this.MaTruongToa = MaTruongToa;
    }

    public Toa_DTO() {
    }

    public String getMaT() {
        return MaT;
    }

    public String getTenT() {
        return TenT;
    }

    public int getSLP() {
        return SLP;
    }

    public int getSLPT() {
        return SLPT;
    }

    public String getMaTruongToa() {
        return MaTruongToa;
    }

    public void setMaT(String MaT) {
        this.MaT = MaT;
    }

    public void setTenT(String TenT) {
        this.TenT = TenT;
    }

    public void setSLP(int SLP) {
        this.SLP = SLP;
    }

    public void setSLPT(int SLPT) {
        this.SLPT = SLPT;
    }

    public void setMaTruongToa(String MaTruongToa) {
        this.MaTruongToa = MaTruongToa;
    }
    
    
}
