/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlktx.Utils;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class DBUtils {
    private Connection conn;
    public DBUtils(){}
    public Connection createConn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/quanlyktx?useSSL=false","root","huy123");
            if (conn == null)
                System.out.println("Kết nối không thành công");
            else
                System.out.println("Kết nối thành công");
        } catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
