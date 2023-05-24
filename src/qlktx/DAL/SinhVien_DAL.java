/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DAL;

import qlktx.DTO.SinhVien_DTO;
import qlktx.BLL.Phong_BLL;
import qlktx.DAL.Phong_DAL;
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
public class SinhVien_DAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private Statement stat = null;
    private ResultSet rs = null;
    private Phong_BLL phong = null;
    
    public String layMaSVTuDong(){
        String MaSV = "";
        String sqlSelectMaKB = "select masv from sinhvien order by masv desc";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sqlSelectMaKB);
            if(rs.absolute(1) == false)
                MaSV = "sv0001";
            else{
                String MaSVHienTai = rs.getString("masv");
                MaSV = MaSVHienTai.substring(2,6);
                int MaSVMoi = Integer.parseInt(MaSV) + 1;
                if(MaSVMoi < 10)
                    MaSV = "sv000" + MaSVMoi;
                else
                    if (MaSVMoi < 100)
                        MaSV = "sv00" + MaSVMoi;
                    else
                        if (MaSVMoi < 1000)
                            MaSV = "sv0" + MaSVMoi;
                        else
                            MaSV = "sv" + MaSVMoi;
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
        return MaSV;
    }
    
    public int xoaSinhVien(String MaSV){
        int result = 0;
        String sqlUpdate = "delete from sinhvien where masv = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlUpdate);
            pres.setString(1, MaSV);
            
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
        
    public int themSinhVien(SinhVien_DTO sv){
        int result = 0;
        
        String sqlInsert = "insert into sinhvien " 
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlInsert);
            
            pres.setString(1, sv.getMaSV());
            pres.setString(2, sv.getPassword());
            pres.setString(3, sv.getCCCD());
            pres.setString(4, sv.getTen());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(5, df.format(sv.getNgaySinh()));
            pres.setString(6, sv.getDiaChi());
            pres.setString(7, sv.getTruong());
            pres.setString(8, sv.getToa());
            pres.setString(9, sv.getPhong());
            pres.setString(10, sv.getSoDT());
            
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
    
    public int suaSinhVien(SinhVien_DTO sv){
        int result = 0;
        String sqlUpdate = "update sinhvien set password = ?, "
                + "cccd = ?, "
                + "ten = ?, "
                + "ngaysinh = ?, "
                + "diachi = ?, "
                + "truong = ?, "
                + "toa = ?, "
                + "phong = ?,"
                + "sodt = ? where masv = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlUpdate );
            pres.setString(1, sv.getPassword());
            pres.setString(2, sv.getCCCD());
            pres.setString(3, sv.getTen());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(4, df.format(sv.getNgaySinh()));
            pres.setString(5, sv.getDiaChi());
            pres.setString(6, sv.getTruong());
            pres.setString(7, sv.getToa());
            pres.setString(8, sv.getPhong());
            pres.setString(9, sv.getSoDT());
            pres.setString(10, sv.getMaSV());
            
            
            result = pres.executeUpdate();
            System.out.println(pres);
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
    
    public SinhVien_DTO timSinhVien(String MaSV){
        SinhVien_DTO result = new SinhVien_DTO();
        
        String sqlTimKiemSinhVien = "select * from sinhvien where masv = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimKiemSinhVien);
            
            pres.setString(1, MaSV);
            rs = pres.executeQuery();
            //System.out.println(pres);
            
            if(rs.next()){
                result.setMaSV(rs.getString(1));
                result.setPassword(rs.getString(2));
                result.setCCCD(rs.getString(3));
                result.setTen(rs.getString(4));
                result.setNgaySinh(rs.getDate(5));
                result.setDiaChi(rs.getString(6));
                result.setTruong(rs.getString(7));
                result.setToa(rs.getString(8));
                result.setPhong(rs.getString(9));
                result.setSoDT(rs.getString(10));
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
    
    public ArrayList<SinhVien_DTO> timTheoPhong(String Toa, String Phong){
         ArrayList<SinhVien_DTO> result = new ArrayList<SinhVien_DTO>();
        
        String sqlTimKiemSinhVien = "select * from sinhvien where toa = ? "
                + "and phong = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimKiemSinhVien);
            
            pres.setString(1, Toa);
            pres.setString(2, Phong);
            rs = pres.executeQuery();
            //System.out.println(pres);

            while(rs.next()){
                SinhVien_DTO sv = new SinhVien_DTO();
                
                sv.setMaSV(rs.getString(1));
                sv.setPassword(rs.getString(2));
                sv.setCCCD(rs.getString(3));
                sv.setTen(rs.getString(4));
                sv.setNgaySinh(rs.getDate(5));
                sv.setDiaChi(rs.getString(6));
                sv.setTruong(rs.getString(7));
                sv.setToa(rs.getString(8));
                sv.setPhong(rs.getString(9));
                sv.setSoDT(rs.getString(10));
                
                result.add(sv);
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
    

    
    public ArrayList<SinhVien_DTO> timTheoTen(String TenSV){
        ArrayList<SinhVien_DTO> result = new ArrayList<SinhVien_DTO>();
        
        String sqlTimKiemSinhVien = "select * from sinhvien where ten = ? "
                + "order by toa";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimKiemSinhVien);
            
            pres.setString(1, TenSV);
            rs = pres.executeQuery();
            System.out.println(pres);

            while(rs.next()){
                SinhVien_DTO sv = new SinhVien_DTO();
                
                sv.setMaSV(rs.getString(1));
                sv.setPassword(rs.getString(2));
                sv.setCCCD(rs.getString(3));
                sv.setTen(rs.getString(4));
                sv.setNgaySinh(rs.getDate(5));
                sv.setDiaChi(rs.getString(6));
                sv.setTruong(rs.getString(7));
                sv.setToa(rs.getString(8));
                sv.setPhong(rs.getString(9));
                sv.setSoDT(rs.getString(10));

                
                result.add(sv);
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
    
    public ArrayList<SinhVien_DTO> timTatCaSinhVien(){
        ArrayList<SinhVien_DTO> result = new ArrayList<SinhVien_DTO>();
        
        String sqlTimKiemSinhVien = "select * from sinhvien order by toa";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimKiemSinhVien);


            rs = pres.executeQuery();
            //System.out.println(pres);
    
            while(rs.next()){
                SinhVien_DTO sv = new SinhVien_DTO();
                
                sv.setMaSV(rs.getString(1));
                sv.setPassword(rs.getString(2));
                sv.setCCCD(rs.getString(3));
                sv.setTen(rs.getString(4));
                sv.setNgaySinh(rs.getDate(5));
                sv.setDiaChi(rs.getString(6));
                sv.setTruong(rs.getString(7));
                sv.setToa(rs.getString(8));
                sv.setPhong(rs.getString(9));
                sv.setSoDT(rs.getString(10));
                
                result.add(sv);
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
    
    public int kiemtraThongTinSinhVien(SinhVien_DTO sv){
        if (sv.getSoDT().matches("\\d{13}")){
            JOptionPane.showMessageDialog(null,"CCCD không đúng",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }
        if(sv.getTen().length() > 40){
            JOptionPane.showMessageDialog(null,"Tên quá dài",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }
        Date nowdate = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if(df.format(nowdate).compareTo(df.format(sv.getNgaySinh())) <= 0){
            JOptionPane.showMessageDialog(null,"Ngày sinh phải bé hơn ngày hiện tại",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }
        if(sv.getDiaChi().length() > 40){
            JOptionPane.showMessageDialog(null,"Dia chi quá dài",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }
        if(sv.getTruong().length() > 40){
            JOptionPane.showMessageDialog(null,"Tên trường quá dài",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }
        if (sv.getSoDT().matches("\\d{11}")){
            JOptionPane.showMessageDialog(null,"Số điện thoại không đúng",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }
        return 1;
    }
    
    public int kiemtraSinhVien(String MaSV){
        int result = 0;
        
        String sqlKiemTraSinhVien = "select * from sinhvien where masv = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlKiemTraSinhVien);
            
            pres.setString(1, MaSV);
            rs = pres.executeQuery();
            if(rs.next()){
                result = 1;
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
