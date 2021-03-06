/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import DAO.NhanVienDAO;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sangt
 */
public class NhanVien extends javax.swing.JFrame {

    DefaultTableModel model;
    Model.NhanVien nv;
    int index;

    /**
     * Creates new form ChuyenDe
     */
    public NhanVien(Model.NhanVien nv) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icon/nhanvien24.png")));
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        this.nv = nv;
        NhanVienDAO.loadNhanVien();
        model = (DefaultTableModel) tb_fillNV.getModel();
//        if(model.getRowCount()>0){
//            index=1;
//            showdetail();
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pn_main = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pn_btn = new javax.swing.JPanel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_lammoi = new javax.swing.JButton();
        btn_timkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_fillNV = new javax.swing.JTable();
        tf_ma = new javax.swing.JTextField();
        tf_hoten = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rbtn_truongphong = new javax.swing.JRadioButton();
        rbtn_nhanvien = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_email = new javax.swing.JTextField();
        tf_matkhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUA??N LY?? NH??N VI??N");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ma?? nh??n vi??n:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("M????t kh????u:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Vai tro??:");

        pn_btn.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        btn_them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/them.png"))); // NOI18N
        btn_them.setText("Th??m    ");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        pn_btn.add(btn_them);

        btn_sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua.png"))); // NOI18N
        btn_sua.setText("S????a     ");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        pn_btn.add(btn_sua);

        btn_xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/xoa.png"))); // NOI18N
        btn_xoa.setText("Xo??a       ");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        pn_btn.add(btn_xoa);

