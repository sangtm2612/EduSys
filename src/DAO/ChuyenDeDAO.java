/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author sangt
 */
public class ChuyenDeDAO {

    public static void themCD(String TenCD, float HocPhi, int ThoiLuong, String Hinh, String MoTa) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into chuyende values ( ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, TenCD);
            ps.setFloat(2, ThoiLuong);
            ps.setInt(3, ThoiLuong);
            ps.setString(4, Hinh);
            ps.setString(5, MoTa);
            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void suaCD(int MaCD, String TenCD, float HocPhi, int ThoiLuong, String Hinh, String MoTa) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update chuyende set tencd = ?, hocphi = ?, thoiluong = ?, hinh = ?, mota = ? where macd = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, TenCD);
            ps.setFloat(2, ThoiLuong);
            ps.setInt(3, ThoiLuong);
            ps.setString(4, Hinh);
            ps.setString(5, MoTa);
            ps.setInt(6, MaCD);
            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void xoaCD(int MaCD) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "delete from chuyende where macd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MaCD);
            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //themCD("Học tập", 20000, 3, null, null);
        //suaCD(0, "zz", 0, 0, "123", "321");
        //xoaCD(0);
    }
}
