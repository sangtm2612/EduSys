/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import Ui.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sangt
 */
public class NhanVienDAO {

    public static void themNV(String Ma, String MatKhau, String HoTen, String Email, int VaiTro) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into NhanVien values ( ?, ?, ?, ?, ?, 0)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Ma);
            ps.setString(2, MatKhau);
            ps.setString(3, HoTen);
            ps.setString(4, Email);
            ps.setInt(5, VaiTro);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void suaNV(String Ma, String MatKhau, String HoTen, String Email, int VaiTro) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update NhanVien set MatKhau = ?, HoTen = ?, Email = ?, VaiTro = ? where manv = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(5, Ma);
            ps.setString(1, MatKhau);
            ps.setString(2, HoTen);
            ps.setString(3, Email);
            ps.setInt(4, VaiTro);

            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xoaNV(String Ma) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update nhanvien set TrangThai = 1 where manv = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Ma);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void loadNhanVien() {
        DefaultTableModel dtm = (DefaultTableModel) NhanVien.tb_fillNV.getModel();
        dtm.setRowCount(0);
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "select * from nhanvien where trangthai = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String vaitro = rs.getInt(5) == 0 ? "Trưởng phòng" : "Nhân viên";
                dtm.addRow(new Object[]{rs.getString(1), rs.getString(3), rs.getString(4), vaitro});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
