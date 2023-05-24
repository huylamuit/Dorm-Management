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
import qlktx.DTO.LuuTru_DTO;
/**
 *
 * @author Administrator
 */
public class LuuTru_DAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private Statement stat = null;
    private ResultSet rs = null;
    
    public int xoaLuuTru(String MaHD){
        int result = 0;
        String sqlUpdate = "delete from luutru where mahd = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlUpdate);
            pres.setString(1, MaHD);
            
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
        
    public int themLuuTru(LuuTru_DTO lt){
        int result = 0;
        
        String sqlInsert = "insert into luutru " 
                + "values(?,?,?,?,?,?,?);";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlInsert);
            
            pres.setString(1, lt.getMaLT());
            pres.setString(2, lt.getMaSV());
            pres.setString(3, lt.getPhong());
            pres.setString(4, lt.getToa());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(5, df.format(lt.getNgayThue()));
            pres.setString(6, df.format(lt.getNgayKT()));
            pres.setBoolean(7, lt.isDaThanhToan());
           
            result = pres.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace(); 
        }
        
        finally{
            try{
                conn.close();
                pres.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public int suaLuuTru(LuuTru_DTO lt){
        int result = 0;
        String sqlUpdate = "update luutru set masv = ?, "
                + "phong = ?, "
                + "toa = ?, "
                + "ngthue = ?, "
                + "ngketthuc = ?, "
                + "thanhthan = ?, "
                + "where malt = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlUpdate);
            
            pres.setString(1, lt.getMaLT());
            pres.setString(2, lt.getMaSV());
            pres.setString(3, lt.getPhong());
            pres.setString(4, lt.getToa());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(5, df.format(lt.getNgayThue()));
            pres.setString(6, df.format(lt.getNgayKT()));
            pres.setBoolean(7, lt.isDaThanhToan());
            
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
    
    public LuuTru_DTO timLuuTru(String MaLT){
        LuuTru_DTO result = new LuuTru_DTO();
        
        String sqlTimLuuTru = "select * from luutru where malt = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimLuuTru);
            
            pres.setString(1, MaLT);
            rs = pres.executeQuery();
            //System.out.println(pres);
            
            if(rs.next()){
                result.setMaLT(rs.getString(1));
                result.setMaSV(rs.getString(2));
                result.setPhong(rs.getString(3));
                result.setToa(rs.getString(4));
                result.setNgayThue(rs.getDate(5));
                result.setNgayKT(rs.getDate(6));
                result.setDaThanhToan(rs.getBoolean(7));
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
    
    public ArrayList<LuuTru_DTO> timTheoMaSinhVien(String MaSV){
         ArrayList<LuuTru_DTO> result = new ArrayList<LuuTru_DTO>();
        
        String sqlTimLuuTru = "select * from luutru where masv = ? ";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimLuuTru);
            
            pres.setString(1, MaSV);
            rs = pres.executeQuery();
            //System.out.println(pres);
            
            while(rs.next()){
                LuuTru_DTO lt = new LuuTru_DTO();
                
                lt.setMaLT(rs.getString(1));
                lt.setMaSV(rs.getString(2));
                lt.setPhong(rs.getString(3));
                lt.setToa(rs.getString(4));
                lt.setNgayThue(rs.getDate(5));
                lt.setNgayKT(rs.getDate(6));
                lt.setDaThanhToan(rs.getBoolean(7));
                
                result.add(lt);
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
    
    public ArrayList<LuuTru_DTO> timTatCaLuuTru(){
        ArrayList<LuuTru_DTO> result = new ArrayList<LuuTru_DTO>();
        
        String sqlTimLuuTru = "select * from luutru";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimLuuTru, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);


            rs = pres.executeQuery();
            //System.out.println(pres);
            
            //System.out.println(rs.getString(""));
            while(rs.next()){
                LuuTru_DTO lt = new LuuTru_DTO();
                
                lt.setMaLT(rs.getString(1));
                lt.setMaSV(rs.getString(2));
                lt.setPhong(rs.getString(3));
                lt.setToa(rs.getString(4));
                lt.setNgayThue(rs.getDate(5));
                lt.setNgayKT(rs.getDate(6));
                lt.setDaThanhToan(rs.getBoolean(7));
                
                result.add(lt);
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
    
    public String layMaLT(String MaSV){
        String result = "";
        
        String sqlTimLuuTru = "select malt from luutru where masv = ? order by malt";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimLuuTru, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
            
            pres.setString(1, MaSV);
            rs = pres.executeQuery();
            //System.out.println(pres);
            if(rs.absolute(1) == false){
                result = "n1" + MaSV.substring(2, 6);
            }else{
                result = rs.getString(1);
                String temp = result.substring(1,2);
                int MaMoi = Integer.parseInt(temp);
                result = "n" + String.valueOf(MaMoi + 1) + MaSV.substring(2, 6);
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
