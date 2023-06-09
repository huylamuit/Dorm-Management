/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlktx;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import qlktx.BLL.ThongBao_BLL;
import qlktx.DAL.ThongBao_DAL;
import qlktx.DTO.ThongBao_DTO;

/**
 *
 * @author ASUS
 */
public class ThongBaoForm extends javax.swing.JFrame {

    /**
     * Creates new form themThongBaoForm
     */

    private String tacgia;
    private String maTB = "";
    public ThongBaoForm(String tacgia) {
        
        initComponents();
        this.tacgia = tacgia;
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);
    }
     public ThongBaoForm(String tacgia, String matb) {
        
        initComponents();
        this.tacgia = tacgia;
        ThongBao_DAL tbDAL = new ThongBao_DAL();
        ThongBao_DTO test = new ThongBao_DTO();
        test = tbDAL.timThongBao(matb);
        txtChuDe.setText(test.getChuDe());
        tpNoiDung.setText(test.getNoiDung());
        btnUpload.setVisible(false);
        
        this.maTB = matb;
        
    }
     
      public ThongBaoForm(String tacgia, String matb, String sinhvien) {
        
        initComponents();
        this.tacgia = tacgia;
        ThongBao_DAL tbDAL = new ThongBao_DAL();
        ThongBao_DTO test = new ThongBao_DTO();
        test = tbDAL.timThongBao(matb);
        txtChuDe.setText(test.getChuDe());
        tpNoiDung.setText(test.getNoiDung());
        tpNoiDung.setEditable(false);
        txtChuDe.setEditable(false);
        btnUpload.setVisible(false);
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);
        
        this.maTB = matb;
        
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tpNoiDung = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        txtChuDe = new javax.swing.JTextField();
        btnUpload = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(94, 119, 141));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tpNoiDung.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jScrollPane2.setViewportView(tpNoiDung);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 950, 240));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 0));
        jLabel1.setText("Chủ Đề: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, 100));

        txtChuDe.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtChuDe.setBorder(null);
        txtChuDe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtChuDeFocusGained(evt);
            }
        });
        txtChuDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtChuDeMouseExited(evt);
            }
        });
        txtChuDe.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtChuDeInputMethodTextChanged(evt);
            }
        });
        jPanel1.add(txtChuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 700, 50));

        btnUpload.setText("Đăng");
        btnUpload.setFocusable(false);
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, 90, 40));

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, 90, 40));

        btnDelete.setText("Xóa");
        btnDelete.setFocusable(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 460, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtChuDeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtChuDeMouseExited
        // TODO add your handling code here:
         //txtChuDe.setBackground(new Color(102,0,0));
    }//GEN-LAST:event_txtChuDeMouseExited

    private void txtChuDeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtChuDeFocusGained
        // TODO add your handling code here:
        // txtChuDe.setBackground(new Color(102,0,0));
    }//GEN-LAST:event_txtChuDeFocusGained

    private void txtChuDeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtChuDeInputMethodTextChanged
        // TODO add your handling code here:
        txtChuDe.setBackground(new Color(102,0,0));
    }//GEN-LAST:event_txtChuDeInputMethodTextChanged

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        ThongBao_BLL tbBLL = new ThongBao_BLL();
        ThongBao_DTO tb = new ThongBao_DTO();
        ThongBao_DAL tbDAL = new ThongBao_DAL();
        maTB = tbDAL.layMaThongBao(tacgia);
        tb.setMaTB(maTB);
        tb.setTacGia(tacgia);
        tb.setChuDe(txtChuDe.getText());
        tb.setNoiDung(tpNoiDung.getText());
        java.util.Date date= new java.util.Date();
        tb.setNgayDang(date);
        tbDAL.themThongBao(tb);
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        ThongBao_DAL tbDAL = new ThongBao_DAL();
        ThongBao_DTO tb = new ThongBao_DTO();
        tb.setMaTB(maTB);
        tb.setTacGia(tacgia);
        tb.setChuDe(txtChuDe.getText());
        tb.setNoiDung(tpNoiDung.getText());
        java.util.Date date= new java.util.Date();
        tb.setNgayDang(date);
        tbDAL.suaThongBao(tb);
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        ThongBao_DAL tbDAL = new ThongBao_DAL();
  
          int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa dữ liệu?",
                        "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION){
                try{
                    int result =       tbDAL.xoaThongBao(maTB);
                    if(result != 0){
                        
                        JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công",
                                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongBaoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongBaoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongBaoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongBaoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongBaoForm("tt0001").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane tpNoiDung;
    private javax.swing.JTextField txtChuDe;
    // End of variables declaration//GEN-END:variables
}
