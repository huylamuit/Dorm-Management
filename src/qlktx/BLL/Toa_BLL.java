/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.BLL;

import java.util.ArrayList;
import qlktx.DAL.Toa_DAL;
import qlktx.DTO.Toa_DTO;

/**
 *
 * @author Administrator
 */
public class Toa_BLL {
    Toa_DAL toaDAL = new Toa_DAL();
    public Toa_DTO timToa(String MaToa){
        return toaDAL.timToa(MaToa);
    }
    
    public ArrayList<Toa_DTO> timTatCaToa(){
        return toaDAL.timTatCaToa();
    }
    
    public int demSoLuongPhong(String MaToa){
        return toaDAL.demSoLuongPhong(MaToa);
    }
    
    public int demSoLuongPhongTrong(String MaToa){
        return toaDAL.demSoLuongPhongTrong(MaToa);
    }
    
    public int suaToa(Toa_DTO Toa){
        return toaDAL.suaToa(Toa);
    }
    
    public Toa_DTO timToaTheoTruongToa(String id){
        return toaDAL.timToaTheoTruongToa(id);
    }
}
