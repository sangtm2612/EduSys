/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAO;

import Database.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Admin
 */
public class HocVienDAO {

    /**
     * @param args the command line arguments
     */
    public static void ThemHV(int MAHV, int MAKH, int MANH, float DIEM) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "insert into HocVien (MaHV,MaKH,MaNH,Diem) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MAHV);
            ps.setInt(2, MAKH);
            ps.setInt(3, MANH);
            ps.setFloat(4, DIEM);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void SuaHV(int MAHV, int MAKH, int MANH, float DIEM) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "update HocVien set MaKH = ? , MaNH = ?,Diem =? where MaHV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MAKH);
            ps.setInt(2, MANH);
            ps.setFloat(3, DIEM);
            ps.setFloat(4, MAHV);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void XoaHV(int MAHV, int MAKH, int MANH, float DIEM) {
        try {
            Connection conn = DatabaseHelper.getConnection("EduSys");
            String sql = "delete from HocVien where MaHV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, MAHV);
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
