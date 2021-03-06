/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import Ui.KhoaHoc;
import Ui.LichSuKhoaHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


//import java.util.Date;
/**
 *
 * @author sangt
 */
public class KhoaHocDAO {

    public static void themKH(int MaCD, int HocPhi, int ThoiLuong, long NgayKG, String GhiChu, String MaNV) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into khoahoc( macd, hocphi, thoiluong, ngaykg, ghichu, manv, trangthai) values (?, ?, ?, ?, ?, ?, 0)";
            java.sql.Date sqlDate = new java.sql.Date(NgayKG);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MaCD);
            ps.setInt(2, HocPhi);
            ps.setInt(3, ThoiLuong);
            ps.setDate(4, sqlDate);
            ps.setString(5, GhiChu);
            ps.setString(6, MaNV);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void suaKH(int MaKH, int MaCD, float HocPhi, int ThoiLuong, long NgayKG, String GhiChu) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update khoahoc set macd = ?, hocphi = ?, thoiluong = ?, ngaykg = ?, ghichu = ? where makh = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MaCD);
            ps.setFloat(2, HocPhi);
            ps.setInt(3, ThoiLuong);
            java.sql.Date d = new java.sql.Date(NgayKG);
            ps.setDate(4, d);
            ps.setString(5, GhiChu);
            ps.setInt(6, MaKH);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void XoaKH(int MaKH) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update khoahoc set trangthai = 1 where makh = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MaKH);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void loadKhoaHoc() {
        DefaultTableModel dtm = (DefaultTableModel) KhoaHoc.tb_content.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
        dtm.setRowCount(0);
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "select * from khoahoc join chuyende on chuyende.macd = khoahoc.macd where khoahoc.trangthai = 0 and chuyende.trangthai = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                java.sql.Date d = rs.getDate(5);
                Date ngaykh = new Date(d.getTime());
                java.sql.Date d1 = rs.getDate(7);
                Date ngaytao = new Date(d1.getTime());
                 dtm.addRow(new Object[] {rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), sdf.format(ngaykh), rs.getString(6),  rs.getString(8), sdf.format(d1)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     public static void ls(String maKH, String manv) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into LsKhoaHoc (MaKH,MaNV,mota,TrangThai) values(?,?,?,0)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKH);
            ps.setString(2, manv);
            ps.setString(3, "???? s???a Kh??a H???c "+maKH);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
        }
    }
     public static void ls2(String maKH, String manv) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into LsKhoaHoc (MaKH,MaNV,mota,TrangThai) values(?,?,?,0)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKH);
            ps.setString(2, manv);
            ps.setString(3, "???? x??a Kh??a H???c "+maKH);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
        }
    }
       public static void loadlskhoHOC() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "select * from LsKhoaHoc where trangthai = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) LichSuKhoaHoc.tbl_lichsu.getModel();
            dtm.setRowCount(0);
            
            while (rs.next()) {
                java.sql.Date d1 = rs.getDate(4);
                Date ngaytao = new Date(d1.getTime());
                dtm.addRow(new Object[] {rs.getInt(1), rs.getInt(2), rs.getString(3), sdf.format(d1), rs.getString(5)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       }
}
