/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.BLL;

import java.util.ArrayList;
import qlktx.DAL.Phong_DAL;
import qlktx.DTO.Phong_DTO;

/**
 *
 * @author Administrator
 */
public class Phong_BLL {
    
    Phong_DAL phongDAL = new Phong_DAL();
    
    public Phong_DTO timPhong(String MaPhong, String MaToa){
        return phongDAL.timPhong(MaPhong, MaToa);
    }
    
    public ArrayList<Phong_DTO> timPhongTheoToa(String MaToa){
        return phongDAL.timPhongTheoToa(MaToa);
    }
    
    public ArrayList<Phong_DTO> timTatCaPhong(){
        return phongDAL.timTatCaPhong();
    }
    
    public int demSoLuongMotPhong(String MaPhong){
        return phongDAL.demSoLuongMotPhong(MaPhong);
    }
    
    public boolean phongday(String MaPhong, int x){
        return phongDAL.phongday(MaPhong, x);
    }
}
