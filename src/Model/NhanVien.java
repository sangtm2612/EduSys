/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ADMIN ASUS
 */
public class NhanVien {
    private int Vaitro;
    private String MaNv,MatKhau,HoTen;

    public NhanVien() {
    }

    public NhanVien(int Vaitro, String MaNv, String MatKhau, String HoTen) {
        this.Vaitro = Vaitro;
        this.MaNv = MaNv;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
    }

    public int getVaitro() {
        return Vaitro;
    }

    public void setVaitro(int Vaitro) {
        this.Vaitro = Vaitro;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "Vaitro=" + Vaitro + ", MaNv=" + MaNv + ", MatKhau=" + MatKhau + ", HoTen=" + HoTen + '}';
    }

    
    
    
}
