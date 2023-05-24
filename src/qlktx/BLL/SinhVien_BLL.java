/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.BLL;

import java.util.ArrayList;
import qlktx.DAL.SinhVien_DAL;
import qlktx.DTO.SinhVien_DTO;

/**
 *
 * @author Administrator
 */
public class SinhVien_BLL {
    SinhVien_DAL sv = new SinhVien_DAL();
    
    public String layMaSinhVien(){
        return sv.layMaSVTuDong();
    }
    
    public int xoaSinhVien(String MaSV){
        return sv.xoaSinhVien(MaSV);
    }
    
    public int themSinhVien(SinhVien_DTO svt){
        return sv.themSinhVien(svt);
    }
    
    public int suaSinhVien(SinhVien_DTO svt){
        return sv.suaSinhVien(svt);
    }
    
    public SinhVien_DTO timSinhVien(String MaSV){
        return sv.timSinhVien(MaSV);
    }
    
    public ArrayList<SinhVien_DTO> timTheoPhong(String Toa, String Phong){
        return sv.timTheoPhong(Toa, Phong);
    }
    
    public ArrayList<SinhVien_DTO> timTheoTen(String TenSV){
        return sv.timTheoTen(TenSV);
    }
    
    public ArrayList<SinhVien_DTO> timTatCaSinhVien(){
        return sv.timTatCaSinhVien();
    }
    
    public int kiemtraThongTinSinhVien(SinhVien_DTO svt){
        return sv.kiemtraThongTinSinhVien(svt);
    }
    
    public int kiemtraSinhVien(String MaSV){
        return sv.kiemtraSinhVien(MaSV);
    }
}
