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
    private String MaNv,MatKhau,HoTen,Vaitro;

    public NhanVien() {
    }

    public NhanVien(String MaNv, String MatKhau, String HoTen, String Vaitro) {
        this.MaNv = MaNv;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
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

    public String getVaitro() {
        return Vaitro;
    }

    public void setVaitro(String Vaitro) {
        this.Vaitro = Vaitro;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "MaNv=" + MaNv + ", MatKhau=" + MatKhau + ", HoTen=" + HoTen + ", Vaitro=" + Vaitro + '}';
    }
    
}
