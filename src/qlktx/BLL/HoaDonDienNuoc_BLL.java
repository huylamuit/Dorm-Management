/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.BLL;

import java.util.ArrayList;
import qlktx.DAL.HoaDonDienNuoc_DAL;
import qlktx.DTO.HoaDonDienNuoc_DTO;

/**
 *
 * @author Administrator
 */
public class HoaDonDienNuoc_BLL {
    HoaDonDienNuoc_DAL hdDAL = new HoaDonDienNuoc_DAL();
    
    public String layMaHD(){
        return hdDAL.layMaHD();
    }
    
    public int xoaHoaDon(String MaHD){
        return hdDAL.xoaHoaDon(MaHD);
    }
    
    public int themHoaDon(HoaDonDienNuoc_DTO hd){
        return hdDAL.themHoaDon(hd);
    }
    
    public int suaHoaDon(HoaDonDienNuoc_DTO hd){
        return hdDAL.suaHoaDon(hd);
    }
    
    public HoaDonDienNuoc_DTO timHoaDon(String MaHD){
        return hdDAL.timHoaDon(MaHD);
    }
    
    public HoaDonDienNuoc_DTO timTheoPhongToa(String Toa, String Phong,int thang,int nam){
        return hdDAL.timTheoPhongToa(Toa, Phong, thang, nam);
    }
    
    public ArrayList<HoaDonDienNuoc_DTO> timTatCaHoaDon(){
        return hdDAL.timTatCaHoaDon();
    }
    
    public int kiemtraThongTinHoaDon(HoaDonDienNuoc_DTO hd){
        return hdDAL.kiemtraThongTinHoaDon(hd);
    }
}

