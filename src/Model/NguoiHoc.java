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
    private String MaNH,HoTen,Gioitinh,DienThoai,Email,GhiChu,MaNV;
    private Date NgayDk,NgaySinh;

    public NguoiHoc() {
    }

    public NguoiHoc(String MaNH, String HoTen, String Gioitinh, String DienThoai, String Email, String GhiChu, String MaNV, Date NgayDk, Date NgaySinh) {
        this.MaNH = MaNH;
        this.HoTen = HoTen;
        this.Gioitinh = Gioitinh;
        this.DienThoai = DienThoai;
        this.Email = Email;
        this.GhiChu = GhiChu;
        this.MaNV = MaNV;
        this.NgayDk = NgayDk;
        this.NgaySinh = NgaySinh;
    }

    public String getMaNH() {
        return MaNH;
    }

    public void setMaNH(String MaNH) {
        this.MaNH = MaNH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
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

    @Override
    public String toString() {
        return "NguoiHoc{" + "MaNH=" + MaNH + ", HoTen=" + HoTen + ", Gioitinh=" + Gioitinh + ", DienThoai=" + DienThoai + ", Email=" + Email + ", GhiChu=" + GhiChu + ", MaNV=" + MaNV + ", NgayDk=" + NgayDk + ", NgaySinh=" + NgaySinh + '}';
    }
    
    
}
