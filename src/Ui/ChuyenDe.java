/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import DAO.ChuyenDeDAO;
import Database.DatabaseHelper;
import static Ui.KhoaHoc.tb_content;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sangt
 */
public class ChuyenDe extends javax.swing.JFrame {

    DefaultTableModel model;
    Model.NhanVien nv;
    int index;

    /**
     * Creates new form ChuyenDe
     */
    public ChuyenDe(Model.NhanVien nv) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icon/chuyende24.png")));
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        this.nv = nv;
        ChuyenDeDAO.loadChuyenDe();
        model = (DefaultTableModel) tb_content.getModel();
        if (tb_content.getRowCount() > 0) {
            index = 0;
            tb_content.setRowSelectionInterval(index, index);
        }
//        showdetails();
    }

    public void clearForm() {
        tf_ma.setText("");
        tf_chuyende.setText("");
        tf_hocphi.setText("");
        tf_hinh.setText("");
        tf_thoiluong.setText("");
        ta_mota.setText("");
        ChuyenDeDAO.loadChuyenDe();
        lb_anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hinh.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_main = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pn_btn = new javax.swing.JPanel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_lammoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_content = new javax.swing.JTable();
        tf_ma = new javax.swing.JTextField();
        tf_chuyende = new javax.swing.JTextField();
        tf_hocphi = new javax.swing.JTextField();
        tf_thoiluong = new javax.swing.JTextField();
        tf_hinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lb_anh = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_mota = new javax.swing.JTextArea();
        btn_timkiem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ CHUYÊN ĐỀ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã chuyên đề:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên chuyên đề:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Học phí:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Thời lượng:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Hình:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mô tả:");

        btn_them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/them.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sua.png"))); // NOI18N
        btn_sua.setText("Sửa     ");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/xoa.png"))); // NOI18N
        btn_xoa.setText("Xóa  ");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_lammoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_lammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/lammoi.png"))); // NOI18N
        btn_lammoi.setText("Làm mới");
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_btnLayout = new javax.swing.GroupLayout(pn_btn);
        pn_btn.setLayout(pn_btnLayout);
        pn_btnLayout.setHorizontalGroup(
            pn_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLayout.createSequentialGroup()
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pn_btnLayout.createSequentialGroup()
                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_lammoi))
        );

        pn_btnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_lammoi, btn_sua, btn_them, btn_xoa});

        pn_btnLayout.setVerticalGroup(
            pn_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_btnLayout.createSequentialGroup()
                .addGroup(pn_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them)
                    .addComponent(btn_sua))
                .addGap(5, 5, 5)
                .addGroup(pn_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_xoa)
                    .addComponent(btn_lammoi)))
        );

        tb_content.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã CD", "Tên CD", "Học phí", "Thời lượng", "Hình", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_content.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tb_content.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_contentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_content);

        tf_ma.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_ma.setEnabled(false);

        tf_chuyende.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_chuyende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_chuyendeActionPerformed(evt);
            }
        });

        tf_hocphi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_hocphi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_hocphiActionPerformed(evt);
            }
        });

        tf_thoiluong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_thoiluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_thoiluongMouseClicked(evt);
            }
        });

        tf_hinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_hinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_hinhMouseClicked(evt);
            }
        });

        jLabel7.setText("Bảng chuyên đề:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_anh.setBackground(new java.awt.Color(255, 255, 255));
        lb_anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hinh.png"))); // NOI18N
        jPanel1.add(lb_anh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 140));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/trolai.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        ta_mota.setColumns(20);
        ta_mota.setLineWrap(true);
        ta_mota.setRows(5);
        jScrollPane2.setViewportView(ta_mota);

        btn_timkiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_mainLayout = new javax.swing.GroupLayout(pn_main);
        pn_main.setLayout(pn_mainLayout);
        pn_mainLayout.setHorizontalGroup(
            pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_mainLayout.createSequentialGroup()
                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8))
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(315, 315, 315)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_mainLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(93, 93, 93)
                                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_hinh, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(tf_thoiluong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_hocphi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pn_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_mainLayout.createSequentialGroup()
                                        .addComponent(btn_timkiem)
                                        .addGap(62, 62, 62)))))))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(pn_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_mainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, tf_chuyende, tf_hinh, tf_hocphi, tf_ma, tf_thoiluong});

        pn_mainLayout.setVerticalGroup(
            pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_mainLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf_thoiluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addComponent(tf_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(tf_hocphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addGroup(pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_mainLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel5)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel6))
                            .addGroup(pn_mainLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(pn_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_timkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(pn_mainLayout.createSequentialGroup()
                        .addComponent(tf_hinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:

        String ma = tf_ma.getText().trim();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chuyên đề cần xóa!");
            return;
        }

        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa chuyên đề này?", "Xóa chuyên đề", JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
            if (nv.getVaitro() == 1) {
                JOptionPane.showMessageDialog(this, "Chỉ trưởng phòng mới được dùng chức năng này");
                return;
            }
            int maInt = Integer.parseInt(ma);
            try {
                Connection conn = DatabaseHelper.getConnection("EduSys");
                String sql = "SELECT COUNT(ChuyenDe.MaCD) FROM dbo.KhoaHoc \n"
                        + "JOIN dbo.ChuyenDe ON ChuyenDe.MaCD = KhoaHoc.MaCD \n"
                        + "WHERE ChuyenDe.TrangThai = 0 AND KhoaHoc.TrangThai = 0 AND ChuyenDe.MaCD = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, maInt);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if (rs.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(this, "Chuyên đề đang có khóa học không được phép xóa!");
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ChuyenDeDAO.xoaCD(maInt);
            clearForm();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            if (tb_content.getRowCount() == 0) {
                clearForm();
            } else {
                if (index == tb_content.getRowCount()) {
                    index--;
                    
                }
                tb_content.setRowSelectionInterval(index, index);
            }
            showdetails();
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void tf_hocphiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_hocphiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_hocphiActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        System.out.println("trở lại");
        this.dispose();
        new Main(nv).setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void tf_chuyendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_chuyendeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_chuyendeActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        String tenChuyenDe = tf_chuyende.getText().trim();
        if (tenChuyenDe.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên chuyên đề!");
            return;
        }
        String hocphiString = tf_hocphi.getText().trim();
        if (hocphiString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập học phí!");
            return;
        }
        int hocPhi = Integer.parseInt(hocphiString);
        String thoiString = tf_thoiluong.getText().trim();
        if (thoiString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thời lượng!");
            return;
        }
        int thoiLuong = Integer.parseInt(thoiString);
        String hinh = tf_hinh.getText().trim();
        String moTa = ta_mota.getText().trim();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).equals(tf_chuyende.getText())) {
                JOptionPane.showMessageDialog(this, "trùng tên chuyên đề");
                return;
            }

        }
        ChuyenDeDAO.themCD(tenChuyenDe, hocPhi, thoiLuong, hinh, moTa);
        ChuyenDeDAO.loadChuyenDe();

        JOptionPane.showMessageDialog(this, "Thêm thành công!");
        index = tb_content.getRowCount() - 1;
        tb_content.setRowSelectionInterval(index, index);

    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
        clearForm();
        ChuyenDeDAO.loadChuyenDe();
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void tb_contentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_contentMouseClicked
        showdetails();
    }//GEN-LAST:event_tb_contentMouseClicked

    public void showdetails() {
        // TODO add your handling code here:
        int i = tb_content.getSelectedRow();
        tf_ma.setText(String.valueOf(tb_content.getValueAt(i, 0)));
        tf_chuyende.setText(String.valueOf(tb_content.getValueAt(i, 1)));
        tf_hocphi.setText(String.valueOf(tb_content.getValueAt(i, 2)));
        tf_hinh.setText(String.valueOf(tb_content.getValueAt(i, 4)));
        tf_thoiluong.setText(String.valueOf(tb_content.getValueAt(i, 3)));
        ta_mota.setText(String.valueOf(tb_content.getValueAt(i, 5)));
        lb_anh.setIcon(new javax.swing.ImageIcon(String.valueOf(tb_content.getValueAt(i, 4))));
        tb_content.setRowSelectionInterval(i, i);
    }

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        String ma = tf_ma.getText().trim();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chuyên đề cần sửa!");
            return;
        }
        int maInt = Integer.parseInt(ma);
        String tenChuyenDe = tf_chuyende.getText().trim();
        if (tenChuyenDe.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên chuyên đề!");
            return;
        }
        String hocphiString = tf_hocphi.getText().trim();
        if (hocphiString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập học phí!");
            return;
        }
        int hocPhi = Integer.parseInt(hocphiString);
        String thoiString = tf_thoiluong.getText().trim();
        if (thoiString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thời lượng!");
            return;
        }
        int thoiLuong = Integer.parseInt(thoiString);
        String hinh = tf_hinh.getText().trim();
        String moTa = ta_mota.getText().trim();
        ChuyenDeDAO.suaCD(maInt, tenChuyenDe, hocPhi, thoiLuong, hinh, moTa);
        ChuyenDeDAO.loadChuyenDe();
        JOptionPane.showMessageDialog(this, "Sửa thành công!");
