/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DAL;
import qlktx.Utils.*;
import java.sql.*;
import qlktx.Utils.*;
import java.sql.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
import qlktx.BLL.Phong_BLL;
import qlktx.DTO.Phong_DTO;
import qlktx.DTO.Toa_DTO;
/**
 *
 * @author Administrator
 */
public class Toa_DAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private Statement stat = null;
    private ResultSet rs = null;
    
    public Toa_DTO timToa(String MaToa){
        Toa_DTO result = new Toa_DTO();
        
        String sqlTimToa = "select * from toa where matoa = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimToa);
            
            pres.setString(1, MaToa);
            rs = pres.executeQuery();

            if(rs.next()){
                result.setMaT(rs.getString(1));
                result.setTenT(rs.getString(2));
                result.setSLP(rs.getInt(3));
                result.setSLPT(rs.getInt(4));
                result.setMaTruongToa(rs.getString(5));
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
    
    public Toa_DTO timToaTheoTruongToa(String id){
        Toa_DTO result = new Toa_DTO();
        
        String sqlTimToa = "select * from toa where  matruongtoa = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimToa);
            
            pres.setString(1, id);
            rs = pres.executeQuery();

            if(rs.next()){
                result.setMaT(rs.getString(1));
                result.setTenT(rs.getString(2));
                result.setSLP(rs.getInt(3));
                result.setSLPT(rs.getInt(4));
                result.setMaTruongToa(rs.getString(5));
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
    
    public ArrayList<Toa_DTO> timTatCaToa(){
        ArrayList<Toa_DTO> result = new ArrayList<Toa_DTO>();
        
        String sqlTimPhong= "select * from toa";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimPhong);


            rs = pres.executeQuery();

            while(rs.next()){
                Toa_DTO phong = new Toa_DTO();
                
                phong.setMaT(rs.getString(1));
                phong.setTenT(rs.getString(2));
                phong.setSLP(rs.getInt(3));
                phong.setSLPT(rs.getInt(4));
                phong.setMaTruongToa(rs.getString(5));
                
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
    
    public int demSoLuongPhong(String MaToa){
        int result = 0;
        
        String sqlSoLuongPhong= "select count(*) from phong, toa "
                + "where phong.matoa = toa.matoa "
                + "and toa.matoa = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlSoLuongPhong);
            pres.setString(1, MaToa);

            rs = pres.executeQuery();

            if(rs.next()){
                result = rs.getInt(1);
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
    
    public int demSoLuongPhongTrong(String MaToa){
        int result = 0;
        ArrayList<Phong_DTO> listPhong = new ArrayList<Phong_DTO>();
        Phong_BLL phongBLL = new Phong_BLL();
        
        listPhong = phongBLL.timPhongTheoToa(MaToa);   
        result = this.demSoLuongPhong(MaToa);
        
        for(int i = 0; i < listPhong.size(); i++){
            Phong_DTO phong = phongBLL.timPhong(listPhong.get(i).getMaP(),listPhong.get(i).getMaT());
            int x = phong.getLoaiP();
            if (phongBLL.phongday(listPhong.get(i).getMaP(), x) == true)
                result -= 1;
        }        
        return result;
    }
    
    public int suaToa(Toa_DTO toa){
        int result = 0;
        String sqlUpdate = "update toa set tentoa = ?, "
                + "slphong = ?, "
                + "slphongtrong = ?, "
                + "matruongtoa = ? "
                +" where matoa = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlUpdate);
            pres.setString(1, toa.getTenT());
            pres.setInt(2, toa.getSLP());
            pres.setInt(3, toa.getSLPT());            
            pres.setString(4, toa.getMaTruongToa());
            pres.setString(5, toa.getMaT());
            
            
            result = pres.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                conn.close();
                pres.close();
                
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
