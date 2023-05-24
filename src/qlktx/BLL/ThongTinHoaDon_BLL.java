/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.BLL;

import java.util.ArrayList;
import qlktx.DAL.ThongTinHoaDon_DAL;
import qlktx.DTO.ThongTinHoaDon_DTO;

/**
 *
 * @author Administrator
 */
public class ThongTinHoaDon_BLL {
    ThongTinHoaDon_DAL hdDAL = new ThongTinHoaDon_DAL();
    
    public String layMaHD(){
        return hdDAL.layMaHD();
    }
    
    public int xoaHoaDon(String MaHD){
        return hdDAL.xoaHoaDon(MaHD);
    }
    
    public int themHoaDon(ThongTinHoaDon_DTO hd){
        return hdDAL.themHoaDon(hd);
    }
    
    public int suaHoaDon(ThongTinHoaDon_DTO hd){
        return hdDAL.suaHoaDon(hd);
    }
    
    public ThongTinHoaDon_DTO timHoaDon(String MaHD){
        return hdDAL.timHoaDon(MaHD);
    }
    
    public ArrayList<ThongTinHoaDon_DTO> timTheoMaSV(String MaSV){
        return hdDAL.timTheoMaSV(MaSV);
    }
    
     public ThongTinHoaDon_DTO timTheoThang(int month, int year){
        return hdDAL.timTheoThang(month, year);
    }
    
    public ArrayList<ThongTinHoaDon_DTO> timTatCaHoaDon(){
        return hdDAL.timTatCaHoaDon();
    }
    
    public int kiemtraThongTinHoaDon(ThongTinHoaDon_DTO hd){
        return hdDAL.kiemtraThongTinHoaDon(hd);
    }
}
