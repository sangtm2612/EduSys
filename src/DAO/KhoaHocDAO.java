/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;


//import java.util.Date;
/**
 *
 * @author sangt
 */
public class KhoaHocDAO {

    public static void themKH(int MaCD, int HocPhi, int ThoiLuong, Date NgayKG, String GhiChu, String MaNV) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into khoahoc( macd, hocphi, thoiluong, ngaykg, ghichu, manv) values (?, ?, ?, ?, ?, ?)";
            java.sql.Date sqlDate = new java.sql.Date(NgayKG.getTime());
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
            e.printStackTrace();
        }
    }

    public static void suaKH(int MaKH, int MaCD, float HocPhi, int ThoiLuong, Date NgayKG, String GhiChu, String MaNV) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update khoahoc set macd = ?, hocphi = ?, thoiluong = ?, ngaykg = ?, ghichu = ?, manv = ? where makh = ?";
            java.sql.Date sqlDate = new java.sql.Date(NgayKG.getTime());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MaCD);
            ps.setFloat(2, HocPhi);
            ps.setInt(3, ThoiLuong);
            ps.setDate(4, sqlDate);
            ps.setString(5, GhiChu);
            ps.setString(6, MaNV);
            ps.setInt(7, MaKH);
            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void XoaKH(int MaKH) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "delete from khoahoc where makh = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MaKH);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}
