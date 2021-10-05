/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.DatabaseHelper;
import Ui.ChuyenDe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sangt
 */
public class ChuyenDeDAO {

    public static void themCD(String TenCD, int HocPhi, int ThoiLuong, String Hinh, String MoTa) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into chuyende values ( ?, ?, ?, ?, ?, 0)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, TenCD);
            ps.setInt(2, HocPhi);
            ps.setInt(3, ThoiLuong);
            ps.setString(4, Hinh);
            ps.setString(5, MoTa);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void suaCD(int MaCD, String TenCD, int HocPhi, int ThoiLuong, String Hinh, String MoTa) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update chuyende set tencd = ?, hocphi = ?, thoiluong = ?, hinh = ?, mota = ? where macd = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, TenCD);
            ps.setInt(2, HocPhi);
            ps.setInt(3, ThoiLuong);
            ps.setString(4, Hinh);
            ps.setString(5, MoTa);
            ps.setInt(6, MaCD);
            int rs = ps.executeUpdate();
            System.out.println(rs);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void xoaCD(int MaCD) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update chuyende set trangthai = 1 where macd = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MaCD);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void loadChuyenDe() {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "select * from chuyende where trangthai = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) ChuyenDe.tb_content.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                dtm.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
