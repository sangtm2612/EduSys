/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;
import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN ASUS
 */
public class NguoiHocDao {

    public static void themNH(String HoTen, String DienThoai, String Email, String GhiChu, String MaNV, Date NgayDk, Date NgaySinh, int MaNH, int Gioitinh) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into NguoiHoc(MaNH,Hoten,NgaySinh,GioiTinh,DienThoai,Email,GhiChu,MaNV,NgayDK) values(?,?,?,?,?,?,?,?,?)";
            java.sql.Date sqlDate = new java.sql.Date(NgaySinh.getTime());
            java.sql.Date sqlDateNgayDk = new java.sql.Date(NgayDk.getTime());
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, MaNH);
            ps.setString(2, HoTen);
            ps.setDate(3, sqlDate);
            ps.setInt(4, Gioitinh);
            ps.setString(5, DienThoai);
            ps.setString(6, Email);
            ps.setString(7, GhiChu);
            ps.setString(8, MaNV);
            ps.setDate(9, sqlDateNgayDk);

            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void suaNH(String HoTen, String DienThoai, String Email, String GhiChu, String MaNV, Date NgayDk, Date NgaySinh, int Gioitinh) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update NguoiHoc set Hoten=?, NgaySinh=? ,GioiTinh=?, DienThoai=?, Email=? , GhiChu=? ,MaNV=? ,NgayDK=?";
            java.sql.Date sqlDate = new java.sql.Date(NgaySinh.getTime());
            java.sql.Date sqlDateNgayDk = new java.sql.Date(NgayDk.getTime());
            PreparedStatement ps = conn.prepareStatement(sql);

           
            ps.setString(1, HoTen);
            ps.setDate(2, sqlDate);
            ps.setInt(3, Gioitinh);
            ps.setString(4, DienThoai);
            ps.setString(5, Email);
            ps.setString(6, GhiChu);
            ps.setString(7, MaNV);
            ps.setDate(8, sqlDateNgayDk);

            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void XoaNH(int MaNH) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "delete from NguoiHoc where MaNH=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MaNH);
            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
    }
}
