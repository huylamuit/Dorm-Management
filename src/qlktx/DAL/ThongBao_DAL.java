/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.DAL;
import qlktx.DTO.ThongBao_DTO;
import qlktx.Utils.*;
import java.sql.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
/**
 *
 * @author ASUS
 */
public class ThongBao_DAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private Statement stat = null;
    private ResultSet rs = null;
    
    public ThongBao_DTO timThongBao(String MaTB){
        ThongBao_DTO result = new ThongBao_DTO();
        
        String sqlTimKiemThongBao = "select * from thongbao where matb = ?";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimKiemThongBao);
            
            pres.setString(1, MaTB);
            rs = pres.executeQuery();
            //System.out.println(pres);
            
            if(rs.next()){
                result.setMaTB(rs.getString(1));
                result.setChuDe(rs.getString(2));
                result.setNoiDung(rs.getString(3));
                result.setNgayDang(rs.getDate(4));
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
    
    public ArrayList<ThongBao_DTO> timTatCaThongBao(){
        ArrayList<ThongBao_DTO> result = new ArrayList<ThongBao_DTO>();
        
        String sqlTimKiemThongBao = "select * from thongbao order by matb desc";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimKiemThongBao);

            rs = pres.executeQuery();
            //System.out.println(pres);
            
            while(rs.next()){
                ThongBao_DTO tb = new ThongBao_DTO();
                
                tb.setMaTB(rs.getString(1));
                tb.setChuDe(rs.getString(2));
                tb.setNoiDung(rs.getString(3));
                tb.setNgayDang(rs.getDate(4));
                
                result.add(tb);
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
    
     public ArrayList<ThongBao_DTO> timTatCaThongBaoTheoTruongToa(String tacgia){
        ArrayList<ThongBao_DTO> result = new ArrayList<ThongBao_DTO>();
        
        String sqlTimKiemThongBao = "select * from thongbao where tacgia = ? order by matb desc";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlTimKiemThongBao);
            pres.setString(1, tacgia);
            rs = pres.executeQuery();
            System.out.println(pres);
            System.out.println("DAL " + tacgia);
            //System.out.println(pres);
            
            while(rs.next()){
                ThongBao_DTO tb = new ThongBao_DTO();
                
                tb.setMaTB(rs.getString(1));
                tb.setChuDe(rs.getString(2));
                tb.setNoiDung(rs.getString(3));
                tb.setNgayDang(rs.getDate(4));
                
                result.add(tb);
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
    
    public String layMaThongBao(String id){
        String MaTB = "";
        String sqlSelectMaTB = "select matb from thongbao where tacgia = '"+ id +"' order by matb desc";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sqlSelectMaTB);
            if(rs.absolute(1) == false)
                MaTB = "TB00000001";
            else{
                String MaTBHienTai = rs.getString("MaTB");
                MaTB = MaTBHienTai.substring(2,10);
                int MaTBMoi = Integer.parseInt(MaTB) + 1;
                if (MaTBMoi < 10)
                    MaTB = "TB0000000" + MaTBMoi;
                else
                    if(MaTBMoi < 100)
                        MaTB = "TB000000" + MaTBMoi;
                    else
                        if (MaTBMoi < 1000)
                            MaTB = "TB00000" + MaTBMoi;
                        else
                            if (MaTBMoi < 10000)
                                MaTB = "TB0000" + MaTBMoi;
                            else
                                if(MaTBMoi < 100000)
                                    MaTB = "TB000" + MaTBMoi;
                                else
                                    if (MaTBMoi < 1000000)
                                        MaTB = "TB00" + MaTBMoi;
                                    else
                                        if (MaTBMoi < 10000000)
                                            MaTB = "TB0" + MaTBMoi;
                                        else
                                            MaTB = "TB" + MaTBMoi;
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
        return MaTB;
    }
    
    public int themThongBao(ThongBao_DTO tb){
        int result = 0;
        
        String sqlInsert = "insert into thongbao " 
                + "values(?,?,?,?,?);";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlInsert);
            
            pres.setString(1, tb.getMaTB());
            pres.setString(2, tb.getChuDe());
            pres.setString(3, tb.getNoiDung());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(4, df.format(tb.getNgayDang()));
            pres.setString(5, tb.getTacGia());
            
            result = pres.executeUpdate();
            
             JOptionPane.showMessageDialog(null, "Đăng tải thành công!",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            
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
    
       public int suaThongBao(ThongBao_DTO tb){
        int result = 0;
        String sqlUpdate = "update thongbao set chude = ?, noidung = ?,ngaydang = ?, tacgia = ? where matb = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlUpdate);
            
            
            pres.setString(1, tb.getChuDe());
            pres.setString(2, tb.getNoiDung());
             DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(3, df.format(tb.getNgayDang()));
           
            pres.setString(4, tb.getTacGia());
            pres.setString(5, tb.getMaTB());
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
       
        public int xoaThongBao(String MaTB){
        int result = 0;
        String sqlUpdate = "delete from thongbao where matb = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlUpdate);
            pres.setString(1, MaTB);
            
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

