/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DAL;
import qlktx.DTO.Phong_DTO;
import qlktx.Utils.*;
import java.sql.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
/**
 *
 * @author Administrator
 */
public class Phong_DAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    //private Statement stat = null;
    private ResultSet rs = null;
    
    public Phong_DTO timPhong(String MaPhong, String MaToa){
        Phong_DTO result = new Phong_DTO();
        
        String sqlTimPhong = "select * from phong where maphong = ? and MaToa = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimPhong);
            
            pres.setString(1, MaPhong);
            pres.setString(2, MaToa);
            System.out.println(pres);
            rs = pres.executeQuery();

            if(rs.next()){
                result.setMaP(rs.getString(1));
                result.setLoaiP(rs.getInt(2));
                result.setGiaTien(rs.getLong(3));
                result.setMaT(rs.getString(4));
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
    
    public ArrayList<Phong_DTO> timPhongTheoToa(String MaToa){
        ArrayList<Phong_DTO> result = new ArrayList<Phong_DTO>();
        
        String sqlTimPhong = "select * from phong where matoa = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimPhong);
            
            pres.setString(1, MaToa);
            rs = pres.executeQuery();

            while(rs.next()){
                Phong_DTO phong = new Phong_DTO();
                
                phong.setMaP(rs.getString(1));
                phong.setLoaiP(rs.getInt(2));
                phong.setGiaTien(rs.getLong(3));
                phong.setMaT(rs.getString(4));
                
                result.add(phong);
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
      
    public ArrayList<Phong_DTO> timPhongTheoToaVaTang(String MaToa, int tang){
        ArrayList<Phong_DTO> result = new ArrayList<Phong_DTO>();
        
        String sqlTimPhong = "select * from phong where matoa = ? and maphong like '" + tang + "%'";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimPhong);
            
            pres.setString(1, MaToa);
           
            System.out.println(pres);
            rs = pres.executeQuery();

            while(rs.next()){
                Phong_DTO phong = new Phong_DTO();
                
                phong.setMaP(rs.getString(1));
                phong.setLoaiP(rs.getInt(2));
                phong.setGiaTien(rs.getLong(3));
                phong.setMaT(rs.getString(4));
                
                result.add(phong);
                
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
    
    public ArrayList<Phong_DTO> timTatCaPhong(){
        ArrayList<Phong_DTO> result = new ArrayList<Phong_DTO>();
        
        String sqlTimPhong= "select * from phong ";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimPhong);

        
            rs = pres.executeQuery();
          

            while(rs.next()){
                Phong_DTO phong = new Phong_DTO();
                
                phong.setMaP(rs.getString(1));
                phong.setLoaiP(rs.getInt(2));
                phong.setGiaTien(rs.getLong(3));
                phong.setMaT(rs.getString(4));
                
                result.add(phong);
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
    
    public int demSoLuongMotPhong(String MaPhong){
        int result = 0;
        
        String sqlDemMotPhong= "select count(*) from sinhvien, phong "
                + "where phong = maphong and toa = matoa and maphong = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlDemMotPhong);
            pres.setString(1, MaPhong);
            System.out.println(pres);
            rs = pres.executeQuery();

            if(rs.next()){
                result = Integer.parseInt(rs.getString(1));
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
    
    public boolean phongday(String MaP, int x){
        boolean result = false;
        
        if(demSoLuongMotPhong(MaP) == x){
            result = true;
        }        
        return result;
    }
}
