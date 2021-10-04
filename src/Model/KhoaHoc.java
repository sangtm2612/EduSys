/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author sangt
 */
public class KhoaHoc {
    private int MaKH;
    private int MaCD;
    private int HocPhi;
    private int ThoiLuong;
    private Date NgayKG;
    private String GhiChu;
    private String MaNV;
    private Date NgayTao;

    public KhoaHoc() {
    }

    public KhoaHoc(int MaKH, int MaCD, int HocPhi, int ThoiLuong, Date NgayKG, String GhiChu, String MaNV, Date NgayTao) {
        this.MaKH = MaKH;
        this.MaCD = MaCD;
        this.HocPhi = HocPhi;
        this.ThoiLuong = ThoiLuong;
        this.NgayKG = NgayKG;
        this.GhiChu = GhiChu;
        this.MaNV = MaNV;
        this.NgayTao = NgayTao;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaCD() {
        return MaCD;
    }

    public void setMaCD(int MaCD) {
        this.MaCD = MaCD;
    }

    public float getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(int HocPhi) {
        this.HocPhi = HocPhi;
    }

    public int getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(int ThoiLuong) {
        this.ThoiLuong = ThoiLuong;
    }

    public Date getNgayKG() {
        return NgayKG;
    }

    public void setNgayKG(Date NgayKG) {
        this.NgayKG = NgayKG;
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

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    @Override
    public String toString() {
        return "KhoaHoc{" + "MaKH=" + MaKH + ", MaCD=" + MaCD + ", HocPhi=" + HocPhi + ", ThoiLuong=" + ThoiLuong + ", NgayKG=" + NgayKG + ", GhiChu=" + GhiChu + ", MaNV=" + MaNV + ", NgayTao=" + NgayTao + '}';
    }

    
    
}
