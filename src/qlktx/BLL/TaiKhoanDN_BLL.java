/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.BLL;
import java.util.ArrayList;
import qlktx.DAL.TaiKhoanDN_DAL;
import qlktx.DTO.TaiKhoanDN_DTO;
/**
 *
 * @author Administrator
 */
public class TaiKhoanDN_BLL {
    TaiKhoanDN_DAL tkDAL = new TaiKhoanDN_DAL();
    
    public String kiemtraTK(String tk){
        return tkDAL.kiemtraTK(tk);
    }
    public int dangnhap(TaiKhoanDN_DTO tk){
        return tkDAL.dangnhap(tk);
    }
    public String phanQuyen(TaiKhoanDN_DTO tk){
        String result = "";
        result = tk.getID().substring(0, 2);
        return result;
    }
    public int quenMatKhau(TaiKhoanDN_DTO tk, String SoDT){
        return tkDAL.quenMatKhau(tk, SoDT);
    }
    public int doiMatKhau(TaiKhoanDN_DTO tk){
        return tkDAL.doiMatKhau(tk);
    }
}
