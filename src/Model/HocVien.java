/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class HocVien {

    private int MaHV;
    private int MaKH;
    private int MaNH;
    private double Diem;

    public HocVien() {
    }

    public HocVien(int MaHV, int MaKH, int MaNH, double Diem) {
        this.MaHV = MaHV;
        this.MaKH = MaKH;
        this.MaNH = MaNH;
        this.Diem = Diem;
    }

    public int getMaHV() {
        return MaHV;
    }

    public void setMaHV(int MaHV) {
        this.MaHV = MaHV;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaNH() {
        return MaNH;
    }

    public void setMaNH(int MaNH) {
        this.MaNH = MaNH;
    }

    public double getDiem() {
        return Diem;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }

    @Override
    public String toString() {
        return "HocVien{" + "MaHV=" + MaHV + ", MaKH=" + MaKH + ", MaNH=" + MaNH + ", Diem=" + Diem + '}';
    }

    

}
