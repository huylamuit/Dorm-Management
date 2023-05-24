/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package qlktx;

import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qlktx.BLL.ThongTinHoaDon_BLL;
import qlktx.BLL.SinhVien_BLL;
import qlktx.DTO.SinhVien_DTO;
import qlktx.DTO.ThongTinHoaDon_DTO;



/**
 *
 * @author ASUS
 */
public class qltthd extends javax.swing.JPanel {

    ThongTinHoaDon_BLL tthdBLL = new ThongTinHoaDon_BLL();
    SinhVien_BLL svBLL = new SinhVien_BLL();
    public qltthd() {
        initComponents();
        this.setVisible(true);
        loadTableDSHD();
        txtMaHD.setEditable(false);
        txtTenSV.setEditable(false);
        datNgTao.setEnabled(false);
        txtTongTien.setEditable(false);
    }
    DefaultTableModel tblModelDSHD;
    private void loadTableDSHD(){
        tblModelDSHD = new DefaultTableModel();
        
        String tieude[] = {"Mã HD", "Tên SV", "Toa", "Phong", "Ngay TT"};
        tblModelDSHD.setColumnIdentifiers(tieude);
        
        ArrayList<ThongTinHoaDon_DTO> listhd = new ArrayList<ThongTinHoaDon_DTO>();
        listhd = tthdBLL.timTatCaHoaDon();
        int arrsize = listhd.size();
        
        ArrayList<SinhVien_DTO> listsv = new ArrayList<SinhVien_DTO>();
        for(int i = 0;i < arrsize; i++){
            SinhVien_DTO sv = svBLL.timSinhVien(listhd.get(i).getMaSV());
            listsv.add(sv);
            String mahd = listhd.get(i).getMaHD();
            String tensv = listsv.get(i).getTen();
            String toa = listsv.get(i).getToa();
            String phong = listsv.get(i).getPhong();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String ngtt;
            if(listhd.get(i).isThanhToan() == true){
                ngtt = df.format(listhd.get(i).getNgayTT());
            }else{
                ngtt = "";
            }
            
            Object[] row = {mahd, tensv, toa, phong, ngtt};
            tblModelDSHD.addRow(row);
        }
        
        tblDSHD.setModel(tblModelDSHD);
        setVisible(true);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();
        pnlContainer1 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        datNgTao = new com.toedter.calendar.JDateChooser();
        txtCTHD = new javax.swing.JTextField();
        txtTenSV = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSHD = new javax.swing.JTable();

        setBackground(new java.awt.Color(94, 119, 141));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContainer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThanhToan.setBackground(new java.awt.Color(237, 236, 164));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        pnlContainer1.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 480, 120, 40));

        jLabel2.setText("Mã hóa đơn:");
        pnlContainer1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 70, 20));

        jLabel4.setText("Tên sinh viên:");
        pnlContainer1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, -1, -1));

        jLabel5.setText("Chi tiết hóa đơn:");
        pnlContainer1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, -1, 50));

        jLabel6.setText("Ngày tạo:");
        pnlContainer1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, -1, -1));

        jLabel7.setText("Tổng tiền:");
        pnlContainer1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, -1, -1));
        pnlContainer1.add(txtMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, 330, -1));
        pnlContainer1.add(datNgTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, 330, -1));

        txtCTHD.setText("Nhập chi tiết hóa đơn");
        pnlContainer1.add(txtCTHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 290, 330, 50));
        pnlContainer1.add(txtTenSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, 330, -1));
        pnlContainer1.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 380, 330, -1));

        tblDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDSHDMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSHD);

        pnlContainer1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 590, -1));

        pnlContainer.add(pnlContainer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 780));

        add(pnlContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1340, 780));
    }// </editor-fold>//GEN-END:initComponents

    private void tblDSHDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSHDMousePressed
        int indexTB = tblDSHD.getSelectedRow();
        
        if(indexTB >= 0 && indexTB <= tblModelDSHD.getRowCount()){
            String mahd = tblModelDSHD.getValueAt(indexTB, 0).toString();
            String tensv = tblModelDSHD.getValueAt(indexTB, 1).toString();
            ThongTinHoaDon_DTO hd = tthdBLL.timHoaDon(mahd);
            
            txtMaHD.setText(mahd);
            txtTenSV.setText(tensv);
            datNgTao.setDate(hd.getNgayTao());
            txtTongTien.setText(String.valueOf(hd.getTongTien()));
        }
    }//GEN-LAST:event_tblDSHDMousePressed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        
        ThongTinHoaDon_DTO hd = new ThongTinHoaDon_DTO();
        hd = tthdBLL.timHoaDon(txtMaHD.getText());
        
        hd.setThanhToan(true);
        Date today = new Date();
        
        hd.setNgayTT(today);
        
        if(tthdBLL.suaHoaDon(hd) == 1){
            JOptionPane.showMessageDialog(null, "Cập nhật thanh toán thành công",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);        
        }else{
            JOptionPane.showMessageDialog(null, "Cập nhật thanh toán thất bại",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE); 
        }
        loadTableDSHD();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private com.toedter.calendar.JDateChooser datNgTao;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlContainer1;
    private javax.swing.JTable tblDSHD;
    private javax.swing.JTextField txtCTHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtTenSV;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}