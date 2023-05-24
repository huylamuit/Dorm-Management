/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DAL;

import qlktx.DTO.TruongToa_DTO;
import qlktx.Utils.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class TruongToa_DAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    //private Statement stat = null;
    private ResultSet rs = null;
    
    public ArrayList<TruongToa_DTO> timTatCaTruongToa(){
        ArrayList<TruongToa_DTO> result = new ArrayList<TruongToa_DTO>();
        
        String sqlTimTruongToa = "select * from truongtoa";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimTruongToa);


            rs = pres.executeQuery();

            while(rs.next()){
                TruongToa_DTO tt = new TruongToa_DTO();
                
                tt.setMaTT(rs.getString(1));
                tt.setPassword(rs.getString(2));
                tt.setCCCD(rs.getString(3));
                tt.setTen(rs.getString(4));
                tt.setNgaySinh(rs.getDate(5));
                tt.setDiaChi(rs.getString(6));
                
                result.add(tt);
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
    
    public TruongToa_DTO timTruongToa(String MaTT){
        TruongToa_DTO result = new TruongToa_DTO();
        
        String sqlTimTruongToa = "select * from truongtoa where matt = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimTruongToa);
            pres.setString(1, MaTT);

            rs = pres.executeQuery();

            while(rs.next()){
                TruongToa_DTO tt = new TruongToa_DTO();
                
                tt.setMaTT(rs.getString(1));
                tt.setPassword(rs.getString(2));
                tt.setCCCD(rs.getString(3));
                tt.setTen(rs.getString(4));
                tt.setNgaySinh(rs.getDate(5));
                tt.setDiaChi(rs.getString(6));
                
                result = tt;
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
       public TruongToa_DTO timTruongToaTheoToa(String MaT){
        TruongToa_DTO result = new TruongToa_DTO();
        
        String sqlTimTruongToa = "select * from truongtoa where toa = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimTruongToa);
            pres.setString(1, MaT);
            System.out.println(pres);

            rs = pres.executeQuery();

            while(rs.next()){
                TruongToa_DTO tt = new TruongToa_DTO();
                
                tt.setMaTT(rs.getString(1));
                tt.setPassword(rs.getString(2));
                tt.setCCCD(rs.getString(3));
                tt.setTen(rs.getString(4));
                tt.setNgaySinh(rs.getDate(5));
                tt.setDiaChi(rs.getString(6));
                
                result = tt;
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
}
