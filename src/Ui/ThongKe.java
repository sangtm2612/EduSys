/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Database.DatabaseHelper;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static org.apache.commons.math3.fitting.leastsquares.LeastSquaresFactory.model;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author sangt
 */
public class ThongKe extends javax.swing.JFrame {

    Model.NhanVien nv;
    DefaultComboBoxModel dcm;
    DefaultTableModel dtm;

    /**
     * Creates new form ThongKe
     */
    public ThongKe(Model.NhanVien nv) {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icon/thongke24.png")));
        setLocationRelativeTo(null);
        setResizable(false);
        this.nv = nv;
        dcm = (DefaultComboBoxModel) cbb_khoahoc.getModel();
        loadCbbKhoaHoc();
        loadTableNguoiHoc();
        loadTableDiemChuyenDe();
        loadCbb_Nam();
        //loadTableDoanhThu();
    }

    public void loadCbbKhoaHoc() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "select tencd, ngaykg, makh from khoahoc join chuyende on chuyende.macd = khoahoc.macd WHERE dbo.KhoaHoc.TrangThai = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Model.KhoaHoc kh = new Model.KhoaHoc();
                kh.setMaKH(rs.getInt(3));
                kh.setTenCD(rs.getString(1));
                kh.setNgayKG(rs.getDate(2));
                dcm.addElement(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTableKhoaHoc(int makh) {
        dtm = (DefaultTableModel) tb_bangdiem.getModel();
        dtm.setRowCount(0);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "SELECT HocVien.MaNH, hoten, diem, IIF(diem>=9, N'Xuất sắc', IIF(diem>=8, N'Giỏi', IIF(diem>=6.5, N'Khá', IIF(diem >= 5, N'Trung bình', N'Yếu')))) AS xeploai FROM dbo.HocVien JOIN dbo.NguoiHoc ON NguoiHoc.MaNH = HocVien.MaNH WHERE MaKH = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, makh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTableNguoiHoc() {
        dtm = (DefaultTableModel) tb_nguoihoc.getModel();
        dtm.setRowCount(0);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "select year(ngaydk)as Nam,count(maNH) as SoLuong, MIN(ngayDK), MAX(ngayDK) from NguoiHoc GROUP by year(ngaydk)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getInt(1), rs.getInt(2), sdf.format(rs.getDate(3)), sdf.format(rs.getDate(4))});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTableDiemChuyenDe() {
        dtm = (DefaultTableModel) tb_diemchuyende.getModel();
        dtm.setRowCount(0);
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "select TenCD, count(mahv),max(diem),min(diem),CONVERT(decimal(8,2),avg(diem),0) from ChuyenDe join KhoaHoc on ChuyenDe.MaCD = KhoaHoc.MaCD join HocVien on HocVien.MaKH = KhoaHoc.MaKH group by TenCD";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString(1), rs.getInt(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCbb_Nam() {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "SELECT DISTINCT YEAR(NgayDK) FROM dbo.NguoiHoc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbb_nam.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTableDoanhThu() {
        try {
            String namString = cbb_nam.getSelectedItem().toString();
            int nam = Integer.parseInt(namString);
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "SELECT TenCD,count(ChuyenDe.MaCD),count(mahv),sum(khoahoc.hocphi),max(khoahoc.HocPhi),min(khoahoc.hocphi),year(ngaytao) \n"
                    + "FROM ChuyenDe join KhoaHoc on ChuyenDe.MaCD = KhoaHoc.MaCD\n"
                    + "JOIN HocVien on HocVien.MaKH = KhoaHoc.MaKH\n"
                    + "GROUP by TenCD,year(ngaytao)\n"
                    + "HAVING year(ngaytao) = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nam);
            ResultSet rs = ps.executeQuery();
            dtm = (DefaultTableModel) tb_doanhthu.getModel();
            tb_doanhthu.removeAll();
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tb_thongke = new javax.swing.JTabbedPane();
        pn_bangdiem = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbb_khoahoc = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bangdiem = new javax.swing.JTable();
        Btn_xuatdiem = new javax.swing.JButton();
        pn_nguoihoc = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_nguoihoc = new javax.swing.JTable();
        pn_diemchuyende = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_diemchuyende = new javax.swing.JTable();
        pn_doanhthu = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbb_nam = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_doanhthu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THỐNG KÊ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Tổng hợp - Thống kê");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/trolai.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        tb_thongke.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pn_bangdiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Khóa học:");

        cbb_khoahoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbb_khoahoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_khoahocItemStateChanged(evt);
            }
        });

        tb_bangdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã người học", "Họ tên", "Điểm", "Xếp loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_bangdiem);

