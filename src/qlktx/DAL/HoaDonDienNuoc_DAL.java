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
import qlktx.DTO.HoaDonDienNuoc_DTO;
/**
 *
 * @author Administrator
 */
public class HoaDonDienNuoc_DAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private Statement stat = null;
    private ResultSet rs = null;
    
    public String layMaHD(){
        String MaHD = "";
        String sqlSelectMaHD = "select mahd from hoadondiennuoc order by mahd desc";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sqlSelectMaHD);
            if(rs.absolute(1) == false)
                MaHD = "DN00000001";
            else{
                String MaHDHienTai = rs.getString("MaHD");
                MaHD = MaHDHienTai.substring(2,10);
                int MaHDMoi = Integer.parseInt(MaHD) + 1;
                if (MaHDMoi < 10)
                    MaHD = "DN0000000" + MaHDMoi;
                else
                    if(MaHDMoi < 100)
                        MaHD = "DN000000" + MaHDMoi;
                    else
                        if (MaHDMoi < 1000)
                            MaHD = "DN00000" + MaHDMoi;
                        else
                            if (MaHDMoi < 10000)
                                MaHD = "DN0000" + MaHDMoi;
                            else
                                if(MaHDMoi < 100000)
                                    MaHD = "DN000" + MaHDMoi;
                                else
                                    if (MaHDMoi < 1000000)
                                        MaHD = "DN00" + MaHDMoi;
                                    else
                                        if (MaHDMoi < 10000000)
                                            MaHD = "DN0" + MaHDMoi;
                                        else
                                            MaHD = "DN" + MaHDMoi;
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
        String sqlUpdate = "delete from hoadondiennuoc where mahd = ?";
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
        
    public int themHoaDon(HoaDonDienNuoc_DTO hd){
        int result = 0;
        
        String sqlInsert = "insert into hoadondiennuoc " 
                + "values(?,?,?,?,?,?,?,?)";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlInsert);
            
            pres.setString(1, hd.getMaHD());
            pres.setString(2, hd.getToa());
            pres.setString(3, hd.getPhong()); 
            pres.setString(4, hd.getChiTiet());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(5, df.format(hd.getNgayTao()));
            pres.setBoolean(6, hd.isThanhToan());           
            pres.setString(7, df.format(hd.getNgayTT()));
            pres.setLong(8, hd.getTongTien());
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
    
    public int suaHoaDon(HoaDonDienNuoc_DTO hd){
        int result = 0;
        String sqlUpdate = "update hoadondiennuoc set toa = ?, "
                + "phong = ?, "
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
            
            pres.setString(1, hd.getToa());
            pres.setString(2, hd.getPhong());
            pres.setString(3, hd.getChiTiet());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(4, df.format(hd.getNgayTao()));
            pres.setBoolean(5, hd.isThanhToan());
            pres.setString(6, df.format(hd.getNgayTT()));
            pres.setLong(7, hd.getTongTien());
            pres.setString(8, hd.getMaHD());
            
            
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
    
    public HoaDonDienNuoc_DTO timHoaDon(String MaHD){
        HoaDonDienNuoc_DTO result = new HoaDonDienNuoc_DTO();
        
        String sqlTimHoaDon = "select * from hoadondiennuoc where mahd = ?";
        
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
                result.setToa(rs.getString(2));
                result.setPhong(rs.getString(3));
                result.setChiTiet(rs.getString(4));
                result.setNgayTao(rs.getDate(5));
                result.setThanhToan(rs.getBoolean(6));
                result.setNgayTT(rs.getDate(7));
                result.setTongTien(rs.getLong(8));
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
    
    public HoaDonDienNuoc_DTO timTheoPhongToa(String Toa, String Phong, int thang, int nam){
         HoaDonDienNuoc_DTO hd = new HoaDonDienNuoc_DTO();
        
        String sqlTimHoaDon = "select * from hoadondiennuoc where toa = ? "
                + "and phong = ? and month(ngaythanhtoan) = ? and year(ngaythanhtoan)= ? ";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimHoaDon);
            
            pres.setString(1, Toa);
            pres.setString(2, Phong);
            pres.setInt(3, thang);
            pres.setInt(4, nam);
            System.out.println(pres);
            rs = pres.executeQuery(); 
            if(rs.next()){
              hd.setMaHD(rs.getString(1));
              hd.setToa(rs.getString(2));
              hd.setPhong(rs.getString(3));
              hd.setChiTiet(rs.getString(4));
              hd.setNgayTao(rs.getDate(5));
              hd.setThanhToan(rs.getBoolean(6));
              hd.setNgayTT(rs.getDate(7));
              hd.setTongTien(rs.getLong(8));
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
        return hd;
    }
    
    public ArrayList<HoaDonDienNuoc_DTO> timTatCaHoaDon(){
        ArrayList<HoaDonDienNuoc_DTO> result = new ArrayList<HoaDonDienNuoc_DTO>();
        
        String sqlTimHoaDon = "select * from hoadondiennuoc";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimHoaDon);


            rs = pres.executeQuery();
            //System.out.println(pres);
            
            //System.out.println(rs.getString(""));
            while(rs.next()){
                HoaDonDienNuoc_DTO hd = new HoaDonDienNuoc_DTO();
                
                hd.setMaHD(rs.getString(1));
                hd.setToa(rs.getString(2));
                hd.setPhong(rs.getString(3));
                hd.setChiTiet(rs.getString(4));
                hd.setNgayTao(rs.getDate(5));
                hd.setThanhToan(rs.getBoolean(6));
                hd.setNgayTT(rs.getDate(7));
                hd.setTongTien(rs.getLong(8));
                
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
  
    public int kiemtraThongTinHoaDon(HoaDonDienNuoc_DTO hd){
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
