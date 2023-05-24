/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DAL;
import qlktx.DTO.SinhVien_DTO;
import qlktx.Utils.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import qlktx.BLL.SinhVien_BLL;
import qlktx.DTO.TaiKhoanDN_DTO;

/**
 *
 * @author Administrator
 */
public class TaiKhoanDN_DAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    //private Statement stat = null;
    private ResultSet rs = null;
    
    public String kiemtraTK(String tk){
        String result = "";
        
        String sqlTimTaiKhoan = "select * from taikhoandn "
                + "where id=?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimTaiKhoan);
            pres.setString(1, tk);
            System.out.println(pres);
            rs = pres.executeQuery();
            

            while(rs.next()){
                result = rs.getString(2);
                System.out.println(result);
            }          
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Lỗi");
        }
        
        finally{
            try{
                conn.close();
                pres.close();
                rs.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    public int dangnhap(TaiKhoanDN_DTO tk){
        String MK = kiemtraTK(tk.getID());
        if(MK.equals(tk.getPassword()) == false || 
                (MK.equals("") == true)){
            JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc tài khoản",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            
            return 0;
        }
        else
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);       
        System.out.println(MK + "/");
        
        return 1;
    }
    
    public int doiMatKhau(TaiKhoanDN_DTO tk){
        int result = 0;
        
        return result;
    }
    
    public int quenMatKhau(TaiKhoanDN_DTO tk, String SoDT){
        int result = 0;
        
        return result;
    }
}
