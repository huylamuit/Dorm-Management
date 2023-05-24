/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.BLL;
import java.util.ArrayList;
import qlktx.DAL.LuuTru_DAL;
import qlktx.DTO.LuuTru_DTO;
/**
 *
 * @author Administrator
 */
public class LuuTru_BLL {
    LuuTru_DAL luutruDAL = new LuuTru_DAL();
    
    public int xoaLuuTru(String MaHD){
        return luutruDAL.xoaLuuTru(MaHD);
    }
    
    public int themLuuTru(LuuTru_DTO lt){
        return luutruDAL.themLuuTru(lt);
    }
    
    public int suaLuuTru(LuuTru_DTO lt){
        return luutruDAL.suaLuuTru(lt);
    }
    
    public LuuTru_DTO timLuuTru(String MaLT){
        return luutruDAL.timLuuTru(MaLT);
    }
    
    public ArrayList<LuuTru_DTO> timTheoMaSinhVien(String MaSV){
        return luutruDAL.timTheoMaSinhVien(MaSV);
    }
    
    public ArrayList<LuuTru_DTO> timTatCaLuuTru(){
        return luutruDAL.timTatCaLuuTru();
    }
    
    public String layMaLT(String MaSV){
        return luutruDAL.layMaLT(MaSV);
    }
}
