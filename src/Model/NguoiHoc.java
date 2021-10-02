/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ADMIN ASUS
 */
public class NguoiHoc {
    private String HoTen,DienThoai,Email,GhiChu,MaNV;
    private Date NgayDk,NgaySinh;
    private int MaNH,Gioitinh;

    public NguoiHoc() {
    }

    public NguoiHoc(String HoTen, String DienThoai, String Email, String GhiChu, String MaNV, Date NgayDk, Date NgaySinh, int MaNH, int Gioitinh) {
        this.HoTen = HoTen;
        this.DienThoai = DienThoai;
        this.Email = Email;
        this.GhiChu = GhiChu;
        this.MaNV = MaNV;
        this.NgayDk = NgayDk;
        this.NgaySinh = NgaySinh;
        this.MaNH = MaNH;
        this.Gioitinh = Gioitinh;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayDk() {
        return NgayDk;
    }

    public void setNgayDk(Date NgayDk) {
        this.NgayDk = NgayDk;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getMaNH() {
        return MaNH;
    }

    public void setMaNH(int MaNH) {
        this.MaNH = MaNH;
    }

    public int getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(int Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    

    
}
