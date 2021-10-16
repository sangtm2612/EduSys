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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import static org.apache.commons.math3.fitting.leastsquares.LeastSquaresFactory.model;
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
    /**
     * Creates new form ThongKe
     */
    public ThongKe(Model.NhanVien nv) {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icon/thongke24.png")));
        setLocationRelativeTo(null);
        setResizable(false);
        this.nv = nv;
        loadCbb();
    }
    
    public void loadCbb() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("(MMM d, yyyy)");
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "select tencd, ngaykg from khoahoc join chuyende on chuyende.macd = khoahoc.macd WHERE dbo.KhoaHoc.TrangThai = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tencd = String.valueOf(rs.getString(1));
                Date d = new Date(rs.getDate(2).getTime());
                cbb_khoahoc.addItem(tencd + " " + sdf.format(d));
            }
        } catch (Exception e) {
            System.out.println(e);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );

        tb_thongke.addTab("Điểm chuyên đề", pn_diemchuyende);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Năm");

        cbb_nam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbb_nam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE))
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
        // TODO add your handling code here:
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
//            Connection conn = DatabaseHelper.getConnection("EduSys");
//            String sql = "select tencd, ngaykg from khoahoc join chuyende on chuyende.macd = khoahoc.macd";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String tencd = String.valueOf(rs.getString(1));
//                Date d = new Date(rs.getDate(2).getTime());
//                System.out.println(sdf.format(d));
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }//GEN-LAST:event_cbb_khoahocItemStateChanged

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Main(nv).setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void Btn_xuatdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_xuatdiemActionPerformed
        ngu((DefaultTableModel) tb_bangdiem.getModel());
    }//GEN-LAST:event_Btn_xuatdiemActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKe(new Model.NhanVien()).setVisible(true);
            }
        });
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

    private void ngu(DefaultTableModel model) {
        
          JFileChooser fchoChooser = new JFileChooser();
        int result = fchoChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                if (!fchoChooser.getSelectedFile().toString().endsWith(".xlsx")) {
                    JOptionPane.showMessageDialog(this, "ngu");
                    return;
                }
                File newFile = new File(fchoChooser.getSelectedFile().toString());
                FileOutputStream file = new FileOutputStream(newFile.getAbsoluteFile().getPath());
//       
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet wsheep = wb.createSheet("name");
                XSSFRow row = wsheep.createRow((short) 0);
                XSSFCell h;
//      
                for (int i = 0; i < model.getColumnCount(); i++) {
                    h = row.createCell((short) i);
                    h.setCellValue(model.getColumnName(i));
                }
                XSSFRow row1;
                XSSFCell a1;
                XSSFCell a2;
                XSSFCell a3;
                XSSFCell a4;
                for (int i = 0; i < model.getRowCount(); i++) {
                    row1 = wsheep.createRow((short) i + 1);
//           
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        a1 = row1.createCell((short) j);
                        a1.setCellValue(model.getValueAt(i, j).toString());
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
}
