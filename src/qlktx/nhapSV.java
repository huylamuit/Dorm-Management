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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qlktx.BLL.Phong_BLL;
import qlktx.BLL.SinhVien_BLL;
import qlktx.BLL.Toa_BLL;
import qlktx.DTO.Phong_DTO;
import qlktx.DTO.SinhVien_DTO;
import qlktx.DTO.Toa_DTO;

/**
 *
 * @author ASUS
 */
public class nhapSV extends javax.swing.JPanel {

    /**
     * Creates new form qlphongForm
     */
    SinhVien_BLL svBLL = new SinhVien_BLL();
    Phong_BLL phongBLL = new Phong_BLL();
    Toa_BLL toaBLL = new Toa_BLL();
    
    String MaKT;

    public nhapSV(String MaKT) {
        initComponents();
        this.MaKT = MaKT;
        this.setVisible(true);
        loadToa();
        loadPhong();
        btnSua.setEnabled(false);
        btnSua.setVisible(false);
    }
    String MaToa_C;
    String MaSV_C;
    public nhapSV(String MaSV, String Toa) {
        initComponents();
        this.setVisible(true);
        cbbToa.setEnabled(false);
        Toa_DTO toa = toaBLL.timToa(Toa);
        MaToa_C = toa.getMaT();
        MaSV_C = MaSV;
        String Item = "Nam";
        cbbToa.setModel(new DefaultComboBoxModel <>(new String[] 
        {Toa, Toa}));
        //loadToa();
        SinhVien_DTO sv = svBLL.timSinhVien(MaSV);
        loadPhong2(Toa);
        txtCCCD.setText(sv.getCCCD());
        txtDiaChi.setText(sv.getDiaChi());
        txtSDT.setText(sv.getSoDT());
        txtTen.setText(sv.getTen());
        txtTruong.setText(sv.getTruong());
        datNgSinh.setDate(sv.getNgaySinh());
        btnThem.setVisible(false);
    }
    
    
    ArrayList<String> arrtoatrong = new ArrayList<String>();
    ArrayList<String> arrmatoatrong = new ArrayList<String>();
    

    public void loadToa(){
        arrtoatrong.removeAll(arrtoatrong);
        arrmatoatrong.removeAll(arrmatoatrong);
        
        Toa_DTO toa = new Toa_DTO();
        
        
        int[] slp;
        int[] slpt;
        
        ArrayList<Toa_DTO> arrtoa = new ArrayList<Toa_DTO>();
        arrtoa = toaBLL.timTatCaToa();
        int arrSize = arrtoa.size();
        slp = new int[arrSize];
        slpt = new int[arrSize];
        
        for(int i = 0; i < arrSize; i++){
            String MaToa = arrtoa.get(i).getMaT();
 
            slp[i] = toaBLL.demSoLuongPhong(MaToa);
            arrtoa.get(i).setSLP(slp[i]);
            slpt[i] = toaBLL.demSoLuongPhongTrong(MaToa);
            arrtoa.get(i).setSLPT(slpt[i]);
            
            toaBLL.suaToa(arrtoa.get(i));
        }
        for(int i = 0; i < arrSize; i++){
            if (arrtoa.get(i).getSLPT() > 0){
                arrtoatrong.add(arrtoa.get(i).getTenT());
                arrmatoatrong.add(arrtoa.get(i).getMaT());
            }
            //System.out.println(slp[i] + "\t" + slpt[i] + "\n");
        }
        //arrtoatrong.toString();
        cbbToa.setModel(new DefaultComboBoxModel<String>(
            arrtoatrong.toArray(new String[0])));
        loadPhong();
    }
    
    ArrayList<String> arrmaphongtrong = new ArrayList<String>();
    public void loadPhong(){
        arrmaphongtrong.removeAll(arrmaphongtrong);
        
        ArrayList<Phong_DTO> arrphong = new ArrayList<Phong_DTO>();
        
        
        String MaToa = arrmatoatrong.get(cbbToa.getSelectedIndex());
        System.out.println(MaToa);
        int arrsize = toaBLL.demSoLuongPhong(MaToa);
        arrphong = phongBLL.timPhongTheoToa(MaToa);
        for(int i = 0; i < arrsize; i++){
            Phong_DTO phong = phongBLL.timPhong(arrphong.get(i).getMaP(),arrphong.get(i).getMaT());
            int x = phong.getLoaiP();
            if(phongBLL.phongday(arrphong.get(i).getMaP(), x) == false){
                arrmaphongtrong.add(arrphong.get(i).getMaP());
            }
        }
        cbbPhong.setModel(new DefaultComboBoxModel<String>(
            arrmaphongtrong.toArray(new String[0])));
        //int slmp = phongBLL.demSoLuongMotPhong();
    }
    
