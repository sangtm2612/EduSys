/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class ChuyenDe {
    private int MaCD;
    private String TenCD;
    private int HocPhi;
    private int ThoiLuong;
    private String Hinh;
    private String MoTa;

    public ChuyenDe() {
    }

    public ChuyenDe(int MaCD, String TenCD, int HocPhi, int ThoiLuong, String Hinh, String MoTa) {
        this.MaCD = MaCD;
        this.TenCD = TenCD;
        this.HocPhi = HocPhi;
        this.ThoiLuong = ThoiLuong;
        this.Hinh = Hinh;
        this.MoTa = MoTa;
    }

    public int getMaCD() {
        return MaCD;
    }

    public void setMaCD(int MaCD) {
        this.MaCD = MaCD;
    }

    public String getTenCD() {
        return TenCD;
    }

    public void setTenCD(String TenCD) {
        this.TenCD = TenCD;
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

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        return "ChuyenDe{" + "MaCD=" + MaCD + ", TenCD=" + TenCD + ", HocPhi=" + HocPhi + ", ThoiLuong=" + ThoiLuong + ", Hinh=" + Hinh + ", MoTa=" + MoTa + '}';
    }

    
    
}
