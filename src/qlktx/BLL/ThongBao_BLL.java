/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.BLL;

import qlktx.DAL.ThongBao_DAL;
import qlktx.DTO.ThongBao_DTO;

/**
 *
 * @author ASUS
 */
public class ThongBao_BLL {
    ThongBao_DAL tbDAL = new ThongBao_DAL();
    
    public ThongBao_DTO timThongBao(String MaTB){
        return tbDAL.timThongBao(MaTB);
    }
    
    public int xoaThongBao(String MaTB){
        return tbDAL.xoaThongBao(MaTB);
    }
}