        Btn_xuatdiem.setText("Xuất File Excel");
        Btn_xuatdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_xuatdiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_bangdiemLayout = new javax.swing.GroupLayout(pn_bangdiem);
        pn_bangdiem.setLayout(pn_bangdiemLayout);
        pn_bangdiemLayout.setHorizontalGroup(
            pn_bangdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_bangdiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbb_khoahoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Btn_xuatdiem)
                .addGap(28, 28, 28))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        pn_bangdiemLayout.setVerticalGroup(
            pn_bangdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_bangdiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_bangdiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbb_khoahoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_xuatdiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
        );

        tb_thongke.addTab("Bảng điểm", pn_bangdiem);

        pn_nguoihoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tb_nguoihoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Năm", "Số người học", "Đăng ký sớm nhất", "Đăng ký muộn nhất"
            }
        ));
        jScrollPane2.setViewportView(tb_nguoihoc);

        javax.swing.GroupLayout pn_nguoihocLayout = new javax.swing.GroupLayout(pn_nguoihoc);
        pn_nguoihoc.setLayout(pn_nguoihocLayout);
        pn_nguoihocLayout.setHorizontalGroup(
            pn_nguoihocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        pn_nguoihocLayout.setVerticalGroup(
            pn_nguoihocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );

        tb_thongke.addTab("Người học", pn_nguoihoc);

        pn_diemchuyende.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tb_diemchuyende.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chuyên đề", "Số lượng học viên", "Điểm thấp nhất", "Điểm cao nhất", "Điểm trung bình"
            }
        ));
        jScrollPane3.setViewportView(tb_diemchuyende);

        javax.swing.GroupLayout pn_diemchuyendeLayout = new javax.swing.GroupLayout(pn_diemchuyende);
        pn_diemchuyende.setLayout(pn_diemchuyendeLayout);
        pn_diemchuyendeLayout.setHorizontalGroup(
            pn_diemchuyendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        pn_diemchuyendeLayout.setVerticalGroup(
            pn_diemchuyendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );

        tb_thongke.addTab("Điểm chuyên đề", pn_diemchuyende);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Năm");

        cbb_nam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbb_nam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_namItemStateChanged(evt);
            }
        });

        tb_doanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chuyên đề", "Số khóa học", "Số học viên", "Học phí  thấp nhất", "Học phí cao nhất", "Tổng tiền"
            }
        ));
        jScrollPane4.setViewportView(tb_doanhthu);

        javax.swing.GroupLayout pn_doanhthuLayout = new javax.swing.GroupLayout(pn_doanhthu);
        pn_doanhthu.setLayout(pn_doanhthuLayout);
        pn_doanhthuLayout.setHorizontalGroup(
            pn_doanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_doanhthuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbb_nam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        pn_doanhthuLayout.setVerticalGroup(
            pn_doanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_doanhthuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_doanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))
        );

        tb_thongke.addTab("Doanh thu", pn_doanhthu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(286, 286, 286)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tb_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tb_thongke))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbb_khoahocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_khoahocItemStateChanged
        Model.KhoaHoc kh = (Model.KhoaHoc) dcm.getSelectedItem();
        loadTableKhoaHoc(kh.getMaKH());
    }//GEN-LAST:event_cbb_khoahocItemStateChanged

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Main(nv).setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void Btn_xuatdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_xuatdiemActionPerformed
        TKBangDiem();
    }//GEN-LAST:event_Btn_xuatdiemActionPerformed

    private void cbb_namItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_namItemStateChanged
        // TODO add your handling code here:
        loadTableDoanhThu();
    }//GEN-LAST:event_cbb_namItemStateChanged

    private void TKBangDiem() {
        dtm = (DefaultTableModel) tb_bangdiem.getModel();
        JFileChooser fchoChooser = new JFileChooser();
        int result = fchoChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                if (!fchoChooser.getSelectedFile().toString().endsWith(".xlsx")) {
                    JOptionPane.showMessageDialog(this, "Không đúng định dạng!");
                    return;
                }
                File newFile = new File(fchoChooser.getSelectedFile().toString());
                FileOutputStream file = new FileOutputStream(newFile.getAbsoluteFile().getPath());
                XSSFWorkbook wb = new XSSFWorkbook();
                //TK điểm
                XSSFSheet Diemsheep = wb.createSheet("TK_Diem");
                XSSFRow row = Diemsheep.createRow((short) 0);
                XSSFCell h;
                for (int i = 0; i < dtm.getColumnCount(); i++) {
                    h = row.createCell((short) i);
                    h.setCellValue(dtm.getColumnName(i));
                }
                XSSFRow row1;
                XSSFCell a1;
                XSSFCell a2;
                XSSFCell a3;
                XSSFCell a4;
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    row1 = Diemsheep.createRow((short) i + 1);
                    for (int j = 0; j < dtm.getColumnCount(); j++) {
                        a1 = row1.createCell((short) j);
                        a1.setCellValue(dtm.getValueAt(i, j).toString());
                    }
                }

                //TK điểm
                dtm = (DefaultTableModel) tb_nguoihoc.getModel();
                XSSFSheet NguoiHocsheep = wb.createSheet("TK_NguoiHoc");
                row = NguoiHocsheep.createRow((short) 0);
                for (int i = 0; i < dtm.getColumnCount(); i++) {
                    h = row.createCell((short) i);
                    h.setCellValue(dtm.getColumnName(i));
                }
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    row1 = NguoiHocsheep.createRow((short) i + 1);
                    for (int j = 0; j < dtm.getColumnCount(); j++) {
                        a1 = row1.createCell((short) j);
                        a1.setCellValue(dtm.getValueAt(i, j).toString());
                    }
                }

                //TK điểm
                dtm = (DefaultTableModel) tb_diemchuyende.getModel();
                XSSFSheet ChuyenDesheep = wb.createSheet("TK_DiemChuyenDe");
                row = ChuyenDesheep.createRow((short) 0);
                for (int i = 0; i < dtm.getColumnCount(); i++) {
                    h = row.createCell((short) i);
                    h.setCellValue(dtm.getColumnName(i));
                }
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    row1 = ChuyenDesheep.createRow((short) i + 1);
                    for (int j = 0; j < dtm.getColumnCount(); j++) {
                        a1 = row1.createCell((short) j);
                        a1.setCellValue(dtm.getValueAt(i, j).toString());
                    }
                }

                //TK Doanh Thu
                dtm = (DefaultTableModel) tb_doanhthu.getModel();
                XSSFSheet DoanhThusheep = wb.createSheet("TK_DoanhThu");
                row = DoanhThusheep.createRow((short) 0);
                for (int i = 0; i < dtm.getColumnCount(); i++) {
                    h = row.createCell((short) i);
                    h.setCellValue(dtm.getColumnName(i));
                }
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    row1 = DoanhThusheep.createRow((short) i + 1);
                    for (int j = 0; j < dtm.getColumnCount(); j++) {
                        a1 = row1.createCell((short) j);
                        a1.setCellValue(dtm.getValueAt(i, j).toString());
                    }
                }
                wb.write(file);
                wb.close();
                file.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }

    }

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
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_xuatdiem;
    private javax.swing.JComboBox<String> cbb_khoahoc;
    private javax.swing.JComboBox<String> cbb_nam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pn_bangdiem;
    private javax.swing.JPanel pn_diemchuyende;
    private javax.swing.JPanel pn_doanhthu;
    private javax.swing.JPanel pn_nguoihoc;
    protected static javax.swing.JTable tb_bangdiem;
    private javax.swing.JTable tb_diemchuyende;
    private javax.swing.JTable tb_doanhthu;
    private javax.swing.JTable tb_nguoihoc;
    private javax.swing.JTabbedPane tb_thongke;
    // End of variables declaration//GEN-END:variables

}