    public void loadPhong2(String MaToa){
        arrmaphongtrong.removeAll(arrmaphongtrong);
        
        ArrayList<Phong_DTO> arrphong = new ArrayList<Phong_DTO>();
        
        //String MaToa = arrmatoatrong.get(cbbToa.getSelectedIndex());
        System.out.println(MaToa);
        int arrsize = toaBLL.demSoLuongPhong(MaToa);
        arrphong = phongBLL.timPhongTheoToa(MaToa);
        for(int i = 0; i < arrsize; i++){
            Phong_DTO phong = phongBLL.timPhong(arrphong.get(i).getMaP(),arrphong.get(i).getMaT());
            int x = phong.getLoaiP();
            if(phongBLL.phongday(arrphong.get(i).getMaP(), x) == false){
                arrmaphongtrong.add(arrphong.get(i).getMaP());
            }
        }
        cbbPhong.setModel(new DefaultComboBoxModel<String>(
            arrmaphongtrong.toArray(new String[0])));
        //int slmp = phongBLL.demSoLuongMotPhong();
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
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        datNgSinh = new com.toedter.calendar.JDateChooser();
        txtDiaChi = new javax.swing.JTextField();
        txtTruong = new javax.swing.JTextField();
        cbbToa = new javax.swing.JComboBox<>();
        cbbPhong = new javax.swing.JComboBox<>();
        txtSDT = new javax.swing.JTextField();

        setBackground(new java.awt.Color(94, 119, 141));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContainer.setPreferredSize(new java.awt.Dimension(1380, 880));
        pnlContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContainer1.setPreferredSize(new java.awt.Dimension(1380, 880));
        pnlContainer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThem.setBackground(new java.awt.Color(237, 236, 164));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnlContainer1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 550, 120, 40));

        btnSua.setBackground(new java.awt.Color(236, 139, 139));
        btnSua.setForeground(new java.awt.Color(255, 255, 102));
        btnSua.setText("Chỉnh sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnlContainer1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 550, 120, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("CCCD:");
        pnlContainer1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 60, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên:");
        pnlContainer1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 70, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ngày sinh:");
        pnlContainer1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 90, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Địa chỉ:");
        pnlContainer1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 70, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Trường:");
        pnlContainer1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 70, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tòa:");
        pnlContainer1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 50, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Phòng:");
        pnlContainer1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 60, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("SDT:");
        pnlContainer1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 50, -1));
        pnlContainer1.add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 330, -1));
        pnlContainer1.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 330, -1));
        pnlContainer1.add(datNgSinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 330, -1));
        pnlContainer1.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 330, -1));

        txtTruong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTruongActionPerformed(evt);
            }
        });
        pnlContainer1.add(txtTruong, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 330, -1));

        cbbToa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbToa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbToaActionPerformed(evt);
            }
        });
        pnlContainer1.add(cbbToa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 330, -1));

        cbbPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlContainer1.add(cbbPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 330, -1));
        pnlContainer1.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 330, -1));

        pnlContainer.add(pnlContainer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 880));

        add(pnlContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 880));
    }// </editor-fold>//GEN-END:initComponents
    
    DefaultTableModel tblModelTTSV;

    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        
        SinhVien_DTO sv = new SinhVien_DTO();
        String MaSV = svBLL.layMaSinhVien();
        sv.setMaSV(MaSV);
        sv.setCCCD(txtCCCD.getText());
        sv.setPassword(MaSV);
        sv.setDiaChi(txtDiaChi.getText());
        sv.setSoDT(txtSDT.getText());
        sv.setNgaySinh(datNgSinh.getDate());
        sv.setToa(arrmatoatrong.get(cbbToa.getSelectedIndex()));
        sv.setPhong(arrmaphongtrong.get(cbbPhong.getSelectedIndex()));
        sv.setTen(txtTen.getText());
        sv.setTruong(txtTruong.getText());
        int check_flag = svBLL.kiemtraThongTinSinhVien(sv);
        if(check_flag == 1){
            if(svBLL.themSinhVien(sv) == 1){
                JOptionPane.showMessageDialog(null,"Thêm sinh viên thành công",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Không thêm được",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }            
            
    // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        SinhVien_DTO sv = new SinhVien_DTO();
        sv.setMaSV(MaSV_C);
        sv.setPassword(MaSV_C);
        sv.setCCCD(txtCCCD.getText());
        sv.setDiaChi(txtDiaChi.getText());
        sv.setSoDT(txtSDT.getText());
        sv.setNgaySinh(datNgSinh.getDate());
        sv.setToa(MaToa_C);
        sv.setPhong(arrmaphongtrong.get(cbbPhong.getSelectedIndex()));
        sv.setTen(txtTen.getText());
        sv.setTruong(txtTruong.getText());
        int check_flag = svBLL.kiemtraThongTinSinhVien(sv);
        if(check_flag == 1){
            if(svBLL.suaSinhVien(sv) == 1){
                JOptionPane.showMessageDialog(null,"Sửa sinh viên thành công",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Chưa cập nhật được thông tin",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }   
    }//GEN-LAST:event_btnSuaActionPerformed

    private void cbbToaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbToaActionPerformed
        loadPhong();
    }//GEN-LAST:event_cbbToaActionPerformed

    private void txtTruongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTruongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTruongActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbPhong;
    private javax.swing.JComboBox<String> cbbToa;
    private com.toedter.calendar.JDateChooser datNgSinh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlContainer1;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTruong;
    // End of variables declaration//GEN-END:variables
}
