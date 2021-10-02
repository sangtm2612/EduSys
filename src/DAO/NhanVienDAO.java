/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author sangt
 */
public class NhanVienDAO {
    
    public static void themNV(String Ma, String MatKhau, String HoTen, int VaiTro) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into NhanVien values ( ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, Ma);
            ps.setString(2, MatKhau);
            ps.setString(3, HoTen);
            ps.setInt(4, VaiTro);
            
            int rs = ps.executeUpdate();
            System.out.println(rs);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void suaNV(String Ma, String MatKhau, String HoTen, int VaiTro) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update NhanVien set MatKhau = ?, HoTen = ?, VaiTro = ? where manv = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(4, Ma);
            ps.setString(1, MatKhau);
            ps.setString(2, HoTen);
            ps.setInt(3, VaiTro);
            
            int rs = ps.executeUpdate();
            System.out.println(rs);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void xoaNV(String Ma) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "delete from nhanvien where manv = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, Ma);
            
            int rs = ps.executeUpdate();
            System.out.println(rs);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {

    }
    
    
}
