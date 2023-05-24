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
import qlktx.DTO.ThongTinHoaDon_DTO;
/**
 *
 * @author Administrator
 */
public class ThongTinHoaDon_DAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private Statement stat = null;
    private ResultSet rs = null;
    
    public String layMaHD(){
        String MaHD = "";
        String sqlSelectMaHD = "select mahd from thongtinhoadon order by mahd desc";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sqlSelectMaHD);
            if(rs.absolute(1) == false)
                MaHD = "HD00000001";
            else{
                String MaHDHienTai = rs.getString("MaHD");
                MaHD = MaHDHienTai.substring(2,10);
                int MaHDMoi = Integer.parseInt(MaHD) + 1;
                if (MaHDMoi < 10)
                    MaHD = "HD0000000" + MaHDMoi;
                else
                    if(MaHDMoi < 100)
                        MaHD = "HD000000" + MaHDMoi;
                    else
                        if (MaHDMoi < 1000)
                            MaHD = "HD00000" + MaHDMoi;
                        else
                            if (MaHDMoi < 10000)
                                MaHD = "HD0000" + MaHDMoi;
                            else
                                if(MaHDMoi < 100000)
                                    MaHD = "HD000" + MaHDMoi;
                                else
                                    if (MaHDMoi < 1000000)
                                        MaHD = "HD00" + MaHDMoi;
                                    else
                                        if (MaHDMoi < 10000000)
                                            MaHD = "HD0" + MaHDMoi;
                                        else
                                            MaHD = "HD" + MaHDMoi;
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Lỗi");
        }
        
        finally{
            try{
                conn.close();
                stat.close();
                rs.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return MaHD;
    }
    
    public int xoaHoaDon(String MaHD){
        int result = 0;
        String sqlUpdate = "delete from thongtinthanhtoan where mahd = ?";
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
        
    public int themHoaDon(ThongTinHoaDon_DTO hd){
        int result = 0;
        
        String sqlInsert = "insert into thongtinhoadon " 
                + "values(?, ?, ?, ?, ?, ?, ?)";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlInsert);
            
            pres.setString(1, hd.getMaHD());
            pres.setString(2, hd.getMaSV());
            pres.setString(3, hd.getChiTiet());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(4, df.format(hd.getNgayTao()));
            pres.setBoolean(5, hd.isThanhToan());
            
            pres.setString(6, df.format(hd.getNgayTT()));
            pres.setLong(7, hd.getTongTien());
            System.out.println(pres);
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
    
    public int suaHoaDon(ThongTinHoaDon_DTO hd){
        int result = 0;
        String sqlUpdate = "update thongtinhoadon set masv = ?, "
                + "chitiet = ?, "
                + "ngaytao = ?, "
                + "dathanhtoan = ?, "
                + "ngaythanhtoan = ?, "
                + "tongtien = ? "
                + "where mahd = ?";

        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlUpdate);
            
            pres.setString(1, hd.getMaSV());
            pres.setString(2, hd.getChiTiet());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(3, df.format(hd.getNgayTao()));
            pres.setBoolean(4, hd.isThanhToan());
            pres.setString(5, df.format(hd.getNgayTT()));
            pres.setLong(6, hd.getTongTien());
            pres.setString(7, hd.getMaHD());
            System.out.println(pres);
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
    
    public ThongTinHoaDon_DTO timHoaDon(String MaHD){
        ThongTinHoaDon_DTO result = new ThongTinHoaDon_DTO();
        
        String sqlTimHoaDon = "select * from thongtinhoadon where mahd = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimHoaDon);
            
            pres.setString(1, MaHD);
            rs = pres.executeQuery();
            //System.out.println(pres);
            
            //System.out.println(rs.getString("tenbn"));
            if(rs.next()){
                result.setMaHD(rs.getString(1));
                result.setMaSV(rs.getString(2));
                result.setChiTiet(rs.getString(3));
                result.setNgayTao(rs.getDate(4));
                result.setThanhToan(rs.getBoolean(5));
                result.setNgayTT(rs.getDate(6));
                result.setTongTien(rs.getLong(7));
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
    
    public ArrayList<ThongTinHoaDon_DTO> timTheoMaSV(String MaSV){
         ArrayList<ThongTinHoaDon_DTO> result = new ArrayList<ThongTinHoaDon_DTO>();
        
        String sqlTimHoaDon = "select * from thongtinhoadon where masv = ? ";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimHoaDon);
            
            pres.setString(1, MaSV);
            rs = pres.executeQuery();
            //System.out.println(pres);
            
            //System.out.println(rs.getString("tenbn"));
            while(rs.next()){
                ThongTinHoaDon_DTO hd = new ThongTinHoaDon_DTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaSV(rs.getString(2));
                hd.setChiTiet(rs.getString(3));
                hd.setNgayTao(rs.getDate(4));
                hd.setThanhToan(rs.getBoolean(5));
                hd.setNgayTT(rs.getDate(6));
                hd.setTongTien(rs.getLong(7));
                
                result.add(hd);
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
    
    public ThongTinHoaDon_DTO timTheoThang(int month, int year){
         ThongTinHoaDon_DTO hd = new ThongTinHoaDon_DTO();
        
        String sqlTimHoaDon = "select * from thongtinhoadon where month(ngaythanhtoan) = ?  and year(ngaythanhtoan) = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimHoaDon);
            
            pres.setInt(1, month);
            pres.setInt(2, year);
            rs = pres.executeQuery();
            //System.out.println(pres);
            
            //System.out.println(rs.getString("tenbn"));
           
            
            hd.setMaHD(rs.getString(1));
            hd.setMaSV(rs.getString(2));
            hd.setChiTiet(rs.getString(3));
            hd.setNgayTao(rs.getDate(4));
            hd.setThanhToan(rs.getBoolean(5));
            hd.setNgayTT(rs.getDate(6));
            hd.setTongTien(rs.getLong(7));
                
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
        return hd;
    }
    
    
    public ArrayList<ThongTinHoaDon_DTO> timTatCaHoaDon(){
        ArrayList<ThongTinHoaDon_DTO> result = new ArrayList<ThongTinHoaDon_DTO>();
        
        String sqlTimHoaDon = "select * from thongtinhoadon";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimHoaDon);


            rs = pres.executeQuery();
            //System.out.println(pres);
            
            //System.out.println(rs.getString(""));
            while(rs.next()){
                ThongTinHoaDon_DTO hd = new ThongTinHoaDon_DTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaSV(rs.getString(2));
                hd.setChiTiet(rs.getString(3));
                hd.setNgayTao(rs.getDate(4));
                hd.setThanhToan(rs.getBoolean(5));
                hd.setNgayTT(rs.getDate(6));
                hd.setTongTien(rs.getLong(7));
                
                result.add(hd);
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
  
    public int kiemtraThongTinHoaDon(ThongTinHoaDon_DTO hd){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if(df.format(hd.getNgayTT()).compareTo(df.format(hd.getNgayTao())) < 0){
                JOptionPane.showMessageDialog(null,
                        "Ngày tạo phải trước ngày thanh toán",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return 0;
        }
        return 1;
    }    
}
