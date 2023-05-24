/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.BLL;

import java.util.ArrayList;
import qlktx.DAL.TruongToa_DAL;
import qlktx.DTO.TruongToa_DTO;

/**
 *
 * @author Administrator
 */
public class TruongToa_BLL {
    TruongToa_DAL ttBLL = new TruongToa_DAL();
    public ArrayList<TruongToa_DTO> timTatCaTruongToa(){
        return ttBLL.timTatCaTruongToa();
    }
    public TruongToa_DTO timTruongToa(String MaTT){
        return ttBLL.timTruongToa(MaTT);
    }
    
     public TruongToa_DTO timTruongToaTheoToa(String MaT){
        return ttBLL.timTruongToaTheoToa(MaT);
    }
}
