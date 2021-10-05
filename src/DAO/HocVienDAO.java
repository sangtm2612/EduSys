/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAO;

import Database.DatabaseHelper;
import Ui.HocVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HocVienDAO {

    /**
     * @param args the command line arguments
     */
    public static void ThemHV(int MAKH, int MANH, float DIEM) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into HocVien (MaKH,MaNH,Diem,TrangThai) values (?,?,?,0)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MAKH);
            ps.setInt(2, MANH);
            ps.setFloat(3, DIEM);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void SuaHV(int MAHV, int MAKH, int MANH, float DIEM) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update hocvien set makh = ?, manh= ?, diem = ? where mahv = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MAKH);
            ps.setInt(2, MANH);
            ps.setFloat(3, DIEM);
            ps.setInt(4, MAHV);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void XoaHV(int MAHV) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "delete from hocvien where MaHV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MAHV);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void loadHocVien() {
        DefaultTableModel dtm = (DefaultTableModel) HocVien.tb_content.getModel();
        dtm.setRowCount(0);
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "select * from hocvien where trangthai = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dtm.addRow(new Object[] {rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