        btn_lammoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_lammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/lammoi.png"))); // NOI18N
        btn_lammoi.setText("La??m m????i");
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });
        pn_btn.add(btn_lammoi);

        btn_timkiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        btn_timkiem.setText("Ti??m Ki????m");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });
        pn_btn.add(btn_timkiem);

        tb_fillNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma?? nh??n vi??n", "Ho?? t??n", "Email", "Vai tro??"
            }
        ));
        tb_fillNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_fillNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_fillNV);

        tf_ma.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tf_hoten.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setText("Ba??ng nh??n vi??n:");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/trolai.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ho?? va?? t??n:");

        buttonGroup1.add(rbtn_truongphong);
        rbtn_truongphong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtn_truongphong.setSelected(true);
        rbtn_truongphong.setText("Tr??????ng pho??ng");
        rbtn_truongphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_truongphongActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtn_nhanvien);
        rbtn_nhanvien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtn_nhanvien.setText("Nh??n vi??n");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Qua??n ly?? nh??n vi??n");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Email:");

        tf_email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout pn_mainLayout = new javax.swing.GroupLayout(pn_main);
        pn_main.setLayout(pn_mainLayout);
        pn_mainLayout.setHorizontalGroup(
            pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_mainLayout.createSequentialGroup()
                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_mainLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pn_mainLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(197, 197, 197)
                        .addComponent(jLabel6))
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(56, 56, 56)
                        .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pn_mainLayout.createSequentialGroup()
                                .addComponent(rbtn_truongphong)
                                .addGap(27, 27, 27)
                                .addComponent(rbtn_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_hoten, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(tf_ma)
                            .addComponent(tf_email)
                            .addComponent(tf_matkhau))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pn_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pn_mainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tf_hoten, tf_ma});

        pn_mainLayout.setVerticalGroup(
            pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_mainLayout.createSequentialGroup()
                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_mainLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_mainLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pn_mainLayout.createSequentialGroup()
                                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(pn_mainLayout.createSequentialGroup()
                                        .addComponent(tf_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(tf_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(21, 21, 21)
                                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(tf_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(21, 21, 21)
                                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbtn_truongphong)
                                    .addComponent(rbtn_nhanvien)
                                    .addComponent(jLabel4)))
                            .addComponent(pn_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void clear() {
        tf_ma.setText("");
        tf_hoten.setText("");
        tf_matkhau.setText("");
        rbtn_truongphong.setSelected(true);

    }

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        String ma = tf_ma.getText().trim();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lo??ng nh????p ma?? nh??n vi??n");
            return;
        }
        int hoi = JOptionPane.showConfirmDialog(this, "Ba??n co?? mu????n ??u????i vi????c nh??n vi??n na??y?", "??u????i vi????c", JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
            if (nv.getVaitro() == 1) {
                JOptionPane.showMessageDialog(this, "ch??? tr?????ng ph??ng m???i ???????c d??ng ch???c n??ng n??y");
                return;
            }

            if (tf_ma.getText().equals(nv.getMaNv())) {
                JOptionPane.showMessageDialog(this, "Ba??n kh??ng th???? ??u????i vi????c chi??nh mi??nh!");
                return;
            }
            NhanVienDAO.xoaNV(ma);
            NhanVienDAO.loadNhanVien();
            JOptionPane.showMessageDialog(this, "Nh??n vi??n " + tf_hoten.getText() + " ??a?? bi?? ??u????i vi????c!");
            clear();
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        System.out.println("tr???? la??i");
        this.dispose();
        new Main(nv);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void rbtn_truongphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_truongphongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_truongphongActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        String ma = tf_ma.getText().trim();
        String matkhau = tf_matkhau.getText().trim();
        String hoten = tf_hoten.getText().trim();
        String email = tf_email.getText().trim();
        try {
            if (ma.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lo??ng nh????p ma?? nh??n vi??n");
                return;
            }
            if (matkhau.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lo??ng nh????p m????t kh????u");
                return;
            }
            if (hoten.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lo??ng nh????p ho?? t??n nh??n vi??n");
                return;
            }
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lo??ng nh????p email");
                return;
            }
            String checkEmail = "\\w+@\\w+(\\.\\w+){1,2}";
            if (!email.matches(checkEmail)) {
                JOptionPane.showMessageDialog(this, "Email kh??ng h???p l???");
                tf_email.setBackground(Color.yellow);
                tf_email.requestFocus();
                return;
            }

            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).equals(ma)) {
                    JOptionPane.showMessageDialog(this, "Tr??ng m?? nh??n vi??n");
                    return;
                }
                if (model.getValueAt(i, 2).equals(email)) {
                    JOptionPane.showMessageDialog(this, "Tr??ng email");
                    return;
                }

            }

            int vaitro = rbtn_truongphong.isSelected() ? 0 : 1;

            NhanVienDAO.themNV(ma, matkhau, hoten, email, vaitro);
            NhanVienDAO.loadNhanVien();
            showdetail();
            JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng");
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
        clear();
        NhanVienDAO.loadNhanVien();
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void tb_fillNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_fillNVMouseClicked
        showdetail();
    }//GEN-LAST:event_tb_fillNVMouseClicked

    public void showdetail() {
        // TODO add your handling code here:
        index = tb_fillNV.getSelectedRow();
        tf_ma.setText(String.valueOf(tb_fillNV.getValueAt(index, 0)));
        tf_hoten.setText(String.valueOf(tb_fillNV.getValueAt(index, 1)));
        tf_email.setText(String.valueOf(tb_fillNV.getValueAt(index, 2)));
        if (tb_fillNV.getValueAt(index, 3).equals("Tr??????ng pho??ng")) {
            rbtn_truongphong.setSelected(true);
        } else {
            rbtn_nhanvien.setSelected(true);
        }
        tb_fillNV.setRowSelectionInterval(index, index);
    }

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        String ma = tf_ma.getText().trim();
        String hoten = tf_hoten.getText().trim();
        String email = tf_email.getText().trim();

        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lo??ng nh????p ma?? nh??n vi??n");
            return;
        }
        if (ma.equals(nv.getMaNv()) && rbtn_nhanvien.isSelected()) {
            JOptionPane.showMessageDialog(this, "Kh??ng ????????c gia??ng ch????c chi??nh mi??nh!");
            return;
        }
        if (hoten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lo??ng nh????p ho?? t??n nh??n vi??n");
            return;
        }
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lo??ng nh????p email");
            return;
        }
        String checkEmail = "\\w+@\\w+(\\.\\w+){1,2}";
        if (!email.matches(checkEmail)) {
            JOptionPane.showMessageDialog(this, "Email kh??ng h???p l???");
            tf_email.setBackground(Color.yellow);
            tf_email.requestFocus();
            return;
        }

        int vaitro = rbtn_truongphong.isSelected() ? 0 : 1;
        NhanVienDAO.suaNV(ma, nv.getMatKhau(), hoten, email, vaitro);
        NhanVienDAO.loadNhanVien();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        boolean check = false;
        String ma = tf_ma.getText().trim();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lo??ng nh????p ma?? nh??n vi??n");
            return;
        }
        for (int i = 0; i < tb_fillNV.getRowCount(); i++) {
            if (ma.equals(tb_fillNV.getValueAt(i, 0))) {
                tb_fillNV.setRowSelectionInterval(i, i);
                showdetail();
                check = true;
            }
        }
        if (check == false) {
            JOptionPane.showMessageDialog(this, "Nh??n vi??n kh??ng t????n ta??i");
            return;
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

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
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pn_btn;
    private javax.swing.JPanel pn_main;
    private javax.swing.JRadioButton rbtn_nhanvien;
    private javax.swing.JRadioButton rbtn_truongphong;
    public static javax.swing.JTable tb_fillNV;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_hoten;
    private javax.swing.JTextField tf_ma;
    private javax.swing.JPasswordField tf_matkhau;
    // End of variables declaration//GEN-END:variables
}
