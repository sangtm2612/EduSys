/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;
import Database.DatabaseHelper;
import Ui.NguoiHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN ASUS
 */
public class NguoiHocDao {

    public static void themNH(String HoTen, long NgaySinh, int GioiTinh, String DienThoai, String Email, String GhiChu, String MaNV, long NgayDK) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into NguoiHoc values( ?, ?, ?, ?, ?, ?, ?, ?, 0)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, HoTen);
            java.sql.Date dNgaySinh = new java.sql.Date(NgaySinh);
            ps.setDate(2, dNgaySinh);
            ps.setInt(3, GioiTinh);
            ps.setString(4, DienThoai);
            ps.setString(5, Email);
            ps.setString(6, GhiChu);
            ps.setString(7, MaNV);
            java.sql.Date dNgayDK = new java.sql.Date(NgayDK);
            ps.setDate(8, dNgayDK);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void suaNH(int MaNH, String HoTen, long NgaySinh, int GioiTinh, String DienThoai, String Email, String GhiChu, long NgayDK) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update NguoiHoc set Hoten=?, NgaySinh=? ,GioiTinh=?, DienThoai=?, Email=? , GhiChu=? ,NgayDK=? where manh = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, HoTen);
            java.sql.Date d1 = new java.sql.Date(NgaySinh);
            ps.setDate(2, d1);
            ps.setInt(3, GioiTinh);
            ps.setString(4, DienThoai);
            ps.setString(5, Email);
            ps.setString(6, GhiChu);
            java.sql.Date d2 = new java.sql.Date(NgayDK);
            ps.setDate(7, d2);
            ps.setInt(8, MaNH);
            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void XoaNH(int MaNH) {
        try {
            
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update nguoihoc set trangthai = 1 where manh = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MaNH);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void loadNguoiHoc() {
        DefaultTableModel dtm = (DefaultTableModel) NguoiHoc.tb_fillNH.getModel();
        dtm.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "select * from NguoiHoc where trangthai = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String gioiTinh = rs.getInt(4) == 0 ? "Nam" : "Nữ";
                java.sql.Date d = rs.getDate(3);
                java.sql.Date d1 = rs.getDate(9);
                Date dUtil = new Date(d.getTime());
                Date d1Util = new Date(d1.getTime());
                dtm.addRow(new Object[]{rs.getInt(1), rs.getString(2), sdf.format(dUtil), gioiTinh, rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), sdf.format(d1Util)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
