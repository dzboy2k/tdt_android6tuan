package topica.edu.vn.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    // Serializable -> Gửi dữ liệu kiểu đối tượng
    private int ma;
    private String ten;
    private double donGia;

    public SanPham() {
    }

    public SanPham(int ma, String ten, double donGia) {
        this.ma = ma;
        this.ten = ten;
        this.donGia = donGia;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return this.ma + " - " + this.ten + " - " + this.donGia;
    }
}