//        index = tb_content.getSelectedRow();
//        tb_content.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btn_suaActionPerformed

    private void tf_thoiluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_thoiluongMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tf_thoiluongMouseClicked

    private void tf_hinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_hinhMouseClicked
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
        fc.setFileFilter(fnef);
        fc.setMultiSelectionEnabled(false);

        int i = fc.showDialog(this, "Chọn file ảnh");
        if (i == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            tf_hinh.setText(f.getAbsolutePath());
            lb_anh.setIcon(new javax.swing.ImageIcon(f.getAbsolutePath()));
        }
    }//GEN-LAST:event_tf_hinhMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        String tenChuyenDe = tf_chuyende.getText().trim();
        if (tenChuyenDe.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên chuyên đề!");
            return;
        }
        boolean check = false;
        for (int i = 0; i < tb_content.getRowCount(); i++) {
            if (tenChuyenDe.equalsIgnoreCase(tb_content.getValueAt(i, 1).toString())) {
                tf_ma.setText(String.valueOf(tb_content.getValueAt(i, 0)));
                tf_chuyende.setText(String.valueOf(tb_content.getValueAt(i, 1)));
                tf_hocphi.setText(String.valueOf(tb_content.getValueAt(i, 2)));
                tf_hinh.setText(String.valueOf(tb_content.getValueAt(i, 4)));
                tf_thoiluong.setText(String.valueOf(tb_content.getValueAt(i, 3)));
                ta_mota.setText(String.valueOf(tb_content.getValueAt(i, 5)));
                lb_anh.setIcon(new javax.swing.ImageIcon(String.valueOf(tb_content.getValueAt(i, 4))));
                tb_content.setRowSelectionInterval(i, i);
                check = true;
            }
        }
        if (check == false) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy chuyên đề!");
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
            java.util.logging.Logger.getLogger(ChuyenDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChuyenDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChuyenDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChuyenDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_anh;
    private javax.swing.JPanel pn_btn;
    private javax.swing.JPanel pn_main;
    private javax.swing.JTextArea ta_mota;
    public static javax.swing.JTable tb_content;
    private javax.swing.JTextField tf_chuyende;
    private javax.swing.JTextField tf_hinh;
    private javax.swing.JTextField tf_hocphi;
    private javax.swing.JTextField tf_ma;
    private javax.swing.JTextField tf_thoiluong;
    // End of variables declaration//GEN-END:variables
}
