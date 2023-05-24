/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlktx;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import qlktx.BLL.Toa_BLL;
import qlktx.DAL.Toa_DAL;
import qlktx.DTO.Toa_DTO;

/**
 *
 * @author ASUS
 */
public class KTFrame extends javax.swing.JFrame {
    private JPanel childPanel;
    /**
     * Creates new form TTFrame
     */
    
    private String matoa;
    private String id;
    public KTFrame(String ID) {
        initComponents();
        this.setTitle("Quản Lý Kí Túc Xá");
        id = ID;
        Toa_BLL tBLL = new Toa_BLL();
        Toa_DTO t = new Toa_DTO();
        Toa_DAL tDAL = new Toa_DAL();
        
        t = tDAL.timToaTheoTruongToa(id);
        matoa = t.getMaT();
        btnBack.setVisible(false);
    }
   
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        pnlQuanLy = new javax.swing.JPanel();
        btnThemSV = new javax.swing.JButton();
        btnThemHDDN = new javax.swing.JButton();
        pnlMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(68, 76, 88));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBackground(new java.awt.Color(68, 76, 88));
        btnBack.setActionCommand("btnBack");
        ImageIcon avt = new ImageIcon("image/left-arrow.png");
        Image userImage = avt.getImage();
        Image modifiedImage = userImage.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH);
        avt = new ImageIcon(modifiedImage);
        btnBack.setIcon(avt);
        btnBack.setVisible(false);
        btnBack.setBorder(null);
        btnBack.setFocusable(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 50, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 80));

        pnlQuanLy.setBackground(new java.awt.Color(94, 119, 141));
        pnlQuanLy.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThemSV.setBackground(new java.awt.Color(255, 255, 255));
        btnThemSV.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btnThemSV.setText("Hóa đơn lưu trú");
        btnThemSV.setAlignmentY(0.0F);
        btnThemSV.setPreferredSize(new java.awt.Dimension(940, 420));
        btnThemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSVActionPerformed(evt);
            }
        });
        pnlQuanLy.add(btnThemSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1420, -1));

        btnThemHDDN.setBackground(new java.awt.Color(255, 255, 255));
        btnThemHDDN.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btnThemHDDN.setText("Hóa đơn điện nước");
        btnThemHDDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHDDNActionPerformed(evt);
            }
        });
        pnlQuanLy.add(btnThemHDDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 1420, 480));

        getContentPane().add(pnlQuanLy, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1440, 950));

        pnlMain.setBackground(new java.awt.Color(94, 119, 141));
        pnlMain.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1440, 950));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSVActionPerformed
        // TODO add your handling code here:
        childPanel = new qltthd();
        btnBack.setVisible(true);
        pnlQuanLy.setVisible(false);
        pnlMain.add(childPanel);
        pnlMain.validate();
    }//GEN-LAST:event_btnThemSVActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        pnlMain.removeAll();
        pnlQuanLy.setVisible(true);
     
        
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnThemHDDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHDDNActionPerformed
        // TODO add your handling code here:
        childPanel = new qlhddnForm();
        btnBack.setVisible(true);
        pnlQuanLy.setVisible(false);
        pnlMain.add(childPanel);
        pnlMain.validate();
    }//GEN-LAST:event_btnThemHDDNActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnThemHDDN;
    private javax.swing.JButton btnThemSV;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlQuanLy;
    // End of variables declaration//GEN-END:variables
}